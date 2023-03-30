import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MonJeu extends BasicGame {
	
	
	Plateau p;

	public MonJeu(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		
		p= new Plateau();
	}



	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		p.dessinerPlateau(g);
		

	}

		@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
			p.selectionnerCase(gc);
			p.victoire();
	}

	

}
