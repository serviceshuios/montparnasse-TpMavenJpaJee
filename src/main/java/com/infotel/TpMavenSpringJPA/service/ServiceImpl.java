package com.infotel.TpMavenSpringJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.TpMavenSpringJPA.dao.Idao;
import com.infotel.TpMavenSpringJPA.metier.Personne;

@Service
public class ServiceImpl implements Iservice {

	@Autowired
	private Idao dao;
	
	@Override
	public int ajouterPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.ajouterPersonne(p);
	}

	public Idao getDao() {
		return dao;
	}

	public void setDao(Idao dao) {
		this.dao = dao;
	}

	@Override
	public List<Personne> findAllPersonnes() {
		// TODO Auto-generated method stub
		return dao.findAllPersonnes();
	}

	@Override
	public Personne getPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return dao.getPersonne(idPersonne);
	}

	@Override
	public Personne affichagePersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return dao.affichagePersonne(idPersonne);
	}

	@Override
	public int supprimerPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.supprimerPersonne(p);
	}

	@Override
	public int modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.modifierPersonne(p);
	}

}
