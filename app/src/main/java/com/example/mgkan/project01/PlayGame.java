package com.example.mgkan.project01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PlayGame extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_title_page);
    Button inventory = (Button) findViewById(R.id.inventoryButton);
    Button start = (Button) findViewById(R.id.startButton);


//    start.setEnabled(false);
    inventory.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(PlayGame.this, InventoryActivity.class);
//        startActivity(intent);
         startActivityForResult(intent,0);
//        finish();
      }
    });
    start.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(PlayGame.this, GameActivity.class);
        startActivity(intent);
      }
    });
  }
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.d(""+resultCode, ""+requestCode);
    ArrayList<String> result = data.getStringArrayListExtra("items");
    for(String item : result ) {
      Log.d("items" ,item);
    }
  }


}
