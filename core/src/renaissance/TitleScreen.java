package renaissance;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleScreen implements Screen {


	SpriteBatch sb;
	public static Texture text;
	public Game game;
	private BitmapFont bmFont;
	public static String alerte;
	public static int width = Gdx.graphics.getWidth()/2 -140;
	public static int height = Gdx.graphics.getHeight()/2-50;

	@Override
	public void show() {
		sb = new SpriteBatch();
		text = new Texture("images/normal_button.bmp");
		bmFont = new BitmapFont();
		bmFont.setColor(Color.BLACK);
		bmFont.setScale(2);
		alerte = "N'appuyez SURTOUT PAS sur le bouton !!!";
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch sp = new SpriteBatch();
		sp.begin();
		sp.draw(text,width , height);
		bmFont.drawMultiLine(sp, alerte , 100, 100);
		sp.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		sb.dispose();
		text.dispose();
		bmFont.dispose();
		game.dispose();

	}



}
