package com.supplychain.commodity.service.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplychain.commodity.service.persistence.facade.CommodityQueryService;
import com.supplychain.commodity.service.persistence.model.MainGroupCommodityEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class CommodityQueryServiceImpl implements CommodityQueryService{

    private final MainGroupCommodityRepository mainGroupCommodityRepository;

    @Override
    public List<MainGroupCommodityEntity> findAll() {
	return mainGroupCommodityRepository.findAll();
    }
}
