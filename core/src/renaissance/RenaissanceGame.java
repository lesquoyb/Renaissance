package renaissance;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;

public class RenaissanceGame extends Game {
	
	
	private boolean first = true;
	public static Controller controller;
	public static final int BUTTON_A = 0;
   public static final PovDirection BUTTON_DPAD_DOWN = PovDirection.south;
   public static final PovDirection BUTTON_DPAD_RIGHT = PovDirection.east;
   public static final PovDirection BUTTON_DPAD_LEFT = PovDirection.west;
	@Override
	public void create () {
		if(Controllers.getControllers().size > 0)
		controller = Controllers.getControllers().get(0);
		setScreen(new TitleScreen());
	}

	@Override
	public void render() {
		super.render();
		if(first){
			if(isOkPressed()){
				setScreen(new World());
				first = false;
			}			
		}

		
	}
	
	public static boolean isOkPressed(){
		if(controller != null){
			if(controller.getButton(BUTTON_A)){
				return true;
			}
		}
		return Gdx.input.isKeyPressed(Keys.SPACE) ;
	}
	
	public static boolean isDownPressed(){
		if(controller != null){
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
