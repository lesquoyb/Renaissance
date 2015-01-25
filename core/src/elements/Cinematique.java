package elements;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;

public class Cinematique implements Screen{

	

	private ArrayList<String> phrases;
	private Music son = Gdx.audio.newMusic(Gdx.files.internal("sons/Bruitages/lettre.mp3"));
	private float delay = 1/4;
	// temps repos entre phrases
	private float oldDelta;
	
	public Cinematique(String texte) {
		phrases = new ArrayList<String>();
		String[] lol = texte.split(".");
		for(String phrase : lol){
			phrases.add(phrase);
		}
	}
	
	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		update(delta);
		
	}


	private void update(float delta){
		
		boolean ajouteLettre = false;
		if(delta > (1/4)){
			ajouteLettre = true;
		}
		else{
			oldDelta += delta;
			if(oldDelta >(1/4)){
				ajouteLettre = true;
			}
		}
		
		if(ajouteLettre){
			son.play();
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
