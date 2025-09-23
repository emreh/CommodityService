package com.supplychain.commodity.service.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.supplychain.commodity.service.persistence.model.UnitEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnitQueryService {

    private final UnitRepository unitRepository;

    public List<UnitEntity> findAll() {
	return unitRepository.findAll();
    }
}
