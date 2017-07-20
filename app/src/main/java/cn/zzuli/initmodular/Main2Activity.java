package cn.zzuli.initmodular;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button bn;
    private EditText edit_1;
    private EditText edit_2;
    private EditText edit_3;
    private EditText edit_4;
    private EditText edit_5;
    private EditText edit_6;
    private EditText edit_7;
    private EditText edit_8;
    private EditText edit_9;
    private EditText edit_10;
    private EditText edit_11;
    private EditText edit_01;
    private EditText edit_02;
    private EditText edit_03;
    private EditText edit_04;
    private EditText edit_05;
    private EditText edit_06;
    private EditText edit_07;
    private EditText edit_08;
    private EditText edit_09;
    private EditText edit_010;
    private EditText edit_011;
    private EditText edit_012;
    private EditText edit_013;
    private EditText edit_014;
    private EditText edit_015;
    private EditText edit_016;
    private Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_linear);
    }

    private void bindView(){
        bn = (Button) findViewById(R.id.request);
        edit_1 = (EditText)findViewById(R.id.edit_1);
        edit_2 = (EditText)findViewById(R.id.edit_2);
        edit_3 = (EditText)findViewById(R.id.edit_3);
        edit_4 = (EditText)findViewById(R.id.edit_4);
        edit_5 = (EditText)findViewById(R.id.edit_5);
        edit_6 = (EditText)findViewById(R.id.edit_6);
        edit_7 = (EditText)findViewById(R.id.edit_7);
        edit_8 = (EditText)findViewById(R.id.edit_8);
        edit_9 = (EditText)findViewById(R.id.edit_9);
        edit_10 = (EditText)findViewById(R.id.edit_10);
        edit_11 = (EditText)findViewById(R.id.edit_11);

        edit_02 = (EditText)findViewById(R.id.edit_02);
        edit_03 = (EditText)findViewById(R.id.edit_03);
        edit_04 = (EditText)findViewById(R.id.edit_04);

        edit_06 = (EditText)findViewById(R.id.edit_06);
        edit_07 = (EditText)findViewById(R.id.edit_07);
        edit_08 = (EditText)findViewById(R.id.edit_08);
        edit_09 = (EditText)findViewById(R.id.edit_09);
        edit_010 = (EditText)findViewById(R.id.edit_010);
        edit_011 = (EditText)findViewById(R.id.edit_011);
        edit_012 = (EditText)findViewById(R.id.edit_012);

        edit_014 = (EditText)findViewById(R.id.edit_014);
        edit_015 = (EditText)findViewById(R.id.edit_015);

    }

    private void initEvent(){
        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(context,"11111",Toast.LENGTH_LONG).show();
                System.out.println(1);
                String s = (String)edit_1.getText().toString();
                System.out.println(s);
            }
        });
    }
}
