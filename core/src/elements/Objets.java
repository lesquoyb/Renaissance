package elements;

import renaissance.World;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public abstract class Objets extends ElementJeu {

	protected boolean franchissable;
	
	public Objets(String s, float x, float y) {
		super(s, x, y);
		bodydef.type = BodyType.StaticBody;
		body = World.world.createBody(bodydef);
		body.createFixture(fixturedef);
	}

}