package cz.doubeon.cars.dao;

import java.math.BigInteger;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import cz.doubeon.cars.model.Refueling;

@Component
public class RefuelingsDao {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Refueling> getByCar(BigInteger carId) {
		final MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("car_id", carId);

		return jdbc.query("select * from refueling where car_id = :car_id order by ref_date asc", params,
				new BeanPropertyRowMapper<>(Refueling.class));
	}

}
