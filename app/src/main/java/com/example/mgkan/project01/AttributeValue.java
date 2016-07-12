package com.example.mgkan.project01;

import java.util.ArrayList;

public class AttributeValue {

    private int strength,speed,intelligence;

    public AttributeValue(int strength, int speed, int intelligence){
        this.strength = strength;
        this.speed =speed;
        this.intelligence =intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
