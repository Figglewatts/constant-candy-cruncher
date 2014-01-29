package figglewatts.constantcandycruncher.projectile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseProjectile {
	private Vector2 velocity;
	private Vector2 acceleration;
	private Texture projectileTexture;
	public Vector2 getVelocity() {
		return velocity;
	}
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	public void setVelocity(float x, float y) {
		this.velocity = new Vector2(x, y);
	}
	public void setVelocityX(float x) {
		this.velocity.x = x;
	}
	public void setVelocityY(float y) {
		this.velocity.y = y;
	}
	public Vector2 getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}
	public void setAcceleration(float x, float y) {
		this.acceleration = new Vector2(x, y);
	}
	public void setAccelerationX(float x) {
		this.acceleration.x = x;
	}
	public void setAccelerationY(float y) {
		this.acceleration.y = y;
	}
	public Texture getProjectileTexture() {
		return projectileTexture;
	}
	public void setProjectileTexture(Texture projectileTexture) {
		this.projectileTexture = projectileTexture;
	}
}
