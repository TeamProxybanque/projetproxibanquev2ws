package fr.gtm.projetproxibanquev2ws.dao;

import fr.gtm.projetproxibanquev2ws.domaine.Compte;

public interface ICompteEpargneDAO {

	//TODO crud
	
	//M�thode CREATE
	public void createCompteEpargne();
	//m�thode read
	public Compte readCompteEpargneByNumCompte(String numCompte);
	//m�thode update
	public void upDateCompteEpargne(Compte compteEpargne);
	//m�thode delate
	public void  delateCompteEpargne(Compte CompteEpargne);
}
