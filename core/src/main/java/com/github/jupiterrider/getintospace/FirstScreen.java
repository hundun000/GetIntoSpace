package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen extends ScreenAdapter {

	private final Rocket rocket;
	private final Batch batch;
	private final BitmapFont bitmapFont;

	public FirstScreen() {
		rocket = new Rocket();
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		rocket.draw(batch, delta);
		String strFps = "FPS: " + String.valueOf(Gdx.graphics.getFramesPerSecond());
		bitmapFont.draw(batch, strFps, 0f, Gdx.graphics.getHeight());
		batch.end();
	}

	@Override
	public void dispose() {
		rocket.dispose();
		batch.dispose();
		bitmapFont.dispose();
	}
}