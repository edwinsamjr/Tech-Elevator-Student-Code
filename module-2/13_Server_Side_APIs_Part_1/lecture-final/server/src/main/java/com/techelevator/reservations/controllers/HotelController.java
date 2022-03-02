package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list(
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city) {

        List<Hotel> hotels = hotelDao.list();

        boolean haveStateCriteria = state != null;
        boolean haveCityCriteria = city != null;
        if (!haveStateCriteria && !haveCityCriteria) {
            return hotels;
        }

        // do our filtering
        List<Hotel> filteredList = new ArrayList<>();
        for(Hotel hotel : hotels) {
            String hotelCity = hotel.getAddress().getCity();
            String hotelState = hotel.getAddress().getState();

            boolean cityMatches = hotelCity.equalsIgnoreCase(city);
            boolean stateMatches = hotelState.equalsIgnoreCase(state);
            if (cityMatches && stateMatches) {
                filteredList.add(hotel);
            } else if (cityMatches && !haveStateCriteria) {
                filteredList.add(hotel);
            } else if (stateMatches && !haveCityCriteria) {
                filteredList.add(hotel);
            }

        }

        return filteredList;
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }

    /*
    • List all reservations in the system:  /reservations
	• Get a reservation by its id           /reservations/{id}
	• List all reservations by a hotel      /hotels/{id}/reservations
	• Create a new reservation              /reservations (POST)
	• Filter hotels by city and state       /hotels?city={city}&state={state}
     */

    //    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return this.reservationDao.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation getReservationById(@PathVariable int id) {
        return this.reservationDao.get(id);
    }

    @GetMapping("/hotels/{id}/reservations")
    public List<Reservation> getReservationsByHotelId(@PathVariable("id") int hotelId) {
        return this.reservationDao.findByHotel(hotelId);
    }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation newReservation) {
        return this.reservationDao.create(newReservation, newReservation.getHotelID());
    }

}
