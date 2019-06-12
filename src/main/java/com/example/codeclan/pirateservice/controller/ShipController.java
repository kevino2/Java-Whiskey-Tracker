package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repository.ShipRepository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ships")
public class ShipController {

    @Autowired
    ShipRepository shipRepository;
    @GetMapping(value = "/pirates/{name}")
//    name variable above and below need to be same
    public List<Ship>findShipWithPiratesNamed(@PathVariable String name){
        return shipRepository.findShipsThatHavePiratesNamed(name);
    }

//    Now that restful API installed controllers are only used for customised searches



//    @GetMapping
//    public List<Ship> getAllPirates(){
//        return shipRepository.findAll();
//    }
}
