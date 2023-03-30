import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class mainJeu {

	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
		
		MonJeu monjeu = new MonJeu("Tic Tac Toe");
		AppGameContainer app = new AppGameContainer(monjeu);
		app.setShowFPS(false);
		app.setDisplayMode(450, 450, false);
		app.start();
		
		
		
	}

}
