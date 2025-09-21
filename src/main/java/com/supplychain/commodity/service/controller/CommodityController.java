package com.supplychain.commodity.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychain.commodity.service.dto.MainGroupCommodityDTO;
import com.supplychain.commodity.service.manager.CommodityManager;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/commodity")
@RequiredArgsConstructor
public class CommodityController {

    private final CommodityManager commodityManager;

    /**
     * Load All Data
     *
     * @return List Of {@link MainGroupCommodityDTO}
     */
    @GetMapping(value = "/loadAll")
    @RolesAllowed({ "ROLE_SUPER_ADMIN", "ROLE_ADMIN" })
    private ResponseEntity<List<MainGroupCommodityDTO>> loadAll() {
	List<MainGroupCommodityDTO> mainGroupCommodityDTOList = commodityManager.loadAll();

	if (mainGroupCommodityDTOList != null)
	    return ResponseEntity.ok(mainGroupCommodityDTOList);

	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
