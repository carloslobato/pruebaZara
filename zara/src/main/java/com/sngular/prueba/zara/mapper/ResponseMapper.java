package com.sngular.prueba.zara.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sngular.prueba.zara.dto.PricesDTO;
import com.sngular.prueba.zara.entities.Prices;

@Component
public class ResponseMapper {

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Convert a Prices object to a PricesDTO object
	 * 
	 * @author Carlos.Lobato
	 * @param prices
	 * @return PricesDTO
	 */
	public PricesDTO convertToDto(Prices prices) {
		PricesDTO pricesDTO = modelMapper.map(prices, PricesDTO.class);

		return pricesDTO;
	}
}
