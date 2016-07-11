package com.example.mgkan.project01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mgkan on 2016-07-11.
 */
public class InventoryActivity extends AppCompatActivity {
  ListView listy;
  SimpleAdapter adapty;
  ArrayList<String> item;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.inventory_page);
    item = new ArrayList<>();
    item.add("dlsfkaj");

    Log.d("test", "entered inventory activity");
    listy = (ListView) findViewById(R.id.itemList);
    adapty = new SimpleAdapter(this, item);
    if (listy != null) {
      listy.setAdapter(adapty);
    }

  }
}
