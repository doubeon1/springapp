package cz.doubeon.cars.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import cz.doubeon.cars.model.Car;

@Component("carsDao")
public class CarsDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public boolean create(Car car) {
		final Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("vin", car.getVin());
		paramMap.put("model", car.getModel());
		paramMap.put("reg_num", car.getRegNum());
		paramMap.put("purchased", car.getPurchased());
		paramMap.put("init_km", car.getInitKm());
		return jdbc.update(
				"insert into cars (vin, model, reg_num, purchased, init_km) values (:vin, :model, :reg_num, :purchased, :init_km)",
				paramMap) == 1;

	}

	public List<Car> getAll() {
		return jdbc.query("select * from cars", new BeanPropertyRowMapper<>(Car.class));
	}

	public Car get(BigInteger id) {
		final MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from cars where id=:id", params, new BeanPropertyRowMapper<>(Car.class));

	}

	public boolean delete(BigInteger id) {
		final MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.update("delete from cars where id=:id", params) == 1;
	}

	public boolean update(Car car) {
		final Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("vin", car.getVin());
		paramMap.put("model", car.getModel());
		paramMap.put("reg_num", car.getRegNum());
		paramMap.put("purchased", car.getPurchased());
		paramMap.put("init_km", car.getInitKm());
		paramMap.put("id", car.getId());
		return jdbc.update(
				"update cars set vin=:vin, model = :model, reg_num = :reg_num, purchased = :purchased, init_km = :init_km where id =:id",
				paramMap) == 1;
	}

}