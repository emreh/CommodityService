package com.supplychain.commodity.service.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supplychain.commodity.service.persistence.model.CommodityManufacturerEntity;

@Repository
public interface CommodityManufacturerRepository extends JpaRepository<CommodityManufacturerEntity, Long> {
}
