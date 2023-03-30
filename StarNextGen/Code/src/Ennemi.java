import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;






/*
 *Ennemi niveau 1
 *Dimension suivant x=57
 *Dimension suivant y=44
 * 
 * 
 * Ennemi niveau 2
 * x=
 * y=
 * 
 * 
 * Enne
 * 
 * */







public class Ennemi {
	
	private float coordonne_x;
	private  float coordonne_y;
	private int pv;
	private float vitesse;
	private Image img;
	private boolean etat;
	private int niveau;  // 	Permet de gerer les niveau, type d'énnemis, les images affichées ;
	private int DimX;
	private int DimY;
	private boolean controleurMissile;
	private int numero;
	private Image Nv2img1;
	private Image Nv2img2;
	private Image Nv2img3;
	private Image Nv2img4;

	private int timer;
	private int timer1;
	private int timepassed;
	private int timepassed1;
	private boolean test;
	private boolean deplacement;
	static int n=1;
	private boolean direction1;
	private int timepassed2;
	

	
	
	public Ennemi() throws SlickException {
		
		
		
		
		this.coordonne_x= (float)(Math.random()*400)+100;
		this.coordonne_y= (float)(Math.random()*-250)-50;
		this.etat=true;
		this.img= new Image("ennemi1 (1).png");
		this.pv=2;
		this.niveau=1;
		this.DimX=41;
		this.DimY=34;
		this.controleurMissile= false;
		this.numero=n;
		this.Nv2img1= new Image ("dropper.png");
		this.Nv2img2= new Image ("dropper2.png");
		this.Nv2img3= new Image ("dropper3.png");
		this.Nv2img4= new Image ("dropper4.png");
		n++;
	
		this.timer=0;
		this.timepassed2=3000;
		this.timepassed=100;
		this.timepassed1=5000;
		
		this.deplacement=false;
		this.direction1=false;
		this.timer1=0;
		
		this.test=true;

	
	}
	
	





	public int getDimX() {
		return DimX;
	}




	public void setDimX(int dimX) {
		DimX = dimX;
	}




	public int getDimY() {
		return DimY;
	}




	public void setDimY(int dimY) {
		DimY = dimY;
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





	public int getPv() {
		return pv;
	}





	public void setPv(int pv) {
		this.pv = pv;
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






	public void setImg(Image img) {
		this.img = img;
	}





	public boolean getEtat() {
		return etat;
	}





	public void setEtat(boolean etat) {
		this.etat = etat;
	}




	


	 public int getNiveau() {
		return niveau;
	}






	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}






	public boolean isControleurMissile() {
		return controleurMissile;
	}






	public void setControleurMissile(boolean controleurMissile) {
		this.controleurMissile = controleurMissile;
	}






	public int getNumero() {
		return numero;
	}






	public void setNumero(int numero) {
		this.numero = numero;
	}






	void ChargerMissile( MissileSurTerrain  mi) throws SlickException {
		Missile m= new Missile(2);
		if(this.niveau==1) {
		
			m.setImg(new Image("MissileE.png"));
			m.setCoordonne_x(this.coordonne_x+19);
			m.setCoordonne_y(this.coordonne_y+10);
			m.setcA(this.numero);
			mi.getMissileSurTerrain().add(m);
		}
		
		if(this.niveau==2) {
			Missile m2= new Missile(2);
			
			
			m.setImg(new Image("red bullet (1).png"));
			m.setCoordonne_x(this.coordonne_x+26);
			m.setCoordonne_y(this.coordonne_y+10);
			m.setId(3);
			m.setcA(this.numero);
			m.setDirection(true);
			mi.getMissileSurTerrain().add(m);
		
			
			m2.setImg(new Image("red bullet (1).png"));
			m2.setCoordonne_x(this.coordonne_x+26);
			m2.setCoordonne_y(this.coordonne_y+10);
			m2.setId(3);
			m2.setcA(this.numero);
			m2.setDirection(false);
			mi.getMissileSurTerrain().add(m2);
			
			
			
		}
		
		if(this.niveau==3) {
			
			m.setImg(new Image("bulletBlue.png"));
			m.setCoordonne_x(this.coordonne_x+26);
			m.setCoordonne_y(this.coordonne_y+10);
			m.setId(4);
			m.setcA(this.numero);
			mi.getMissileSurTerrain().add(m);


		}
		
		if(this.niveau==4) {
			
			for(int i=0; i<5; i++) {
				Missile n= new Missile(2);
				
				n.setImg(new Image("Poncturer.png"));
				n.setCoordonne_x(this.coordonne_x+20+ (int)(Math.random()*15));
				n.setCoordonne_y(this.coordonne_y+10 + (int)(Math.random()*15));
				n.setId(5);
				n.setcA(this.numero);
				mi.getMissileSurTerrain().add(n);
				
			}
			
			
			
			
		}
		
		
	}
	

	 
	 
	 
	public void tirerMissile( int delta , MissileSurTerrain mi) throws SlickException  {
			
		 
		 
		 	if(this.coordonne_y>100)
		 	 if (this.niveau==1|| this.niveau==2)
		 		 if(this.timer<=this.timepassed2)
						this.timer+=delta;
					else {
					
						this.ChargerMissile(mi);
						this.timer=0;
					}

		 			
		 	 
		
		 	if (this.niveau==3)
		 		 if(this.deplacement) {
		 			 
		 			 
		 			 
		 		 if(test) {
					 if(this.timer<=this.timepassed)
							this.timer+=delta;
						else {
						
							this.ChargerMissile(mi);
							this.timer=0;
						}
		 		 }
		 		 
		 		 
		 		 if(this.timer1<this.timepassed1)
		 			 this.timer1+=delta;
		 		else {
		 			this.test=!this.test;
		 			this.timer1=0;
		 		}
 
				 
				 
			 }
		 	 
		 	 
		 	 
		 	if(this.niveau==4) {
		 		 if(this.timer1<this.timepassed1)
		 			 this.timer1+=delta;
		 		else {
		 			this.ChargerMissile(mi);
		 			this.timer1=0;
		 		 
		 	 }
		 	 
		 	 
		 	 }	 
		 
			 
	 }
	 
	
	

	 
	 
	 public void afficherEnnemi(Graphics g) {
		 

			g.drawImage(this.img, this.coordonne_x, this.coordonne_y);
			

			
		}
	 
	
	 
	 
	 
	 
	 public void deplacementEnnemi(int delta, Jet j) {
		 
		
	 
		 if (this.niveau==1) {
		
			 if(this.coordonne_y<80)
				 this.vitesse=250;
			 else 
				 this.vitesse=20;
		
			 this.coordonne_y += this.vitesse*delta/1000f;

		 }
		 
		 if (this.niveau==2)
		 {
			 	
				if( this.coordonne_x< 450 && this.direction1 ) {
					this.coordonne_x += this.vitesse*delta/1000f;
					this.coordonne_y+= this.vitesse*delta/1000f;
	
				}
				else this.direction1=false;
				
				
				
				if(this.coordonne_x>250 && !this.direction1) {
					this.coordonne_x-=this.vitesse*delta/1000f;
					this.coordonne_y+= this.vitesse*delta/1000f;
				}
					
				else this.direction1=true;
		
			  
			  
			 
		 }
		 
		 if(this.niveau==3) {
			 
			 
			 if(this.coordonne_y<100 && !this.deplacement) {
				 this.coordonne_y+=120*delta/1000f;
			 }
			 
			 else this.deplacement=true;
			 
			if(this.deplacement) {
			 if(this.coordonne_x<j.getCoordonne_x())
				 this.coordonne_x+=this.vitesse*delta/1000f;
			 
			 if(this.coordonne_x>j.getCoordonne_x())
				 this.coordonne_x-=this.vitesse*delta/1000f;
			}
		 }
		 
		 if(this.niveau==4) {
			 if(this.coordonne_y<100)
			  this.coordonne_y+=90*delta/1000f;
		
		 }
	 }
	 
	 
	 
	 
	 
	 public Image ImageRandomizer() {
			int i=(int)(Math.random()*4)+1;
			
			if(i==1)
				return this.Nv2img1;
			
			else if (i==2)
				return this.Nv2img2;
			
			else if (i==3)
				return this.Nv2img3;
			
			else return this.Nv2img4;
		}

	 
	 
	 static Ennemi InitEnnemiNiveau2(int x, int y) throws SlickException {
		  
		 Ennemi e= new Ennemi();
		 e.setImg(e.ImageRandomizer());
		 e.setPv(10);
		 e.setNiveau(2); 
		 e.setCoordonne_x(x);
		 e.setCoordonne_y(y);
		 e.setVitesse(45);
		 
		 
		return e;
			
	 
	 
	 
	 }
	 
	 static Ennemi InitEnnemiNiveau3() throws SlickException {
		  
		 Ennemi e= new Ennemi();
		 e.setImg(new Image("sniper.png"));
		 e.setPv(30);
		 e.setNiveau(3); 
		 e.setCoordonne_x((float)(Math.random()*600)+50);
		 e.setCoordonne_y(-100);
		 e.setVitesse(25);
		 
		 
		return e;	
	 }
		 
		 static Ennemi InitEnnemiNiveau4(int x, int y) throws SlickException {
			  
			 Ennemi e= new Ennemi();
			 e.setImg(new Image("dropppers.png"));
			 e.setPv(15);
			 e.setNiveau(4); 
			 e.setCoordonne_x(x);
			 e.setCoordonne_y(y);
			 e.setVitesse(25);
			 
			 
			return e;	


		 }
		 
		
		 
	 
		 
	 

}


	
