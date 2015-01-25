package renaissance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import elements.GameMap;
import elements.Hero;

public class World implements Screen{

	public static SpriteBatch spriteBatch;
	private Hero hero;
	//	private ArrayList<Enemy> enemies;
	private OrthographicCamera cam;
	public static GameMap map;


	@Override
	public void show() {
		spriteBatch = new SpriteBatch();
		hero = new Hero("pacman",0,0);
		//		enemies = new ArrayList<Enemy>();
		cam = new OrthographicCamera();

		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		map = new GameMap("maps/map1.tmx");
	}

	@Override
	public void render(float delta) {

		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



		map.render(cam);
		spriteBatch.setProjectionMatrix(cam.projection);
		spriteBatch.begin();
		hero.render(spriteBatch);
		//		for (Enemy it : enemies) {
		//			it.render();
		//		}

		spriteBatch.end();


		cam.position.set(hero.x ,hero.y,0);
		cam.update();
	}



	public void update(float delta){
		hero.update(delta);
		//for (Enemy it : enemies) {
		//			it.update();
		//		}
	}


	@Override
	public void resize(int width, int height) {
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
		cam.viewportHeight = height;
		cam.viewportWidth = width;
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
		map.dispose();
		spriteBatch.dispose();
		//		for(Enemy it : enemies){
		//			it.dispose();
		//		}

	}
}
