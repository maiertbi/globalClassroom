package com.dogsy.presentation.start;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dogsy.R;

public class RegisterMail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_mail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageButton ib = findViewById(R.id.ib_regusermail);
        EditText et = findViewById(R.id.et_regusermail);
        TextView tv = findViewById(R.id.tv_nomail);

        ib.setOnClickListener(view -> {
            String userMail = et.getText().toString();

            // TODO: FABIAN - add regex-check to the if clause (https://www.w3schools.com/java/java_regex.asp)
            if (userMail.isEmpty()) {
                // TODO: FABIAN - change text-appeareance (color, position) to make it look like LoginActivity.java
                tv.setText("Please enter a correct email");
                return;
            }

            Intent passwordScreen = new Intent(getApplicationContext(), RegisterPassword.class);
            passwordScreen.putExtra("mail", userMail);
            startActivity(passwordScreen);
            overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
        });
    }

    // handles back button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
