import com.techelevator.HotelReservation;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class HotelReservationTest {


    //Test estimate total calculation
    @Test
    public void gives_correct_total_for_1_night() {
        HotelReservation hotelReservation = new HotelReservation("Edwin", 1);

        BigDecimal actualTotal =  hotelReservation.getEstimatedTotal();
        BigDecimal expectedTotal = new BigDecimal("59.99");

        Assert.assertEquals("Did not give total of $59.99 for one night",expectedTotal, actualTotal);

    }

    @Test
    public void gives_correct_total_for_2_nights() {
        HotelReservation hotelReservation = new HotelReservation("Edwin", 2);

        BigDecimal actualTotal =  hotelReservation.getEstimatedTotal();
        BigDecimal expectedTotal = new BigDecimal("119.98");

        Assert.assertEquals("Did not give total of $119.98 for two nights",expectedTotal, actualTotal);

    }

    /*Couldn't figure out syntax in time to get exception test to pass instead
    of just printing the exception message*/
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void gives_exception_if_name_is_empty() {
        HotelReservation hotelReservation = new HotelReservation("", 1);

        BigDecimal actualTotal =  hotelReservation.getEstimatedTotal();
        BigDecimal expectedTotal = new BigDecimal("59.99");

        Assert.assertEquals("Did not give exception when name was empty",expectedTotal, actualTotal);
    }

    @Test (expected = java.lang.IllegalArgumentException.class)
    public void gives_exception_if_name_is_null() {
        HotelReservation hotelReservation = new HotelReservation(null, 1);

        BigDecimal actualTotal =  hotelReservation.getEstimatedTotal();
        BigDecimal expectedTotal = new BigDecimal("59.99");

        Assert.assertEquals("Did not give exception when name was null",expectedTotal, actualTotal);

    }

    @Test (expected = java.lang.IllegalArgumentException.class)
    public void gives_exception_if_num_of_nights_is_below_1() {
        HotelReservation hotelReservation = new HotelReservation("Edwin", 0);

        BigDecimal actualTotal =  hotelReservation.getEstimatedTotal();
        BigDecimal expectedTotal = new BigDecimal("59.99");

        Assert.assertEquals("Did not give exception when number of nights is below 1",expectedTotal, actualTotal);

    }





    //Test actual total method

    @Test
    public void gives_correct_total_after_minibar_fee() {
        HotelReservation hotelReservation = new HotelReservation("Edwin", 1);
        BigDecimal actualTotal =  hotelReservation.addFees(true, false);
        BigDecimal expectedTotal = new BigDecimal("72.98");

        Assert.assertEquals("Did not give total of $72.98 for one night and minibar used",expectedTotal, actualTotal);

    }

    @Test
    public void gives_correct_total_after_cleaning_fee() {
        HotelReservation hotelReservation = new HotelReservation("Edwin", 1);
        BigDecimal actualTotal =  hotelReservation.addFees(false, true);
        BigDecimal expectedTotal = new BigDecimal("94.98");

        Assert.assertEquals("Did not give total of $94.98 for one night and cleaning fee",expectedTotal, actualTotal);

    }

    @Test
    public void gives_correct_total_after_minibar_and_cleaning_fees() {
        HotelReservation hotelReservation = new HotelReservation("Edwin", 1);
        BigDecimal actualTotal =  hotelReservation.addFees(true, true);
        BigDecimal expectedTotal = new BigDecimal("142.96");

        Assert.assertEquals("Did not give total of $142.96 for one night and minibar used",expectedTotal, actualTotal);

    }


}
