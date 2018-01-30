package com.example.jonathansun5.cryptoconvert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        EditText e1 = (EditText)findViewById(R.id.editText2);
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.RGroup);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.RGroup2);
        double num1 = Double.parseDouble(e1.getText().toString());
        if (rg1.getCheckedRadioButtonId() == R.id.radioButton) {
            if (rg2.getCheckedRadioButtonId() == R.id.radioButton7) {
//                Log.d("HSASHAK", "button 1 ");
            } else if (rg2.getCheckedRadioButtonId() == R.id.radioButton8) {
                num1 = num1 / 10955.91;
//                Log.d("HSASHAK", "button 1 ");
            } else if (rg2.getCheckedRadioButtonId() == R.id.radioButton9) {
//                Log.d("HSASHAK", "button 1 ");
                num1 = num1 * 145.54;
            }
        } else if (rg1.getCheckedRadioButtonId() == R.id.radioButton2) {
            if (rg2.getCheckedRadioButtonId() == R.id.radioButton7) {
                num1 = num1 * 10955.91;
            } else if (rg2.getCheckedRadioButtonId() == R.id.radioButton8) {

            } else if (rg2.getCheckedRadioButtonId() == R.id.radioButton9) {
                num1 = num1 * 1609050.84;
            }
        } else if (rg1.getCheckedRadioButtonId() == R.id.radioButton3) {
            if (rg2.getCheckedRadioButtonId() == R.id.radioButton7) {
                num1 = num1 / 145.54;
            } else if (rg2.getCheckedRadioButtonId() == R.id.radioButton8) {
                num1 = num1 / 1609050.84;
            } else if (rg2.getCheckedRadioButtonId() == R.id.radioButton9) {

            }
        }
        TextView t1 = (TextView)findViewById(R.id.textView);
        t1.setText(Double.toString(num1));
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
