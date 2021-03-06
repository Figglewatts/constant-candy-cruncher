package figglewatts.constantcandycruncher.entity;

import java.util.UUID;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import figglewatts.constantcandycruncher.animation.AnimatedSprite;

public abstract class Entity {
	private AnimatedSprite sprite;
	private String name;
	private long id;
	public Sprite getSprite() {
		return sprite;
	}
	public void setSprite(AnimatedSprite sprite) {
		this.sprite = sprite;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	private void generateID() {
		this.id = UUID.randomUUID().getMostSignificantBits();
	}
	
	public void update(double delta) {
	}
	
	public void draw(SpriteBatch batch) {
		this.sprite.draw(batch);
	}
	
	public Entity(Texture texture, String name) {
		this.sprite = new AnimatedSprite(texture);
		this.sprite.flip(false, true);
		this.name = name;
		this.generateID();
	}
}
