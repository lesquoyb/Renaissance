package elements;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Guide extends Enemy {

	float var=50,xCible=var,yCible=var;
	public Vector2 translation = new Vector2();

	public Guide(String s, float x, float y) {
		super(s, x, y);

	}

	@Override
	public void update(float delta){
		y -= Hero.GRAVITE * delta;


		/*if(x > xCible)
		{
			xCible = -var;
			yCible = 0;
		}
		else{
			xCible = var;
			yCible = 0;
		}*/


		translation = new Vector2(xCible,yCible);
		float deltaX = translation.x  * delta * 2;
		x += deltaX;
		float deltaY  = translation.y * delta*2;
		y += deltaY;
		translation.sub(new Vector2(deltaX,deltaY));


		int caseX = (int)x/(int)GameMap.largeurTile;
		int caseX2 = caseX+1;
		int caseY = (int)y/(int)GameMap.hauteurTile;
		if(GameMap.layerSol.getCell(caseX, caseY) != null || GameMap.layerSol.getCell(caseX2, caseY) != null){
			y = (caseY+1)*GameMap.hauteurTile;
		}
	}

	@Override
	public void render(SpriteBatch sb){
		sb.draw(texture,x,y);
	}


}
