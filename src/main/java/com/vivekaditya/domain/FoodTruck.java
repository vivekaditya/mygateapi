package com.vivekaditya.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * 
 */
@Entity
@Table(name = "foodTrucks")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FoodTruck {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column()
	private String locationid;

	@Column()
	private String applicant;

	@Column()
	private String facilityType;

	@Column()
	private String cnn;

	@Column()
	private String locationDescription;

	@Column()
	private String address;

	@Column()
	private String blocklot;

	@Column()
	private String block;

	@Column()
	private String lot;

	@Column()
	private String permit;

	@Column()
	private String status;

	@Lob
	private String foodItems;

	@Column()
	private Double x;

	@Column()
	private Double y;

	@Column()
	private Double latitude;

	@Column()
	private Double longitude;

	@Lob
	private String schedule;

	@Column()
	private String dayshours;

	@Column()
	private Date NOISent;

	@Column()
	private Date approved;

	@Column()
	private Date received;

	@Column()
	private String priorPermit;

	@Column()
	private Date expirationDate;

	@Column()
	private String location;

	public FoodTruck() {
	}

	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public String getCnn() {
		return cnn;
	}

	public void setCnn(String cnn) {
		this.cnn = cnn;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlocklot() {
		return blocklot;
	}

	public void setBlocklot(String blocklot) {
		this.blocklot = blocklot;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDayshours() {
		return dayshours;
	}

	public void setDayshours(String dayshours) {
		this.dayshours = dayshours;
	}

	public Date getNOISent() {
		return NOISent;
	}

	public void setNOISent(Date nOISent) {
		NOISent = nOISent;
	}

	public Date getApproved() {
		return approved;
	}

	public void setApproved(Date approved) {
		this.approved = approved;
	}

	public Date getReceived() {
		return received;
	}

	public void setReceived(Date received) {
		this.received = received;
	}

	public String getPriorPermit() {
		return priorPermit;
	}

	public void setPriorPermit(String priorPermit) {
		this.priorPermit = priorPermit;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
