package com.sngular.prueba.zara.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sngular.prueba.zara.entities.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

	/**
	 * Query the rate to apply to a product of a brand on a specific date
	 * 
	 * @author Carlos.Lobato
	 * @param date  of application of the price
	 * @param productId
	 * @param brandId 
	 * @return List<Prices>
	 */
	@Query("SELECT p FROM Prices p WHERE p.startDate<=:date and p.endDate>=:date and p.productId = :productId and p.brandId = :brandId order by p.priority DESC")
	Optional<List<Prices>> findPrices(@Param("date") Date date, @Param("productId") Long productId,
			@Param("brandId") Long brandId);

}
