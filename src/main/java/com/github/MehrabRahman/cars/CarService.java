package com.github.MehrabRahman.cars;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarService {
    public List<Car> getAll() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(Long.valueOf(1), "Honda", "Civic", 2021));
        cars.add(new Car(Long.valueOf(2), "Toyota", "Rav4", 2020));
        return cars;
    }
}
