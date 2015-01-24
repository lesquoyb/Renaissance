package renaissance;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameMap{
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	
	
	public GameMap(String name) {
		map = new TmxMapLoader().load(name);
		renderer = new OrthogonalTiledMapRenderer(map);
	}
	
	public void update(){
		//TODO
	}
	
	public void render(){
		renderer.render();
	}
	
	public void dispose(){
		map.dispose();
		renderer.dispose();
	}
	
	

}
