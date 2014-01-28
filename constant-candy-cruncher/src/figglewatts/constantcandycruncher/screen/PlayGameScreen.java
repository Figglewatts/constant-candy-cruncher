package figglewatts.constantcandycruncher.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import figglewatts.constantcandycruncher.entity.Player;

public class PlayGameScreen extends GameScreen {
	private Texture test;
	private TextureRegion testRegion;
	private SpriteBatch batch;
	
	public Player player;
	
	@Override
	public void show() {
		super.show();
		
		batch = new SpriteBatch();
		
		test = new Texture(Gdx.files.internal("data/test.png"));
		testRegion = new TextureRegion(test);
		testRegion.flip(false, true);
		
		player = new Player();
		player.getSprite().setPosition(super.viewportWidth / 2, super.viewportHeight - 40);
		System.out.println(player.getSprite().getX() + ", " + player.getSprite().getY());
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
		
		player.update(delta);
		
		batch.begin();
		//batch.draw(testRegion, 400, 300);
		batch.draw(player.getSprite().getTexture(), player.getSprite().getX(), player.getSprite().getY());
		player.draw(batch);
		batch.end();
	}
}
