package com.example.mgkan.project01;

import java.util.ArrayList;

/**
 * Created by mgkan on 2016-07-14.
 */
public class Equipment {
  String att1,att2,att3,itemName;
  ArrayList<String> equipment;

  public Equipment(String att1, String att2, String att3){
    this.att1= att1;
    this.att2= att2;
    this.att3= att3;

  }
  public Equipment(String itemName, ArrayList<String> equipment){
    this.itemName = itemName;
    this.equipment = equipment;
    this.att1 = getAtt1(this.equipment);
    this.att2 = getAtt2(this.equipment);
    this.att3 = getAtt3(this.equipment);

  }
  public String getAtt1(ArrayList<String> equipment) {
    return att1;
  }

  public void setAtt1(String att1) {
    this.att1 = att1;
  }

  public String getAtt2(ArrayList<String> equipment) {
    return att2;
  }

  public void setAtt2(String att2) {
    this.att2 = att2;
  }

  public String getAtt3(ArrayList<String> equipment) {
    return att3;
  }

  public void setAtt3(String att3) {
    this.att3 = att3;
  }
}
