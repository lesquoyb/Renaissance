package elements;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


abstract class ElementJeu  {  

	protected Texture texture;
	public final float largeur;
	public final float hauteur;
	public float x;
	public float y;
	
	public ElementJeu(String s, float x, float y)
	{
		
		texture = TextureFactory.getTexture(s);
		this.x = x;
		this.y = y;
		largeur = texture.getWidth();
		hauteur = texture.getHeight();
	}

	public void render(SpriteBatch s)
	{
		s.draw(texture,0,0);
	}
	
	public abstract void update(float delta);
	
	public void dispose(){
		texture.dispose();
	}
	
	
	
}
