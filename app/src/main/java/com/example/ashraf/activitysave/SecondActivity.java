package com.example.ashraf.activitysave;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.phoneNumber;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private String recivedMessage;
    private Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView) findViewById(R.id.textView1);
        recivedMessage = getIntent().getStringExtra("pas");
        textView.setText(recivedMessage);
    }

    public void setAction(View view) {
        Intent intent = null;
        b1 = (Button) findViewById(R.id.call);
        b2 = (Button) findViewById(R.id.dial);
        switch (view.getId()) {
            case R.id.dial:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + recivedMessage));
                Toast.makeText(this, "Dial "+recivedMessage, Toast.LENGTH_SHORT).show();
                /*if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }*/
                startActivity(intent);
                break;
            case R.id.call:

                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + recivedMessage));
                Toast.makeText(this, "Call "+recivedMessage, Toast.LENGTH_SHORT).show();
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
                 break;

        }
    }

}
