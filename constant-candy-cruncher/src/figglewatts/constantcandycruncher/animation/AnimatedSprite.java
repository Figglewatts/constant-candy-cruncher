package figglewatts.constantcandycruncher.animation;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class AnimatedSprite extends Sprite {
	private boolean animating;
	private Map<String, FrameAnimation> animations = new Hashtable<String, FrameAnimation>();
	private String currentAnimation;
	
	public boolean isAnimating() {
		return animating;
	}
	public void setAnimating(boolean animating) {
		this.animating = animating;
	}
	public String getCurrentAnimation() {
		return currentAnimation;
	}
	public void setCurrentAnimation(String currentAnimation) {
		this.currentAnimation = currentAnimation;
	}
	public FrameAnimation getCurrentFrameAnimation() {
		if (currentAnimation != null || currentAnimation != "") {
			return animations.get(currentAnimation);
		} else {
			return null;
		}
	}
	public FrameAnimation getAnimationByName(String name) {
		if (animations.get(name) != null) {
			return animations.get(name);
		} else {
			return null;
		}
	}
	
	public AnimatedSprite(Texture texture) {
		super(texture);
		this.animations = new Hashtable<String, FrameAnimation>();
		this.currentAnimation = null;
	}
	public AnimatedSprite(int x, int y, int w, int h, Texture texture) {
		super(texture);
		this.setPosition(x, y);
		this.animations = new Hashtable<String, FrameAnimation>();
		this.currentAnimation = null;
	}
	
	public void addAnimation(String name, Rectangle rect, int frames, float frameLength) {
		animations.put(name, new FrameAnimation(rect, frames, frameLength));
		this.setSize((int)rect.width, (int)rect.height);
		this.setOrigin(super.getWidth() / 2, super.getHeight() / 2);
	}
	public void addAnimation(String name, Rectangle rect, int frames, float frameLength, String nextAnimation) {
		animations.put(name, new FrameAnimation(rect, frames, frameLength, nextAnimation));
		this.setSize((int)rect.width, (int)rect.height);
		this.setOrigin(super.getWidth() / 2, super.getHeight() / 2);
	}
	
	public void update(double delta) {
		if (animating) {
			if (getCurrentAnimation() == null) {
				if (animations.size() > 0) {
					@SuppressWarnings("unused") // #yolo
					String[] keys = new String[animations.size()];
					Set<String> keysSet = new HashSet<String>(animations.keySet());
					keys = (String[])keysSet.toArray();
				} else {
					return;
				}
			}
			// run current animation's update method
			this.getCurrentFrameAnimation().update(delta);
			
			// check to see if there's a followup animation for this animation
			if (this.getCurrentFrameAnimation().getNextAnimation() != null) {
				// if there is, see if the currently playing animation has completed a full loop
				if (this.getCurrentFrameAnimation().getPlayCount() > 0) {
					// if it has, set up the next animation
					getCurrentFrameAnimation().setPlayCount(0);
					currentAnimation = this.getCurrentFrameAnimation().getNextAnimation();
				}
			}
		}
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		if (animating) {
			batch.draw(this.getTexture(), this.getX(), this.getY(),
			(int)this.getCurrentFrameAnimation().getFrameRectangle().width,
			(int)this.getCurrentFrameAnimation().getFrameRectangle().height,
			(int)this.getCurrentFrameAnimation().getFrameRectangle().x,
			(int)this.getCurrentFrameAnimation().getFrameRectangle().y,
			(int)this.getCurrentFrameAnimation().getFrameRectangle().width,
			(int)this.getCurrentFrameAnimation().getFrameRectangle().height,
			false, true);
		}
	}
}
