package com.example.zakatgold;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityAboutUs extends AppCompatActivity {

    //declare
    Button gitHub;

    private Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Top bar customization
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        //calling the topbar_title_layout
        getSupportActionBar().setCustomView(R.layout.topbar_title_layout);

        setContentView(R.layout.activity_about_us);

        //binding
        gitHub = (Button) findViewById(R.id.btnGitHub);
        btnHome = (Button) findViewById(R.id.btnHomeAbout);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActity();
            }
        });

        gitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://github.com/YaminIbrahim/ZakatGold");
            }//close onClick
        }); //.setOnClickListener()
    }//close onCreate()

    public void openHomeActity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goLink(String link){
        Uri uri = Uri.parse(link);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }//close goLink

}//close ActivityAboutUs