package elements;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameMap  {

	public OrthogonalTiledMapRenderer renderer;
	public TiledMap map;
	
	public GameMap(String file){
		map = new TmxMapLoader().load(file);
		renderer = new OrthogonalTiledMapRenderer(map);
		TiledMapTileSet tileset = map.getTileSets().getTileSet("2");
		for(TiledMapTile tile : tileset){

		}
		for(MapLayer m : map.getLayers()){
			for( MapObject o : m.getObjects()){
				
			}
		}
		
	}

	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	public void render(OrthographicCamera cam) {
		renderer.setView(cam);
		renderer.render();
	}


	public void dispose() {
		map.dispose();
		renderer.dispose();
	}

}
