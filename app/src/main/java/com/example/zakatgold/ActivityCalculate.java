package com.example.zakatgold;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCalculate extends AppCompatActivity {

    //declare
    EditText etKeep, etWear, etCurrent;
    Button btnReset, btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Top bar customization
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        //calling the topbar_title_layout
        getSupportActionBar().setCustomView(R.layout.topbar_title_layout);

        setContentView(R.layout.activity_calculate);

        //bind
        etKeep = (EditText) findViewById(R.id.etKeep);
        etWear = (EditText) findViewById(R.id.etWear);
        etCurrent = (EditText) findViewById(R.id.etCurrent);

        //initialize reset button
        btnReset = (Button) findViewById(R.id.btnReset);

        //functioning reset button
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etKeep.getText().clear();
                etWear.getText().clear();
                etCurrent.getText().clear();
            }//close onClick()
        });

        //initialize calculate button
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        //functioning calculate button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keep = etKeep.getText().toString();
                String wear = etWear.getText().toString();
                String current = etCurrent.getText().toString();

                //passing with intent
                Intent intent = new Intent(ActivityCalculate.this, ActivityResult.class);
                intent.putExtra("keepGold", keep);
                intent.putExtra("wearGold", wear);
                intent.putExtra("currentGold", current);

                startActivity(intent);
            }//close onCLick()
        });
    }//close onCreate()
}//close ActivityCalculate