package com.hotel.reservations.controller;

import com.hotel.reservations.dto.ReservationDto;
import com.hotel.reservations.handlers.Response;
import com.hotel.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reservation")
public class ReservationController {


    private ReservationService service;

    @Autowired
    public ReservationController(ReservationService service){this.service = service;}

    @GetMapping("/{id}")
    @ResponseBody
    //@CrossOrigin(origins = "http://localhost:4200")
    public Response findById(@PathVariable Long id){return service.findById(id);}

    @GetMapping
    public Response findAll(){return service.findByAll();}

    @PostMapping
    @ResponseBody
    public Response save(@Valid @RequestBody ReservationDto dto){
        return service.save(dto);
    }

    @PutMapping
    @ResponseBody
    public Response update(@Valid @RequestBody ReservationDto dto) {
        return service.update(dto);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public Response delete(@PathVariable Long id){
        return service.delete(id);
    }

}
