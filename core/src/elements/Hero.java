package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hero extends Personnages {

	public static final int velocity = 180;
	public static final float GRAVITE = 9.801f;
	public float jump_val = 0;
	private static final  float jump_max = 40;
	private boolean jumping = false;
	private String step= "";
	static float time_elapsed = 0;
	
	public void print(String s) {
		if (time_elapsed > 1) {
			System.out.println(s);
		}
	}
	
	public Hero(String s, float x, float y) {
		super(s, x, y);		
	}
	
	
	public void update(float delta) {
		time_elapsed += delta;
		
		float new_x = x;
		float new_y = y;


		if(Gdx.input.isKeyPressed(Keys.LEFT)) { new_x -= velocity * delta; }
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) { new_x += velocity * delta;	}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) { new_y -= velocity * delta; }
		if(Gdx.input.isKeyJustPressed(Keys.SPACE) && !jumping) {
			jumping = true;
			jump_val = jump_max;
		}
		
		if ( jumping ) {
			if (jump_val > -jump_max) {
				jump_val -= GRAVITE * delta * GameMap.hauteurTile;
			} else {
				jump_val = 0;
				jumping = false;
			}
		}
		new_y -= GRAVITE * delta * GameMap.hauteurTile;
		new_y += jump_val;
		
		int newcase_x = (int)new_x / (int)GameMap.largeurTile; 
		int newcase_y = (int)new_y / (int)GameMap.hauteurTile; 
		int pcase_x = (int)x / (int)GameMap.largeurTile; 
		int pcase_y = (int)y / (int)GameMap.hauteurTile; 
		int newcase_x2 = (int)(new_x + (int)GameMap.largeurTile -1) / (int)GameMap.largeurTile; 
		int newcase_y2 = (int)(new_y + (int)GameMap.hauteurTile -1) / (int)GameMap.hauteurTile; 
		int pcase_x2 = (int)(x + (int)GameMap.largeurTile - 1) / (int)GameMap.largeurTile; 
		int pcase_y2 = (int)(y + (int)GameMap.hauteurTile - 1) / (int)GameMap.hauteurTile; 
		
		print("hero on cell : " + pcase_x + "-" + pcase_y);
		
		if ((GameMap.layerSol.getCell(newcase_x, pcase_y) == null) && (GameMap.layerSol.getCell(newcase_x2, pcase_y) == null)) {
			print("x");
			x = new_x;
		}
		if ((GameMap.layerSol.getCell(pcase_x, newcase_y) == null) && (GameMap.layerSol.getCell(pcase_x2, newcase_y) == null) && (GameMap.layerSol.getCell(pcase_x, newcase_y2) == null) && (GameMap.layerSol.getCell(pcase_x2, newcase_y2) == null)) {
			print("y");
			y = new_y;
		}
		
		

		
		/*
		if ( jump.y > 0){
			float deltaY  = jumpUp.y * delta*2;
			y += deltaY;
			jump.sub(new Vector2(0,deltaY));		
		}


		caseX = (int)x/(int)GameMap.largeurTile;
		caseY = (int)y/(int)GameMap.hauteurTile;
		if(GameMap.layerSol.getCell(caseX, caseY) != null ){
			x = (caseX+1)*GameMap.largeurTile ;
		}

		caseX = (int)x/(int)GameMap.largeurTile;
		caseY = (int)y/(int)GameMap.hauteurTile;
		if(GameMap.layerSol.getCell(caseX, caseY) != null ){
			x = (caseX+1)*GameMap.largeurTile ;
		}
				
		caseX = (int)x+texture.getWidth()/(int)GameMap.largeurTile;
		caseY = (int)y/(int)GameMap.hauteurTile;
		caseY2 = caseY + 1;
		if(GameMap.layerSol.getCell(caseX, caseY) != null  ){
			x = (caseX-1)*GameMap.largeurTile;
		}
		if(GameMap.layerSol.getCell(caseX, caseY2) != null){
			x = (caseX) * GameMap.largeurTile;
		}
	
		
		
		if(Gdx.input.isKeyPressed(Keys.DOWN))
		{
			System.out.println("lolo");
			y -= velocity * delta;
		}
		caseX = (int)x/(int)GameMap.largeurTile;
		caseX2 = caseX+1;
		caseY = (int)y/(int)GameMap.hauteurTile;
		if(GameMap.layerSol.getCell(caseX, caseY) != null || GameMap.layerSol.getCell(caseX2, caseY) != null){
			y = (caseY+1)*GameMap.hauteurTile;
			jumping = false;
		}
		
		//check collisions

		caseX = (int)x/(int)GameMap.largeurTile;
		caseY = (int)y/(int)GameMap.hauteurTile;
		caseX2 = caseX+1;

		if(GameMap.layerSol.getCell(caseX, caseY) != null || GameMap.layerSol.getCell(caseX2, caseY) != null){
			y = (caseY+1)*GameMap.hauteurTile;
			jumping = false;
		}
		
		
		if(Gdx.input.isKeyJustPressed(Keys.SPACE))
		{
			if(!jumping){
				jumping = true;
				jump = jumpUp.cpy();	
			}
		}
		caseX = (int)x/(int)GameMap.largeurTile;
		caseX2 = caseX +1;
		caseY = (int)y+texture.getHeight()/(int)GameMap.hauteurTile;
		if(GameMap.layerSol.getCell(caseX, caseY) != null || GameMap.layerSol.getCell(caseX2, caseY) != null ){
			y = (caseY-1)*GameMap.hauteurTile;
			jumping = false;
		}
<<<<<<< HEAD
		
		

		
=======
*/
		if (time_elapsed > 1) time_elapsed -= 1;
>>>>>>> origin/master
	}

	@Override
	public void render(SpriteBatch sb){
		sb.draw(texture,0,0);
	}
	
	
	
}
