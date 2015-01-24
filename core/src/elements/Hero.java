package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector3;

public class Hero extends Personnages {

	public static final int velocity = 100;
	public static final float GRAVITE = 9.81f;
	public float x; 
	public float y;
	public Vector3 move;
	public Hero(String s, float x, float y) {
		super(s, x, y);
		move = new Vector3();
		this.x = x;
		this.y = y;


		
	}
	
	
	public void update(float delta)
	{
		y -= GRAVITE * delta;
		
		//check collisions
		TiledMapTileLayer layerSol =(TiledMapTileLayer) GameMap.map.getLayers().get("sol");
		float largeurTile = layerSol.getTileWidth();
		float hauteurTile = layerSol.getTileHeight();
		int caseX = (int)x/(int)largeurTile;
		int caseY = (int)y/(int)hauteurTile;
		int caseX2 = caseX+1;
		int caseY2;
		
		if(layerSol.getCell(caseX, caseY) != null || layerSol.getCell(caseX2, caseY) != null){
			y = (caseY+1)*hauteurTile;
		}
		
		if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			x -= velocity * delta;	
			//check collision 
			caseX = (int)x/(int)largeurTile;
			caseY = (int)y/(int)hauteurTile;
			if(layerSol.getCell(caseX, caseY) != null ){
				x = (caseX+1)*largeurTile;
			}
		}

		if(Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			x += velocity * delta;
			caseX = (int)x+texture.getWidth()/(int)largeurTile;
			caseY = (int)y/(int)hauteurTile;
			if(layerSol.getCell(caseX, caseY) != null ){
				x = (caseX-1)*largeurTile;
			}
		}
		
		if(Gdx.input.isKeyPressed(Keys.UP))
		{
			y += velocity * delta;
			caseX = (int)x/(int)largeurTile;
			caseX2 = caseX +1;
			caseY = (int)y+texture.getHeight()/(int)hauteurTile;
			if(layerSol.getCell(caseX, caseY) != null || layerSol.getCell(caseX2, caseY) != null ){
				y = (caseY-1)*hauteurTile;
			}
		}
		
		if(Gdx.input.isKeyPressed(Keys.DOWN))
		{
			y -= velocity * delta;
			caseX = (int)x/(int)largeurTile;
			caseX2 = caseX+1;
			caseY = (int)y/(int)hauteurTile;
			if(layerSol.getCell(caseX, caseY) != null || layerSol.getCell(caseX2, caseY) != null){
				y = (caseY+1)*hauteurTile;
			}
			
		}
		

		
		
	}

	@Override
	public void render(SpriteBatch sb){
		sb.draw(texture,0,0);
	}
	
	@Override
	public void update()
	{
		
		/*
		move = new Vector3(body.getPosition().x,body.getPosition().y,0);
		
		if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			body.applyForce(new Vector2(-10,0), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
			//body.setLinearVelocity(-10,0);
			
		}
		
		else if(Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			body.applyForce(new Vector2(10,0), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
			//body.setLinearVelocity(10,0);
		}
		
		else if(Gdx.input.isKeyPressed(Keys.UP))
		{
			body.applyForce(new Vector2(0,10), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
			//body.setLinearVelocity(0,10);
		}
		
		else if(Gdx.input.isKeyPressed(Keys.DOWN))
		{
			body.applyForce(new Vector2(0,-10), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
			//body.setLinearVelocity(0,-10);
		}
		*/
	}
}
