package com.example.project.project.controller;

import com.example.project.project.pojo.Car;
import com.example.project.project.pojo.CarShop;
import com.example.project.project.repository.CarRepository;
import com.example.project.project.repository.CarShopRepository;
import com.example.project.project.service.CarShopService;
import com.example.project.project.service.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarshopController {
    @Autowired
    private CarShopService service;
    @Autowired
    private CarRepository repository;
    @Autowired
    private CarShopRepository carShopRepository;

    @GetMapping("/carshops")
    public ResponseEntity<List<CarShop>> getAllCarShops() {
        List<CarShop> list = service.getAllCarShops();

        return new ResponseEntity<List<CarShop>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("carshop/{id}")
    public ResponseEntity<CarShop> getCarShopById(@PathVariable("id") Long id) throws RecordNotFoundException {
        CarShop carShop = service.getCarShopById(id);

        return new ResponseEntity<CarShop>(carShop, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) throws RecordNotFoundException {
        Car car = service.getCarById(id);

        return new ResponseEntity<Car>(car, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carList = service.getAllCars();

        return new ResponseEntity<List<Car>>(carList, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("carshop/{id}")
    public HttpStatus deleteCarShopById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteCarShopById(id);
        return HttpStatus.FORBIDDEN;
    }

    @DeleteMapping("car/{id}")
    public HttpStatus deleteCarById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteCarById(id);
        return HttpStatus.FORBIDDEN;
    }

    @PostMapping("/carshop")
    public ResponseEntity<CarShop> createCarShop(@RequestBody CarShop carShop) {
        return ResponseEntity.ok().body(this.service.createCarShop(carShop));
    }

    @PostMapping("/car/{carShopId}")
    public Car createCourse(@PathVariable(value = "carShopId") Long car_id,
                            @Valid @RequestBody Car car) throws RecordNotFoundException {
        return carShopRepository.findById(car_id).map(carShop -> {
            car.setCarShop(carShop);
            return repository.save(car);
        }).orElseThrow(() -> new RecordNotFoundException("Shop not found"));
    }

}
