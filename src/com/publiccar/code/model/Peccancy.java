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
 * Peccancy generated by hbm2java
 */
@Entity
@Table(name = "peccancy", catalog = "publiccar")
public class Peccancy implements java.io.Serializable {

	private Integer peccancyId;
	private Integer carId;
	private Integer driverId;
	private String peccancyContent;
	private String peccancyDate;

	public Peccancy() {
	}

	public Peccancy(Integer carId, Integer driverId, String peccancyContent, String peccancyDate) {
		this.carId = carId;
		this.driverId = driverId;
		this.peccancyContent = peccancyContent;
		this.peccancyDate = peccancyDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "peccancy_id", unique = true, nullable = false)
	public Integer getPeccancyId() {
		return this.peccancyId;
	}

	public void setPeccancyId(Integer peccancyId) {
		this.peccancyId = peccancyId;
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

	@Column(name = "peccancy_content")
	public String getPeccancyContent() {
		return this.peccancyContent;
	}

	public void setPeccancyContent(String peccancyContent) {
		this.peccancyContent = peccancyContent;
	}

	@Column(name = "peccancy_date")
	public String getPeccancyDate() {
		return this.peccancyDate;
	}

	public void setPeccancyDate(String peccancyDate) {
		this.peccancyDate = peccancyDate;
	}

}
