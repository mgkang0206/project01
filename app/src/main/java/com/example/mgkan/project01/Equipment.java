package com.example.mgkan.project01;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by mgkan on 2016-07-14.
 */
public class Equipment implements Parcelable {
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

  protected Equipment(Parcel in) {
    itemName = in.readString();
    if (in.readByte() == 0x01) {
      attribute = new ArrayList<>();
      in.readList(attribute, String.class.getClassLoader());
    } else {
      attribute = null;
    }
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(itemName);
    if (attribute == null) {
      dest.writeByte((byte) (0x00));
    } else {
      dest.writeByte((byte) (0x01));
      dest.writeList(attribute);
    }
  }

  @SuppressWarnings("unused")
  public static final Parcelable.Creator<Equipment> CREATOR = new Parcelable.Creator<Equipment>() {
    @Override
    public Equipment createFromParcel(Parcel in) {
      return new Equipment(in);
    }

    @Override
    public Equipment[] newArray(int size) {
      return new Equipment[size];
    }
  };
}
