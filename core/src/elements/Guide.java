package elements;


public class Guide extends Enemy {

	float var=150,xCible=var,yCible=var;
	
	public Guide(String s, float x, float y) {
		super(s, x, y);

	}
	
	@Override
	public void update(){
		//float x,y;
		

	if(x > xCible)
	{
		xCible = -var;
		yCible = -var;
	}
	else{
		xCible = var;
		yCible = var;
	}
	
		
		
		//x = xCible - body.getPosition().x;
		
		//y = yCible - body.getPosition().y;
		
		//body.applyForce(new Vector2(xCible,yCible), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
		//TODO
	
		
		//xCible = body.getPosition().x;
		
		//yCible = body.getPosition().y;
		
		
		//body.applyForceToCenter(x, y, true);//.applyForce(new Vector2(x,y), new Vector2(body.getPosition().x-texture.getWidth(),body.getPosition().y-texture.getHeight()), true);
		
	}
	
}
