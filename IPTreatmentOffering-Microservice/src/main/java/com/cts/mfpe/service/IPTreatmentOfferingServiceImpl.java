package com.cts.mfpe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mfpe.exception.IPTreatmentPackageNotFoundException;
import com.cts.mfpe.model.AilmentCategory;
import com.cts.mfpe.model.IPTreatmentPackage;
import com.cts.mfpe.model.PackageDetail;
import com.cts.mfpe.model.SpecialistDetail;
import com.cts.mfpe.repository.IPTreatmentPackageRepository;
import com.cts.mfpe.repository.PackageDetailRepository;
import com.cts.mfpe.repository.SpecialistDetailRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IPTreatmentOfferingServiceImpl implements IPTreatmentOfferingService {

	@Autowired
	IPTreatmentPackageRepository treatmentPackRepository;

	@Autowired
	SpecialistDetailRepository specialistRepository;
	
	@Autowired
	PackageDetailRepository packageDetailRepository;

	@Override
	public List<IPTreatmentPackage> findAllIPTreatmentPackages() {

		List<IPTreatmentPackage> treatmentPackages = treatmentPackRepository.findAll();
		log.info("[IPTreatmentPackage details:] "+ treatmentPackages);
		return treatmentPackages;
	}

	@Override
	public IPTreatmentPackage findIPTreatmentPackageByName(AilmentCategory ailment, String packageName) throws IPTreatmentPackageNotFoundException {

		IPTreatmentPackage treatmentPackage = treatmentPackRepository.findByName(ailment, packageName)
					.orElseThrow(() -> new IPTreatmentPackageNotFoundException("IP Treatment Package not found"));
		
		log.info("[IPTreatmentPackage ("+packageName+") detail:] "+ treatmentPackage);
		return treatmentPackage;
	}

	@Override
	public List<SpecialistDetail> findAllSpecialists() {

		List<SpecialistDetail> specialists = specialistRepository.findAll();
		log.info("[Specialist details:] " + specialists);
		return specialists;
	}

	@Override
	public List<SpecialistDetail> findSpecialistsByExpertise(AilmentCategory ailmentCategory) {
		List<SpecialistDetail> specialists = specialistRepository.findByAreaOfExpertise(ailmentCategory);
		log.info("[Specialist details:] " + specialists);
		return specialists;
	}

	@Override
	public boolean addSpecialist(SpecialistDetail detail) {
		try {
			specialistRepository.save(detail);
			return true;
		}catch(Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteSpecialistById(int id) {
		try {
			specialistRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			
		}
		return false;
	}


	@Override
	public List<PackageDetail> getAllPackages() {
		return packageDetailRepository.findAll();
	}

	@Override
	public IPTreatmentPackage updateIPTreatmentPackage(int id, IPTreatmentPackage ipTreatmentPackage)
			throws IPTreatmentPackageNotFoundException {
		IPTreatmentPackage temp = treatmentPackRepository.findById(id).orElse(null);
		if(temp == null) {
			throw new IPTreatmentPackageNotFoundException("Package not found");
		}
		ipTreatmentPackage.setTreatmentPackageId(id);
		treatmentPackRepository.save(ipTreatmentPackage);
		return ipTreatmentPackage;
	}

}
