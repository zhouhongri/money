package com.publiccar.code.model;
// default package
// Generated 2018-5-23 17:35:35 by Hibernate Tools 4.0.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Consumption generated by hbm2java
 */
@Entity
@Table(name = "consumption", catalog = "publiccar")
public class Consumption implements java.io.Serializable {

	private Integer consumptionId;
	private Integer carId;
	private Integer deiverId;
	private String consumptionAddress;
	private String consumptionDate;
	private String consumptionMoney;
	private Integer consumptionNumber;

	public Consumption() {
	}

	public Consumption(Integer carId, Integer deiverId, String consumptionAddress, String consumptionDate,
			String consumptionMoney, Integer consumptionNumber) {
		this.carId = carId;
		this.deiverId = deiverId;
		this.consumptionAddress = consumptionAddress;
		this.consumptionDate = consumptionDate;
		this.consumptionMoney = consumptionMoney;
		this.consumptionNumber = consumptionNumber;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "consumption_id", unique = true, nullable = false)
	public Integer getConsumptionId() {
		return this.consumptionId;
	}

	public void setConsumptionId(Integer consumptionId) {
		this.consumptionId = consumptionId;
	}

	@Column(name = "car_id")
	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	@Column(name = "deiver_id")
	public Integer getDeiverId() {
		return this.deiverId;
	}

	public void setDeiverId(Integer deiverId) {
		this.deiverId = deiverId;
	}

	@Column(name = "consumption_address")
	public String getConsumptionAddress() {
		return this.consumptionAddress;
	}

	public void setConsumptionAddress(String consumptionAddress) {
		this.consumptionAddress = consumptionAddress;
	}

	@Column(name = "consumption_date", length = 0)
	public String getConsumptionDate() {
		return this.consumptionDate;
	}

	public void setConsumptionDate(String consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	@Column(name = "consumption_money")
	public String getConsumptionMoney() {
		return this.consumptionMoney;
	}

	public void setConsumptionMoney(String consumptionMoney) {
		this.consumptionMoney = consumptionMoney;
	}

	@Column(name = "consumption_number")
	public Integer getConsumptionNumber() {
		return this.consumptionNumber;
	}

	public void setConsumptionNumber(Integer consumptionNumber) {
		this.consumptionNumber = consumptionNumber;
	}

}