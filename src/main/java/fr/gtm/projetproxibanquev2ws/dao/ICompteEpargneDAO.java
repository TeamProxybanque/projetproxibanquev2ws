package fr.gtm.projetproxibanquev2ws.dao;

import fr.gtm.projetproxibanquev2ws.domaine.Compte;

public interface ICompteEpargneDAO {

	//TODO crud
	
	//Méthode CREATE
	public void createCompteEpargne();
	//méthode read
	public Compte readCompteEpargneByNumCompte(String numCompte);
	//méthode update
	public void upDateCompteEpargne(Compte compteEpargne);
	//méthode delate
	public void  delateCompteEpargne(Compte CompteEpargne);
}
