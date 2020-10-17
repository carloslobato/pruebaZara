package com.sngular.prueba.zara.services;

import java.util.Date;
import java.util.Optional;

import com.sngular.prueba.zara.dto.PricesDTO;

public interface PricesServices {

	Optional<PricesDTO> getPrices(Date date, Long productId, Long brandId);

	
}
