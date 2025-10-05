package com.supplychain.commodity.service.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplychain.commodity.service.persistence.facade.UnitQueryService;
import com.supplychain.commodity.service.persistence.model.UnitEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class UnitQueryServiceImpl implements UnitQueryService{

    private final UnitRepository unitRepository;

    @Override
    public List<UnitEntity> findAll() {
	return unitRepository.findAll();
    }
}
