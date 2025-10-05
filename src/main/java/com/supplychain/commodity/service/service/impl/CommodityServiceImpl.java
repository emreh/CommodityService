package com.supplychain.commodity.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supplychain.commodity.service.dto.MainGroupCommodityDTO;
import com.supplychain.commodity.service.mapper.MainGroupCommodityEntityToDTOMapper;
import com.supplychain.commodity.service.persistence.facade.CommodityQueryService;
import com.supplychain.commodity.service.service.CommodityService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommodityServiceImpl implements CommodityService {

    private final CommodityQueryService commodityQueryService;
    private final MainGroupCommodityEntityToDTOMapper mainGroupCommodityEntityToDTOMapper;

    @Transactional(readOnly = true)
    public List<MainGroupCommodityDTO> loadAll() {
	return commodityQueryService.findAll().stream().map(mainGroupCommodityEntityToDTOMapper::convertToDTO)
		.collect(Collectors.toList());
    }
}
