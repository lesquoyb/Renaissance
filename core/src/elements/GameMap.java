package elements;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
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
	public OrthographicCamera cam;
	
	public GameMap(String file){
		obstacles = new ArrayList<Body>();
		map = new TmxMapLoader().load(file);
		renderer = new OrthogonalTiledMapRenderer(map,1/32f);
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 50, 30);
		layerSol =(TiledMapTileLayer) GameMap.map.getLayers().get("sol");
		largeurTile = layerSol.getTileWidth();
		hauteurTile = layerSol.getTileHeight();
		
		/*
        float largeur = collisionLayer.getTileHeight();
        float hauteur = collisionLayer.getTileWidth();
		for (int x = 0; x < collisionLayer.getWidth(); x++) {
	        for (int y = 0; y < collisionLayer.getHeight(); y++) {
	            Cell cell = collisionLayer.getCell(x, y);
	            if (cell != null){
	            	PolygonShape shape = new PolygonShape();
	            	shape.setAsBox(largeur, hauteur);
	            	FixtureDef fDef = new FixtureDef();
	            	fDef.shape = shape;
	            	BodyDef bDef = new BodyDef();
	            	bDef.type = BodyType.StaticBody;
	            	bDef.position.x = x*largeur;
	            	bDef.position.y = y*hauteur;
	            	Body body = World.world.createBody(bDef);
	            	//body.createFixture(fDef);
	            	//obstacles.add(body);
	            }
	        }
		}
		*/
		
	}

	
	public void render() {
		cam.update();
		renderer.setView(cam);
		renderer.render();
	
	}


	public void dispose() {
		map.dispose();
		renderer.dispose();
	}

}
