import org.newdawn.slick.Image;

public class Decor {
	
	private float coordonne_x;
	private  float coordonne_y;
	private float vitesse;
	private Image img;
	private int id;
	
	
	public Decor() {
		
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
	
	
	
	
	
	public int getId() {
		return id;
	}



	public void setImg(Image img) {
		this.img = img;
	}
	
	

}
