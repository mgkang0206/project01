package com.example.mgkan.project01;

import java.util.ArrayList;

/**
 * Created by mgkan on 2016-07-14.
 */
public class Equipment {
  private String itemName;
  private ArrayList<String> attribute;

  public Equipment(String itemName, ArrayList<String> attribute) {
    this.itemName = itemName;
    this.attribute = attribute;
  }

  public String getItemName() {
    return itemName;
  }

  public ArrayList<String> getAttribute() {
    return attribute;
  }

  public void setAttribute(ArrayList<String> attribute) {
    this.attribute = attribute;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }
}