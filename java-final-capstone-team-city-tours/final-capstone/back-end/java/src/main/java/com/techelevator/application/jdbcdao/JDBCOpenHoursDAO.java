package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.OpenHoursDAO;
import com.techelevator.application.model.OpenHours;

@Component
public class JDBCOpenHoursDAO implements OpenHoursDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCOpenHoursDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<OpenHours> readOpenHoursById(long destinationId) {
		List<OpenHours> list = new ArrayList<>();
		String sqlReadOpenHoursById = "SELECT open_hours.*, day_of_week.name " +
				 					  "FROM open_hours " + 
				 					  "INNER JOIN day_of_week on day_of_week.day_id = open_hours.day_id " +
									  "WHERE destination_id = ? ";
									
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlReadOpenHoursById, destinationId);
		while(results.next()) {
			OpenHours openHours = mapRowToOpenHours(results);
			list.add(openHours);
		}
		return list;
	}


	private OpenHours mapRowToOpenHours(SqlRowSet results) {
		OpenHours openHours = new OpenHours();
		openHours.setHoursId(results.getLong("hours_id"));
		openHours.setDayId(results.getLong("day_id"));
		openHours.setDestinationId(results.getLong("destination_id"));
		openHours.setOpen(results.getString("open"));
		openHours.setClose(results.getString("close"));
		openHours.setDayOfWeek(results.getString("name"));
		return openHours;
	}
}
