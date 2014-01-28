package figglewatts.constantcandycruncher.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Entity {
	// THESE STATS ARE UNMODIFYABLE WITH UPGRADES
	// THEY ARE CHANGED BY THE GAME
	private int health = 100;
	private int lives = 3;
	
	// THESE STATS ARE MODIFYABLE WITH UPGRADES
	private int maxHealth = 100;
	private float moveSpeed = 2.4f;
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}

	public Player() {
		super(new Texture(Gdx.files.internal("data/playerTexture.png")), "Player");
		this.health = maxHealth;
	}
	
	@Override
	public void update(double delta) {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			this.getSprite().translateX(-moveSpeed);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			this.getSprite().translateX(moveSpeed);
		}
	}
}
