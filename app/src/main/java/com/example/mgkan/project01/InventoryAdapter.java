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
import java.util.Arrays;

/**
 * Created by Mauve3 on 7/7/16.
 */

public class InventoryAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<String> inven;
    private final Context mContext;

    public InventoryAdapter(Context mContext) {
        //super();
      inflater = LayoutInflater.from(mContext);

      this.inven = new ArrayList<>();
      this.mContext = mContext;
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

        String item = inven.get(position);
        if (item != null && item.length() > 0) {
          itemBox.setText(item);
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
          inven.set(position, itemBox.getText().toString());
          Log.d("test", itemBox.getText().toString());
          Log.d("test", Arrays.toString(inven.toArray()));

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
      });

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Attribute.class);
//               mContext.startActivity(intent);
              ((Activity) mContext).startActivityForResult(intent,1);

            }
        });

        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              inven.remove(position);
              notifyDataSetChanged();
              Log.d("position removed",""+position);
              Log.d("test", Arrays.toString(inven.toArray()));
              notifyDataSetInvalidated();
            }
        });

        v.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v) {
            Intent intent = new Intent(mContext.getApplicationContext(), InventoryActivity.class);
             mContext.startActivity(intent);
           }
        });

//      @Override
//      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (requestCode == 1) {
//          if(resultCode == Activity.RESULT_OK){
//            String result=data.getStringExtra("Attribute");
//          }
//          if (resultCode == Activity.RESULT_CANCELED) {
//            //Write your code if there's no result
//          }
//        }
//      }//onActivityResult

        return v;
    }
}
