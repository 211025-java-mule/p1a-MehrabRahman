package com.github.MehrabRahman.cars;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String helloYou(@PathVariable("name") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getOne(@PathVariable("id") int id) {
        return carService.getAll().get(id -1);
    }

    @PostMapping("/")
    public Car postCar(@RequestBody Car car) {
        return car;
    }
}
