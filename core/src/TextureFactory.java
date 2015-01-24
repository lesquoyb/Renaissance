import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class TextureFactory{

	private static HashMap<String, Texture> map = new HashMap<String, Texture>(); 
	
	private static Texture currentTexture = null;
	
	
	public Texture getTexture(String name){
		currentTexture = map.get(name);
		if(currentTexture == null){
			map.put(name, new Texture("images/" + name  + ".png"));
		}
		return currentTexture;
	
	}
	
}
