package com.example.mgkan.project01;

import java.util.ArrayList;

public class AttributeValue {

    private String strength,speed,intelligence;

    public AttributeValue(String strength, String speed, String intelligence){
        this.strength = strength;
        this.speed =speed;
        this.intelligence =intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public String getSpeed() {
        return speed;
    }

    public String getIntelligence() {
        return intelligence;
    }
}
