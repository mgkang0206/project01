package com.example.mgkan.project01.models;

import com.example.mgkan.project01.activities.InventoryActivity;

import java.util.HashMap;

/**
 * Created by mgkan on 2016-07-11.
 */
public class Character {
  HashMap<String,String> equipment;
  InventoryActivity inAct;
  String[] stringP;

  int[] att=new int[3];

  AttributeValue attr;

  int strengthTotal,speedTotal,intelligenceTotal;

    // You don't need to store a reference to the inventoryActivity here.
    // Characters are objects that should exist independently of the activity they are
    // created in. Think about it this way: activities know about characters inside them,
    // but it doesn't matter to a character what activity they are inside.
  public Character(InventoryActivity inventoryActivity) {
    this.inAct = inventoryActivity;
//    setEquipment(inAct.getEquipment());
    setAttributes(equipment);
//    Log.d("Strength", ""+strengthTotal);
//    Log.d("Speed", ""+speedTotal);
//    Log.d("Intelligence", ""+intelligenceTotal);
  }
  public void setEquipment(HashMap<String,String> equipmentData){
    equipment = equipmentData;
  }
  public void setAttributes(HashMap<String,String> equipment){
    strengthTotal=0;
    speedTotal=0;
    intelligenceTotal=0;

    for(String value : equipment.values()){
      stringP = value.split(" ");
      String attr = stringP[0];
      String val = stringP[1];
      int v = Integer.parseInt(val);
      if(attr.equals("Strength")){
       strengthTotal += v;
      }else if(attr.equals("Speed")){
        speedTotal += v;
      }else {
        intelligenceTotal += v;
      }
    }
  }
  public int[] getAttribute(){
    att[0]=strengthTotal;
    att[1]=speedTotal;
    att[2]=intelligenceTotal;

    attr.strength = strengthTotal;
    attr.speed = speedTotal;
    attr.intelligence = intelligenceTotal;

    return att;
  }


  //will receive hash map<itemName, attribute> make it useful for GameActivity to use
}
