package com.supplychain.commodity.service.persistence.facade;

import java.util.List;

import com.supplychain.commodity.service.persistence.model.UnitEntity;

public interface UnitQueryService {

    public List<UnitEntity> findAll();
}
