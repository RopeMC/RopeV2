package de.ropemc.rv2.api.entity;

public interface LivingEntity extends Entity {

    int getHurtTime();

    float getHealth();

    void setHealth(float health);
}
