package elements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Obstacle extends Objets{

	
	
	public Obstacle(String s, float x, float y) {
		super(s, x, y);
		franchissable = false;
	}
	
	
	@Override
	public void render(SpriteBatch s) {
		super.render(s);
	}



	@Override
	public void update() { /* do nothing */	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

}
