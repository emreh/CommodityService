package com.supplychain.commodity.service.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supplychain.commodity.service.dto.MainGroupCommodityDTO;
import com.supplychain.commodity.service.mapper.MainGroupCommodityEntityToDTOMapper;
import com.supplychain.commodity.service.persistence.repository.MainGroupCommodityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommodityManager {

    private final MainGroupCommodityRepository mainGroupCommodityRepository;
    private final MainGroupCommodityEntityToDTOMapper mainGroupCommodityEntityToDTOMapper;

    @Transactional(readOnly = true)
    public List<MainGroupCommodityDTO> loadAll() {
        return mainGroupCommodityRepository.findAll().stream().map(mainGroupCommodityEntityToDTOMapper::convertToDTO).collect(Collectors.toList());
    }
}
