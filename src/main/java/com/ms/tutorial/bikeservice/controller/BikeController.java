package com.ms.tutorial.bikeservice.controller;

import com.ms.tutorial.bikeservice.entity.Bike;
import com.ms.tutorial.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll(){
        List<Bike> bikes = bikeService.getAll();
        if(bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable("id") int id){
        Bike bike = bikeService.getBikeById(id);
        if(bike == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bike);
    }

    @PostMapping()
    public ResponseEntity<Bike> save(@RequestBody Bike bike){
        Bike BikeNew = bikeService.savebike(bike);
        return ResponseEntity.ok(BikeNew);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") int userId){
        List<Bike> Bikes = bikeService.byUserId(userId);
        if(Bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(Bikes);
    }



}
