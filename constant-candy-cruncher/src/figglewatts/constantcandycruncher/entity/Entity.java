package figglewatts.constantcandycruncher.entity;

import java.util.UUID;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Entity {
	private Sprite sprite;
	private String name;
	private long id;
	public Sprite getSprite() {
		return sprite;
	}
	public void setSprite(Sprite sprite) {
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
	
	public Entity(Texture texture, String name) {
		this.sprite = new Sprite(texture);
		this.name = name;
		this.generateID();
	}
}
