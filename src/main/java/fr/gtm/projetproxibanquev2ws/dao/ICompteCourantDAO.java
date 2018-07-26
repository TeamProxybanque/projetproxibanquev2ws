package fr.gtm.projetproxibanquev2ws.dao;

import fr.gtm.projetproxibanquev2ws.domaine.Compte;

public interface ICompteCourantDAO {

	//TODO crud
	
	//Méthode CREATE
	public void createCompteCourant();
	//méthode read
	public Compte readCompteCourantByNumCompte(String numCompte);
	//méthode update
	public void upDateCompteCourant(Compte compteCourant);
	//méthode delate
	public void  delateCompteCourant(Compte CompteCourant);
}
