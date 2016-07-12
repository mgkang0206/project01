package com.example.mgkan.project01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Attribute extends AppCompatActivity {
  ListView list2;
  AttributeAdapter adapt2;
  ArrayList<String> stat1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.attribute_page);
    stat1 = new ArrayList<>();
    stat1.add("Strength");
    stat1.add("Speed");
    stat1.add("Intelligence");


    Log.d("test", "entered attribute activity");
    list2 = (ListView) findViewById(R.id.itemList);
    adapt2 = new AttributeAdapter(this, stat1);
    if (list2 != null) {
      list2.setAdapter(adapt2);
    }
  }
}
