package com.supplychain.commodity.service.persistence.facade;

import java.util.List;

import com.supplychain.commodity.service.persistence.model.MainGroupCommodityEntity;

public interface CommodityQueryService {

    public List<MainGroupCommodityEntity> findAll();
}
