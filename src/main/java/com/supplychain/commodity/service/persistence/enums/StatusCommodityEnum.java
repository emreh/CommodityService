package com.supplychain.commodity.service.persistence.enums;

import com.supplychain.commodity.service.util.MessageUtils;

public enum StatusCommodityEnum {

    WAITING_FOR_CHECK_IN, WAITING_FOR_CHECK_OUT, ACTIVED, RESERVED, EVACUATED;

    public String getLabel() {
	return MessageUtils.getMessage("status.commodity.enum." + this.name());
    }
}
