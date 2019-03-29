package ro.pub.cs.systems.eim.practicaltest01var06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {

    Button b_generate = null;
    Button b_check= null;
    Button b_back = null;

    EditText e_score = null;
    TextView guess = null;
    int nu_set;

    private BList blist = new BList();
    private class BList implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Button b =  (Button)v;
            switch (b.getId()){
                case R.id.b_back:
                    setResult(-1, null);
                    break;
                case R.id.b_generate:
                    Random r = new Random();
                    Integer i1 = r.nextInt(9 - 0);
                    guess.setText(i1.toString());
                    break;
                case R.id.b_check:
                    if(Integer.parseInt(guess.getText().toString()) == nu_set) {
                        e_score.setText(Integer.parseInt(e_score.getText().toString())+1);
                    }

                    break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("number")) {
            nu_set = intent.getIntExtra("number", -1);
            guess.setText(nu_set);
        }

        b_generate = (Button)findViewById(R.id.b_generate);
        b_generate.setOnClickListener(blist);
        b_check = (Button)findViewById(R.id.b_check);
        b_check.setOnClickListener(blist);
        b_back = (Button)findViewById(R.id.b_back);
        b_back.setOnClickListener(blist);


        e_score = (EditText)findViewById(R.id.edit_score);
        guess = (TextView)findViewById(R.id.edit_guess);



    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("number", e_score.getText().toString());
        savedInstanceState.putString("check",  guess.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("number")) {
            guess.setText(savedInstanceState.getString("number"));
        } else {
            guess.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("check")) {
            e_score.setText(savedInstanceState.getString("check"));
        } else {
            e_score.setText(String.valueOf(0));
        }
    }



}
