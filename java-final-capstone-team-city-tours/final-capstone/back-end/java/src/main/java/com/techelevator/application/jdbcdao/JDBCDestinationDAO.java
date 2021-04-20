package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.DestinationDAO;
import com.techelevator.application.model.Destination;

@Component
public class JDBCDestinationDAO implements DestinationDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCDestinationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Destination> getAllDestinations() {
		List<Destination> list = new ArrayList<>();
		String sqlGetAllDestinations = "SELECT * " +
									   "FROM destinations ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDestinations);
		while(results.next()) {
			Destination destination = mapRowToDestination(results);
			list.add(destination);
		}
		return list;
	}
	
	@Override
	public List<Destination> viewDestinationsByItineraryId(Long id) {
		List<Destination> list = new ArrayList<>();
		String sqlViewDestinationsByItineraryId = "SELECT destinations.* " +
												  "FROM destinations " +
												  "JOIN itinerary_destination ON destinations.destination_id = itinerary_destination.destination_id " +
												  "JOIN itinerary ON itinerary.itinerary_id = itinerary_destination.itinerary_id " +
												  "WHERE itinerary.itinerary_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlViewDestinationsByItineraryId, id);
		while(results.next()) {
			Destination destination = mapRowToDestination(results);
			list.add(destination);
		}
		return list;							
	}
	
	@Override
	public List<Destination> findDestinationsByZip(String zipcode) {
		List<Destination> list = new ArrayList<>();
		String sqlGetDestinationByZipcode = "SELECT * " +
				 					        "FROM destinations " +  
									        "WHERE zipcode = ? ";
									
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDestinationByZipcode, zipcode);
		while(results.next()) {
			Destination destination = mapRowToDestination(results);
			list.add(destination);
		}
		return list;
	}

	@Override
	public List<Destination> findDestinationByName(String name) {
		List<Destination> list = new ArrayList<>();
		String sqlGetDestinationByName = "SELECT * " +
									     "FROM destinations " + 
								         "WHERE name = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDestinationByName, name);
		while (results.next()) {
			list.add(mapRowToDestination(results));
		}
		return list;
	}

	@Override
	public List<Destination> findDestinationById(long destinationId) {
		List<Destination> list = new ArrayList<>();
		String sqlGetDestinationById = "SELECT * " +
									   "FROM destinations " + 
								       "WHERE destination_id = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDestinationById, destinationId);
		while (results.next()) {
			list.add(mapRowToDestination(results));
		}
		return list;
	}
	
	@Override
	public List<Destination> findDestinationsByType(String type) {
		List<Destination> list = new ArrayList<>();
		String sqlGetDestinationByType = "SELECT * " +
									   "FROM destinations " + 
								       "WHERE type = ? ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDestinationByType, type);
		while (results.next()) {
			list.add(mapRowToDestination(results));
		}
		return list;
	}
	

	@Override
	public void deleteDestination(long destinationId) {
		String deleteDestination = "DELETE " +
								   "FROM destinations " +
								   "WHERE destination_id = ? ";
		jdbcTemplate.update(deleteDestination, destinationId);
	}

	private Destination mapRowToDestination(SqlRowSet results) {
		Destination destination = new Destination();
		destination.setDestinationId(results.getLong("destination_id"));
		destination.setName(results.getString("name"));
		destination.setDescription(results.getString("description"));
		destination.setStreetAddress(results.getString("street_address"));
		destination.setCity(results.getString("city"));
		destination.setState(results.getString("state"));
		destination.setZipcode(results.getString("zipcode"));
		destination.setLatitude(results.getDouble("latitude"));
		destination.setLongitude(results.getDouble("longitude"));
		destination.setWebsite(results.getString("website"));
		destination.setType(results.getString("type"));
		destination.setImage(results.getString("image"));
		return destination;
	}

	
}
