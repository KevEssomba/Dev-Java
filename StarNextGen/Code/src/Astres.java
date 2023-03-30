import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Astres {
	
	float coordonne_x;
	float coordonne_y;
	Image img;
	int vitesse;
	int timer;
	int timepassed;
	
	public Astres() throws SlickException {
		
		int x=(int) (Math.random()*3)+1;
		this.coordonne_x=(float) (Math.random()*700)+10;
		this.coordonne_y=-100;
		
		if (x==1)
			this.img= new Image ("Terran.png");
		if(x==2)
			this.img= new Image ("Lava.png");
		
		if(x==3)
			this.img= new Image("Ice.png");
		
		this.vitesse=8;
		
		this.timepassed=8000;
	}
	
	
	public void deplacementAstre(int delta) {
		this.coordonne_y+=this.vitesse*delta/1000f;
			
	}
	
	public void initAstre(int delta) throws SlickException {
		Astres Astre;
		
		if(timer<timepassed) {
			timer+=delta;
			}
		else {
			Astre= new Astres();
			timer=0;
			System.out.println("ok");
		}
	}
	
	public void afficherAstre(Graphics g) {
		
		g.drawImage(this.img, coordonne_x, coordonne_y);
		
	}

}
