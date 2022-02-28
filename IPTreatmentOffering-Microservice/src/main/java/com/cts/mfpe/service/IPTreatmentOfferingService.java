package com.cts.mfpe.service;

import java.util.List;

import com.cts.mfpe.exception.IPTreatmentPackageNotFoundException;
import com.cts.mfpe.model.AilmentCategory;
import com.cts.mfpe.model.IPTreatmentPackage;
import com.cts.mfpe.model.PackageDetail;
import com.cts.mfpe.model.SpecialistDetail;

public interface IPTreatmentOfferingService {
	
	List<IPTreatmentPackage> findAllIPTreatmentPackages();
	IPTreatmentPackage findIPTreatmentPackageByName(AilmentCategory ailment, String packageName) throws IPTreatmentPackageNotFoundException;
	List<SpecialistDetail> findAllSpecialists();
	List<SpecialistDetail> findSpecialistsByExpertise(AilmentCategory ailmentCategory);
	boolean addSpecialist(SpecialistDetail detail);
	boolean deleteSpecialistById(int id);
	IPTreatmentPackage updateIPTreatmentPackage(int id, IPTreatmentPackage ipTreatmentPackage) throws IPTreatmentPackageNotFoundException;
	List<PackageDetail> getAllPackages();
}
