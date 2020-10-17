package com.sngular.prueba.zara.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sngular.prueba.zara.dto.PricesDTO;
import com.sngular.prueba.zara.services.PricesServices;

@RestController
@RequestMapping("/prueba/zara/api/v1")
public class PruebaController {

	@Autowired
	private PricesServices pricesServices;

	/**
	 * 
	 * Endpoint get Prices returns the data of the rate to apply in case of
	 * obtaining a status 200. If there is no rate to apply, it returns a status 204
	 * 
	 * @author Carlos.Lobato
	 * @param date  of application of the price
	 * @param productId
	 * @param brandId
	 * @return ResponseEntity<Optional<PricesDTO>>
	 */
	
	@GetMapping(value = "/prices")
	@ResponseBody
	public ResponseEntity<Optional<PricesDTO>> getPrices(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date date,
			@RequestParam("productId") Long productId, @RequestParam("brandId") Long brandId) {

		Optional<PricesDTO> prices = pricesServices.getPrices(date, productId, brandId);

		if (prices.isPresent()) {
			return new ResponseEntity<Optional<PricesDTO>>(prices, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<PricesDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
