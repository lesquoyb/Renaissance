package renaissance.desktop;

import renaissance.RenaissanceGame;
import renaissance.World;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Renaissance";
//		config.fullscreen = true;
		config.width = World.WIDTH;
		config.height = World.HEIGHT;
		new LwjglApplication(new RenaissanceGame(), config);
	}
}
