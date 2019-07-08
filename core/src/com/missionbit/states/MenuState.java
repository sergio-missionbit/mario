package com.missionbit.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.sprites.Player;


public class MenuState extends State {

    private Player player;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        player = new Player(50,300);
        player.move();
    }
    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {
        player.dispose();
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        player.update(dt);
        cam.position.x = player.getPosition().x + 80;

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        super.render(sb);

        sb.begin();
        // Start Drawing
        sb.draw(player.getTexture(), player.getPosition().x, player.getPosition().y);
        // Stop Drawing

        sb.end();

    }
}
