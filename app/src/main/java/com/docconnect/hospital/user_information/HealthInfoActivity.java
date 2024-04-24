package com.docconnect.hospital.user_information;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.docconnect.hospital.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HealthInfoActivity extends AppCompatActivity {

    private DatabaseReference patientRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Health Information");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2E5DA3")));

        // Initialize Firebase references
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        patientRef = FirebaseDatabase.getInstance().getReference().child("patients").child(userID);

        // Retrieve and display health information
        retrieveAndDisplayHealthInfo();
    }

    private void retrieveAndDisplayHealthInfo() {
        patientRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Patient patient = snapshot.getValue(Patient.class);

                if (patient != null) {
                    HealthInformation healthInfo = patient.getHealthInformation();
                    if (healthInfo != null) {
                        // Retrieve health information data
                        Date dob = healthInfo.getDateOfBirth();
                        int weight = healthInfo.getWeight();
                        String gender = healthInfo.getGender();
                        String prescription = healthInfo.getPrescription();

                        // Update TextViews with health information data
                        TextView textViewDOB = findViewById(R.id.textViewDOB);
                        TextView textViewWeight = findViewById(R.id.textViewWeight);
                        TextView textViewGender = findViewById(R.id.textViewGender);
                        TextView textViewPrescription = findViewById(R.id.textViewPrescription);

                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
                        String dobStr = dateFormat.format(dob);

                        textViewDOB.setText("Date of Birth: " + dobStr);
                        textViewWeight.setText("Weight: " + weight + " lbs");
                        textViewGender.setText("Gender: " + gender);
                        textViewPrescription.setText("Prescription: " + prescription);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });
    }
}
