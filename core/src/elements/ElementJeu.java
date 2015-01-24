package elements;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


abstract class ElementJeu  {  

	protected Texture texture;
	public final float largeur;
	public final float hauteur;
	public float x;
	public float y;
	/*
	public Body body; 
	public FixtureDef fixturedef;
	public BodyDef bodydef;
	*/
	
	public ElementJeu(String s, float x, float y)
	{
		
		texture = TextureFactory.getTexture(s);
		this.x = x;
		this.y = y;
		largeur = texture.getWidth();
		hauteur = texture.getHeight();
		/*
		bodydef = new BodyDef();
		bodydef.position.x = x;
		bodydef.position.y = y ;
		fixturedef = new FixtureDef();
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(texture.getWidth()/2, texture.getHeight()/2);
		fixturedef.shape = shape;
		*/
	}

	public void render(SpriteBatch s)
	{
	//	s.draw(texture,body.getPosition().x  - texture.getWidth()/2,body.getPosition().y - texture.getHeight()/2);
	}
	
	public abstract void update(float delta);
	
	public void dispose(){
		texture.dispose();
	}
	
	
	
}
