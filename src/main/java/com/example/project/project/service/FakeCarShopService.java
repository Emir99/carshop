package com.example.project.project.service;

import com.example.project.project.pojo.Car;
import com.example.project.project.pojo.CarShop;

import java.util.List;

public interface FakeCarShopService {
    List<CarShop> getAllCarShops();
    List<Car> getAllCars();
    CarShop getCarShopById(Long id) throws RecordNotFoundException;
    Car getCarById(Long id) throws RecordNotFoundException;
    void deleteCarShopById(Long id) throws RecordNotFoundException;
    void deleteCarById(Long id) throws RecordNotFoundException;
    CarShop createCarShop(CarShop carShop);
}
