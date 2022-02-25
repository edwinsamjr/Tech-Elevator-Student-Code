package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DuplicateKeyException;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park park = sut.getPark(1);
        this.assertParksMatch(PARK_1, park);

    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Park park = sut.getPark(99);
        Assert.assertNull(park);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parks = sut.getParksByState("AA");
        Assert.assertEquals(2, parks.size());

        this.assertParksMatch(PARK_1, parks.get(0));
        this.assertParksMatch(PARK_3, parks.get(1));
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> parks = sut.getParksByState("XX");
        Assert.assertEquals(0, parks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Park expectedPark = new Park(0, "Oak Park", LocalDate.now(), 2, true);
        Park actualPark = sut.createPark(expectedPark);

        expectedPark.setParkId(actualPark.getParkId());

        this.assertParksMatch(expectedPark, actualPark);
//        Assert.assertEquals(expectedPark.getParkName(), actualPark.getParkName());
//        Assert.assertEquals(expectedPark.getArea(), actualPark.getArea(), 0.1);
//        Assert.assertEquals(expectedPark.getDateEstablished(), actualPark.getDateEstablished());
//        Assert.assertEquals(expectedPark.getHasCamping(), actualPark.getHasCamping());

    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Park expectedPark = new Park(0, "Oak Park", LocalDate.now(), 2, true);
        Park createPark = sut.createPark(expectedPark);
//        expectedPark.setParkId(createPark.getParkId());

        Park actualPark = sut.getPark(createPark.getParkId());
//        this.assertParksMatch(expectedPark, actualPark);
        this.assertParksMatch(createPark, actualPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Park parkToUpdate = sut.getPark(1);
        parkToUpdate.setParkName("french park");
        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setArea(200);
        parkToUpdate.setHasCamping(!parkToUpdate.getHasCamping());

        sut.updatePark(parkToUpdate);

        Park retrievedPark = sut.getPark(1);
        this.assertParksMatch(parkToUpdate, retrievedPark);

    }

    @Test
    public void deleted_park_cant_be_retrieved() {
     sut.deletePark(2);
     Park retrievedPark = sut.getPark(2);
     Assert.assertNull(retrievedPark);

    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
     sut.addParkToState(1, "BB");
     List<Park> parksInState = sut.getParksByState("BB");
     this.assertParksMatch(PARK_1, parksInState.get(0));
    }

    @Test(expected = DuplicateKeyException.class)
    public void duplicateParkStateAssignmentThrows() {
        sut.addParkToState(1, "AA");
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
     sut.removeParkFromState(3, "AA");
     List<Park> parks = sut.getParksByState("AA");
     Assert.assertEquals(1, parks.size());
//     this.assertParksMatch(sut.getPark(2 ), parks.get(0));
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals("ids do not match", expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
