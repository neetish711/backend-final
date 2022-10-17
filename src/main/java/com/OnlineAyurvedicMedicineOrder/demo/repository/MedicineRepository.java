package com.OnlineAyurvedicMedicineOrder.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineAyurvedicMedicineOrder.demo.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

}
