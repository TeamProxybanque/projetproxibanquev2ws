

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import fr.gtm.projetproxibanquev2ws.domaine.Compte;
import fr.gtm.projetproxibanquev2ws.domaine.CompteCourant;
import fr.gtm.projetproxibanquev2ws.domaine.CompteEpargne;

public class TestVirement {
	Compte compte1 = new CompteCourant(1,"51236E", 450.12);
	Compte compte2 = new CompteEpargne(2,"56124F", 754.85);
	double montant = 50.12;

	
	@Test
	public void testSoustractionCompteDebiteur() {
		compte1.setSolde(compte1.getSolde() - montant);
		compte2.setSolde(compte2.getSolde() + montant);
		
		assertEquals(compte1.getSolde(), 400, 0);
	}
	
	@Test
	public void testAdditionCompteCrediteur() {
		compte1.setSolde(compte1.getSolde() - montant);
		compte2.setSolde(compte2.getSolde() + montant);
		
		assertEquals(compte2.getSolde(), 804.97, 0);
	}
	
	@Test
	public void testDecouvertCompteDebiteur() {
		boolean test = false;
		
		if(compte1.getSolde()-montant>0) {
			test=true;
		}
		
		assertEquals(test, true);
		
	}
	
}
