package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(long parkId) {
        String sql = "SELECT park_id, park_name, date_established, area, has_camping" +
                " FROM park" +
                " WHERE park_id = ?;";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, parkId);
        Park park = null;
        if (results.next()) {
            park = mapRowToPark(results);
        }

        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        final String sql =
                "SELECT park.park_id, park.park_name, park.date_established, park.area, park.has_camping" +
                        " FROM park" +
                        " JOIN park_state ON park.park_id = park_state.park_id" +
                        " WHERE park_state.state_abbreviation = ?;";

        SqlRowSet result = this.jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        List<Park> parks = new ArrayList<>();

        while (result.next()) {
            Park park = this.mapRowToPark(result);
            parks.add(park);
        }

        return parks;
    }


    @Override
    public Park createPark(Park park) {
        final String sql =
                "INSERT INTO park (park_name, date_established, area, has_camping)" +
                        " VALUES (?, ?, ?, ?) RETURNING park_id;";
        Long newID = this.jdbcTemplate.queryForObject(sql, Long.class,
                park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping());

        Park resultPark = getPark(newID);
        return resultPark;
    }

    @Override
    public void updatePark(Park park) {
        final String sql =
                "UPDATE park" +
                        " SET park_name = ?, date_established = ?, area = ?, has_camping = ?" +
                        " WHERE park_id = ?;";

        this.jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping(), park.getParkId());

    }

    @Override
    public void deletePark(long parkId) {
        final String removefromParkState =
                "DELETE from park_state WHERE park_id = ?";

        final String removeFromPark =
                "DELETE FROM park WHERE park_id = ?";

        this.jdbcTemplate.update(removefromParkState, parkId);
        this.jdbcTemplate.update(removeFromPark, parkId);
    }

    @Override
    public void addParkToState(long parkId, String stateAbbreviation) {
        final String sql =
                "INSERT INTO park_state (park_id, state_abbreviation)" +
                        " VALUES (?, ?);";
        this.jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    @Override
    public void removeParkFromState(long parkId, String stateAbbreviation) {

        final String sql =
                "DELETE FROM park_state WHERE park_id = ? AND state_abbreviation = ?;";
        this.jdbcTemplate.update(sql, parkId, stateAbbreviation);

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();

        park.setParkId(rowSet.getLong("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));

        return park;
    }
}
