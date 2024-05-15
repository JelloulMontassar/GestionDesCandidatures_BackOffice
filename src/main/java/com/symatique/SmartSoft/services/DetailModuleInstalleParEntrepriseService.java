package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.DetailModuleInstalleParEntreprise;

@Service
public interface DetailModuleInstalleParEntrepriseService {
	
	DetailModuleInstalleParEntreprise getDetailModuleInstalleParEntreprise(Long id);

	List<DetailModuleInstalleParEntreprise> getAllDetailModuleInstalleParEntreprise();

	DetailModuleInstalleParEntreprise saveDetailModuleInstalleParEntreprise(DetailModuleInstalleParEntreprise DetailModuleInstalleParEntreprise);

	DetailModuleInstalleParEntreprise updateDetailModuleInstalleParEntreprise(DetailModuleInstalleParEntreprise DetailModuleInstalleParEntreprise);

	void deleteDetailModuleInstalleParEntreprise(Long id);
	
	List<DetailModuleInstalleParEntreprise> saveAll(List<DetailModuleInstalleParEntreprise> listeDetailModuleInstalleParEntreprise);

}
