import org.newdawn.slick.Graphics;

public class Ciel {
	etoile [] etoiles = new etoile[15];
	
	public Ciel() {
		for (int i = 0; i < etoiles.length; i++) {
			etoiles[i]= new etoile();
		}
		
	}
	
	public void deplacerCiel(int delta) {
		
		for(int i=0; i<etoiles.length;i++)
			etoiles[i].deplacementEtoile(delta);		
	}
	
	public void afficherCiel(Graphics g) {
		
	 for (int i = 0; i < etoiles.length; i++) {
		 etoiles[i].afficherEtoile(g);	
	}
	 
	 
	}
	

}
