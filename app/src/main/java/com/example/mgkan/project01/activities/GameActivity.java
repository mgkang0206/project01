package com.example.mgkan.project01.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mgkan.project01.*;
import com.example.mgkan.project01.models.Character;

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

  // geluso says: I see you're trying to pass in a Character here. Putting this in a constructor
  // isn't the best way to do this because you don't have control over when Activities are
  // constructed. Instead of passing it as a parameter in the constructor you could pull
  // some information out of an Intent.
  public GameActivity(Character character){

    this.chari = character;
    att = chari.getAttribute();
    Log.d("Strength", ""+att[0]);
    Log.d("Speed", ""+att[1]);
    Log.d("Intelligence", ""+att[2]);
  }

  //build game which consists of many arrays each leading to next until gameover.

}
