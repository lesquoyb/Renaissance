package renaissance;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class RenaissanceGame extends Game {
	
	
	private boolean first = true;
	@Override
	public void create () {
		setScreen(new TitleScreen());
	}

	@Override
	public void render() {
		super.render();
		if(first){
			if(Gdx.input.isKeyPressed(Keys.SPACE)){
				setScreen(new World());
				first = false;
			}			
		}

		
	}
	
	

}
