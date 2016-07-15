package com.example.mgkan.project01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
/**
 * Created by mgkan on 2016-07-11.
 */
public class InventoryActivity extends AppCompatActivity {
  ListView listy;
  InventoryAdapter adapty;
  Button submit,add;


  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.inventory_page);

    submit= (Button) findViewById(R.id.itemSubmit);
    add= (Button) findViewById(R.id.itemAdd);
    add.setEnabled(false);


    Log.d("test", "entered inventory activity");

    listy = (ListView) findViewById(R.id.itemList);
      adapty = new InventoryAdapter(this);
      if (listy != null) {
        listy.setAdapter(adapty);
      }
      adapty.addList("");

    adapty.notifyDataSetChanged();
    Log.d("test","populated");

    submit.setEnabled(false);
    submit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(InventoryActivity.this, PlayGame.class);
        ArrayList<String> itemHolder =  new ArrayList<>();
        ArrayList<Equipment> listEquip = adapty.getEquipments();
        Gson gson = new Gson();
        for(Equipment item : listEquip ) {
         itemHolder.add(gson.toJson(item));
        }
        intent.putExtra("items", itemHolder);
        setResult(Activity.RESULT_OK,intent);
        finish();

      }
    });

    add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        adapty.addList("");
        adapty.notifyDataSetChanged();
        add.setEnabled(false);
        submit.setEnabled(false);
      }
    });

  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.d("requestCOde", ""+requestCode);
    ArrayList<String> result = data.getStringArrayListExtra("Attribute");
    adapty.addAttribute(requestCode, result);

    Gson gson1 = new Gson();
    Log.d("gson String", gson1.toJson(adapty.getItem(requestCode)));
    Equipment testEquip = gson1.fromJson(gson1.toJson(adapty.getItem(requestCode)),Equipment.class);
    Log.d("Equip name", testEquip.getItemName());
//    gson.toJson(adapty.getItem(requestCode));

    String addAct = data.getStringExtra("enableAdd");

    if(addAct==null||addAct.equals("disabled")){
      add.setEnabled(false);
    }
    else{
      add.setEnabled(true);
      submit.setEnabled(true);
    }
  }

}
