package renaissance;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.graphics.Texture;

import elements.Cinematique;

public class RenaissanceGame extends Game {


	private boolean first = true;
	private boolean second = false;
	private boolean third = false;
	private Music explosion;
	public static Controller controller;
	public static final int BUTTON_A = 0;
	public static final PovDirection BUTTON_DPAD_DOWN = PovDirection.south;
	public static final PovDirection BUTTON_DPAD_RIGHT = PovDirection.east;
	public static final PovDirection BUTTON_DPAD_LEFT = PovDirection.west;
	
	
	@Override
	public void create () {
		explosion =  Gdx.audio.newMusic(Gdx.files.internal("sons/Bruitages/explosion1_0.mp3"));
		if(Controllers.getControllers().size > 0)
			controller = Controllers.getControllers().get(0);
		setScreen(new TitleScreen());
	}

	@Override
	public void render() {
		super.render();
		if(first){
			if(isOkPressed()){
				TitleScreen.text = new Texture(Gdx.files.internal("images/pressed_button.png"));
				TitleScreen.width -= 250;
				explosion.play();
				TitleScreen.alerte = "               Mécréant tu vas maintenant \n     affronter les conséquences de tes actes !";
				second = true;
				third = false;	
				first = false;
			}	
		}
		else if (second){
			if(isOkPressed()){
				setScreen(new Cinematique(Gdx.files.internal("textes/intro.txt").readString("utf-8")));
				second = false;
				third = true;
			}
		}
		else if(third){
			if(isOkPressed()){
				setScreen(new World());
				third = false;
			}
		}
			
	}

	public static boolean isOkPressed(){
		if(controller != null){
			if(controller.getButton(BUTTON_A)){
				return true;
			}
		}
		return Gdx.input.isKeyJustPressed(Keys.SPACE) ;
	}

	public static boolean isDownPressed(){
		if(controller != null){
			//if(controller.getAxis())
			if(controller.getButton(BUTTON_DPAD_DOWN.ordinal())){
				return true;
			}
		}
		return Gdx.input.isKeyPressed(Keys.DOWN) ;
	}


	public static boolean isLeftPressed(){
		if(controller != null){
			if(controller.getButton(BUTTON_DPAD_LEFT.ordinal())){
				return true;
			}
		}
		return Gdx.input.isKeyPressed(Keys.LEFT) ;
	}


	public static boolean isRightPressed(){
		if(controller != null){
			if(controller.getButton(BUTTON_DPAD_RIGHT.ordinal())){
				return true;
			}
		}
		return Gdx.input.isKeyPressed(Keys.RIGHT) ;
	}


}
