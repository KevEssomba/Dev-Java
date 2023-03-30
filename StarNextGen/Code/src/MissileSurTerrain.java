import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MissileSurTerrain {
	
	
	private ArrayList<Missile> missileSurTerrain;
	private float score;
	
	
	
	
	public MissileSurTerrain() {
		
		missileSurTerrain = new ArrayList<>();
		this.score=0;
	}

	


	public float getScore() {
		return score;
	}




	public void setScore(float score) {
		this.score = score;
	}




	public ArrayList<Missile> getMissileSurTerrain() {
		return missileSurTerrain;
	}


	
	

	public void setMissileSurTerrain(ArrayList<Missile> missileSurTerrain) {
		this.missileSurTerrain = missileSurTerrain;
	}
	
	
	
	
	public void afficherMissile( Graphics g) {
		
		
		for (Missile n: missileSurTerrain)
			g.drawImage(n.getImg(), n.getCoordonne_x(), n.getCoordonne_y());
		
		
	}
	
	
	public void deplacementBalle(int delta, Jet j) {
		
		for(Missile n: missileSurTerrain)
			n.deplacementMissile(delta,j);
		
		this.score+=(int)10*delta/1000f;
		
		
	}
	
	
	

	public void collisionMissileBataillon( BataillonEnnemi b) throws SlickException {
		
		ArrayList<Ennemi> ennemiASup = new ArrayList<>();
		ArrayList<Missile> missileASup = new ArrayList<>();
		float x=0;
		boolean test=false;
		
		for(Missile n: this.missileSurTerrain) {
			

			for(Ennemi e: b.getB())
				if(n.VerifCollission(e) && n.getId()==1) {
					e.setPv(e.getPv()-1);
					missileASup.add(n);
					
					if(e.getPv()==0)
						ennemiASup.add(e);
					
					if(e.getPv()==0 && e.getNiveau()==4) {
						test=true;
						x=e.getCoordonne_x();
					}
						
					
					if(e.getCoordonne_y()>800)
						ennemiASup.add(e);
						
					this.score+=500;
					
				}
			
			if(n.getCoordonne_y()>800)
				missileASup.add(n);
			
			if(n.getCoordonne_y()<0)
				missileASup.add(n);
		}
		
		if(test) {
			b.getB().add(Ennemi.InitEnnemiNiveau4((int)x, -100));
		}
		
		b.getB().removeAll(ennemiASup);
		this.missileSurTerrain.removeAll(missileASup);
		
		
	}
	
	
public void collisionMissileJet(Jet j) throws SlickException {
		
	
		ArrayList<Missile> missileASup = new ArrayList<>();
		float x=0;
		boolean test=false;
		
		for(Missile n: this.missileSurTerrain) {
			

			
				if(n.VerifCollissionJet(j) && n.getId()!=1) {
					j.setPv(j.getPv()-1);
					missileASup.add(n);	
				}
				
				if(j.getPv()==0)
					j.etat=false;
					
		}
		
		this.missileSurTerrain.removeAll(missileASup);
		
		
}



	
	
	
	
	
	

}
