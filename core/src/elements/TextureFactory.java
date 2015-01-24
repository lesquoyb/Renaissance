package elements;
import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;


public class TextureFactory{

	private static HashMap<String, Texture> map = new HashMap<String, Texture>(); 
	
	private static Texture currentTexture = null;
	
	
	public static Texture getTexture(String name){
		currentTexture = map.get(name);
		if(currentTexture == null){
			map.put(name, new Texture("images/" + name  + ".png"));
			currentTexture = map.get(name);
		}
		return currentTexture;
	
	}
	
}
