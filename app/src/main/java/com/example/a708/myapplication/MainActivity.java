package com.example.a708.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView player1TextView;
    private TextView player2TextView;
    private TextView player3TextView;
    private TextView player4TextView;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1TextView = (TextView) findViewById(R.id.tv_pl1);
        player2TextView = (TextView) findViewById(R.id.tv_pl2);
        player3TextView = (TextView) findViewById(R.id.tv_pl3);
        player4TextView = (TextView) findViewById(R.id.tv_pl4);
        layout = findViewById(R.id.layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(item.getItemId() == R.id.itemTwenty){
            builder.setTitle("Are you sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            resetScore(20);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create().show();

        }else if(item.getItemId() == R.id.itemForty){
            builder.setTitle("Are you sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            resetScore(40);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create().show();
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void onClickAdd(View view){
        Object tag = view.getTag();
        TextView textView = (TextView) layout.findViewWithTag(tag);

        int score = Integer.parseInt(textView.getText().toString());
        score++;
        textView.setText(score + "");
    }

    public void onClickSub(View view){
        Object tag = view.getTag();
        TextView textView = (TextView) layout.findViewWithTag(tag);

        int score = Integer.parseInt(textView.getText().toString());
        score--;
        textView.setText(score + "");
    }

    private void resetScore(int score){
        player1TextView.setText(score + "");
        player2TextView.setText(score + "");
        player3TextView.setText(score + "");
        player4TextView.setText(score + "");
    }

}
