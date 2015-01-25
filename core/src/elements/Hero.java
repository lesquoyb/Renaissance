package elements;

import renaissance.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hero extends Personnages {

	public static final int velocity = 400;
	public static final float GRAVITE = 5.801f;
	public float jump_val = 0;
	private static final  float jump_max = 50;
	private boolean jumping = false;
	static float time_elapsed = 0;
	public static  Music saut =Gdx.audio.newMusic(Gdx.files.internal("sons/Bruitages/Jump.ogg"));
	public static  Music pas1 = Gdx.audio.newMusic(Gdx.files.internal("sons/Bruitages/stepwood_1.wav"));
	public static  Music pas2 = Gdx.audio.newMusic(Gdx.files.internal("sons/Bruitages/stepwood_2.wav"));
	public boolean play_pas1 = true;
	public static  Music BGS_sewer = Gdx.audio.newMusic(Gdx.files.internal("sons/BGS/Drips.ogg"));
	public static  Music BGS_out = Gdx.audio.newMusic(Gdx.files.internal("sons/BGS/Wind.ogg"));
	public static  Music BGM_sewer = Gdx.audio.newMusic(Gdx.files.internal("sons/BGM/Sewer.mp3"));
	static final float step_cooldown = 0.5f;
	float time_between_step = 0;

	
	public void print(String s) {
		if (time_elapsed > 1) {
			System.out.println(s);
		}
	}
	
	public Hero(String s, float x, float y) {
		super(s, x, y);	
		 pas1.setLooping(false);
		 pas2.setLooping(false);
		 saut.setLooping(false);
		 BGS_sewer.setLooping(true);
		 BGS_sewer.setPan(0, .1f);
		 BGS_out.setLooping(true);
		 BGS_out.setPan(0, .1f);
		 BGS_sewer.play();
		 BGM_sewer.play();

	}
	
	
	public void update(float delta) {
		
		float new_x = x;
		float new_y = y;


		if(Gdx.input.isKeyPressed(Keys.LEFT)) { new_x -= velocity * delta; }
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) { new_x += velocity * delta; }
		if(Gdx.input.isKeyPressed(Keys.DOWN)) { new_y -= velocity * delta; }
		
		if(Gdx.input.isKeyJustPressed(Keys.SPACE) && !jumping) {
			jumping = true;
			saut.play();
			jump_val = jump_max;
		}
		
		if ( jumping ) {
			if (jump_val > -jump_max) {
				jump_val -= GRAVITE * delta * GameMap.hauteurTile;
			} else {
				jump_val = 0;
				jumping = false;
			}
		}
		new_y -= GRAVITE * delta * GameMap.hauteurTile;
		new_y += jump_val;
		
		int newcase_x = (int)new_x / (int)GameMap.largeurTile; 
		int newcase_y = (int)new_y / (int)GameMap.hauteurTile; 
		int pcase_x = (int)x / (int)GameMap.largeurTile; 
		int pcase_y = (int)y / (int)GameMap.hauteurTile; 
		int newcase_x2 = (int)(new_x + (int)GameMap.largeurTile -1) / (int)GameMap.largeurTile; 
		int newcase_y2 = (int)(new_y + (int)GameMap.hauteurTile -1) / (int)GameMap.hauteurTile; 
		int pcase_x2 = (int)(x + (int)GameMap.largeurTile - 1) / (int)GameMap.largeurTile; 

		if(World.compteurScenes != World.nbScenes){
			if ((GameMap.layerSol.getCell(newcase_x, pcase_y) == null) && (GameMap.layerSol.getCell(newcase_x2, pcase_y) == null)) {
				if ((jumping == false) && (new_x != x)) {
					if (time_between_step == 0) {
						if (play_pas1) pas1.play();
						else pas2.play();
						time_between_step = step_cooldown;
						play_pas1 = !play_pas1;
					}
				}
				x = new_x;
			}
			if ((GameMap.layerSol.getCell(pcase_x, newcase_y) == null) && (GameMap.layerSol.getCell(pcase_x2, newcase_y) == null) && (GameMap.layerSol.getCell(pcase_x, newcase_y2) == null) && (GameMap.layerSol.getCell(pcase_x2, newcase_y2) == null)) {
				y = new_y;
			}	
			if ((GameMap.layerNext.getCell(newcase_x, pcase_y) != null) && (GameMap.layerNext.getCell(newcase_x2, pcase_y) != null)
					&&	(GameMap.layerNext.getCell(pcase_x, newcase_y) != null) && (GameMap.layerNext.getCell(pcase_x2, newcase_y) != null) 
					&&  (GameMap.layerNext.getCell(pcase_x, newcase_y2) != null) && (GameMap.layerNext.getCell(pcase_x2, newcase_y2) != null)) {
					
					System.out.println("collision");
					if(World.compteurScenes <= World.compteurScenes){
						System.out.println("qlmsdkjfq mlsj");
						World.map = new GameMap(World.scenes[World.compteurScenes]);
						World.compteurScenes++;
					}else{
						//TODO screen victoire.
					}
					x = 100;
					y = 400;
					jump_val = 0f;
				}
				
		}

		
		
		time_between_step -= delta;
		if (time_between_step < 0) time_between_step = 0;
	
	}

	@Override
	public void dispose() {
		super.dispose();
		saut.dispose();
		pas1.dispose();
		pas2.dispose();
	}

	@Override
	public void render(SpriteBatch sb){
		sb.draw(texture,0,0);
	}
	
	
	
}
