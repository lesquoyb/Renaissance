package elements;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;


abstract class ElementJeu  {  

	protected Texture texture;
	protected Body body; 
	protected FixtureDef fixturedef;
	protected BodyDef bodydef;

	
	public ElementJeu(String s, float x, float y)
	{
		
		texture = TextureFactory.getTexture(s);
		bodydef = new BodyDef();
		bodydef.position.x = x;
		bodydef.position.y = y;
		fixturedef = new FixtureDef();
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(texture.getWidth()/2, texture.getHeight()/2);
		fixturedef.shape = shape;
	}

	public void render(SpriteBatch s)
	{
		s.draw(texture,body.getPosition().x,body.getPosition().y);
	}
	
	public abstract void update();
	
	public void dispose(){
		texture.dispose();
	}
	
	
	
}
