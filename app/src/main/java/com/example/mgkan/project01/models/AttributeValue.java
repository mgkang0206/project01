package com.example.mgkan.project01.models;

public class AttributeValue {

    public int strength,speed,intelligence;

    public AttributeValue(int strength, int speed, int intelligence){
        this.strength = strength;
        this.speed =speed;
        this.intelligence =intelligence;
    }

    public AttributeValue add(AttributeValue a2) {
        return new AttributeValue(this.strength + a2.strength,
                this.speed + a2.speed, this.intelligence + a2.intelligence);
    }
}
