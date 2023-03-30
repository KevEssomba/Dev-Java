import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {
	
	Jet j;
	BataillonEnnemi e;
	Scenario s;
	MissileSurTerrain m;
	Ciel c;
	Menu menu;

	

	public Main(String title) {
		super(title);
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
		
		 j= new Jet();
		 e= new BataillonEnnemi();
		 s= new Scenario();
		 m= new MissileSurTerrain();
		 c= new Ciel();
		 menu= new Menu();

		 

	}
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		
		switch(menu.choix) {
		case 0:
			menu.afficherMenu(g);
			c.afficherCiel(g);
			break;
		case 1:
			m.afficherMissile(g);
			e.afficherBataillonEtMissileE(g);
			j.afficherJetEtMissile(g);
			s.affichageScore(g, m, j);
			c.afficherCiel(g);
			j.afficherGameOver(g);
			break;
		case 2:
	
			break;
			
		case 3:
			gc.exit();
			break;
		}

	}



	@Override
	public void update(GameContainer gc,  int delta) throws SlickException {
	
		switch(menu.choix) {
		case 0:
			c.deplacerCiel(delta);
			menu.hover(gc);
			menu.Selection(gc);
		
		break;
		case 1:
			j.deplacementJet(gc, delta);
			m.deplacementBalle(delta,j);
			j.tirerMissile(delta, m, gc);
			e.deplacementBataillon(delta,j);
			e.tirerMissileE(delta, m);
			m.collisionMissileBataillon(e);
			e.ajouterEnnemi(m,s);
			s.PassageNiveau2(e,m, delta);
			e.ajouterEnnemi2(s,m);
			s.PassageNiveau3(e, m, delta);
			s.PassageNiveau4(e, m, delta);
			e.ajouterEnnemi3(m, s);
			c.deplacerCiel(delta);
			m.collisionMissileJet(j);
			j.Cheat(gc);

			
		break;
		
		case 2:
			
			gc.exit();
		break;
		
		}
	}

	public static void main(String[] args) throws SlickException {
		

		
		Main monjeu = new Main("Space War");
		AppGameContainer app = new AppGameContainer(monjeu);
		app.setShowFPS(false);
		app.setDisplayMode(700, 700, false);
		app.start();
		
		
		
	}

}
