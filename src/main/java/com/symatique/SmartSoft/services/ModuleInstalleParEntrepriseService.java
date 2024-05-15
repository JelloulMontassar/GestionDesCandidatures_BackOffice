package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.ModuleInstalleParEntreprise;

@Service
public interface ModuleInstalleParEntrepriseService {

	ModuleInstalleParEntreprise getModuleInstalleParEntreprise(Long id);

	List<ModuleInstalleParEntreprise> getAllModuleInstalleParEntreprises();

	ModuleInstalleParEntreprise saveModele(ModuleInstalleParEntreprise moduleInstalleParEntreprise);

	ModuleInstalleParEntreprise updateModuleInstalleParEntreprise( ModuleInstalleParEntreprise moduleInstalleParEntreprise);

	void deleteModuleInstalleParEntreprise(Long id);
	
	List<ModuleInstalleParEntreprise> saveAll(List<ModuleInstalleParEntreprise> listeModuleInstalleParEntreprise);
}
