package com.example.mgkan.project01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Mauve3 on 7/7/16.
 */

public class InventoryAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<String> inven;
    private final Context context;

    public InventoryAdapter(Context context) {
        //super();
      inflater = LayoutInflater.from(context);

      this.inven = new ArrayList<>();
      this.context = context;
    }


    public void addList(String item){
      inven.add(item);
    }

    @Override
    public int getCount() {
        return inven.size();
    }

    @Override
    public Object getItem(int position) {
        return inven.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View child, ViewGroup parent) {

        Log.d("Position: " , "" + position);

        View v = child;
        final EditText itemBox;


        if (v == null) {

            v = inflater.inflate(R.layout.inven_item, parent, false);
        }


        itemBox = (EditText) v.findViewById(R.id.items);
        Button stats = (Button) v.findViewById(R.id.attButton);
        Button drop = (Button) v.findViewById(R.id.dropButton);
        stats.setEnabled(false);


        //not working as it should. come back to it.!!!!!!!
        if(itemBox.getText()!=null){
            stats.setEnabled(true);
        }
        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), Attribute.class);
                context.startActivity(intent);
                inven.add(itemBox.getText().toString());
                Log.d("test","item sent to arraylist");
                //context.startActivityForResult(intent,1);
            }
        });
        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             inven.remove(position);
              notifyDataSetInvalidated();
            }
        });

        v.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v) {
            Intent intent = new Intent(context.getApplicationContext(), InventoryActivity.class);
             context.startActivity(intent);
           }
        });



        return v;
    }
}
