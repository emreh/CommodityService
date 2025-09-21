package com.supplychain.commodity.service.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.supplychain.commodity.service.dto.MainGroupCommodityDTO;
import com.supplychain.commodity.service.persistence.model.MainGroupCommodityEntity;

@Mapper(uses = SubGroupCommodityEntityToDTOMapper.class)
public interface MainGroupCommodityEntityToDTOMapper {

    /**
     * Convert Entity To DTO
     *
     * @param mainGroupCommodityEntity
     * @return
     */
    @Mappings({
            @Mapping(source = "subGroupCommodityEntityList", target = "subGroupCommodityDTOList")
    })
    MainGroupCommodityDTO convertToDTO(MainGroupCommodityEntity mainGroupCommodityEntity);

    /**
     * Convert DTO To Entity
     *
     * @param mainGroupCommodityDTO
     * @return
     */
    @InheritInverseConfiguration
    MainGroupCommodityEntity reverseToEntity(MainGroupCommodityDTO mainGroupCommodityDTO);
}
