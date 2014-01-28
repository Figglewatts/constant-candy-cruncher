package figglewatts.constantcandycruncher;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Constant Candy Cruncher";
		cfg.useGL20 = true;
		cfg.width = 800;
		cfg.height = 600;
		new LwjglApplication(new ConstantCandyCruncher(), cfg);
	}
}
