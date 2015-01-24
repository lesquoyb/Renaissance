package renaissance;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World implements Screen{
	private SpriteBatch spriteBatch;
	private ArrayList<GameMap> maps;
//	private Hero hero;
//	private ArrayList<Enemy> enemies;
	private OrthographicCamera cam;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		spriteBatch = new SpriteBatch();
		maps = new ArrayList<GameMap>();
//		hero = new Hero();
//		enemies = new ArrayList<Enemy>();
		cam = new OrthographicCamera();
		
		maps.add(new GameMap("maps/map1.tmx"));
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		spriteBatch.begin();
		for (GameMap it : maps) {
			it.render();
		}
//		hero.render();
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
