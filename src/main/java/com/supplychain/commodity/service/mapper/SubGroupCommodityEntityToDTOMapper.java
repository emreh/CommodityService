package com.supplychain.commodity.service.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.supplychain.commodity.service.dto.SubGroupCommodityDTO;
import com.supplychain.commodity.service.persistence.model.SubGroupCommodityEntity;

@Mapper(uses = CommodityManufacturerEntityToDTOMapper.class)
public interface SubGroupCommodityEntityToDTOMapper {

    /**
     * Convert Entity To DTO
     *
     * @param subGroupCommodityEntity
     * @return
     */
    @Mappings({
            @Mapping(source = "commodityManufacturerEntityList", target = "commodityManufacturerDTOList")
    })
    SubGroupCommodityDTO convertToDTO(SubGroupCommodityEntity subGroupCommodityEntity);

    /**
     * Convert DTO To Entity
     *
     * @param subGroupCommodityDTO
     * @return
     */
    @InheritInverseConfiguration
    SubGroupCommodityEntity reverseToEntity(SubGroupCommodityDTO subGroupCommodityDTO);
}
