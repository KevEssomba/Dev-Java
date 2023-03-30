import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class etoile {
	float coordonne_x;
	float coordonne_y;
	String shape;
	int vitesse;

	
	public etoile() {
		this.coordonne_x=(float)Math.random()*700;
		this.coordonne_y=(float)Math.random()*700;
		this.shape=".";
		this.vitesse=60;

		
	}

	public void afficherEtoile(Graphics g) {
		int n=(int)(Math.random()*2)+1;
		
		if (n==1)
		g.setColor(Color.lightGray);
		else 
			g.setColor(Color.blue);
		g.drawString(this.shape, this.coordonne_x, this.coordonne_y);
	}
	
	public void deplacementEtoile(int delta) {
		
			if (this.coordonne_y<700)
				this.coordonne_y+=vitesse*delta/1000f;	
			else {this.coordonne_y=0;
			this.coordonne_x=(float)Math.random()*700;
			}
		}
	
		

}
