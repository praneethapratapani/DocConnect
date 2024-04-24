package com.docconnect.hospital.user_information;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.docconnect.hospital.MainActivity;
import com.docconnect.hospital.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    private DatabaseReference patientsRef;
    private DatabaseReference doctorsRef;

    private Spinner doctorsSpinner;
    private Spinner patientsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        getSupportActionBar().setTitle("Admin");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2E5DA3")));

        // Set background color
        MainActivity.setActivityBackgroundColor(0xf0ffffff, this);

        patientsRef = FirebaseDatabase.getInstance().getReference().child("patients");
        doctorsRef = FirebaseDatabase.getInstance().getReference().child("doctors");

        // Initialize spinners
        doctorsSpinner = findViewById(R.id.doctors_spinner);
        patientsSpinner = findViewById(R.id.patients_spinner);

        // Populate doctors spinner
        populateDoctorsSpinner();

        // Populate patients spinner
        populatePatientsSpinner();

        Button btnDeleteDoctor = findViewById(R.id.btn_delete_doctor);
        btnDeleteDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete currently selected doctor in the doctors spinner
                deleteDoctor();
            }
        });

        Button btnDeletePatient = findViewById(R.id.btn_delete_patient);
        btnDeletePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete currently selected patient in the patients spinner
                deletePatient();
            }
        });

        Button logout = findViewById(R.id.btn_sign_out);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sign out and navigate to MainActivity
                FirebaseAuth.getInstance().signOut();
                Intent navigateToMainActivity = new Intent(AdminActivity.this, MainActivity.class);
                startActivity(navigateToMainActivity);
                finish(); // Close this activity
            }
        });
    }

    private void populateDoctorsSpinner() {
        doctorsRef.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                List<String> doctorsList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String doctorName = snapshot.child("name").getValue(String.class);
                    doctorsList.add(doctorName);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AdminActivity.this, android.R.layout.simple_spinner_item, doctorsList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                doctorsSpinner.setAdapter(adapter);
            }
        });
    }

    private void populatePatientsSpinner() {
        patientsRef.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                List<String> patientsList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String patientName = snapshot.child("name").getValue(String.class);
                    patientsList.add(patientName);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AdminActivity.this, android.R.layout.simple_spinner_item, patientsList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                patientsSpinner.setAdapter(adapter);
            }
        });
    }

    private void deleteDoctor() {
        String selectedDoctor = (String) doctorsSpinner.getSelectedItem();
        // Get the key of the selected doctor
        doctorsRef.orderByChild("name").equalTo(selectedDoctor).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    snapshot.getRef().removeValue(); // Remove the selected doctor from the database
                    populateDoctorsSpinner(); // Refresh the doctors spinner
                    showToast(selectedDoctor + " has been deleted.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
    }

    private void deletePatient() {
        String selectedPatient = (String) patientsSpinner.getSelectedItem();
        // Get the key of the selected patient
        patientsRef.orderByChild("name").equalTo(selectedPatient).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    snapshot.getRef().removeValue(); // Remove the selected patient from the database
                    populatePatientsSpinner(); // Refresh the patients spinner
                    showToast(selectedPatient + " has been deleted.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(AdminActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}
