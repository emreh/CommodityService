package com.supplychain.commodity.service.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.supplychain.commodity.service.persistence.enums.UnitCommidityEnum;
import com.supplychain.commodity.service.persistence.facade.UnitQueryService;
import com.supplychain.commodity.service.persistence.model.UnitEntity;
import com.supplychain.commodity.service.service.UnitService;

import jakarta.annotation.PostConstruct;

@Service
public class UnitServiceImpl implements UnitService {
    private final UnitQueryService unitQueryService;
    private final Map<String, UnitEntity> unitCache = new HashMap<>();

    public UnitServiceImpl(UnitQueryService unitQueryService) {
	this.unitQueryService = unitQueryService;
	loadUnits();
    }

    @PostConstruct
    private void loadUnits() {
	unitQueryService.findAll().forEach(unit -> unitCache.put(unit.getSymbol(), unit));
    }

    @Override
    public Optional<UnitEntity> getCustomUnit(String symbol) {
	return Optional.ofNullable(unitCache.get(symbol));
    }

    @Override
    public Optional<Double> getConversionFactor(String symbol) {
	// ابتدا Enum استاندارد
	Optional<UnitCommidityEnum> standardUnit = UnitCommidityEnum.fromSymbol(symbol);
	if (standardUnit.isPresent()) {
	    return Optional.of(standardUnit.get().getConversionFactor());
	}
	// سپس واحدهای سفارشی
	return getCustomUnit(symbol).map(UnitEntity::getConversionFactor);
    }

    @Override
    public BigDecimal convertToBase(BigDecimal value, String symbol) {
	return getConversionFactor(symbol).map(f -> value.multiply(BigDecimal.valueOf(f)))
		.orElseThrow(() -> new IllegalArgumentException("Unknown unit: " + symbol));
    }

    @Override
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
