package com.sngular.prueba.zara.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sngular.prueba.zara.dto.PricesDTO;
import com.sngular.prueba.zara.entities.Prices;
import com.sngular.prueba.zara.mapper.ResponseMapper;
import com.sngular.prueba.zara.repositories.PricesRepository;
import com.sngular.prueba.zara.services.impl.PricesServicesImpl;

@ExtendWith(SpringExtension.class)
public class PricesServicesImplTest {

	@InjectMocks
	private PricesServicesImpl pricesServicesImpl;

	@Mock
	private PricesRepository pricesRepository;

	@Mock
	private ResponseMapper responseMapper;

	@Test
	public void getPricesWhenResultOK() {

		String strStartDate = "2020-06-14 10:00:00";
		String strEndDate = "2020-06-14 21:00:00";
		Timestamp tsStartDate = Timestamp.valueOf(strStartDate);
		Timestamp tsEndDate = Timestamp.valueOf(strEndDate);

		Prices prices = new Prices();
		prices.setId(1L);
		prices.setPriority(2L);
		prices.setProductId(345L);
		prices.setPriceList(1L);
		prices.setBrandId(1L);
		prices.setCurr("EUR");
		prices.setPrice(29.00f);
		prices.setStartDate(tsStartDate);
		prices.setEndDate(tsEndDate);

		List<Prices> listPrices = new ArrayList<Prices>();
		listPrices.add(prices);

		Optional<List<Prices>> lstPrices = Optional.of(listPrices);

		PricesDTO pricesDTO = new PricesDTO();
		pricesDTO.setBrandId(1L);
		pricesDTO.setProductId(345L);
		pricesDTO.setCurr("EUR");
		pricesDTO.setPrice(29.00f);
		pricesDTO.setStartDate(strStartDate);
		pricesDTO.setEndDate(strEndDate);

		Mockito.when(pricesRepository.findPrices(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(lstPrices);
		Mockito.when(responseMapper.convertToDto(prices)).thenReturn(pricesDTO);

		Optional<PricesDTO> result = pricesServicesImpl.getPrices(new Date(), 345L, 1L);

		assertNotNull(result);
		assertEquals(pricesDTO, result.get());

	}

	@Test
	public void getPricesIsEmpty() {

		Optional<List<Prices>> lstPrices = Optional.empty();

		Mockito.when(pricesRepository.findPrices(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(lstPrices);

		Optional<PricesDTO> result = pricesServicesImpl.getPrices(new Date(), 345L, 1L);

		assertEquals(Optional.empty(), result);
	}
}
