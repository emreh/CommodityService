package com.supplychain.commodity.service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName(value = "commodityDetails")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommodityDetailsDTO {

    @JsonProperty(value = "name")
    private String name;
    // کد
    @JsonProperty(value = "code")
    private String code;
    // قیمت خرید
    @JsonProperty(value = "purchasePrice")
    private BigDecimal purchasePrice;
    // قیمت فورش
    @JsonProperty(value = "cellPrice")
    private BigDecimal cellPrice;
    // درصد تخفیف
    @JsonProperty(value = "discountPercent")
    private double discountPercent;
    // تعداد
    @JsonProperty(value = "number")
    private Integer number;
    // تاریخ تولید
    @JsonProperty(value = "manufactureDate")
    private LocalDate manufactureDate;
    // تاریخ انقضا
    @JsonProperty(value = "expirationDate")
    private LocalDate expirationDate;
    // مکان در انبار
    @JsonProperty(value = "warehouseLocation")
    private String warehouseLocation;
    // مشخصات
    @JsonProperty(value = "detailList")
    private Map<String, String> detailList;
    // حداقل تعداد
    @JsonProperty(value = "minNumber")
    private Integer minNumber;
    // حداکثر تعداد
    @JsonProperty(value = "maxNumber")
    private Integer maxNumber;
}
