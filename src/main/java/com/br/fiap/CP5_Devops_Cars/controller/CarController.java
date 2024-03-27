package com.br.fiap.CP5_Devops_Cars.controller;

import com.br.fiap.CP5_Devops_Cars.entitty.Car;
import com.br.fiap.CP5_Devops_Cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("car", new Car());
        return "base";
    }

    @PostMapping("/")
    public String submitForm(Car car) {
        carRepository.save(car);
        return "redirect:/";
    }

    @GetMapping("/cars")
    public String showCars(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "car";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Carro não encontrado Id: " + id));
        model.addAttribute("car", car);
        return "editCar"; // Aqui está o caminho correto para o template
    }

    @PostMapping("/update/{id}")
    public String updateCarro(@PathVariable Long id, @ModelAttribute Car car) {
        car.setId(id);
        carRepository.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCarro(@PathVariable Long id) {
        carRepository.deleteById(id);
        return "redirect:/cars";
    }
}
