package com.example.student.smsmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sendBtn;
    EditText txtphoneNo;

    EditText txtmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sendBtn=(Button) findViewById(R.id.button);
        txtphoneNo=(EditText) findViewById(R.id.editText);
        txtmessage=(EditText) findViewById(R.id.editText2);

        sendBtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                sendSMSMessage();

            }
        });




    }



    protected void sendSMSMessage() {
        Log.i("send SMS", "");
        String phoneNo = txtphoneNo.getText().toString();
        String message = txtmessage.getText().toString();

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNo, null, message, null, null);

            Toast.makeText(getApplicationContext(), "SMS sent", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed ", Toast.LENGTH_LONG).show();
            e.printStackTrace();


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
}
