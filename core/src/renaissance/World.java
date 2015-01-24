package renaissance;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;

import elements.Hero;

public class World implements Screen{
	
	public static com.badlogic.gdx.physics.box2d.World world;
	private SpriteBatch spriteBatch;
	private Hero hero;
//	private ArrayList<Enemy> enemies;
	private OrthographicCamera cam;

	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	
	@Override
	public void show() {
		Box2D.init();
		world = new com.badlogic.gdx.physics.box2d.World(new Vector2(0.f,-9.81f), true);
		spriteBatch = new SpriteBatch();
		hero = new Hero("pacman",0,0);
//		enemies = new ArrayList<Enemy>();
		cam = new OrthographicCamera();
		
//		maps.add(new GameMap("maps/map1.tmx"));
	//	maps.add(new GameMap("maps/test.tmx"));
		cam.setToOrtho(true, 500,500 );

		map = new TmxMapLoader().load("maps/test.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
	}

	@Override
	public void render(float delta) {
		
		world.step(12, 6, 2);
		spriteBatch.setProjectionMatrix(cam.projection);
		spriteBatch.begin();
			hero.render(spriteBatch);
			
	//		for (Enemy it : enemies) {
	//			it.render();
	//		}
				
		spriteBatch.end();
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		hero.dispose();
//		for(Enemy it : enemies){
//			it.dispose();
//		}
		
	}
}
