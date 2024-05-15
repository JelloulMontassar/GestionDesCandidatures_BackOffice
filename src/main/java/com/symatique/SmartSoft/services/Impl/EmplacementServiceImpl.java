package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Emplacement;
import com.symatique.SmartSoft.repository.EmplacementRepository;
import com.symatique.SmartSoft.services.EmplacementService;

@Service
public class EmplacementServiceImpl implements EmplacementService {

	@Autowired
	private EmplacementRepository emplacementRepository;


	@Override
	public Emplacement getEmplacement(Long id) {
		// TODO Auto-generated method stub
		return emplacementRepository.findById(id).get();
	}

	@Override
	public List<Emplacement> getAllEmplacements() {
		// TODO Auto-generated method stub
		return emplacementRepository.findAll().stream().filter(emplacement -> emplacement.isSupression() == false)
				.collect(Collectors.toList());
	}

	@Override
	public Emplacement saveEmplacement(Emplacement emplacement) {
		// TODO Auto-generated method stub
		return emplacementRepository.save(emplacement);
	}

	@Override
	public Emplacement updateEmplacement(Emplacement emplacement) {
		// TODO Auto-generated method stub
		return emplacementRepository.save(emplacement);
	}

	@Override
	public void deleteEmplacement(Long id) {
		// TODO Auto-generated method stub
		Emplacement emplacement = getEmplacement(id);
		emplacement.setSupression(true);
		emplacementRepository.save(emplacement);
	}

	public boolean checkLibelleExists(String libelle ,Long idEntreprise , Long id) {
		Optional<Emplacement> existingEmplacement = emplacementRepository.findByLibelleAndSupressionAndIdNotAndIdEntreprise(libelle, false, id, idEntreprise);
		// Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
		return existingEmplacement.isPresent();
	}

	public boolean checkLibelle(String libelle,Long idEntreprise) {
		// Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id
		// spécifié
		Optional<Emplacement> existingEmplacement = emplacementRepository.findByLibelleAndSupressionAndIdEntreprise(libelle, false, idEntreprise);
		// Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
		return existingEmplacement.isPresent();
	}

	@Override
	public boolean modifierLibelleEmplacement(String oldLibelle, String newLibelle) {
		/*List<DetailTempBluetooth> listeDetailTempBluetooth = detailTempBluetoothService
				.findDetailTempBluetoothByLibelleEmplacementAndSuppressionFalse(oldLibelle);
		for (DetailTempBluetooth detailTempBluetooth : listeDetailTempBluetooth) {
			detailTempBluetooth.setLibelleEmplacement(newLibelle);
		}
		detailTempBluetoothService.saveAll(listeDetailTempBluetooth);
		List<DetailTempFiliaire> listeDetailTempFiliaire = detailTempFiliaireService
				.findDetailTempFiliaireByLibelleEmplacementAndSuppressionFalse(oldLibelle);
		for (DetailTempFiliaire detailTempFiliaire : listeDetailTempFiliaire) {
			detailTempFiliaire.setLibelleEmplacement(newLibelle);
		}
		detailTempFiliaireService.saveAll(listeDetailTempFiliaire);*/
		return true;
	}

	@Override
	public boolean verifierExistsDetails(String libelle) {

		/*boolean detailTempBluetooth = detailTempBluetoothService
				.findDetailTempBluetoothByLibelleEmplacementAndSuppressionFalse(libelle).isEmpty();
		boolean detailTempFiliaire = detailTempFiliaireService
				.findDetailTempFiliaireByLibelleEmplacementAndSuppressionFalse(libelle).isEmpty();
	
		return detailTempBluetooth && detailTempFiliaire;*/
		return true;
	}

	
}
