package com.missionbit.mario.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.missionbit.mario.Mario;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = Mario.WIDTH;
		config.height = Mario.HEIGHT;
		config.title = Mario.TITLE;

		new LwjglApplication(new Mario(), config);
	}
}
