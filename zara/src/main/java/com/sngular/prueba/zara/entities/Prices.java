package com.sngular.prueba.zara.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRICES")
public class Prices {

	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	@Column(name="ID")		
	Long id;
	
	@Column(name="BRAND_ID")
	Long brandId;
	
	@Column(name="START_DATE")
	Timestamp startDate;
	
	@Column(name="END_DATE")
	Timestamp endDate;
	
	@Column(name="PRICE_LIST")
	Long priceList;
	
	@Column(name="PRODUCT_ID")
	Long productId;
	
	@Column(name="PRIORITY")
	Long priority;
	
	@Column(name="PRICE")
	float price;
	
	@Column(name="CURR")
	String curr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	
}
