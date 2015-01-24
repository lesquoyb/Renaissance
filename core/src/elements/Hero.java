package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.physics.box2d.World;  
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hero extends Personnages {


	public Hero(String s, float x, float y) {
		super(s, x, y);
		
	}

	void Maj()
	{
		if(Gdx.input.isKeyPressed(Keys.LEFT))
		{
			body.setLinearVelocity(-10,0);
		}
		
		if(Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			body.setLinearVelocity(10,0);
		}
		
		if(Gdx.input.isKeyPressed(Keys.UP))
		{
			body.setLinearVelocity(0,10);
		}
		
		if(Gdx.input.isKeyPressed(Keys.DOWN))
		{
			body.setLinearVelocity(0,-10);
		}
	}
}
