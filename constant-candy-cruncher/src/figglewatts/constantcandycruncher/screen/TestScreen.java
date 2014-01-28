package figglewatts.constantcandycruncher.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TestScreen extends GameScreen {
	Texture test;
	TextureRegion testRegion;
	SpriteBatch batch;
	
	@Override
	public void show() {
		super.show();
		
		batch = new SpriteBatch();
		
		test = new Texture(Gdx.files.internal("data/test.png"));
		testRegion = new TextureRegion(test);
		testRegion.flip(false, true);
	}
	
	@Override
	public void hide() {
		super.hide();
		
		batch.dispose();
		test.dispose();
	}
	
	@Override
	public void render(float delta) {
		// clear viewport for new frame
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// apply superclass' camera to spritebatch
		batch.setProjectionMatrix(camera.combined);
		
		batch.setBlendFunction(GL10.GL_NEAREST, GL10.GL_NEAREST);
		
		batch.begin();
		batch.draw(testRegion, 0, 0);
		batch.end();
	}
}
