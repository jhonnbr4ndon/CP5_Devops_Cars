package com.br.fiap.CP5_Devops_Cars.repository;

import com.br.fiap.CP5_Devops_Cars.entitty.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
