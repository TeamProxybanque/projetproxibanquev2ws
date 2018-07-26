package fr.gtm.projetproxibanquev2ws.dao;

import fr.gtm.projetproxibanquev2ws.domaine.Compte;

public interface ICompteCourantDAO {

	//TODO crud
	
	//M�thode CREATE
	public void createCompteCourant();
	//m�thode read
	public Compte readCompteCourantByNumCompte(String numCompte);
	//m�thode update
	public void upDateCompteCourant(Compte compteCourant);
	//m�thode delate
	public void  delateCompteCourant(Compte CompteCourant);
}
