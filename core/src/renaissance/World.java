package renaissance;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;

import elements.Hero;

public class World implements Screen{
	private com.badlogic.gdx.physics.box2d.World world;
	private SpriteBatch spriteBatch;
	private ArrayList<GameMap> maps;
	private Hero hero;
//	private ArrayList<Enemy> enemies;
	private OrthographicCamera cam;
	
	@Override
	public void show() {
		Box2D.init();
		world = new com.badlogic.gdx.physics.box2d.World(new Vector2(0.f,9.81f), true);
		spriteBatch = new SpriteBatch();
		maps = new ArrayList<GameMap>();
//		hero = new Hero();
//		enemies = new ArrayList<Enemy>();
		cam = new OrthographicCamera();
		
//		maps.add(new GameMap("maps/map1.tmx"));
		maps.add(new GameMap("maps/test.tmx"));
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		spriteBatch.begin();
		for (GameMap it : maps) {
			it.render();
		}
//		hero.render(spriteBatch);
//		for (Enemy it : enemies) {
//			it.render();
//		}
		

		
		
		
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		for (GameMap it : maps){
			it.dispose();
		}
//		hero.dispose();
//		for(Enemy it : enemies){
//			it.dispose();
//		}
	}
}
