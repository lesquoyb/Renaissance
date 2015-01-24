package renaissance;

import com.badlogic.gdx.Game;

public class RenaissanceGame extends Game {
	
	@Override
	public void create () {
		setScreen(new World());
	}

}
