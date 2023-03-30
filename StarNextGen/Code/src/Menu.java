import java.util.Arrays;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Menu {
	
	 int choix;
	 private Image ImgJouer;
	 private Image ImgExit;
	 private Image ImgInstruction;
	 private Image logo;
	
	
	public Menu() throws SlickException{
		this.choix=0;
		this.ImgJouer= new Image("play non-hover.png");
		this.logo= new Image ("Logo.png");
		this.ImgInstruction= new Image("instruct-non hover.png");
		this.ImgExit= new Image("Exit non-hover.png");
	}
	

	
public int[] clicCase(int x, int y) {
	
	int [] tab= new int [2];
	
	tab[0]=x;
	tab[1]=y;
	

	return tab;
		
		
		
		
	}

public int[] hoverCase(int x, int y){
	
int [] tab= new int [2];
	
	tab[0]=x;
	tab[1]=y;

	return tab;


}


public void Selection(GameContainer gc) {
		
	
	Input inp= gc.getInput();
	
	if(inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
		float x=inp.getMouseX();
		float y= inp.getMouseY();
	
		if(x > 270 &&  x< 414   ) 
			if(400< y && y<432 )
			choix=1;
			
		if(x> 270 &&  x<414  ) 
			if(500< y && y<532 )
				choix=3;
	
	
	}
	
}


	


public void hover(GameContainer gc) throws SlickException {
Input inp= gc.getInput();
	
	float x=inp.getMouseX();
	float y= inp.getMouseY();
	
	if(x > 270 &&  x< 414   ) {
		if(400< y && y<432 )
			this.ImgJouer=new Image("play non-hover.png");
	}
	
	else this.ImgJouer=new Image("play.png");
	
	if(x> 270 &&  x<414  ) {
		if(450< y && y<482 )
			this.ImgInstruction =new Image("instruct-non hover.png");
	}
	
	else this.ImgInstruction =new Image("instruction.png");
	
	
	if(x> 270 &&  x<414  ) {
		if(500< y && y<532 )
			this.ImgExit =new Image("Exit non-hover.png");
	}
	
	else this.ImgExit =new Image("exit.png");
	
	
}








public void afficherMenu(Graphics g) {
	
	g.drawImage(this.logo, 120, 150);
	
	g.drawImage( this.ImgJouer, 270, 400);
	
	g.drawImage( this.ImgInstruction, 270, 450  );
	
	g.drawImage(this.ImgExit, 270, 500);
	
	
	
	
}


}
