package fr.gtm.projetproxibanquev2ws.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import fr.gtm.projetproxibanquev2ws.dao.CompteCourantDAO;
import fr.gtm.projetproxibanquev2ws.dao.CompteEpargneDAO;
import fr.gtm.projetproxibanquev2ws.domaine.Compte;
import fr.gtm.projetproxibanquev2ws.domaine.CompteCourant;
import fr.gtm.projetproxibanquev2ws.domaine.CompteEpargne;
import fr.gtm.projetproxibanquev2ws.domaine.Virement;
/**
 * Web services permettant de g�n�rer un virement
 * @author Zack & Aubin
 *
 */
@Path("/virement")
public class VirementService {

	// mes objets dao
	CompteCourantDAO compteCDAO = new CompteCourantDAO();
	CompteEpargneDAO compteEDAO = new CompteEpargneDAO();
	Virement levirement = null;
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	String dateVirement;

	// Methode de virement
	/**
	 * M�thode POST permettant de consumer un document json contenant un objet Virement. La m�thode traite le contenu de virement pour une implentation en base de donn�es
	 * @param virement
	 * @return
	 * @see Virement
	 */
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response effectuerVirement(Virement virement) {

		Compte compteDebiteur = null;
		Compte compteCrediteur = null;
		Compte compteTempo = null;
		// v�rification d'apr�s le num�ros de compte pour savoir si c'est un compte courant ou epargne
		//puis assigniation � sa classe (�pargne ou courant)
		if (compteCDAO.readCompteCourantByNumCompte(virement.getNumeroCompteCrediteur()) != null) {
			compteTempo = compteCDAO.readCompteCourantByNumCompte(virement.getNumeroCompteCrediteur());
			compteCrediteur = new CompteCourant(compteTempo.getIdCompte(), compteTempo.getNumeroDeCompte(), compteTempo.getSolde());
		} else if (compteEDAO.readCompteEpargneByNumCompte(virement.getNumeroCompteCrediteur()) != null) {
			compteTempo = compteEDAO.readCompteEpargneByNumCompte(virement.getNumeroCompteCrediteur());
			compteCrediteur = new CompteEpargne(compteTempo.getIdCompte(), compteTempo.getNumeroDeCompte(), compteTempo.getSolde());
		}
		if (compteCDAO.readCompteCourantByNumCompte(virement.getNumeroCompteDebiteur()) != null) {
			compteTempo = compteCDAO.readCompteCourantByNumCompte(virement.getNumeroCompteDebiteur());
			compteDebiteur = new CompteCourant(compteTempo.getIdCompte(), compteTempo.getNumeroDeCompte(), compteTempo.getSolde());
		} else if (compteEDAO.readCompteEpargneByNumCompte(virement.getNumeroCompteDebiteur()) != null) {
			compteTempo = compteEDAO.readCompteEpargneByNumCompte(virement.getNumeroCompteDebiteur());
			compteDebiteur = new CompteEpargne(compteTempo.getIdCompte(), compteTempo.getNumeroDeCompte(), compteTempo.getSolde());
		}
		
		//v�rification que le solde actuel - le montant du virement reste sup�rieur � 0
		if (compteDebiteur.getSolde() - virement.getMontant() > 0) {
			compteDebiteur.setSolde(compteDebiteur.getSolde() - virement.getMontant());
			compteCrediteur.setSolde(compteCrediteur.getSolde() + virement.getMontant());

			//suivant si le compte est courant ou epargne mettre � jours dans la bonne table en base de donn�es
			if (compteCrediteur instanceof CompteCourant) {
				compteCDAO.upDateCompteCourant(compteCrediteur);

			}else if(compteCrediteur instanceof CompteEpargne) {
				compteEDAO.upDateCompteEpargne(compteCrediteur);
			}
			
			if(compteDebiteur instanceof CompteCourant) {
				compteCDAO.upDateCompteCourant(compteDebiteur);
			}else if (compteDebiteur instanceof CompteEpargne) {
				compteEDAO.upDateCompteEpargne(compteDebiteur);
			}

		}
		return Response.status(201).entity(virement).build();

	}
	
	/**
	 * M�thode GET de test permettant de controler le bon fonctionnement du servlet Jersey en affichant "Bonjour"
	 * @return
	 */
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_HTML)
	public String test() {
		return "<html>Bonjour</html>";
	}
	
	
}
