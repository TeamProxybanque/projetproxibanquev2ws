package fr.gtm.projetproxibanquev2ws.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gtm.projetproxibanquev2ws.domaine.Compte;
import fr.gtm.projetproxibanquev2ws.domaine.CompteCourant;
import fr.gtm.projetproxibanquev2ws.domaine.CompteEpargne;


public class CompteEpargneDAO implements ICompteEpargneDAO{
	
	//objet de conection
	ConnectionBDD maCo = new ConnectionBDD();
	Compte compteTempo = null;
	
	public void createCompteEpargne() {
		// TODO Auto-generated method stub
		
	}

	public Compte readCompteEpargneByNumCompte(String numCompte) {
		String requete = "SELECT * FROM compteepargne WHERE numeroDeCompte = "+numCompte;
		maCo.seConnecter();
		ResultSet rs = maCo.executeRequete(requete);
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				double solde = rs.getDouble("solde");
				
				compteTempo = new CompteEpargne(id, numCompte, solde);
			}
		} catch (SQLException e) {
			System.out.println("erreur lors de la methode readCompteEpargneByNumCompte");
			e.printStackTrace();
		}
		
		return compteTempo;
	}

	public void upDateCompteEpargne(Compte compteEpargne) {
		String requete = "UPDATE compteepargne SET solde ='"+compteEpargne.getSolde()+"'";
		maCo.seConnecter();
		maCo.updateData(requete);
		maCo.closeConnection();
	}

	public void delateCompteEpargne(Compte CompteEpargne) {
		// TODO Auto-generated method stub
		
	}

}
