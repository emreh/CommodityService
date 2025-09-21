package com.supplychain.commodity.service.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.supplychain.commodity.service.dto.CommodityManufacturerDTO;
import com.supplychain.commodity.service.persistence.model.CommodityManufacturerEntity;

@Mapper(uses = CommodityDetailsEntityToDTOMapper.class)
public interface CommodityManufacturerEntityToDTOMapper {

    /**
     * Convert Entity To DTO
     *
     * @param commodityManufacturerEntity
     * @return
     */
    @Mappings({ @Mapping(source = "commodityDetailsEntityList", target = "commodityDetailsDTOList") })
    CommodityManufacturerDTO convertToDTO(CommodityManufacturerEntity commodityManufacturerEntity);

    /**
     * Convert DTO To Entity
     *
     * @param commodityManufacturerDTO
     * @return
     */
    @InheritInverseConfiguration
    CommodityManufacturerEntity reverseToEntity(CommodityManufacturerDTO commodityManufacturerDTO);
}
