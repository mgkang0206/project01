package com.example.mgkan.project01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Attribute extends AppCompatActivity {
  ListView list,list2;
  AttributeAdapter adapt;
  AttributeAdapter2 adapt2;
  ArrayList<String> stat1;
  Button done;
  ArrayList<String> att;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.attribute_page);
    stat1 = new ArrayList<>();
    stat1.add("Strength");
    stat1.add("Speed");
    stat1.add("Intelligence");

    ArrayList<String> equipment= new ArrayList<>();

    Log.d("test", "entered attribute activity");
    list = (ListView) findViewById(R.id.itemList);
    list2 = (ListView) findViewById(R.id.itemList2);
    adapt = new AttributeAdapter(this, stat1);
    if (list != null) {
      list.setAdapter(adapt);
    }

    att= adapt.getEquipment();
    adapt2 =new AttributeAdapter2(this, att);
    if (list2 !=null){
      list2.setAdapter(adapt2);
    }

    done =(Button) findViewById(R.id.doneButton);
    done.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });
  }

}
