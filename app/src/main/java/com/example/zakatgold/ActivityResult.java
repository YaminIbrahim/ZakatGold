package com.example.zakatgold;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {

    //declare
    Button btnHome;
    EditText keep, wear, cPrice;
    TextView keepGram, keepCurrent, keepUruf, keepPay, keepTotal;
    TextView wearGram, wearCurrent, wearUruf, wearPay, wearTotal;
    TextView totalZakatGold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Top bar customization
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        //calling the topbar_title_layout
        getSupportActionBar().setCustomView(R.layout.topbar_title_layout);

        setContentView(R.layout.activity_result);

        //bind keep gold variable
        keepGram = (TextView) findViewById(R.id.tvCalcGram);
        keepCurrent = (TextView) findViewById(R.id.tvCalcCurrent);
        keepUruf = (TextView) findViewById(R.id.tvCalcUruf);
        keepPay = (TextView) findViewById(R.id.tvCalcPay);
        keepTotal = (TextView)findViewById(R.id.tvTotalKeep);

        //bind wear gold variable
        wearGram= (TextView) findViewById(R.id.tvWearGram);
        wearCurrent = (TextView)  findViewById(R.id.tvWearCurrent);
        wearUruf = (TextView) findViewById(R.id.tvWearUruf);
        wearPay = (TextView) findViewById(R.id.tvWearPay);
        wearTotal = (TextView) findViewById(R.id.tvTotalWear);

        //bind tvTotal
        totalZakatGold = (TextView) findViewById(R.id.tvTotal);

        //get intent value from ActivityCalculate
        String keepS = getIntent().getStringExtra("keepGold");
        String wearS = getIntent().getStringExtra("wearGold");
        String currentS = getIntent().getStringExtra("currentGold");

        //converting string data type to integer
        int keep = Integer.parseInt(keepS);
        int wear = Integer.parseInt(wearS);
        int current = Integer.parseInt(currentS);

        //Uruf value
        int urufKeepTotal = keep - 85;
        int urufWearTotal = wear - 200;
        if(urufKeepTotal<0){
            urufKeepTotal = 0;
        }
        if(urufWearTotal<0){
            urufWearTotal = 0;
        }

        //zakat payable
        int zakatPayKeep = urufKeepTotal*current;
        int zakatPayWear = urufWearTotal*current;

        //total for keep and wear cast to float data type
        float totalZakatKeep = (float) (zakatPayKeep*0.025);
        float totalZakatWear = (float) (zakatPayWear*0.025);

        //total zakat
        float zakatTotal = totalZakatKeep + totalZakatWear;

        //convert float to string
        String sKeep = Float.toString(totalZakatKeep);
        String sWear = Float.toString(totalZakatWear);
        String sTotal = Float.toString(zakatTotal);

        //display keep gold detail
        keepGram.setText("Gram                      : " + keep + " gram");
        keepCurrent.setText("Current Gold         : RM" + current);
        keepUruf.setText("Uruf                        : " + urufKeepTotal);
        keepPay.setText("Zakat Payable      : RM" + zakatPayKeep);
        keepTotal.setText("Total Keep Zakat : RM" + sKeep);

        //display wear gold detail
        wearGram.setText("Gram                      : " + wear + " gram");
        wearCurrent.setText("Current Gold         : RM" + current);
        wearUruf.setText("Uruf                        : " + urufWearTotal);
        wearPay.setText("Zakat Payable      : RM" + zakatPayWear);
        wearTotal.setText("Total Wear Zakat : RM" + sWear);

        //display total zakat that need to be pay
        totalZakatGold.setText("Total Zakat           : RM" + sTotal);

        //initialize home button
        btnHome = (Button) findViewById(R.id.btnHome);

        //functioning home button
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActivity();
            }//close onClick()
        });
    }//close onCreate()

    //intent
    public void openHomeActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }//close openHomeActivity()
}//close ActivityResult