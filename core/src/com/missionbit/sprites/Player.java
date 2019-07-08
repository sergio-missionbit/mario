package com.missionbit.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


public class Player {

    private final int BASE_TEXTURE_FRAMES = 21;


    private Animation playerAnimation;
    public PlayerState state;
    private Vector2 position;
    private Vector2 velocity;
    private Texture baseTexture;

    public Vector2 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return playerAnimation.getFrame();
    }


    public Player(int x, int y){

        this.state = PlayerState.IDLE;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(x, y);
        this.baseTexture = new Texture("small-mario-sprites.png");
    }

    private int[] getFramesForState(){
        switch (this.state){
            case IDLE:
                return new int[]{ 2 };
            case JUMPING:
                return new int[]{ 5 };
            case FALLING:
                return new int[]{ 8, 9 };
            case MOVING:
                return new int[]{ 2, 3, 6, 7 };
            case BREAKING:
                return new int[]{ 4 };
            case CLIMBING:
                return new int[]{ 19, 20 };
            case GAME_OVER:
                return new int[]{ 11 };
            case DESCENDING:
                return new int[]{ 0, 1 };
            case BREAKING_SWIMMING:
                return new int[]{ 14 };
            case START_SWIMMING:
                return new int[]{ 12, 13 };
            case SWIMMING:
                return new int[]{ 15,16, 17, 18 };
            default:
                return new int[]{ 11 };
        }
    }

    public void move(){
        this.state = PlayerState.MOVING;
        playerAnimation = new Animation(
                new TextureRegion(baseTexture),
                21,
                this.getFramesForState(),
                0.5f
                );
    }

    public void swim(){
        this.state = PlayerState.SWIMMING;
        playerAnimation = new Animation(
                new TextureRegion(baseTexture),
                21,
                this.getFramesForState(),
                0.5f
        );
    }

    public void update(float dt){
        playerAnimation.update(dt);
    }


    public void dispose() {
        baseTexture.dispose();
    }

}
