package com.supplychain.commodity.service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName(value = "commodityManufacturer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommodityManufacturerDTO {

    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "code")
    private String code;

    private List<CommodityDetailsDTO> commodityDetailsDTOList;
}
