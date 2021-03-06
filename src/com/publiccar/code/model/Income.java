package com.publiccar.code.model;
// default package
// Generated 2018-5-31 19:20:17 by Hibernate Tools 4.0.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Income generated by hbm2java
 */
@Entity
@Table(name = "income", catalog = "publiccar")
public class Income implements java.io.Serializable {

	private Integer incomeId;
	private Integer carId;
	private Integer driverId;
	private String incomeSumMoney;

	public Income() {
	}

	public Income(Integer carId, Integer driverId, String incomeSumMoney) {
		this.carId = carId;
		this.driverId = driverId;
		this.incomeSumMoney = incomeSumMoney;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "income_id", unique = true, nullable = false)
	public Integer getIncomeId() {
		return this.incomeId;
	}

	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}

	@Column(name = "car_id")
	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	@Column(name = "driver_id")
	public Integer getDriverId() {
		return this.driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	@Column(name = "income_sum_money", length = 100)
	public String getIncomeSumMoney() {
		return this.incomeSumMoney;
	}

	public void setIncomeSumMoney(String incomeSumMoney) {
		this.incomeSumMoney = incomeSumMoney;
	}

}
