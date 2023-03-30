import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class Jet {
	
	
	
	private float coordonne_x;
	private  float coordonne_y;
	private int pv;
	private float vitesse;
	private Image img;
	private boolean controleurMissile;
	private int timer;
	private int timepassed;
	private int dimX;
	private int dimY;
	public boolean etat;
	
	
	
	
	public Jet() throws SlickException {
		this.coordonne_x=300;
		this.coordonne_y=600;
		this.img= new Image("pngkit_space-ship-png_328881 (1) (1).png");
		this.vitesse=30 ;
		this.controleurMissile=false;
		this.timer=0;
		this.timepassed=100;
		this.dimX=45;
		this.dimY=42;
		this.etat=true;
		this.pv=15;

		
		
	}
	
	
	
	
	public int getDimX() {
		return dimX;
	}




	public void setDimX(int dimX) {
		this.dimX = dimX;
	}




	public int getDimY() {
		return dimY;
	}




	public void setDimY(int dimY) {
		this.dimY = dimY;
	}




	public float getCoordonne_x() {
		return coordonne_x;
	}





	public void setCoordonne_x(float coordonne_x) {
		this.coordonne_x = coordonne_x;
	}





	public float getCoordonne_y() {
		return coordonne_y;
	}





	public void setCoordonne_y(float coordonne_y) {
		this.coordonne_y = coordonne_y;
	}





	public int getPv() {
		return pv;
	}





	public void setPv(int pv) {
		this.pv = pv;
	}





	public float getVitesse() {
		return vitesse;
	}





	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}





	public Image getImg() {
		return img;
	}






	public void setImg(Image img) {
		this.img = img;
	}
	
	
	





	public void afficherJetEtMissile(Graphics g) {
		
		if (this.etat)
			g.drawImage(this.img, this.coordonne_x, this.coordonne_y);
		
		
		
	}
	
	
	public void deplacementJet(GameContainer gc, int delta ) {
		

		
		Input inp= gc.getInput();
		
		
		if(inp.isKeyDown(Input.KEY_LEFT)) {
				this.coordonne_x-= this.vitesse*delta/100f;
			}
		if(inp.isKeyDown(Input.KEY_RIGHT)) {
				this.coordonne_x+= this.vitesse*delta/100f;
			}
		if(inp.isKeyDown(Input.KEY_UP)) {
				this.coordonne_y-= this.vitesse*delta/100f;
			}
		if(inp.isKeyDown(Input.KEY_DOWN)) {
				this.coordonne_y+= this.vitesse*delta/100f;
			}
		
	}
	
	
	
	
	
	 void ChargerMissile( MissileSurTerrain  mi) throws SlickException {
		Missile m= new Missile(1);
		m.setVitesse(200);
		m.setCoordonne_x(this.coordonne_x+16);
		m.setCoordonne_y(this.coordonne_y);
		
		mi.getMissileSurTerrain().add(m);
		
	}

	 
	 
	
	 
	 public void tirerMissile( int delta , MissileSurTerrain mi, GameContainer gc ) throws SlickException  {
			
		Input inp= gc.getInput();
				
				
				if(inp.isKeyDown(Input.KEY_SPACE)) 
				{
	
						if(this.timer<=this.timepassed)
							this.timer+=delta;
						else {
						
							this.ChargerMissile(mi);
							this.timer=0;
				}
				
		
	
	
	
		
				}
	 
	 }
	 
	public void afficherGameOver(Graphics g) throws SlickException {
		
		if (!this.etat)
			g.drawImage(new Image("gameOver.png"), 100, 100);
		
	}
	 
	
	public void Cheat(GameContainer gc) {
		
		Input inp= gc.getInput();
		
		if (inp.isKeyDown(Input.KEY_W))
			if (inp.isKeyDown(Input.KEY_I))
				if (inp.isKeyDown(Input.KEY_N))
					{this.pv=100000;
					this.etat=true;
					}
	}

	
	
	
	
	
	
	
	
	

}
