package com.supplychain.commodity.service.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supplychain.commodity.service.persistence.model.UnitEntity;

@Repository
interface UnitRepository extends JpaRepository<UnitEntity, Long> {
    Optional<UnitEntity> findBySymbol(String symbol);
}
