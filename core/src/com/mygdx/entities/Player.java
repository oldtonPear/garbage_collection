/*package com.mygdx.entities;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    public float speed = 5 * Resources.TILE_SIZE;
    private Vector2 currentVelocity = new Vector2(0, 0);

    public Player(Vector2 startPosition) {
        super();
        sprite = [sprite retrieving logic];

        // Set the actor's x and y coordinates, as well as width and height.
        setBounds(startPosition.x, startPosition.y, sprite.getWidth(), sprite.getHeight());

        // Create the Box2D body for the Player
        physicalBody = [libgdx Body creation logic]

        // connect Actor with Box2D body
        physicalBody.setUserData(this);

        addListener(FreeRoamingMovementListener(this));
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        trackMovement(delta);
    }

    private void trackMovement(float delta) {
        // calculate how far the body has moved by multiplying the constant speed by how much time has elapsed
        float movement = delta * speed;

        // move the physical body by multiplying current velocity with the movement
        physicalBody.setLinearVelocity(currentVelocity.cpy().scl(movement));

        // move sprite by moving actor to the same coordinates as the physical body
        this.setPosition(physicalBody.getPosition().x - Resources.WORLD_TILE_SIZE / 2f, physicalBody.getPosition().y - Resources.WORLD_TILE_SIZE / 2f);
    }

    void setStateAndVelocity(PlayerState newState, Vector2 newVelocity) {
        // Update our velocity and enact it on our physical body.
        currentVelocity = newVelocity;
        physicalBody.setLinearVelocity(currentVelocity);

        // Update our state and let the sprite animator know of our new state.
        [...]

        // Trigger hooks upon a state change.
        [...]
    }
}*/