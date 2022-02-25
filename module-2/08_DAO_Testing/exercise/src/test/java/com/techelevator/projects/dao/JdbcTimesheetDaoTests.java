package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1L, 1L, 1L, 
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2L, 1L, 1L,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3L, 2L, 1L,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet actualTimesheet = sut.getTimesheet(1L);

        assertTimesheetsMatch(TIMESHEET_1, actualTimesheet);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet actualTimesheet = sut.getTimesheet(99L);

        Assert.assertNull(actualTimesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = sut.getTimesheetsByEmployeeId(1L);

        Assert.assertEquals(2, timesheets.size());
        assertTimesheetsMatch(timesheets.get(0), TIMESHEET_1);
        assertTimesheetsMatch(timesheets.get(1), TIMESHEET_2);

    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);

        Assert.assertEquals(3, timesheets.size());
        assertTimesheetsMatch(timesheets.get(0), TIMESHEET_1);
        assertTimesheetsMatch(timesheets.get(2), TIMESHEET_3);
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet inputTimesheet = new Timesheet(5L, 2L, 2L,
                LocalDate.of(2021, 3, 1), 3, true, "Timesheet 5");

        Timesheet createdTimesheet = sut.createTimesheet(inputTimesheet);
        Long newId = createdTimesheet.getTimesheetId();
        inputTimesheet.setTimesheetId(newId);

        assertTimesheetsMatch(inputTimesheet, createdTimesheet);

    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet inputTimesheet = new Timesheet(89L, 2L, 2L,
                LocalDate.of(2021, 3,1), 3, true, "Timesheet 5");

        Timesheet createdTimesheet = sut.createTimesheet(inputTimesheet);
        Long createdID = createdTimesheet.getTimesheetId();
        Timesheet actualTimesheet = sut.getTimesheet(createdID);
        inputTimesheet.setTimesheetId(createdID);

        assertTimesheetsMatch(inputTimesheet, actualTimesheet);

    }



    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet inputTimesheet = new Timesheet(4L, 1L, 1L,
                LocalDate.of(2021,3,1), 3, true, "Timesheet 5");

        sut.updateTimesheet(inputTimesheet);

        Timesheet createdTimesheet = sut.getTimesheet(4L);
        assertTimesheetsMatch(inputTimesheet, createdTimesheet);

    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(4L);
        Timesheet retrievedTimesheet =sut.getTimesheet(4L);

        Assert.assertNull(retrievedTimesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        Double actualBillableHoursEmp1 = sut.getBillableHours(1L, 1L);
        Double expectedBillableHoursEmp1 = 2.5;

        Double actualBillableHoursEmp2 = sut.getBillableHours(2L, 2L);
        Double expectedBillableHoursEmp2 = 0.0;


        Assert.assertEquals(expectedBillableHoursEmp1, actualBillableHoursEmp1);
        Assert.assertEquals(expectedBillableHoursEmp2, actualBillableHoursEmp2);



    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
