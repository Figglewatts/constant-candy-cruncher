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

import figglewatts.constantcandycruncher.screen.TestScreen;

public class ConstantCandyCruncher implements ApplicationListener {
	
	TestScreen test = new TestScreen();
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		test.show();
	}

	@Override
	public void dispose() {
		test.dispose();
	}

	@Override
	public void render() {		
		test.render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height) {
		test.resize(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
