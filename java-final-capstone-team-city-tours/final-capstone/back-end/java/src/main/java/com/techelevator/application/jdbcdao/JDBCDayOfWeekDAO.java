package com.techelevator.application.jdbcdao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.DayOfWeekDAO;
import com.techelevator.application.model.DayOfWeek;
import com.techelevator.application.model.Destination;

@Component
public class JDBCDayOfWeekDAO implements DayOfWeekDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCDayOfWeekDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public DayOfWeek getDayById(long dayId) {
		DayOfWeek dayOfWeek = new DayOfWeek();
		String sqlGetDayById = "SELECT * " +
							   "FROM day_of_week " + 
							   "WHERE day_id = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDayById, dayId);
		if (results.next()) {
			dayOfWeek = mapRowToDayOfWeek(results);
		}
		return dayOfWeek;
	}

	@Override
	public DayOfWeek getDayByName(String name) {
		DayOfWeek dayOfWeek = new DayOfWeek();
		String sqlGetDayByName = "SELECT * " +
								 "FROM day_of_week " + 
							     "WHERE name = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDayByName, name);
		if (results.next()) {
			dayOfWeek = mapRowToDayOfWeek(results);
		}
		return dayOfWeek;
	}

	private DayOfWeek mapRowToDayOfWeek(SqlRowSet results) {
		DayOfWeek dayOfWeek = new DayOfWeek();
		dayOfWeek.setDayId(results.getLong("day_id"));
		dayOfWeek.setName(results.getString("name"));
		return dayOfWeek;
	}
}
