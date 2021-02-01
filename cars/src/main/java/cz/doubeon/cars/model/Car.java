package cz.doubeon.cars.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Car {
	private BigInteger id;
	private String vin;
	private String model;
	private String regNum;
	private Date purchased;
	private BigDecimal initKm;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public Date getPurchased() {
		return purchased;
	}

	public void setPurchased(Date purchased) {
		this.purchased = purchased;
	}

	public BigDecimal getInitKm() {
		return initKm;
	}

	public void setInitKm(BigDecimal initKm) {
		this.initKm = initKm;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", vin=" + vin + ", model=" + model + ", regNum=" + regNum + ", purchased=" + purchased
				+ ", initKm=" + initKm + "]";
	}

}
