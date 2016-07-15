package com.example.mgkan.project01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by mgkan on 2016-07-11.
 */
public class GameActivity extends AppCompatActivity{
  Character chari;
  int[] att;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.empty);

  }
  public GameActivity(Character character){

    this.chari = character;
    att = chari.getAttribute();
    Log.d("Strength", ""+att[0]);
    Log.d("Speed", ""+att[1]);
    Log.d("Intelligence", ""+att[2]);
  }

  //build game which consists of many arrays each leading to next until gameover.

}
