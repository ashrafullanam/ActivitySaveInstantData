package com.example.ashraf.activitysave;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Life cycle";
    private EditText editText;
    private TextView textView;
    private Button button;
    static final String STATE_TEXT = "Text";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate called");
        super.onCreate(savedInstanceState);
        /*if (savedInstanceState != null) {
            message = savedInstanceState.getString("saveState");
        }*/
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
            }
        });

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        textView.setText(savedInstanceState.getString("reStore"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("reStore",textView.getText().toString());
        //outState.putString("saveState",message);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop called");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart called");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy called");
    }

}
