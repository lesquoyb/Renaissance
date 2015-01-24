package elements;

import com.badlogic.gdx.math.Vector2;

public class Guide extends Enemy {

	public Guide(String s, float x, float y) {
		super(s, x, y);

	}
	
	@Override
	public void update(){
		float x,y;
		float xCible=15,yCible=0;
		
		x = xCible - body.getPosition().x;

		xCible = body.getPosition().x;
		
		y = yCible - body.getPosition().y;

		yCible = body.getPosition().y;
		
		body.applyForce(new Vector2(x,y), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
		
	}
	
}
