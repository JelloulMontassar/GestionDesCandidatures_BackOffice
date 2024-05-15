package com.symatique.SmartSoft.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.ModuleInstalleParEntreprise;
import com.symatique.SmartSoft.repository.ModuleInstalleParEntrepriseRepository;
import com.symatique.SmartSoft.services.ModuleInstalleParEntrepriseService;

@Service
public class ModuleInstalleParEntrepriseServiceImpl implements ModuleInstalleParEntrepriseService {

	@Autowired
	private ModuleInstalleParEntrepriseRepository moduleInstalleParEntrepriseRepository;

	@Override
	public ModuleInstalleParEntreprise getModuleInstalleParEntreprise(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return moduleInstalleParEntrepriseRepository.findById(id).get();
	}

	@Override
	public List<ModuleInstalleParEntreprise> getAllModuleInstalleParEntreprises() {
		// TODO Auto-generated method stub
		return moduleInstalleParEntrepriseRepository.findAll();
	}

	@Override
	public ModuleInstalleParEntreprise saveModele(ModuleInstalleParEntreprise moduleInstalleParEntreprise) {
		// TODO Auto-generated method stub
		return moduleInstalleParEntrepriseRepository.save(moduleInstalleParEntreprise);
	}

	@Override
	public ModuleInstalleParEntreprise updateModuleInstalleParEntreprise(
			ModuleInstalleParEntreprise moduleInstalleParEntreprise) {
		
		// tempsReel.setId(id);
		return moduleInstalleParEntrepriseRepository.save(moduleInstalleParEntreprise);
	}

	@Override
	public void deleteModuleInstalleParEntreprise(Long id) {
		ModuleInstalleParEntreprise moduleInstalleParEntreprise = getModuleInstalleParEntreprise(id);
		// tempsReel.setId(id);
		moduleInstalleParEntrepriseRepository.save(moduleInstalleParEntreprise);

	}

	@Override
	public List<ModuleInstalleParEntreprise> saveAll(
			List<ModuleInstalleParEntreprise> listeModuleInstalleParEntreprise) {
		// TODO Auto-generated method stub
		return moduleInstalleParEntrepriseRepository.saveAll(listeModuleInstalleParEntreprise);
	}
	
	

}
