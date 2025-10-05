package com.supplychain.commodity.service.service;

import java.util.List;

import com.supplychain.commodity.service.dto.MainGroupCommodityDTO;

public interface CommodityService {

    public List<MainGroupCommodityDTO> loadAll();
}
