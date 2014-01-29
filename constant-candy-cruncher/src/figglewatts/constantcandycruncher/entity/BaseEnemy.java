package figglewatts.constantcandycruncher.entity;

import com.badlogic.gdx.graphics.Texture;

public abstract class BaseEnemy extends Entity {
	
	private int health;
	private float moveSpeed;
	protected abstract void moveFunction();
	
	
	public BaseEnemy(Texture texture, String name) {
		super(texture, name);
		// TODO Auto-generated constructor stub
	}

}
