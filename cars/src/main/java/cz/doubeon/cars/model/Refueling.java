package cz.doubeon.cars.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Refueling {
	private BigInteger id;
	private Date refDate;
	private BigDecimal price;
	private BigDecimal amount;
	private BigDecimal km;
	private BigInteger carId;
	private String location;
	private String fuel;

	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getKm() {
		return km;
	}

	public void setKm(BigDecimal km) {
		this.km = km;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public BigInteger getCarId() {
		return carId;
	}

	public void setCarId(BigInteger carId) {
		this.carId = carId;
	}

}
