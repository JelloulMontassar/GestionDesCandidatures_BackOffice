package com.symatique.SmartSoft.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.DetailModuleInstalleParEntreprise;
import com.symatique.SmartSoft.repository.DetailModuleInstalleParEntrepriseRepository;
import com.symatique.SmartSoft.services.DetailModuleInstalleParEntrepriseService;

@Service
public class DetailModuleInstalleParEntrepriseServiceImpl implements DetailModuleInstalleParEntrepriseService{

	
	@Autowired
	private DetailModuleInstalleParEntrepriseRepository detailModuleInstalleParEntrepriseRepository;
	
	@Override
	public DetailModuleInstalleParEntreprise getDetailModuleInstalleParEntreprise(Long id) {
		// TODO Auto-generated method stub
		return detailModuleInstalleParEntrepriseRepository.findById(id).get();
	}

	@Override
	public List<DetailModuleInstalleParEntreprise> getAllDetailModuleInstalleParEntreprise() {
		// TODO Auto-generated method stub
		return detailModuleInstalleParEntrepriseRepository.findAll();
	}

	@Override
	public DetailModuleInstalleParEntreprise saveDetailModuleInstalleParEntreprise(
			DetailModuleInstalleParEntreprise DetailModuleInstalleParEntreprise) {
		// TODO Auto-generated method stub
		return detailModuleInstalleParEntrepriseRepository.save(DetailModuleInstalleParEntreprise);
	}

	@Override
	public DetailModuleInstalleParEntreprise updateDetailModuleInstalleParEntreprise(
			DetailModuleInstalleParEntreprise DetailModuleInstalleParEntreprise) {
		// TODO Auto-generated method stub
		return detailModuleInstalleParEntrepriseRepository.save(DetailModuleInstalleParEntreprise);
	}

	@Override
	public void deleteDetailModuleInstalleParEntreprise(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DetailModuleInstalleParEntreprise> saveAll(
			List<DetailModuleInstalleParEntreprise> listeDetailModuleInstalleParEntreprise) {
		// TODO Auto-generated method stub
		return detailModuleInstalleParEntrepriseRepository.saveAll(listeDetailModuleInstalleParEntreprise);
	}

}
