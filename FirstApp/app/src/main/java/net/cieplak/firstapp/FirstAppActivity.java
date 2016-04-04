package net.cieplak.firstapp;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class FirstAppActivity extends ActionBarActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_app);
        TextView textView = (TextView)findViewById(R.id.textView);
        Resources resources = getResources();
        String miasta[] = resources.getStringArray(R.array.miasta);
        String total="";
        for (String miasto:miasta){
            total=total+miasto+",";
        }

        int[] numerki=resources.getIntArray(R.array.numerki);
        int suma =0;
        for (int numer:numerki){
            suma+=numer;
        }
        total=total+String.valueOf(suma);


        String ilosc = resources.getQuantityString(R.plurals.ilosc_studentow,0,0);
        total=total+" "+ilosc;

        textView.setText(total);
        BitmapDrawable background = (BitmapDrawable)resources.getDrawable(R.drawable.zdjecie01);
        textView.setBackground(background);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_app, menu);
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
