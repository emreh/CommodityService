package com.supplychain.commodity.service.persistence.model;

import com.supplychain.base.model.BaseEntityModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "UNITS")
public class UnitEntity extends BaseEntityModel<Long> {

    // نام واحد (فارسی یا عمومی، مثل "کیلوگرم" یا "بسته ۶ تایی")
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
    // نماد واحد (مثل "kg", "g", "pcs")
    @Column(name = "SYMBOL", length = 20, nullable = false, unique = true)
    private String symbol;
    // دسته‌بندی واحد (مثل "WEIGHT", "VOLUME", "COUNT", "LENGTH")
    @Column(name = "CATEGORY", length = 50, nullable = false)
    private String category;
    // واحد پایه برای تبدیل (مثلاً برای وزن = "g"، برای حجم = "ml")
    @Column(name = "BASE_UNIT", length = 20, nullable = false)
    private String baseUnit;
    // ضریب تبدیل به واحد پایه (مثلاً kg → 1000 g)
    @Column(name = "CONVERSION_FACTOR", nullable = false)
    private Double conversionFactor;
}
