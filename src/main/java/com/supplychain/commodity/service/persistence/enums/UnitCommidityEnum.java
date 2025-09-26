package com.supplychain.commodity.service.persistence.enums;

import java.util.Arrays;
import java.util.Optional;

import com.supplychain.base.uitl.MessageUtils;

public enum UnitCommidityEnum {
    GRAM("g", "WEIGHT", "g", 1.0), KILOGRAM("kg", "WEIGHT", "g", 1000.0), MILLIGRAM("mg", "WEIGHT", "g", 0.001),
    LITER("l", "VOLUME", "ml", 1000.0), MILLILITER("ml", "VOLUME", "ml", 1.0), PIECE("pcs", "COUNT", "pcs", 1.0);

    private final String symbol;
    private final String category;
    private final String baseUnit;
    private final Double conversionFactor;

    UnitCommidityEnum(String symbol, String category, String baseUnit, Double conversionFactor) {
	this.symbol = symbol;
	this.category = category;
	this.baseUnit = baseUnit;
	this.conversionFactor = conversionFactor;
    }

    public String getSymbol() {
	return symbol;
    }

    public String getCategory() {
	return category;
    }

    public String getBaseUnit() {
	return baseUnit;
    }

    public Double getConversionFactor() {
	return conversionFactor;
    }

    public static Optional<UnitCommidityEnum> fromSymbol(String symbol) {
	return Arrays.stream(values()).filter(u -> u.symbol.equalsIgnoreCase(symbol)).findFirst();
    }

    public String getLabel() {
	return MessageUtils.getMessage("unit.commodity.enum." + this.name());
    }
}
