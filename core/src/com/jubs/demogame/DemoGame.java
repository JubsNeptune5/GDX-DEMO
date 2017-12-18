package com.jubs.demogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DemoGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture img;
    private float x;
    private float y;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        x = 0;
        y = 0;
    }

    @Override
    public void render() {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x = x+10;   
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x = x-1;   
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            y = y+10;   
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y = y-1;   
        }
        
        //Mouse/touch stuff
        if(Gdx.input.isTouched()){
            int mouseX = Gdx.input.getX();
            if(mouseX > Gdx.app.getGraphics().getWidth()/2){
                x = x+1;
            }
            if(mouseX < Gdx.app.getGraphics().getWidth()/2){
                x = x-1000000;
            }
        }
        //Clear screen
        //1 red 0 green 0 blue
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, x, y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
