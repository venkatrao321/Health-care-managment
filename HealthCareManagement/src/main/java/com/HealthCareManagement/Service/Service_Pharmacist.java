package com.HealthCareManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HealthCareManagement.Entity.Medicine;
import com.HealthCareManagement.Entity.Pharmacist;
import com.HealthCareManagement.Repository.Repository_Medicine;
import com.HealthCareManagement.Repository.Repository_Pharmacist;

import Exception.RecordNotFoundException;

@Service
public class Service_Pharmacist {

	@Autowired
	Repository_Pharmacist repo;
	@Autowired
	Repository_Medicine medRepo;

	public Pharmacist fetchpharmacistByUserNameAndPassWord(String tempUserName, String tempPassword) {
		// TODO Auto-generated method stub
		return repo.findByUserNameAndPassWord(tempUserName, tempPassword);
	}
// add medicine
	public Medicine createMedicine(Medicine medicine) {
		return medRepo.save(medicine);
	}
//get all medicine
	public List<Medicine> getAllMedicine() {
		return this.medRepo.findAll();
	}
//delete medicine by id 
	public void deleteMedicine(int id) throws RecordNotFoundException {
		Optional<Medicine> medicindb = this.medRepo.findById(id);

		if (medicindb.isPresent()) {
			this.medRepo.delete(medicindb.get());
		} else {
			throw new RecordNotFoundException("Record not found with id : ", id);
		}
	}
//Get medicine by id
	public Medicine getMedicineById(int medicineId) throws RecordNotFoundException {

        Optional < Medicine > MedicineDb = medRepo.findById(medicineId);

        if (MedicineDb.isPresent()) {
            return MedicineDb.get();
        } else {
            throw new RecordNotFoundException("Record not found with id : ",medicineId);
        }
	}
//update medicine by id
        public Medicine updateMedicine(Medicine medicine) throws RecordNotFoundException{
            Optional < Medicine > medicineDb = medRepo.findById(medicine.getM_id());

            if (medicineDb.isPresent()) {
            	Medicine medicineUpdate = medicineDb.get();
            	medicineUpdate.setM_id(medicine.getM_id());
            	medicineUpdate.setName(medicine.getName());
            	medicineUpdate.setAmount(medicine.getAmount());
            	medicineUpdate.setQuantity(medicine.getQuantity());
            	medicineUpdate.setMfg(medicine.getMfd());
            	medicineUpdate.setExpiry(medicine.getExpiry());
                medRepo.save(medicineUpdate);
                return medicineUpdate;
            } else {
                throw new RecordNotFoundException("Record not found with id : ",medicine.getM_id());
            }
    }
}
