package com.example.mgkan.project01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mauve3 on 7/7/16.
 */
public class AttributeAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<String> attribute;
    private final Context context;

    public AttributeAdapter(Context context, ArrayList<String> attribute) {
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

            v = inflater.inflate(R.layout.attribute_item, parent, false);
        }


        stat = (TextView) v.findViewById(R.id.attributeView);
        stat.setText(String.valueOf(attribute.get(position)));
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value;
                double temp;

                String attributeResult;
                temp =  Math.random();
                if(temp>0.9){
                  value = 5;
                }else if(temp>0.7){
                  value = 4;
                }else if(temp>0.5){
                  value = 3;
                }else if(temp>0.3){
                  value = 2;
                }else{
                  value = 1;
                }
                attributeResult = stat.getText().toString()+" "+value;
                Log.d("attributeResult", attributeResult);


                String message = stat.getText().toString()+" "+value;
                Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context.getApplicationContext(), InventoryActivity.class);

                intent.putExtra("Attribute", attributeResult);
                ((Activity) context).setResult(Activity.RESULT_OK,intent);
                ((Activity) context).finish();


            }
        });

        v.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v) {
            Intent intent = new Intent(context.getApplicationContext(), Attribute.class);
               context.startActivity(intent);

           }
        });

        return v;
    }
}
