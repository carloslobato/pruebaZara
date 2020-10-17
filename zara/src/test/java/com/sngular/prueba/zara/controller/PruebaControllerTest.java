package com.sngular.prueba.zara.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sngular.prueba.zara.dto.PricesDTO;
import com.sngular.prueba.zara.services.PricesServices;

@ExtendWith(SpringExtension.class)

public class PruebaControllerTest {

	@Mock
	private PricesServices pricesServices;

	@InjectMocks
	private PruebaController pruebaController;

	@Test
	public void getPricesWhenResponseOK() {

		PricesDTO pricesDto = new PricesDTO();
		pricesDto.setProductId(345L);
		pricesDto.setPriceList(1L);
		pricesDto.setBrandId(1L);
		pricesDto.setCurr("EUR");
		pricesDto.setPrice(29.00f);
		pricesDto.setStartDate("2020-06-14 10:00");
		pricesDto.setEndDate("2020-06-14 21:00");

		Optional<PricesDTO> prices = Optional.of(pricesDto);

		Mockito.when(pricesServices.getPrices(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(prices);

		ResponseEntity<Optional<PricesDTO>> result = pruebaController.getPrices(new Date(), 345L, 1L);

		PricesDTO resultPrices = result.getBody().get();
		
		assertNotNull(result);
		
		assertEquals(prices.get().getPrice(), resultPrices.getPrice());
		assertEquals(prices.get().getBrandId(), resultPrices.getBrandId());
		assertEquals(prices.get().getStartDate(), resultPrices.getStartDate());
		assertEquals(prices.get().getEndDate(), resultPrices.getEndDate());
		assertEquals(prices.get().getProductId(), resultPrices.getProductId());
		assertEquals(prices.get().getPriceList(), resultPrices.getPriceList());

	}

	@Test
	public void getPricesWhenResponseNoContent() {

		ResponseEntity<Optional<PricesDTO>> response = new ResponseEntity<Optional<PricesDTO>>(HttpStatus.NO_CONTENT);
		Optional<PricesDTO> prices = Optional.empty();

		Mockito.when(pricesServices.getPrices(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(prices);
		ResponseEntity<Optional<PricesDTO>> result = pruebaController.getPrices(new Date(), 345L, 1L);

		assertEquals(response.getStatusCode(), result.getStatusCode());
	}

}
