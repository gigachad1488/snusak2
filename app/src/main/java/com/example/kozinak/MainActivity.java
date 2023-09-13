package com.example.kozinak;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.Serializable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    VideoView vid;
    private EditText etFirstName, etLastName, etAge, etSalary;
    private Button btnGoToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this, R.raw.raw);
        player.start();
        player.setLooping(true);


        vid = findViewById(R.id.govno228);
        Uri ur = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.zol);
        vid.setVideoURI(ur);
        MediaController mediaController = new MediaController(this);
        vid.setMediaController(mediaController);
        mediaController.setMediaPlayer(vid);
        vid.start();


        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAge = findViewById(R.id.etAge);
        etSalary = findViewById(R.id.etSalary);
        btnGoToSecondActivity = findViewById(R.id.btnGoToSecondActivity);

        btnGoToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();
                String age = etAge.getText().toString();
                String salary = etSalary.getText().toString();

                User user = new User();
                user.setFirstName(etFirstName.getText().toString());
                user.setLastName(etLastName.getText().toString());
                if (etAge.getText().toString().trim().length() > 0) {
                    user.setAge(Integer.parseInt(etAge.getText().toString()));
                }
                else
                {
                    user.setAge(0);
                }

                if (etSalary.getText().toString().trim().length() > 0) {
                    user.setSalary(Double.parseDouble(etSalary.getText().toString()));
                }
                else
                {
                    user.setSalary(0);
                }



                Gson gson = new Gson();
                String userJson = gson.toJson(user);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("userJson", userJson);
                startActivity(intent);
            }
        });


    }
}
