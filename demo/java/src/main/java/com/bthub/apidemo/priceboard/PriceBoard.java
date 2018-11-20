package com.bthub.apidemo.priceboard;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.bthub.apidemo.dto.Band;
import com.bthub.apidemo.dto.Cp;
import com.bthub.apidemo.dto.Quote;
import com.bthub.apidemo.dto.Symbol;

public class PriceBoard {

	private final Symbol symbol;
	private final Map<Integer, Cp> idToCp;
	private Map<Integer, Quote> cpIdToQuoteMap = new ConcurrentHashMap<Integer, Quote>();

	public PriceBoard(Symbol symbol, Map<Integer, Cp> idToCp) {
		this.symbol = symbol;
		this.idToCp = idToCp;
	}

	public void onQuote(Quote quote) {
		if (!symbol.getId().equals(quote.getSymbolId())) {
			return;
		}
		cpIdToQuoteMap.put(quote.getCpId(), quote);
	}

	public void print() {
		List<Quote> quotes = cpIdToQuoteMap.values().stream().collect(Collectors.toList());
		List<Ticker> newBids = new ArrayList<>();
		List<Ticker> newAsks = new ArrayList<>();
		for (Quote quote : quotes) {
			BigDecimal commission = quote.getCommission();
			String cpName = idToCp.get(quote.getCpId()).getName();
			for (Band band : quote.getBids()) {
				BigDecimal price = band.getPrice();
				BigDecimal commissionPrice = price.multiply(BigDecimal.ONE.subtract(commission)).setScale(symbol.getTradingPriceScale(), RoundingMode.DOWN);
				newBids.add(new Ticker(cpName, price, commissionPrice, band.getVolume()));
			}
			for (Band band : quote.getAsks()) {
				BigDecimal price = band.getPrice();
				BigDecimal commissionPrice = price.divide(BigDecimal.ONE.subtract(commission), symbol.getTradingPriceScale(), RoundingMode.UP);
				newAsks.add(new Ticker(cpName, price, commissionPrice, band.getVolume()));
			}
		}
		newBids.sort(Comparator.comparing(Ticker::getCommissionPrice).reversed());
		newAsks.sort(Comparator.comparing(Ticker::getCommissionPrice).reversed());
		System.out.println("asks");
		newAsks.stream().forEach(System.out::println);
		System.out.println("bids");
		newBids.stream().forEach(System.out::println);
	}

}
