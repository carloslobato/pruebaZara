package com.sngular.prueba.zara.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sngular.prueba.zara.dto.PricesDTO;
import com.sngular.prueba.zara.entities.Prices;
import com.sngular.prueba.zara.mapper.ResponseMapper;
import com.sngular.prueba.zara.repositories.PricesRepository;
import com.sngular.prueba.zara.services.PricesServices;

@Service
public class PricesServicesImpl implements PricesServices {

	@Autowired
	private PricesRepository pricesRepository;

	@Autowired
	private ResponseMapper responseMapper;

	/**
	 * Return a Optional<PricesDTO> object the price to be applied for a specific
	 * product on an application date.
	 * 
	 * @author Carlos.Lobato
	 * @param date      of application of the price
	 * @param productId
	 * @parama brandId
	 * @return Optional<PricesDTO>
	 */
	@Override
	public Optional<PricesDTO> getPrices(Date date, Long productId, Long brandId) {

		Optional<List<Prices>> lstPrices = pricesRepository.findPrices(date, productId, brandId);

		if (lstPrices.isPresent()) {
			List<Prices> prices = lstPrices.get();

			PricesDTO priceDTO = responseMapper.convertToDto(prices.get(0));
			return Optional.of(priceDTO);
		} else {

			return Optional.empty();
		}

	}

}
