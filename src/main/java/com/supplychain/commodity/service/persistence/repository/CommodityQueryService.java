package com.supplychain.commodity.service.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplychain.commodity.service.persistence.model.MainGroupCommodityEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommodityQueryService {

    private final MainGroupCommodityRepository mainGroupCommodityRepository;

    public List<MainGroupCommodityEntity> findAll() {
	return mainGroupCommodityRepository.findAll();
    }
}
