package com.supplychain.commodity.service.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.supplychain.commodity.service.persistence.enums.UnitCommidityEnum;
import com.supplychain.commodity.service.persistence.model.UnitEntity;
import com.supplychain.commodity.service.persistence.repository.UnitQueryService;

import jakarta.annotation.PostConstruct;

@Service
public class UnitService {

    private final UnitQueryService unitQueryService;
    private final Map<String, UnitEntity> unitCache = new HashMap<>();

    public UnitService(UnitQueryService unitQueryService) {
	this.unitQueryService = unitQueryService;
	loadUnits();
    }

    @PostConstruct
    private void loadUnits() {
	unitQueryService.findAll().forEach(unit -> unitCache.put(unit.getSymbol(), unit));
    }

    public Optional<UnitEntity> getCustomUnit(String symbol) {
	return Optional.ofNullable(unitCache.get(symbol));
    }

    public Optional<Double> getConversionFactor(String symbol) {
	// ابتدا Enum استاندارد
	Optional<UnitCommidityEnum> standardUnit = UnitCommidityEnum.fromSymbol(symbol);
	if (standardUnit.isPresent()) {
	    return Optional.of(standardUnit.get().getConversionFactor());
	}
	// سپس واحدهای سفارشی
	return getCustomUnit(symbol).map(UnitEntity::getConversionFactor);
    }

    public BigDecimal convertToBase(BigDecimal value, String symbol) {
	return getConversionFactor(symbol).map(f -> value.multiply(BigDecimal.valueOf(f)))
		.orElseThrow(() -> new IllegalArgumentException("Unknown unit: " + symbol));
    }

    public BigDecimal convertFromBase(BigDecimal baseValue, String symbol) {
	return getConversionFactor(symbol).map(f -> baseValue.divide(BigDecimal.valueOf(f), RoundingMode.HALF_UP))
		.orElseThrow(() -> new IllegalArgumentException("Unknown unit: " + symbol));
    }

    @CacheEvict(value = "units", allEntries = true)
    public void reloadCache() {
	unitCache.clear();
	loadUnits();
    }
}