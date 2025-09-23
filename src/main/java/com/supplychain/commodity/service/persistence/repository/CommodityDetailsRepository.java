package com.supplychain.commodity.service.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supplychain.commodity.service.persistence.model.CommodityDetailsEntity;

@Repository
interface CommodityDetailsRepository extends JpaRepository<CommodityDetailsEntity, Long> {
}
