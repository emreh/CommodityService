package com.supplychain.commodity.service.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supplychain.commodity.service.persistence.model.SubGroupCommodityEntity;

@Repository
public interface SubGroupCommodityRepository extends JpaRepository<SubGroupCommodityEntity, Long> {
}
