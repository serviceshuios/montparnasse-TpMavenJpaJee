package com.infotel.TpMavenSpringJPA.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.TpMavenSpringJPA.metier.Personne;

@Transactional
@Repository
public class DaoImpl implements Idao {

	@PersistenceContext
	EntityManager em;
	@Override
	public int ajouterPersonne(Personne p) {
		
		em.persist(p);
		return p.getId();
	}
	@Override
	public List<Personne> findAllPersonnes() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Personne p").getResultList();
	}
	@Override
	public Personne getPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return em.getReference(Personne.class, idPersonne);
	}
	@Override
	public Personne affichagePersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return em.find(Personne.class, idPersonne);
	}
	@Override
	public int supprimerPersonne(Personne p) {
		// TODO Auto-generated method stub
		em.remove(p);
		return p.getId();
	}
	@Override
	public int modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		em.merge(p);
		return p.getId();
	}

}
