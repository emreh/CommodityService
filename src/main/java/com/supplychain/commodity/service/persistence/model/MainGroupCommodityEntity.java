package com.supplychain.commodity.service.persistence.model;

import java.util.List;

import com.supplychain.base.model.BaseEntityModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
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
@Table(name = "MAIN_GROUP_COMMODITY", indexes = { @Index(name = "idx_mgc_name", columnList = "NAME"),
	@Index(name = "idx_mgc_code", columnList = "CODE") })
public class MainGroupCommodityEntity extends BaseEntityModel<Long> {

    // نام
    @Column(name = "NAME", length = 250, nullable = false, unique = true)
    private String name;
    // کد
    @Column(name = "CODE", length = 250, nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "mainGroupCommodityEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    private List<SubGroupCommodityEntity> subGroupCommodityEntityList;
}
