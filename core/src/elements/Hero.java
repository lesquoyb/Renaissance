package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;  
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hero extends Personnages {


	public Hero(String s, float x, float y) {
		super(s, x, y);
		
	}

	void update()
	{
		if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			body.applyForce(new Vector2(-10,0), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
			//body.setLinearVelocity(-10,0);
		}
		
		if(Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			body.applyForce(new Vector2(10,0), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
			//body.setLinearVelocity(10,0);
		}
		
		if(Gdx.input.isKeyPressed(Keys.UP))
		{
			body.applyForce(new Vector2(0,10), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
			//body.setLinearVelocity(0,10);
		}
		
		if(Gdx.input.isKeyPressed(Keys.DOWN))
		{
			body.applyForce(new Vector2(0,-10), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
			//body.setLinearVelocity(0,-10);
		}
	}
}
