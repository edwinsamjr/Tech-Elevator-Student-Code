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
    public List<Hotel> list() {
        return hotelDao.list();
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
     * List all reservations in the system:  /reservations
     * Get a reservation by its id:          /reservations/{id}
     * List all reservations by a hotel:     /hotels/{id}/reservations
     * Create a new reservation:             /reservations
     * Filter hotels by city and state:      /hotels?city={city}&state={state}

     */

    //    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    @GetMapping(path = "/reservations")
    public List<Reservation> getReservations() {
        return this.reservationDao.findAll();
    }

    @GetMapping(path = "/reservations/{id}")
    public Reservation getReservationById(@PathVariable int id) {
        return reservationDao.get(id);
    }

    @GetMapping(path = "/hotels/{id}/reservations")
    public List<Reservation> getReservationsByHotelId(@PathVariable("id") int hotelId) {
        return this.reservationDao.findByHotel(hotelId);
    }

    @PostMapping(path = "/reservations")
    public void createReservation(Reservation newReservation) {
        this.reservationDao.create(newReservation, newReservation.getHotelID());
    }

    @RequestMapping(path = "/hotels/", method = RequestMethod.GET)
    public List<Hotel> list(
            @RequestParam String state,
            @RequestParam String city) {
        List<Hotel> hotels = hotelDao.list();

        if (state == null && city == null) {
            return hotelDao.list();
        }

        List<Hotel> filteredList = new ArrayList<>();
        for (Hotel hotel : hotels) {
            String hotelCity = hotel.getAddress().getCity();
            String hotelState = hotel.getAddress().getState();
            if (hotelCity.equalsIgnoreCase(city) && hotelState.equalsIgnoreCase(state)) {
                filteredList.add(hotel);
            }

        }
        return filteredList;

    }
}
