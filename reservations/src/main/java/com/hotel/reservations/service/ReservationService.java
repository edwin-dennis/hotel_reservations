package com.hotel.reservations.service;

import com.hotel.reservations.Constants;
import com.hotel.reservations.dto.ReservationDto;
import com.hotel.reservations.entity.Reservation;
import com.hotel.reservations.handlers.Response;
import com.hotel.reservations.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.hotel.reservations.Constants.*;

@Service
public class ReservationService {

    private ReservationRepository repository;

    @Autowired
    public ReservationService(ReservationRepository repository){
        this.repository = repository;
    }

    public Response findById(Long id){

        Optional<Reservation> instance = repository.findById(id);

        return instance.map(Constants::success).orElseGet(Constants::incorrectInformation);
    }

    public Response findByAll(){
        return success(repository.findAll());
    }

    public Response save(ReservationDto dto){

        if(dto.getId()!=null){
            return update(dto);
        }

        Reservation reservation = new Reservation();
        reservation.setRoomNumber(dto.getRoomNumber());
        reservation.setClientFullName(dto.getClientFullName());
        reservation.setReservationDates(dto.getReservationDates());
        return successfulSaved(repository.save(reservation));
    }

    public Response update(ReservationDto dto){

        Optional<Reservation> findItem = repository.findById(dto.getId());

        if(findItem.isPresent()){
            Reservation reservation = findItem.get();
            reservation.setRoomNumber(dto.getRoomNumber());
            reservation.setClientFullName(dto.getClientFullName());
            reservation.setReservationDates(dto.getReservationDates());

            return successfullyUpdated(repository.save(reservation));

        }
        return incorrectInformation();
    }

    public Response delete(Long id){

        Optional<Reservation> findItem = repository.findById(id);

        if(findItem.isPresent()){
            repository.delete(findItem.get());
            return successfullyUpdated("");

        }
        return incorrectInformation();
    }



}
