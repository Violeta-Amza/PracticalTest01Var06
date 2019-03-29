package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.Intent;
import android.content.IntentFilter;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03ChooseNumber extends AppCompatActivity {

    Button b1 = null;
    EditText number = null;
    TextView nr = null;


    private BList2 blist2 = new BList2();
    private class BList2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
            String number_int = number.getText().toString();
            intent.putExtra("number", number_int);
            startActivityForResult(intent, 1);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_choose_number);

        number =  (EditText) findViewById(R.id.edit_number);
        nr = (TextView)findViewById(R.id.edit_nr);
        b1 = (Button)findViewById(R.id.b_play);
        b1.setOnClickListener(blist2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        //registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        //unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        //Intent intent = new Intent(this, PracticalTest01Service.class);
        //stopService(intent);
        super.onDestroy();
    }


}
