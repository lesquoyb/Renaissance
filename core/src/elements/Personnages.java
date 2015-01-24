package elements;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;


public abstract class Personnages extends ElementJeu {

	public Personnages(String s, float x, float y) {
		super(s, x, y);
		bodydef.type = BodyType.DynamicBody;
		//body = World.world.createBody(bodydef);
		body.createFixture(fixturedef);
	}

	
}
