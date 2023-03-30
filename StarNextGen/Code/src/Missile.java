import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;





// id 3 coorespond au ennemi niveau2
public class Missile {
	
	private float coordonne_x;
	private  float coordonne_y;
	private float vitesse;
	private Image img;
	private int id;
 	private int cA; //correspondance avec le numero Alien
 	private boolean direction;
	
	public Missile(int id) throws SlickException {
	
		this.id = id;
		this.vitesse=(int)(Math.random()*35)+30;
		this.img= new Image("Fireball (1).png");
		this.direction=false;
	
	
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
	
	
	

	public float getVitesse() {
		return vitesse;
	}
	
	
	

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	
	
	public Image getImg() {
		return img;
	}
	
	
	
	
	
	public boolean getDirection() {
		return direction;
	}




	public void setDirection(boolean direction) {
		this.direction = direction;
	}




	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}



	public void setImg(Image img) {
		this.img = img;
	}
	


	public int getcA() {
		return cA;
	}




	public void setcA(int cA) {
		this.cA = cA;
	}




	public void deplacementMissile( int delta, Jet j) {
		
		if(this.id==1)
			this.coordonne_y-=this.vitesse*delta/1000f;
		
		
		
		else if(this.id==2 || this.id==4)
			this.coordonne_y+=this.vitesse*delta/1000f;
		
		
		
		else if(this.id==3) {
			if( this.coordonne_x< 690 && this.direction ) {
				this.coordonne_x += this.vitesse*delta/1000f;
				this.coordonne_y+= (this.vitesse-20)*delta/1000f;

			}
			else this.direction=false;
			
			
			
			if(this.coordonne_x>0 && !this.direction) {
				this.coordonne_x-=this.vitesse*delta/1000f;
				this.coordonne_y+= (this.vitesse-20)*delta/1000f;
			}
				
			else this.direction=true;
			
		}
		
		else if(this.id==5) {
			
			if(this.coordonne_x < j.getCoordonne_x() && this.coordonne_y<j.getCoordonne_y()) {
				this.coordonne_x+=this.vitesse*delta/1000f;
				this.coordonne_y+=this.vitesse*delta/1000f;
			}
				
			else if (this.coordonne_x > j.getCoordonne_x() && this.coordonne_y<j.getCoordonne_y()) {
				this.coordonne_x-=this.vitesse*delta/1000f;
				this.coordonne_y+=this.vitesse*delta/1000f;
			}
				
			else if(this.coordonne_x < j.getCoordonne_x() && this.coordonne_y>j.getCoordonne_y()) {
				this.coordonne_x+=this.vitesse*delta/1000f;
				this.coordonne_y-=this.vitesse*delta/1000f;
			}
				
			
			else if(this.coordonne_x==j.getCoordonne_x()&& this.coordonne_x!=j.getCoordonne_y())
				if (this.coordonne_y>j.getCoordonne_y()) {
					this.coordonne_y-=this.vitesse*delta/1000f;
				}
					
				else {
					this.coordonne_y+=this.vitesse*delta/1000f;
					
				}
			else if(this.coordonne_x!=j.getCoordonne_x() && this.coordonne_y==j.getCoordonne_y())
				if (this.coordonne_x>j.getCoordonne_x())
					this.coordonne_x+=this.vitesse*delta/1000f;
				else {
					this.coordonne_x-=this.vitesse*delta/1000f;
				}
			
			else {
				this.coordonne_x-=this.vitesse*delta/1000f;
				this.coordonne_y-=this.vitesse*delta/1000f;
			}
		}
		
			
			
			
		}
		
		
		
		

	
	
	
	public boolean VerifCollission( Ennemi  e ) {
		
		if(this.coordonne_x>= e.getCoordonne_x() && this.coordonne_x<= e.getCoordonne_x()+e.getDimX() )
			return  (this.coordonne_y >= e.getCoordonne_y() && this.coordonne_y<= e.getCoordonne_y()+e.getDimY()-10);

		else 	return false;
		
	}
	
	public boolean VerifCollissionJet( Jet  e ) {
		
		if(this.coordonne_x>= e.getCoordonne_x() && this.coordonne_x<= e.getCoordonne_x()+e.getDimX() )
			return  (this.coordonne_y >= e.getCoordonne_y() && this.coordonne_y<= e.getCoordonne_y()+e.getDimY()-10);

		else 	return false;
		
	}

	

	
	
	
}
	
	