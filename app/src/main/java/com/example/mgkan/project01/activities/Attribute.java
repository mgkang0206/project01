package com.example.mgkan.project01.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.mgkan.project01.adapters.AttributeAdapter2;
import com.example.mgkan.project01.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Attribute extends AppCompatActivity {
    ListView list2;
    AttributeAdapter2 adapt2;
    Button done;
    ArrayList<String> attribute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attribute_page);
        Log.d("test", "entered attribute activity");
        Intent intent = getIntent();
        attribute = intent.getStringArrayListExtra("Attribute");

        setAttributeClickListener(R.id.strengthButton, "Strength");
        setAttributeClickListener(R.id.speedButton, "Speed");
        setAttributeClickListener(R.id.intelligenceButton, "Intelligence");

        Log.d("test", Arrays.toString(attribute.toArray()));
        list2 = (ListView) findViewById(R.id.itemList2);
        adapt2 = new AttributeAdapter2(this, attribute);
        if (list2 != null) {
            list2.setAdapter(adapt2);
        }
        Log.d("list", Arrays.toString(attribute.toArray()));
        Log.d("test", "populated");
        done = (Button) findViewById(R.id.doneButton);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("list", Arrays.toString(attribute.toArray()));
                Intent intent = new Intent(Attribute.this, InventoryActivity.class);
                intent.putStringArrayListExtra("Attribute", attribute);
                intent.putExtra("enableAdd", "Enabled");
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });
    }


    public void setAttributeClickListener(int id, final String attr) {
        final Button btn = (Button) findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            attribute.add(attr + " " + getRandomValue());
                                            adapt2.notifyDataSetChanged();
                                            btn.setEnabled(false);
                                        }
                                    }
        );
    }

  public int getRandomValue(){
    int value;
    double temp;

    temp = Math.random();
    if (temp > 0.9) {
      value = 5;
    } else if (temp > 0.7) {
      value = 4;
    } else if (temp > 0.5) {
      value = 3;
    } else if (temp > 0.3) {
      value = 2;
    } else {
      value = 1;
    }
    return value;
  }

}
