package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hero extends Personnages {

	public static final int velocity = 180;
	public static final float GRAVITE = 9.801f;
	public Vector2 jump = new Vector2();
	private static final Vector2 jumpUp = new Vector2(0,256);
	private boolean jumping = false;
	
	
	public Hero(String s, float x, float y) {
		super(s, x, y);		
	}
	
	@Override
	public void update(float delta)
	{
		
		int caseX;
		int caseY;
		int caseX2;
		int caseY2;

		if ( jump.y > 0){
			float deltaY  = jumpUp.y * delta*2;
			y += deltaY;
			jump.sub(new Vector2(0,deltaY));		
		}
		
		if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			x -= velocity * delta;	
		}
		caseX = (int)x/(int)GameMap.largeurTile;
		caseY = (int)y/(int)GameMap.hauteurTile;
		if(GameMap.layerSol.getCell(caseX, caseY) != null ){
			x = (caseX+1)*GameMap.largeurTile ;
		}
				
		if(Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			x += velocity * delta;
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
		y -= GRAVITE * delta*2;
		
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
		
		

		
	}

	@Override
	public void render(SpriteBatch sb){
		sb.draw(texture,0,0);
	}
	
	
	
}
