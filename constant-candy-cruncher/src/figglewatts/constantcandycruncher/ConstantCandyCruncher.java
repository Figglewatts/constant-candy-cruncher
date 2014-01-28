package figglewatts.constantcandycruncher;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Matrix4;

import figglewatts.constantcandycruncher.screen.PlayGameScreen;

public class ConstantCandyCruncher implements ApplicationListener {
	
	private final float TIMESTEP = 1f / 60f;
	private final float FRAMERATE = 1f / 120f;
	private double updateAccumulator = 0d;
	private double renderAccumulator = 0d;
	private long oldTime = System.nanoTime();
	private long currentTime = System.nanoTime();
	private double delta = 0.0f;
	
	private PlayGameScreen playGameScreen = new PlayGameScreen();
	
	@Override
	public void create() {		
		playGameScreen.show();
	}

	@Override
	public void dispose() {
		playGameScreen.dispose();
	}

	@Override
	public void render() {		
		oldTime = currentTime;
		currentTime = System.nanoTime();
		
		// provides delta in seconds with nanosecond accuracy
		// e.g. 0.003 is 0 seconds and 3 milliseconds (or 3x10^-3 seconds)
		delta = (double)(currentTime - oldTime) * 0.000000001f;
		
		updateAccumulator += delta;
		while(updateAccumulator > TIMESTEP) {
			// update
			playGameScreen.update(delta);
			updateAccumulator -= TIMESTEP;
		}
		
		renderAccumulator += delta;
		if (renderAccumulator > FRAMERATE) {
			// draw
			playGameScreen.render(Gdx.graphics.getDeltaTime());
			renderAccumulator = 0.0f;
		}
	}

	@Override
	public void resize(int width, int height) {
		playGameScreen.resize(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
