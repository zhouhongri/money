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
 * Repair generated by hbm2java
 */
@Entity
@Table(name = "repair", catalog = "publiccar")
public class Repair implements java.io.Serializable {

	private Integer repairId;
	private Integer carId;
	private Integer driverId;
	private String repairContent;
	private String repairUnit;
	private String repairDate;
	private String repairMoney;

	public Repair() {
	}

	public Repair(Integer carId, Integer driverId, String repairContent, String repairUnit, String repairDate,
			String repairMoney) {
		this.carId = carId;
		this.driverId = driverId;
		this.repairContent = repairContent;
		this.repairUnit = repairUnit;
		this.repairDate = repairDate;
		this.repairMoney = repairMoney;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "repair_id", unique = true, nullable = false)
	public Integer getRepairId() {
		return this.repairId;
	}

	public void setRepairId(Integer repairId) {
		this.repairId = repairId;
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

	@Column(name = "repair_content", length = 100)
	public String getRepairContent() {
		return this.repairContent;
	}

	public void setRepairContent(String repairContent) {
		this.repairContent = repairContent;
	}

	@Column(name = "repair_unit")
	public String getRepairUnit() {
		return this.repairUnit;
	}

	public void setRepairUnit(String repairUnit) {
		this.repairUnit = repairUnit;
	}

	@Column(name = "repair_date")
	public String getRepairDate() {
		return this.repairDate;
	}

	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}

	@Column(name = "repair_money")
	public String getRepairMoney() {
		return this.repairMoney;
	}

	public void setRepairMoney(String repairMoney) {
		this.repairMoney = repairMoney;
	}

}
