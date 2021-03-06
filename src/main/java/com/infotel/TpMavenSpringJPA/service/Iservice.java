package com.infotel.TpMavenSpringJPA.service;

import java.util.List;

import com.infotel.TpMavenSpringJPA.metier.Personne;

public interface Iservice {

	public int ajouterPersonne(Personne p);
	public List<Personne> findAllPersonnes();
	public Personne getPersonne(int idPersonne);
	public Personne affichagePersonne(int idPersonne);
	public int supprimerPersonne(Personne p);
	public int modifierPersonne(Personne p);

}
