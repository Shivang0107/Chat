package com.example.chat.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chat.databinding.ActivityPhoneValidationBinding;
import com.google.firebase.auth.FirebaseAuth;

public class PhoneValidation extends AppCompatActivity {

    ActivityPhoneValidationBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPhoneValidationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth=FirebaseAuth.getInstance();

        if(auth.getCurrentUser()!=null)
        {
            Intent intent=new Intent(PhoneValidation.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        getSupportActionBar().hide();

        binding.phone.requestFocus();

        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PhoneValidation.this,otpActivity.class);
                intent.putExtra("phoneNumber",binding.phone.getText().toString());
                startActivity(intent);
            }
        });
    }
}