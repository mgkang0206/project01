package com.example.mgkan.project01;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by mgkan on 2016-07-11.
 */
public class Character {
  HashMap<String,String> equipment;
  InventoryActivity inAct;
  String[] stringP;
  int[] att=new int[3];
  int strengthTotal,speedTotal,intelligenceTotal;

  public Character(InventoryActivity inventoryActivity) {
    this.inAct = inventoryActivity;
    setEquipment(inAct.getEquipment());
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
    return att;
  }


  //will receive hash map<itemName, attribute> make it useful for GameActivity to use
}
