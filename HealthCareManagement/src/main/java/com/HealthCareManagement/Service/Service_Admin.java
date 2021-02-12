package com.HealthCareManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.HealthCareManagement.Entity.Admin;
import com.HealthCareManagement.Entity.Doctor;
import com.HealthCareManagement.Entity.Medicine;
import com.HealthCareManagement.Entity.Pharmacist;
import com.HealthCareManagement.Entity.Receptionist;
import com.HealthCareManagement.Repository.Repository_Admin;
import com.HealthCareManagement.Repository.Repository_Doctor;
import com.HealthCareManagement.Repository.Repository_Pharmacist;
import com.HealthCareManagement.Repository.Repository_Receptionist;

import Exception.RecordNotFoundException;

@org.springframework.stereotype.Service
public class Service_Admin {

	@Autowired
	Repository_Admin repo;
	@Autowired
	Repository_Pharmacist phRepo;
	@Autowired
	Repository_Receptionist recpRepo;
	@Autowired
	Repository_Doctor doRepo;

	public Admin saveAdmin(Admin admin) {
		return repo.save(admin);
	}

	public Admin fetchAdminByEmail(String email) {
		return repo.findByEmail(email);
	}

	public Admin fetchAdminByUserNameAndPassWord(String tempUserName, String tempPassword) {
		// TODO Auto-generated method stub
		return repo.findByUserNameAndPassWord(tempUserName, tempPassword);
	}

	// add pharmacist
	public Pharmacist createPharmacist(Pharmacist pharmacist) {
		return phRepo.save(pharmacist);
	}

//view all Pharmacist
	public List<Pharmacist> getAllPharmacist() {
		return this.phRepo.findAll();
	}
	// delete Pharmacist

	public void deletePharmacist(int id) throws RecordNotFoundException {
		Optional<Pharmacist> pharmacistdb = this.phRepo.findById(id);

		if (pharmacistdb.isPresent()) {
			this.phRepo.delete(pharmacistdb.get());
		} else {
			throw new RecordNotFoundException("Record not found with id : ", id);
		}
	}

	// get Pharmacist by id
	public Pharmacist getPharmacistById(int PharmacistId) {

		Optional<Pharmacist> Pharmacistdb = phRepo.findById(PharmacistId);

		if (Pharmacistdb.isPresent()) {
			return Pharmacistdb.get();
		} else {
			throw new RecordNotFoundException("Record not found with id : ", PharmacistId);
		}
	}

	// update Pharmacist by id
	public Pharmacist updatePharmacist(Pharmacist pharmacist) throws RecordNotFoundException {
		Optional<Pharmacist> PharmacistDb = phRepo.findById(pharmacist.getPh_id());

		if (PharmacistDb.isPresent()) {
			Pharmacist pharmacistUpdate = PharmacistDb.get();
			pharmacistUpdate.setPh_id(pharmacist.getPh_id());
			pharmacistUpdate.setEmail(pharmacist.getEmail());
			pharmacistUpdate.setUserName(pharmacist.getUserName());
			pharmacistUpdate.setPassWord(pharmacist.getPassWord());
			pharmacistUpdate.setFirstName(pharmacist.getFirstName());
			pharmacistUpdate.setLastName(pharmacist.getLastName());
			pharmacistUpdate.setPhoneNo(pharmacist.getPhoneNo());
			pharmacistUpdate.setAddress(pharmacist.getAddress());
			pharmacistUpdate.setAge(pharmacist.getAge());
			pharmacistUpdate.setGender(pharmacist.getGender());

			phRepo.save(pharmacistUpdate);
			return pharmacistUpdate;
		} else {
			throw new RecordNotFoundException("Record not found with id : ", pharmacist.getPh_id());
		}

	}

	// get all Receptionist
	public List<Receptionist> getAllReceptionist() {
		return this.recpRepo.findAll();
	}

	// update Receptionist by id
	public Receptionist updateReceptionist(Receptionist receptionist) throws RecordNotFoundException {
		Optional<Receptionist> ReceptionistDb = recpRepo.findById(receptionist.getR_id());

		if (ReceptionistDb.isPresent()) {
			Receptionist receptionistUpdate = ReceptionistDb.get();
			receptionistUpdate.setR_id(receptionist.getR_id());
			receptionistUpdate.setEmail(receptionist.getEmail());
			receptionistUpdate.setUserName(receptionist.getUserName());
			receptionistUpdate.setPassWord(receptionist.getPassWord());
			receptionistUpdate.setFirstName(receptionist.getFirstName());
			receptionistUpdate.setLastName(receptionist.getLastName());
			receptionistUpdate.setPhoneNo(receptionist.getPhoneNo());
			receptionistUpdate.setAddress(receptionist.getAddress());
			receptionistUpdate.setGender(receptionist.getGender());

			recpRepo.save(receptionistUpdate);
			return receptionistUpdate;
		} else {
			throw new RecordNotFoundException("Record not found with id : ", receptionist.getR_id());
		}

	}

	// get all Doctor
	public List<Doctor> getAllDoctor() {
		return this.doRepo.findAll();
	}

	public Doctor updateDoctor(Doctor doctor) throws RecordNotFoundException {
		Optional<Doctor> DoctorDb = doRepo.findById(doctor.getD_id());

		if (DoctorDb.isPresent()) {
			Doctor DoctorUpdate = DoctorDb.get();
			DoctorUpdate.setD_id(doctor.getD_id());
			DoctorUpdate.setEmail(doctor.getEmail());
			DoctorUpdate.setUserName(doctor.getUserName());
			DoctorUpdate.setPassWord(doctor.getPassWord());
			DoctorUpdate.setFirstName(doctor.getFirstName());
			DoctorUpdate.setLastName(doctor.getLastName());
			DoctorUpdate.setPhoneNo(doctor.getPhoneNo());
			DoctorUpdate.setAddress(doctor.getAddress());
			DoctorUpdate.setGender(doctor.getGender());
			DoctorUpdate.setAge(doctor.getAge());
			DoctorUpdate.setSpecalization(doctor.getSpecalization());
			doRepo.save(DoctorUpdate);
			return DoctorUpdate;
		} else {
			throw new RecordNotFoundException("Record not found with id : ", doctor.getD_id());
		}

	}

}
