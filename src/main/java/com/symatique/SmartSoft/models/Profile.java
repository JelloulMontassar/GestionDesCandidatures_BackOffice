	package com.symatique.SmartSoft.models;

	import java.io.Serializable;
	import java.util.List;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

	import com.fasterxml.jackson.annotation.JsonIgnore;

	import lombok.AllArgsConstructor;
	import lombok.NoArgsConstructor;

	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name = "T_Profile")
	public class Profile implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "Pro_Id")
		private Long id;

		@Column(name = "Pro_Libelle")
		private String libelle;

		@Column(name = "Pro_Description")
		private String description;

		@Column(name = "Pro_Supprimer")
		private boolean supression;

		@JsonIgnore
		@OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
		private List<Utilisateur> ListUtilisateurs;

		@OneToMany(mappedBy = "profile")
		private List<Privilege> listPrivileges;

		@Column(name = "Ent_Id")
		private Long idEntreprise;

		@Column(name = "Ent_Libelle")
		private String libelleEntreprise;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLibelle() {
			if (libelle != null && !libelle.equals("")) {
				libelle = libelle.substring(0, 1).toUpperCase() + "" + libelle.substring(1);
			}
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<Privilege> getListPrivileges() {
			return listPrivileges;
		}

		public void setListPrivileges(List<Privilege> listPrivileges) {
			this.listPrivileges = listPrivileges;
		}

		public boolean isSupression() {
			return supression;
		}

		public void setSupression(boolean supression) {
			this.supression = supression;
		}

		public Long getIdEntreprise() {
			return idEntreprise;
		}

		public void setIdEntreprise(Long idEntreprise) {
			this.idEntreprise = idEntreprise;
		}

		public String getLibelleEntreprise() {
			return libelleEntreprise;
		}

		public void setLibelleEntreprise(String libelleEntreprise) {
			this.libelleEntreprise = libelleEntreprise;
		}

	}
