package renaissance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;

import elements.GameMap;
import elements.Hero;
import elements.Obstacle;

public class World implements Screen{
	
	public static com.badlogic.gdx.physics.box2d.World world;
	public static SpriteBatch spriteBatch;
	private Hero hero;
//	private ArrayList<Enemy> enemies;
	private OrthographicCamera cam;
	public static GameMap map;
	private Obstacle o;

	
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
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		map = new GameMap("maps/map1.tmx");
		o = new Obstacle("obstacle", 0, -100,100,500);
	}

	@Override
	public void render(float delta) {
		
		update(delta);
		
		//world.step(12, 6, 2);
		
		//map.unproject(cam);
		
		
		
<<<<<<< HEAD
=======
		world.step(12, 6, 2);
//		cam.position.x = hero.body.getPosition().x;		
//		cam.update();
//		cam.position.set(hero.bodydef.position.x/2.f, hero.bodydef.position.y/2.f, 0);
//		cam.position.set(hero.body.getPosition().x /2.f, hero.body.getPosition().y / 2.f, 0);
//		cam.lookAt(hero.body.getPosition().x, hero.body.getPosition().y, 0);
//		cam.update();
	    
		
>>>>>>> origin/master
		map.render(cam);
		spriteBatch.setProjectionMatrix(cam.projection);
		spriteBatch.begin();
			hero.render(spriteBatch);
			o.render(spriteBatch);
	//		for (Enemy it : enemies) {
	//			it.render();
	//		}
				
		spriteBatch.end();
		

		cam.position.set(hero.x ,hero.y,0);
		cam.update();
	}

	
	
	public void update(float delta){
		o.update();
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
		world.dispose();
		spriteBatch.dispose();
//		for(Enemy it : enemies){
//			it.dispose();
//		}
		
	}
}
