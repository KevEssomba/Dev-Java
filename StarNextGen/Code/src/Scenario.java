import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Scenario {
	
	
	private boolean InitNiveau2;
	private boolean InitNiveau3;
	private boolean InitNiveau4;
	private int timer;
	private int timepassed;
	private int niveau;


	public Scenario() throws SlickException {
		
		this.niveau=1;
		this.InitNiveau2= false;
		this.InitNiveau3=false;
		this.InitNiveau4=false;
		this.timepassed=8000;
		this.timer=0;
	}
	



	
	
	public boolean getInitNiveau2() {
		return InitNiveau2;
	}






	public void getInitNiveau2(boolean initNiveau2) {
		InitNiveau2 = initNiveau2;
	}






	public boolean getInitNiveau3() {
		return InitNiveau3;
	}






	public void getInitNiveau3(boolean initNiveau3) {
		InitNiveau3 = initNiveau3;
	}






	public boolean getInitNiveau4() {
		return InitNiveau4;
	}






	public void setInitNiveau4(boolean initNiveau4) {
		InitNiveau4 = initNiveau4;
	}






	public void PassageNiveau2(BataillonEnnemi b,MissileSurTerrain m, int delta) throws SlickException {
		
		
		
		if(m.getScore()>60000 && !this.InitNiveau2) {
	
				
				if(this.timer<this.timepassed)
					this.timer+=delta;
				else {
					b.getB().add(Ennemi.InitEnnemiNiveau2(350, -100));
					this.InitNiveau2=true;
					this.timer=0;
					this.niveau=2;
				}

		}
		
	
		
	}
	
public void PassageNiveau3(BataillonEnnemi b,MissileSurTerrain m, int delta) throws SlickException {
		
		
		
	if(m.getScore()>100000 && !this.InitNiveau3){
			if(this.timer<this.timepassed)
				this.timer+=delta;
			else {
				b.getB().add(Ennemi.InitEnnemiNiveau3());
				this.InitNiveau3=true;
				this.timer=0;
				this.niveau=3;	
			}

		}
		
	
		
	}

public void PassageNiveau4(BataillonEnnemi b,MissileSurTerrain m, int delta) throws SlickException {
	
	
	
	if( m.getScore()>250000 && !this.InitNiveau4) {
		if(this.timer<this.timepassed)
			this.timer+=delta;
		else {
			b.getB().add(Ennemi.InitEnnemiNiveau4(100,-100));
			b.getB().add(Ennemi.InitEnnemiNiveau4(600,-100));
			this.InitNiveau4=true;
			this.timer=0;
			this.niveau=3;	
		}
			
		
					

	}
	

	
}
	
	
	
public void affichageScore(Graphics g, MissileSurTerrain m, Jet j) {
		
		g.setColor(Color.lightGray);
		g.drawString(" Score: ", 1 , 5);
		g.drawString((int)m.getScore()+" ", 10 , 25);
		g.setColor(Color.red);
		g.drawString(" Vie: ", 1 , 45);
		g.drawString(j.getPv()+" ", 10, 65);
		
	}
	
	
	
}
