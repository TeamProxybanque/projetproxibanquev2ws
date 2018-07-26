package fr.gtm.projetproxibanquev2ws.domaine;

public abstract class Compte {

	//Attributs de compte
	private int idCompte;
	private String numeroDeCompte;
	private double solde;
	
	//Constructeur principal
	public Compte(int idCompte, String numeroDeCompte, double solde) {
		super();
		this.idCompte = idCompte;
		this.numeroDeCompte = numeroDeCompte;
		this.solde = solde;
	}
	
	//surcharge de constructeur sans id
	public Compte(String numeroDeCompte, double solde) {
		super();
		this.numeroDeCompte = numeroDeCompte;
		this.solde = solde;
	}
	
	//surcharge de constructeur vide
	public Compte() {
		super();
	}

	//getters et setters
	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getNumeroDeCompte() {
		return numeroDeCompte;
	}

	public void setNumeroDeCompte(String numeroDeCompte) {
		this.numeroDeCompte = numeroDeCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
		
	
}
