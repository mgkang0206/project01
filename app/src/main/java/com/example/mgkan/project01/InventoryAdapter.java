package com.example.mgkan.project01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
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
    private final Context mContext;
    private ArrayList<Equipment> equipments;


    public InventoryAdapter(Context mContext,ArrayList<Equipment> itemName) {
    //super();
    inflater = LayoutInflater.from(mContext);
      this.equipments = itemName;
    this.mContext = mContext;
    }

    public void addList(String item){
      Equipment newE = new Equipment(item, new ArrayList<String>());
      equipments.add(newE);
    }
    public void addAttribute(int position,ArrayList<String> attribute){
      equipments.get(position).setAttribute(attribute);
    }

    @Override
    public int getCount() {
        return equipments.size();
    }

    @Override
    public Object getItem(int position) {
        return equipments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public ArrayList<Equipment> getEquipments() {
      return equipments;
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

        Equipment item = equipments.get(position);
        if (item != null && item.getItemName().length() > 0) {
          itemBox.setText(item.getItemName());
        } else {
          itemBox.setText("");
        }

       final Button stats = (Button) v.findViewById(R.id.attButton);
       Button drop = (Button) v.findViewById(R.id.dropButton);

       if(itemBox.length()==0) {
         stats.setEnabled(false);
       }
       itemBox.addTextChangedListener(new TextWatcher() {
       @Override
       public void beforeTextChanged(CharSequence s, int start, int count, int after) {

       }

       @Override
       public void onTextChanged(CharSequence s, int start, int before, int count) {
          if (itemBox.length() > 0) {
            stats.setEnabled(true);
          }
          equipments.get(position).setItemName(itemBox.getText().toString());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }

      });

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(mContext, Attribute.class);
              intent.putStringArrayListExtra("Attribute", equipments.get(position).getAttribute());
              ((Activity) mContext).startActivityForResult(intent,position);

            }
        });

        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              equipments.remove(position);
              notifyDataSetChanged();
            }
        });

        v.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v) {
            Intent intent = new Intent(mContext.getApplicationContext(), InventoryActivity.class);
             mContext.startActivity(intent);
           }
        });

        return v;
    }

}
