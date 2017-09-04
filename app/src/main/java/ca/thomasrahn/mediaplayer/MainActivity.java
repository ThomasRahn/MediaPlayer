package ca.thomasrahn.mediaplayer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String path = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button)findViewById(R.id.play_video);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);

                Bundle b = new Bundle();

                b.putString("file", path);

                intent.putExtras(b);

                startActivity(intent);

            }
        });

        String root_sd = Environment.getExternalStorageDirectory().toString();
        File file = new File(root_sd + "/Download");


        StringBuffer sb = new StringBuffer();
        for(String s : file.list()){
            sb.append(s);
        }

        path = file.listFiles()[1].getAbsolutePath();
        //Find the view by its id
        TextView tv = (TextView)findViewById(R.id.file_view);

        //Set the text
        tv.setText(sb.toString());


    }



}
