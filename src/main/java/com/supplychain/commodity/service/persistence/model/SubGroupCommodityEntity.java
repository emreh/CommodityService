package com.supplychain.commodity.service.persistence.model;

import java.util.List;

import com.supplychain.base.model.BaseEntityModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "SUB_GROUP_COMMODITY", indexes = { @Index(name = "idx_sgc_name", columnList = "NAME"),
	@Index(name = "idx_sgc_code", columnList = "ODE") })
public class SubGroupCommodityEntity extends BaseEntityModel<Long> {

    // نام
    @Column(name = "NAME", length = 250, nullable = false, unique = true)
    private String name;
    // کد
    @Column(name = "CODE", length = 250, nullable = false, unique = true)
    private String code;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_MAIN_GROUP_COMMODITY", nullable = false)
    @OrderBy("id ASC")
    private MainGroupCommodityEntity mainGroupCommodityEntity;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "SUB_MANUFACTURER", joinColumns = @JoinColumn(name = "SUB_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "ID"))
    @OrderBy("id ASC")
    private List<CommodityManufacturerEntity> commodityManufacturerEntityList;
}
