package elements;

import java.util.ArrayList;

import renaissance.World;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class GameMap  {

	public OrthogonalTiledMapRenderer renderer;
	public TiledMap map;
	private Box2DDebugRenderer rendererD;
	public ArrayList<Body> obstacles;
	
	public GameMap(String file){
		rendererD = new Box2DDebugRenderer();
		obstacles = new ArrayList<Body>();
		map = new TmxMapLoader().load(file);
		renderer = new OrthogonalTiledMapRenderer(map);
		TiledMapTileLayer collisionLayer = (TiledMapTileLayer)map.getLayers().get("sol");
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
	            	body.createFixture(fDef);
	            	obstacles.add(body);
	            }
	        }
		}
		
	}

	
	public void update() {
		
	}

	
	public void render(OrthographicCamera cam) {
		renderer.setView(cam);
		renderer.render();
		rendererD.render(World.world, cam.projection);
		
		World.spriteBatch.begin();
		World.spriteBatch.end();
	}


	public void dispose() {
		map.dispose();
		renderer.dispose();
	}

}
