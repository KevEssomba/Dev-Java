import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Case {
	
	private int id;
	private Image img;
	private float coordinate_x;
	private float coordinate_y;
	
	public Case() {
		
	}
	
	public Case(int type, int x, int y) throws SlickException {
		
		
		if (type==0) {
			this.img= new Image("o.png ");
			this.coordinate_x= x*150+20;
			this.coordinate_y = y*150+20;
			
			
		}
		
		else {
			this.img = new Image ("x.png");
		
			this.coordinate_x= x*150;
			this.coordinate_y = y*150;
		}
		
		this.id=type;
		
	}
	
	
	public void afficherCase(Graphics g) {
		
		g.drawImage(this.img, this.coordinate_x, this.coordinate_y);
		
	}

	public float getCoordinate_x() {
		return coordinate_x;
	}

	public void setCoordinate_x(int coordinate_x) {
		this.coordinate_x = coordinate_x;
	}

	public float getCoordinate_y() {
		return coordinate_y;
	}

	public void setCoordinate_y(int coordinate_y) {
		this.coordinate_y = coordinate_y;
	}

	public int getId() {
		return id;
	}

	
	
	
	
	
	
	
	

}
