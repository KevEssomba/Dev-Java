import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Plateau {
	
	private Case[][] cases;
	private Image plateau;
	private Image fond;
	private static int type=1;
	
	
	

	
	public Plateau() throws SlickException {
		
		this.cases= new Case [3][3];
		this.plateau = new Image ("Plateau.png");
		this.fond = new Image ("whiteBG.png");

		 
	}
	
	public void dessinerCases(Graphics g) {
		
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(this.cases[i][j]!=null)
					this.cases[i][j].afficherCase(g);
		
		
	}
	
	
	public void dessinerPlateau(Graphics g) {
		
		
		g.drawImage(this.fond, 0, 0);
		g.drawImage(this.plateau, 0, 0);
		this.dessinerCases(g);	
		
		
	}
	
	
	public void selectionnerCase(GameContainer gc) throws SlickException {
		
		Input inp= gc.getInput();
		
		if(inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			int x=inp.getMouseX()/150;
			int y=inp.getMouseY()/150;
		
			if (this.cases[x][y]==null) {
				this.cases[x][y]= setCase(x,y);
				
			}

		}
		
		
	}
	
	Case setCase(int x, int y) throws SlickException {
		
		Case nouvelleCase = new Case( type%2, x, y);
		type++;
			
		return nouvelleCase;
		
		
	}
	

	
	
	
	public void victoire() {
		

		for(int i=0; i<3; i++)
			for (int j=0; j<3; j++) {
				
				if( this.cases[i][j]!=null && (this.verifHoriz(this.cases[i][j]) || this.verifPerp(this.cases[i][j]) || this.verifVert(this.cases[i][j]) || this.verifPerpH(this.cases[i][j])))
					System.out.println("Victoire");
				
				
			}
		
		
		
		
	}
	
	
	public boolean  verifVert(Case caseCourante) {
		
		ArrayList<Case> listeVerif= new ArrayList<>();
		
		for(int i=0; i<3; i++)
			for (int j=0; j<3; j++) 
				if(this.cases[i][j]!=null &&  caseCourante.getCoordinate_x()==this.cases[i][j].getCoordinate_x()) 
						listeVerif.add(this.cases[i][j]);
		
		
		
	 if(listeVerif.size()==3){
		
		for(Case c:listeVerif) {
			if(c.getId()!=caseCourante.getId())
				return false;
			
			else return true;
		}
		

		
	}
			
	 return false;

		

	}
	

	public boolean  verifHoriz(Case caseCourante) {
		
		ArrayList<Case> listeVerif= new ArrayList<>();
		
		for(int i=0; i<3; i++)
			for (int j=0; j<3; j++) 
				if( this.cases[i][j]!=null && this.cases[i][j].getCoordinate_y()==caseCourante.getCoordinate_y()) 
						listeVerif.add(this.cases[i][j]);
	
		 if(listeVerif.size()==3){
			
			for(Case c:listeVerif) {
				if(c.getId()!=caseCourante.getId())
					return false;
				
				else return true;
			}
		 }
		 
		
			return false;

			
	} 
	

	public boolean  verifPerp(Case caseCourante) {
		
		ArrayList<Case> listeVerif= new ArrayList<>();
		
		for(int i=0; i<3; i++)
			for (int j=0; j<3; j++) 
				if( this.cases[i][j]!=null && (this.cases[i][j].getCoordinate_x()==caseCourante.getCoordinate_x()+150 && this.cases[i][j].getCoordinate_y()==caseCourante.getCoordinate_y()+150 || this.cases[i][j].getCoordinate_x()==caseCourante.getCoordinate_x()+300 && this.cases[i][j].getCoordinate_y()==caseCourante.getCoordinate_y()+300 )) 
						listeVerif.add(this.cases[i][j]);
				
		listeVerif.add(caseCourante);
		

		 if(listeVerif.size()==3){
			
			for(Case c:listeVerif) {
				if(c.getId()!=caseCourante.getId())
					return false;
				
				else return true;
				}
			
			
		

		 }
		 return false;
	
	}
	
	

	public boolean  verifPerpH(Case caseCourante) {
		
		ArrayList<Case> listeVerif= new ArrayList<>();
		
		for(int i=0; i<3; i++)
			for (int j=0; j<3; j++) 
				if( this.cases[i][j]!=null && (this.cases[i][j].getCoordinate_x()==caseCourante.getCoordinate_x()+150 && this.cases[i][j].getCoordinate_y()==caseCourante.getCoordinate_y()-150 || this.cases[i][j].getCoordinate_x()==caseCourante.getCoordinate_x()+300 && this.cases[i][j].getCoordinate_y()==caseCourante.getCoordinate_y()-300 )) 
						listeVerif.add(this.cases[i][j]);
				
		listeVerif.add(caseCourante);

		 if(listeVerif.size()==3){
			
			for(Case c:listeVerif) {
				if(c.getId()!=caseCourante.getId())
					return false;
				
				else return true;
				}
			
			
		

		 }
		 return false;
	
	}
	
	
	
	
	

}
