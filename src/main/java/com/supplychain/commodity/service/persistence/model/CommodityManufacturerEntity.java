package com.supplychain.commodity.service.persistence.model;

import java.util.List;

import com.supplychain.base.model.BaseEntityModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "COMMODITY_MANUFACTURER", indexes = { @Index(name = "idx_cm_name", columnList = "NAME"),
	@Index(name = "idx_cm_code", columnList = "CODE") })
public class CommodityManufacturerEntity extends BaseEntityModel<Long> {

    // نام
    @Column(name = "NAME", length = 250, nullable = false, unique = true)
    private String name;
    // کد
    @Column(name = "CODE", length = 250, nullable = false, unique = true)
    private String code;

    @ManyToMany(mappedBy = "commodityManufacturerEntityList", cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    private List<SubGroupCommodityEntity> subGroupCommodityEntityList;

    @OneToMany(mappedBy = "commodityManufacturerEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    private List<CommodityDetailsEntity> commodityDetailsEntityList;
}
