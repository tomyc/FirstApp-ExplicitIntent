package net.cieplak.firstapp_explicitintent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ActicityA extends ActionBarActivity {

    private static final int request_code=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acticity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acticity_a, menu);
        return true;
    }

    public void onClick(View view){
        Intent i = new Intent(this,ActivityB.class);
        final EditText editText1 = (EditText)findViewById(R.id.editText1);
        String myString = editText1.getText().toString();
        i.putExtra("pString",myString);
        startActivityForResult(i, request_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==request_code) {
            if (resultCode == -1) {
                TextView textView1 = (TextView) findViewById(R.id.textView1);
                String returningString = data.getExtras().getString("returnData");
                textView1.setText(returningString);
            }
        }
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
