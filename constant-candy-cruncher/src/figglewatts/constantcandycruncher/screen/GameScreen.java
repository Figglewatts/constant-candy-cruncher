package figglewatts.constantcandycruncher;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {
	public OrthographicCamera camera;
	
	public void initViewport(float width, float height, float aspect) {
		// get window size in pixels
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		System.out.println("W: " + w + ", H: " + h);
		
		float vw, vh; // viewport size in screen coords
		float ox, oy; // viewport offset in screen coords
		
		// check aspect ratio
		if (w > h * aspect) {
			// black bars on sides
			System.out.println(h * aspect);
			vh = h;
			vw = Math.round(vh * aspect);
			oy = 0;
			ox = (w - vw) / 2;
			System.out.println("X: " + ox + ", Y: " + oy + ", W: " + vw + ", H: " + vh);
		} else {
			// black bars on top and bottom
			vw = w;
			vh = Math.round(vw * (1 / aspect));
			ox = 0;
			oy = (h - vh) / 2;
		}
		
		// create camera with desired resolution
		camera = new OrthographicCamera(width, height);
		
		// move camera center to push 0, 0 into the corner
		camera.translate(width / 2, height / 2);
		
		// set Y to point downwards
		camera.setToOrtho(true, width, height);
		
		// update camera matrix
		camera.update();
		
		// set viewport to restrict drawing
		Gdx.gl20.glViewport((int)ox, (int)oy, (int)vw, (int)vh);
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
		// set up viewport when window is resized
		initViewport(400, 300, (4f/3f));
	}

	@Override
	public void show() {
		// set up viewport on first load
		initViewport(400, 300, (4f/3f));
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
