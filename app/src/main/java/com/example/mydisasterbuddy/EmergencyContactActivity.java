package com.example.mydisasterbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EmergencyContactActivity extends AppCompatActivity
{
    EditText etNum1;
    EditText etNum2;
    EditText etNum3;
    Button btnSave;

    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contact);

        etNum1 = findViewById(R.id.edit_text_num_1);
        etNum2 = findViewById(R.id.edit_text_num_2);
        etNum3 = findViewById(R.id.edit_text_num_3);

        btnSave = findViewById(R.id.button_save);

        mRef = FirebaseDatabase.getInstance().getReference("users");

        btnSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String userId = mRef.push().getKey();
                DatabaseReference childRef = mRef.child(userId);

                String num1 = etNum1.getText().toString();
                String num2 = etNum2.getText().toString();
                String num3 = etNum3.getText().toString();

                EmergencyContact emergencyContact = new EmergencyContact(num1,num2,num3);

                childRef.setValue(emergencyContact);

                childRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        Toast.makeText(EmergencyContactActivity.this, "Emergency contacts Save Successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError)
                    {
                        Toast.makeText(EmergencyContactActivity.this, "Some Error occurred!", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}
