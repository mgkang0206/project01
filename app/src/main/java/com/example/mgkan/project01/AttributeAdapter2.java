package com.example.mgkan.project01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Mauve3 on 7/7/16.
 */
public class AttributeAdapter2 extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<String> attribute;
    private final Context context;

    public AttributeAdapter2(Context context, ArrayList<String> attribute) {
        //super();
        inflater = LayoutInflater.from(context);
        this.attribute = attribute;
        this.context = context;
    }
    @Override
    public int getCount() {
        return attribute.size();
    }

    @Override
    public Object getItem(int position) {
        return attribute.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View child, ViewGroup parent) {

        Log.d("Position " , "" + position);

        View v = child;
        final TextView stat;

        if (v == null) {

            v = inflater.inflate(R.layout.attribute_displayitem, parent, false);
        }


        stat = (TextView) v.findViewById(R.id.attributeDisplayView);
        stat.setText(String.valueOf(attribute.get(position)));

        v.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v) {
            Intent intent = new Intent(context.getApplicationContext(), Attribute.class);
               context.startActivity(intent);

           }
        });

        return v;
    }
}
