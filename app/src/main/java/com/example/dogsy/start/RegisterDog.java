package com.example.dogsy.start;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dogsy.R;

public class RegisterDog extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // TODO: do something here

    }
}
