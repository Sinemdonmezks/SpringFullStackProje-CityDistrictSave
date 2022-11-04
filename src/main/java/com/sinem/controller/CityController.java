package com.sinem.controller;

import com.sinem.dto.request.SaveRequestDto;
import com.sinem.repository.entity.City;
import com.sinem.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping ("/save")
    public ResponseEntity<City> save(@RequestBody SaveRequestDto dto){
        return ResponseEntity.ok(cityService.save(dto));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<City>> findAll(){
        return ResponseEntity.ok(cityService.findAll());
    }
}
 */
