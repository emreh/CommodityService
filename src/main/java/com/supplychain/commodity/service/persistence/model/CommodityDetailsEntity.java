package com.supplychain.commodity.service.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import com.supplychain.base.model.BaseEntityModel;
import com.supplychain.commodity.service.persistence.util.HashMapConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "COMMODITY_DETAILS", indexes = { @Index(name = "idx_cd_code", columnList = "CODE"),
	@Index(name = "idx_cd_name", columnList = "NAME") })
public class CommodityDetailsEntity extends BaseEntityModel<Long> {

    // نام
    @Column(name = "NAME", length = 250, nullable = false, unique = true)
    private String name;
    // کد
    @Column(name = "CODE", length = 250, nullable = false, unique = true)
    private String code;
    // قیمت خرید
    @Column(name = "PURCHASE_PRICE")
    private BigDecimal purchasePrice;
    // قیمت فورش
    @Column(name = "CELL_PRICE", nullable = false)
    private BigDecimal cellPrice;
    // درصد تخفیف
    @Column(name = "DISCOUNT_PERCENT")
    private double discountPercent;
    // تعداد
    @Column(name = "NUMBER", nullable = false)
    private Integer number;
    // تاریخ تولید
    @Column(name = "MANUFACTURE_DATE")
    private LocalDate manufactureDate;
    // تاریخ انقضا
    @Column(name = "EXPIRATION_DATE")
    private LocalDate expirationDate;
    // مکان در انبار
    @Column(name = "WAREHOUSE_LOCATION")
    private String warehouseLocation;
    // مشخصات
    @Column(name = "DEIATLS", length = 3000)
    @Convert(converter = HashMapConverter.class)
    private Map<String, String> detailList;
    // حداقل تعداد
    @Column(name = "MIN_NUMBER", nullable = false)
    private Integer minNumber;
    // حداکثر تعداد
    @Column(name = "MAX_NUMBER", nullable = false)
    private Integer maxNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "COMMODITY_DETAILS_TO_MANUFACTURER", joinColumns = @JoinColumn(name = "DETAILS_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "ID"))
    @OrderBy("id ASC")
    private CommodityManufacturerEntity commodityManufacturerEntity;
}