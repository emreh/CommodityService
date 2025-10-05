package com.supplychain.commodity.service.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.supplychain.commodity.service.persistence.model.UnitEntity;

public interface UnitService {

    public Optional<UnitEntity> getCustomUnit(String symbol);
    
    public Optional<Double> getConversionFactor(String symbol);
    
    public BigDecimal convertToBase(BigDecimal value, String symbol);
    
    public BigDecimal convertFromBase(BigDecimal baseValue, String symbol);
}