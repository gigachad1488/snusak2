package com.example.kozinak;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView tvUserData;
    private Button btnBack;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        WebView view = findViewById(R.id.govnoosla);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl("https://yandex.ru/games/app/244421?utm_source=game_promo_catalog&utm_campaign=rus_games_brand_yandex_search_460.new%7C59207972&utm_medium=search&utm_content=k50id%7C0100000026527301731_26527301731%7Ccid%7C59207972%7Cgid%7C4460521681%7Caid%7C12964419156%7Cadp%7Cyes%7Cpos%7Cpremium1%7Csrc%7Csearch_none%7Cdvc%7Cdesktop%7Cmain#app-id=244421&catalog-session-uid=catalog-a81333e9-b774-52ed-8740-890ec2bec8fc-1694585583034-3554&pos=%7B%22listType%22%3A%22suggested%22%2C%22tabCategory%22%3A%22common%22%7D&redir-data=%7B%22block%22%3A%22suggested%22%2C%22block_index%22%3A2%2C%22card%22%3A%22adaptive_recommended_new%22%2C%22col%22%3A0%2C%22first_screen%22%3A1%2C%22page%22%3A%22main%22%2C%22rn%22%3A975388469%2C%22row%22%3A0%2C%22rtx_reqid%22%3A%22%22%2C%22wrapper%22%3A%22grid-list%22%2C%22http_ref%22%3A%22https%253A%252F%252Fyandex.ru%252Fgames%252F%253Fname%253DRBI%2526first-seen%253D%25257B%252522utm_source%252522%25253A%252522yandex%252522%25257D%22%7D");

        tvUserData = findViewById(R.id.tvUserData);
        btnBack = findViewById(R.id.btnBack);

        String userJson = getIntent().getStringExtra("userJson");
        if (userJson != null) {
            Gson gson = new Gson();
            user = gson.fromJson(userJson, User.class);

        }

        tvUserData.setText(user.getUserData());
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}