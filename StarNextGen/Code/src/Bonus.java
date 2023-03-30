import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bonus {
	private Image img1;
	private float coordonee_x;
	private float coordonee_y;
	private int vitesse;
	private int id;
	
	

	public Bonus() throws SlickException {
		this.coordonee_x=(float)(Math.random()*700)+10;
		this.coordonee_y=0;
		this.id=(int)(Math.random()*2)+1;
		this.img1=new Image("Bonus-vie.png");	
		this.vitesse=50;
		
	}
	
	
	
	


	public void afficherBonus() {
		int deltaX=30, deltaY=30;
			this.img1.drawWarped(this.coordonee_x+deltaX, this.coordonee_y, this.coordonee_x+deltaX, this.coordonee_y+ deltaY, this.coordonee_x, this.coordonee_y+ deltaY, this.coordonee_x, this.coordonee_y);
	}
	
	
	public void resetPosition() {
		this.coordonee_x=(float)(Math.random()*700)+1;
		this.coordonee_y=0;
	}
	
	public void deplacementBonus(int delta) {
	
			if(this.coordonee_y<700)
				this.coordonee_y+=this.vitesse*delta/1000f;
			else 
				this.resetPosition();
	
	}
	
	
	

}
