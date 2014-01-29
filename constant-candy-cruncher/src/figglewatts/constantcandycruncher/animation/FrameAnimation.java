package figglewatts.constantcandycruncher.animation;

import com.badlogic.gdx.math.Rectangle;

public class FrameAnimation implements Cloneable {
	private Rectangle initialFrame;
	private int frameCount;
	private int currentFrame;
	private float frameLength;
	private float frameTimer;
	private int playCount = 0;
	private String nextAnimation;
	public Rectangle getInitialFrame() {
		return initialFrame;
	}
	public void setInitialFrame(Rectangle initialFrame) {
		this.initialFrame = initialFrame;
	}
	public int getFrameCount() {
		return frameCount;
	}
	public void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}
	public int getCurrentFrame() {
		return currentFrame;
	}
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	public float getFrameLength() {
		return frameLength;
	}
	public void setFrameLength(float frameLength) {
		this.frameLength = frameLength;
	}
	public float getFrameTimer() {
		return frameTimer;
	}
	public void setFrameTimer(float frameTimer) {
		this.frameTimer = frameTimer;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	public String getNextAnimation() {
		return nextAnimation;
	}
	public void setNextAnimation(String nextAnimation) {
		this.nextAnimation = nextAnimation;
	}
	public float getFrameWidth() {
		return this.initialFrame.width;
	}
	public float getFrameHeight() {
		return this.initialFrame.height;
	}
	public Rectangle getFrameRectangle() {
		return new Rectangle(this.initialFrame.x + (initialFrame.width * currentFrame), 
				this.initialFrame.y, initialFrame.width, initialFrame.height);
	}
	
	public FrameAnimation(Rectangle firstFrame, int frames) {
		this(firstFrame, frames, 200);
	}
	public FrameAnimation(Rectangle firstFrame, int frames, float frameLength) {
		this(firstFrame, frames, frameLength, null);
	}
	public FrameAnimation(Rectangle firstFrame, int frames, float frameLength, String nextAnimation) {
		this.initialFrame = firstFrame;
		this.frameCount = frames;
		this.frameLength = frameLength;
		this.nextAnimation = nextAnimation;
	}
	
	public void update(double delta) {
		this.frameTimer += delta;
		
		if (this.frameTimer > this.frameLength) {
			this.frameTimer = 0F;
			this.currentFrame = (this.currentFrame + 1) % this.frameCount;
			if (this.currentFrame == 0) {
				this.playCount = Math.min(this.playCount + 1, Integer.MAX_VALUE);
			}
		}
	}
	
	@Override
	public Object clone() {
		return new FrameAnimation(this.initialFrame, this.frameCount, this.frameLength, this.nextAnimation);
	}
}
