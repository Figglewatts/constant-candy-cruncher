package figglewatts.constantcandycruncher.effect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import figglewatts.constantcandycruncher.screen.GameScreen;

public class Background {
	private Texture backgroundTexture;
	private Texture[] parallaxTextures = new Texture[4];
	private float backgroundOffset;
	private float parallaxOffset;
	public float getBackgroundOffset() {
		return backgroundOffset;
	}
	public void setBackgroundOffset(float backgroundOffset) {
		this.backgroundOffset = backgroundOffset;
		if (backgroundOffset < 0) {
			backgroundOffset += backgroundTexture.getWidth();
		}
		if (backgroundOffset > backgroundTexture.getWidth()) {
			backgroundOffset -= backgroundTexture.getWidth();
		}
	}
	public void modifyBackgroundOffset(float amount) {
		this.setBackgroundOffset(this.getBackgroundOffset() + amount);
	}
	public float getParallaxOffset() {
		return parallaxOffset;
	}
	public void setParallaxOffset(float parallaxOffset, int index) {
		this.parallaxOffset = parallaxOffset;
		if (parallaxOffset < 0) {
			parallaxOffset += parallaxTextures[index].getWidth();
		} 
		if (parallaxOffset > parallaxTextures[index].getWidth()) {
			parallaxOffset -= parallaxTextures[index].getWidth();
		}
	}
	public void modifyParallaxOffset(float amount, int index) {
		this.setParallaxOffset(this.getParallaxOffset() + amount, index);
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(backgroundTexture, -1 * backgroundOffset, 0);
		if (backgroundOffset > backgroundTexture.getWidth() - GameScreen.viewportWidth) {
			batch.draw(backgroundTexture, (-1 * backgroundOffset) + backgroundTexture.getWidth(), 0);
		}
		if (backgroundOffset < backgroundTexture.getWidth() - GameScreen.viewportWidth) {
			batch.draw(backgroundTexture, (-1 * backgroundOffset) - backgroundTexture.getWidth(), 0);
		}
		
		for (int i = 1; i < parallaxTextures.length+1; i++) {
			batch.draw(parallaxTextures[i-1], -1 * parallaxOffset * i, 0);
			if (parallaxOffset > parallaxTextures[i-1].getWidth() - GameScreen.viewportWidth) {
				batch.draw(parallaxTextures[i-1], (-1 * parallaxOffset * i) + parallaxTextures[i-1].getWidth(), 0);
			}
			if (parallaxOffset < parallaxTextures[i-1].getWidth() - GameScreen.viewportWidth) {
				batch.draw(parallaxTextures[i-1], (-1 * parallaxOffset * i) - parallaxTextures[i-1].getWidth(), 0);
			}
		}
	}
	
	public Background() {
		backgroundTexture = new Texture(Gdx.files.internal("data/background.png"));
		parallaxTextures[0] = new Texture(Gdx.files.internal("data/starfield4.png"));
		parallaxTextures[1] = new Texture(Gdx.files.internal("data/starfield3.png"));
		parallaxTextures[2] = new Texture(Gdx.files.internal("data/starfield2.png"));
		parallaxTextures[3] = new Texture(Gdx.files.internal("data/starfield.png"));
	}
}
