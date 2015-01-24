package elements;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;

public class GameMap  {

	public OrthogonalTiledMapRenderer renderer;
	public static TiledMap map;
	public static ArrayList<Body> obstacles;
	public static TiledMapTileLayer layerSol;
	public static float largeurTile;
	public static float hauteurTile ;
	public static Guide g1;

	
	public GameMap(String file){
		obstacles = new ArrayList<Body>();
		map = new TmxMapLoader().load(file);
		renderer = new OrthogonalTiledMapRenderer(map);
		layerSol =(TiledMapTileLayer) GameMap.map.getLayers().get("sol");
		largeurTile = layerSol.getTileWidth();
		hauteurTile = layerSol.getTileHeight();
		g1 = new Guide("pacman",-120,100);
		
	}

	
	public void render(OrthographicCamera cam) {
		renderer.setView(cam);
		renderer.render();
	}
	
	public void renderContent(SpriteBatch batch){
		g1.render(batch);
	}
	
	
	
	public void update(float delta){
		g1.update(delta);
	}


	public void dispose() {
		map.dispose();
		renderer.dispose();
		g1.dispose();
	}

}
