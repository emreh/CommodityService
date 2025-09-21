package com.supplychain.commodity.service.mapper;

import org.mapstruct.Mapper;

import com.supplychain.commodity.service.dto.CommodityDetailsDTO;
import com.supplychain.commodity.service.persistence.model.CommodityDetailsEntity;

@Mapper
public interface CommodityDetailsEntityToDTOMapper {

    /**
     * Convert Entity To DTO
     *
     * @param commodityDetailsEntity
     * @return
     */
    CommodityDetailsDTO convertToDTO(CommodityDetailsEntity commodityDetailsEntity);

    /**
     * Convert DTO To Entity
     *
     * @param commodityDetailsDTO
     * @return
     */
    CommodityDetailsEntity reverseToEntity(CommodityDetailsDTO commodityDetailsDTO);
}
