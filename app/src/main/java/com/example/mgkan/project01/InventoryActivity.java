package com.example.mgkan.project01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mgkan on 2016-07-11.
 */
public class InventoryActivity extends AppCompatActivity {
  ListView listy;
  InventoryAdapter adapty;
  Button submit,add;
  HashMap<String, String> equipment= new HashMap<>();
  ArrayList<String> itemList;
  ArrayList<String> results = new ArrayList<>();
//  private final ArrayList<Attribute> equipmentList;

  public HashMap<String,String> getEquipment(){
    return equipment;
  }
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

    submit.setEnabled(false);//enable it after checking all item names, attributes are set
    submit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        for(int i=0; i<itemList.size();i++){
          equipment.put(itemList.get(i).toString(),results.get(i).toString());

        }
        for (String name: equipment.keySet()){

          String key =name.toString();
          String value = equipment.get(name).toString();
          System.out.println(key + " " + value);

        }
        Intent intent = new Intent(InventoryActivity.this, PlayGame.class);
        startActivity(intent);
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

    String result = data.getStringExtra("Attribute");
    String addAct = data.getStringExtra("enableAdd");
    Log.d("RESULT", result);
    itemList = adapty.getInven();
    Log.d("test", Arrays.toString(itemList.toArray()));
    if(results.size()<itemList.size()) {
      results.add(result);
      Log.d("test", Arrays.toString(results.toArray()));
    }
    if(addAct==null||addAct.equals("disabled")){
      add.setEnabled(false);
    }
    else{
      add.setEnabled(true);
      submit.setEnabled(true);
    }
  }

}
