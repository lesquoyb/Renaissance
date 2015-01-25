package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class Cinematique implements Screen{

	
	private Music son = Gdx.audio.newMusic(Gdx.files.internal("sons/Bruitages/lettre.mp3"));
	private String texte;
	private int index;
	private float oldDelta;
	BitmapFont bmFont;
	private Label label;
	
	
	
	
    private SpriteBatch batch;
    private float height = 0;
    

	public Cinematique(String texte) {
		this.texte = texte;
		index = 0;
		bmFont = new BitmapFont(Gdx.files.internal("polices/adler.fnt"), false);
		
	}
	
	@Override
	public void show() {
		  
        batch = new SpriteBatch();    
        bmFont = new BitmapFont();
        bmFont.setColor(Color.WHITE);
        bmFont.setScale(2);
	}

	@Override
	public void render(float delta) {
		update(delta);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	       String sub = texte.substring(0, index);
	        batch.begin();
	        	bmFont.drawMultiLine(batch, sub, 10, Gdx.graphics.getHeight()/2+100 );
	        batch.end();
	}


	private void update(float delta){
		if(index < texte.length()){
			boolean ajouteLettre = false;
	
			if(delta >  Math.random()){
				ajouteLettre = true;
			}
			else{
				oldDelta += delta;
				if(oldDelta >  Math.random()){
					ajouteLettre = true;
					oldDelta=0;
				}
			}
			
			if(ajouteLettre){
				son.play();
				//si encore lettre affiche
				if (index  < texte.length()){				
					index ++;
				}
			}
		}
		
	}

	@Override
	public void dispose() {
		
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

	
	

	
	
	

}
