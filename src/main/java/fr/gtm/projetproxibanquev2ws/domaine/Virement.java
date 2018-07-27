package fr.gtm.projetproxibanquev2ws.domaine;
/**
 * L'objet Virement permet de contenir des �l�ments essentiels � un virement (numero de compte d�biteur, num�ros de compte cr�diteur)
 * @author Zack & Aubin
 *
 */
public class Virement {

	// attributs
	private int idVirement;
	private String dateVirement;
	private String numeroCompteDebiteur;
	private String numeroCompteCrediteur;
	private double montant;
/**
 * Constructeur de Virement, il permettra de mettre en base un virement entre deux compte
 * @param idVirement
 * @param dateVirement
 * @param numeroCompteDebiteur
 * @param numeroCompteCrediteur
 * @param montant
 */
	// constructeur
	public Virement(int idVirement, String dateVirement, String numeroCompteDebiteur, String numeroCompteCrediteur,
			double montant) {
		super();
		this.idVirement = idVirement;
		this.dateVirement = dateVirement;
		this.numeroCompteDebiteur = numeroCompteDebiteur;
		this.numeroCompteCrediteur = numeroCompteCrediteur;
		this.montant = montant;
	}

/**
 * Surcharge du constructeur pour ignor� l'id qui sera g�n�r� dynamiquement en basede donn�es
 * @param dateVirement
 * @param numeroCompteDebiteur
 * @param numeroCompteCrediteur
 * @param montant
 */
	public Virement(String dateVirement, String numeroCompteDebiteur, String numeroCompteCrediteur, double montant) {
		super();
		this.dateVirement = dateVirement;
		this.numeroCompteDebiteur = numeroCompteDebiteur;
		this.numeroCompteCrediteur = numeroCompteCrediteur;
		this.montant = montant;
	}

	public int getIdVirement() {
		return idVirement;
	}

	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}

	public String getDateVirement() {
		return dateVirement;
	}

	public void setDateVirement(String dateVirement) {
		this.dateVirement = dateVirement;
	}

	public String getNumeroCompteDebiteur() {
		return numeroCompteDebiteur;
	}

	public void setNumeroCompteDebiteur(String numeroCompteDebiteur) {
		this.numeroCompteDebiteur = numeroCompteDebiteur;
	}

	public String getNumeroCompteCrediteur() {
		return numeroCompteCrediteur;
	}

	public void setNumeroCompteCrediteur(String numeroCompteCrediteur) {
		this.numeroCompteCrediteur = numeroCompteCrediteur;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	

}
