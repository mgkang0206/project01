package com.example.mgkan.project01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mauve3 on 7/7/16.
 */
public class SimpleAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<String> inven;
    private final Context context;

    public SimpleAdapter(Context context, ArrayList<String> inven) {
        //super();
        inflater = LayoutInflater.from(context);
        this.inven = inven;
        this.context = context;
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
    public View getView(int position, View child, ViewGroup parent) {

        Log.d("Position: " , "" + position);

        View v = child;
        EditText item;

        if (v == null) {

            v = inflater.inflate(R.layout.inven_item, parent, false);
        }


        item = (EditText) v.findViewById(R.id.items);



        v.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v) {
            Intent intent = new Intent(context.getApplicationContext(), InventoryActivity.class);
               context.startActivity(intent);

           }
        });

        return v;
    }
}
