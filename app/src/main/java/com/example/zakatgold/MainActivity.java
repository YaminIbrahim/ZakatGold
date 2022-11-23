package com.example.zakatgold;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //declare
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Top bar customization
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        //calling the topbar_title_layout
        getSupportActionBar().setCustomView(R.layout.topbar_title_layout);

        setContentView(R.layout.activity_main);

        //initialize btnNext
        btnNext = (Button) findViewById(R.id.btnNext);

        //functioning btnNext
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityCalculate();
            }//close onCLick()
        });
    }//close onCreate()

    //drop down menu for Abous Us page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_icon, menu);
        return true;
    }

    //open About Us page
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemMenu:
                openActivityAboutUs();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //passing info with intent
    public void openActivityCalculate(){
        Intent intent = new Intent(this, ActivityCalculate.class);
        startActivity(intent);
    }//close openActivityCalculate()

    public void openActivityAboutUs(){
        Intent intent = new Intent(this, ActivityAboutUs.class);
        startActivity(intent);
    }//close openActivityAboutUs()
}//close MainActivity