import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BataillonEnnemi {
	
	private ArrayList<Ennemi> b;
	private int  LimiteScoreatteint;

	
	public BataillonEnnemi() throws SlickException {
		
		this.b= new ArrayList<>();
		this.LimiteScoreatteint=100000; // Penser à changer de niveau quand le score limite est atteint et le mettre à une nouvelle hauteur
		
		for (int i=0; i<3; i++)
			b.add(new Ennemi());
		
	}
	
	
	
	
	public ArrayList<Ennemi> getB() {
		return b;
	}





	public void setB(ArrayList<Ennemi> b) {
		this.b = b;
	}





	public void afficherBataillonEtMissileE( Graphics  g ) {
	
		
		for (Ennemi e:b)
			e.afficherEnnemi(g);
		

			
	}
	
	
	public void deplacementBataillon ( int delta, Jet j ) {
		
		
		for (Ennemi e:b)
			e.deplacementEnnemi(delta,j);
		
	}
	

	
	public void tirerMissileE(int delta, MissileSurTerrain mi) throws SlickException {
		
		
		for(Ennemi e: b)
			e.tirerMissile(delta, mi);
	}
	
	
	
	
	public void ajouterEnnemi(MissileSurTerrain m , Scenario s) throws SlickException {
	 
	int n=0;
		
	
	 for (Ennemi x: b)
			 n++;
	 
		 
	 if (n<6 && m.getScore()< 60000 && !s.getInitNiveau2())
		 this.b.add(new Ennemi());
		 
	 }
	
	
	
	
	
	public void ajouterEnnemi2 (Scenario s, MissileSurTerrain m ) throws SlickException {
		
		ArrayList<Ennemi> ennemiNv2= new ArrayList<>();
		
	
		if(s.getInitNiveau2() && m.getScore()<100000 ) {
		for(Ennemi e:b) {
			if(e.getNiveau()==2)
				ennemiNv2.add(e);
		}
		
		if(ennemiNv2.get(ennemiNv2.size()-1).getCoordonne_y()>-70)
			b.add(Ennemi.InitEnnemiNiveau2(350, -150));
		
		
		}
		
	}
		
		
		public void ajouterEnnemi3(MissileSurTerrain m , Scenario s) throws SlickException {
			 
			int n=0;
				
			if(s.getInitNiveau3() && m.getScore()<250000 ) {
			 for (Ennemi x: b)
					 if(x.getNiveau()==3)
						 n++;
				 
			 if (n==0)
				 this.b.add(Ennemi.InitEnnemiNiveau3());
				 
			 }
			
		}
		

	 

	

}
