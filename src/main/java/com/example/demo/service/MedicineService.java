package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Medicine;
import com.example.demo.repository.MedicineRepo;

import java.util.List;

@Service
public class MedicineService {
    private final MedicineRepo medicineRepository;

    @Autowired
    public MedicineService(MedicineRepo medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

   
    public Medicine createMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    
    public Medicine updateMedicine(Long id, Medicine medicine) {
        medicine.setId(id);
        return medicineRepository.save(medicine);
    }

   
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElse(null);
    }

  
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }
}
