package fr.gtm.projetproxibanquev2ws.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gtm.projetproxibanquev2ws.domaine.Compte;
import fr.gtm.projetproxibanquev2ws.domaine.CompteCourant;

public class CompteCourantDAO implements ICompteCourantDAO{
	
	//créer un objet de connection
	ConnectionBDD maCo = new ConnectionBDD();
	Compte compteTempo = null;

	public void createCompteCourant() {
		// TODO Auto-generated method stub
	}

	public Compte readCompteCourantByNumCompte(String numCompte) {
		String requete = "SELECT * FROM comptecourant WHERE numeroDeCompte = "+numCompte;
		maCo.seConnecter();
		ResultSet rs = maCo.executeRequete(requete);
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				double solde = rs.getDouble("solde");
				
				compteTempo = new CompteCourant(id, numCompte, solde);
			}
		} catch (SQLException e) {
			System.out.println("erreur lors de la methode readCompteCourantByNumCompte");
			e.printStackTrace();
		}
		
		return compteTempo;
	}

	public void upDateCompteCourant(Compte compteCourant) {
		String requete = "UPDATE comptecourant SET solde ='"+compteCourant.getSolde()+"'";
		maCo.seConnecter();
		maCo.updateData(requete);
		maCo.closeConnection();

	}

	public void delateCompteCourant(Compte CompteCourant) {
		// TODO Auto-generated method stub
		
	}

}
