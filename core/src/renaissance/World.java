package renaissance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import elements.GameMap;
import elements.Guide;
import elements.Hero;

public class World implements Screen{

	public static final int HEIGHT = 600;//1440; 
	public static final int WIDTH = 800;//4480;
	public static SpriteBatch spriteBatch;
	public static Hero hero;
	private static Texture jump = null;
	//	private ArrayList<Enemy> enemies;
	public static OrthographicCamera cam = new OrthographicCamera();
	public static GameMap map;
	public static int compteurScenes = 0;
	public static final int nbScenes = 3;
	public static final String scenes[] = {"maps/map2r.tmx","maps/map3r.tmx","maps/map5.tmx"};
	//TODO transition map4
	
	@Override
	public void show() {
		spriteBatch = new SpriteBatch();

		hero = new Hero("heros-sprite-spawn",100,150);

//		enemies = new ArrayList<Enemy>();
		int ratio = Math.min(Gdx.graphics.getWidth()/World.WIDTH, Gdx.graphics.getHeight()/World.HEIGHT);
		cam.setToOrtho(false, WIDTH*ratio, HEIGHT*ratio);
		cam.zoom = 1.8f;
		map = new GameMap("maps/map1r.tmx");

	}

	@Override
	public void render(float delta) {

		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		



		map.render(cam);
//		spriteBatch.setProjectionMatrix(cam.projection.setToTranslation(0, -cam.viewportWidth/2 + 64, 0));
		spriteBatch.setProjectionMatrix(cam.projection);
		
		spriteBatch.begin();
			hero.render(spriteBatch);
		//		for (Enemy it : enemies) {
		//			it.render();
		//		}

		spriteBatch.end();


		cam.position.set(hero.x ,hero.y,0);
//		cam.translate(new Vector2(0,Gdx.graphics.getHeight()/2-64));

		
		cam.update();
		
		if(compteurScenes==3){
			hero.cinematique = true;
			while(hero.x < WIDTH)
			{
			hero.x += 10; 
			}
		
		}
	}

	


	public void update(float delta){
		if(hero.cinematique == false)
		{
			hero.update(delta);
		}
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
