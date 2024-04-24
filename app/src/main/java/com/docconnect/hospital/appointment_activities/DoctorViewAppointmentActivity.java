package com.docconnect.hospital.appointment_activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.docconnect.hospital.R;
import com.docconnect.hospital.user_information.HealthInformation;
import com.docconnect.hospital.user_information.Patient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class DoctorViewAppointmentActivity extends AppCompatActivity {

    FirebaseAuth auth;
    TextView appointmentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view_appointment);

        auth = FirebaseAuth.getInstance();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("See Upcoming Appointments");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2E5DA3")));

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot appointmentsSnapshot = snapshot.child("Appointments");
                String doctorID = auth.getUid();

                ArrayList<Date> upcomingAppointmentDates = new ArrayList<Date>();
                ArrayList<Appointment> upcomingAppointments = new ArrayList<Appointment>();

                for (DataSnapshot appointment:appointmentsSnapshot.getChildren()){
                    Appointment apt = appointment.getValue(Appointment.class);
                    Date appointmentDate = apt.getStartTime();
                    upcomingAppointmentDates.add(appointmentDate);
                }
                Collections.sort(upcomingAppointmentDates);

                for (Date date:upcomingAppointmentDates){
                    for (DataSnapshot appointment:appointmentsSnapshot.getChildren()){
                        Appointment apt = appointment.getValue(Appointment.class);
                        if (date.equals(apt.getStartTime())
                                && doctorID.equals(apt.getDoctorID())
                                && !upcomingAppointments.contains(apt)){
                            upcomingAppointments.add(apt);
                        }
                    }
                }

                for(Appointment apt:upcomingAppointments){
                    //If the doctorID of an appointment matches the doctorID of the current doctor, the appointment will be retrieved
                    getAppointment(apt.getStartTime(), apt.getPatientID());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void getAppointment(Date date, String patientID){

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("patients");
        LinearLayout layout = (LinearLayout) findViewById(R.id.doctor_appointment_list);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot patient:snapshot.getChildren()){
                    Patient pat = patient.getValue(Patient.class);

                    if (patientID.equals(patient.getKey())){
                        appointmentInfo = new TextView(DoctorViewAppointmentActivity.this);

                        Calendar currentTime = Calendar.getInstance();
                        Date currentDate = currentTime.getTime();

                        //An if statement to ensure only future appointment dates are displayed
                        if (date.compareTo(currentDate) > 0){
                            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d 'at' h:mm a");
                            String time = dateFormat.format(date);
                            appointmentInfo.setText(time + " with " + pat.getName() + "\n");
                            Resources resource = (Resources) getBaseContext().getResources();
                            ColorStateList csl = (ColorStateList) resource.getColorStateList(R.color.black);
                            appointmentInfo.setTextColor(csl);
                            appointmentInfo.setTextSize(15);
                            appointmentInfo.setPadding(16,16,16,16);
//                            appointmentInfo.setGravity(Gravity.CENTER);
                            layout.addView(appointmentInfo);

                            appointmentInfo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // Show an input dialog to prompt the user to enter the prescription
                                    AlertDialog.Builder builder = new AlertDialog.Builder(DoctorViewAppointmentActivity.this);
                                    builder.setTitle("Enter Prescription");

                                    // Set up the input
                                    final EditText input = new EditText(DoctorViewAppointmentActivity.this);
                                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                                    builder.setView(input);

                                    // Set up the buttons
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String prescription = input.getText().toString().trim();
                                            if (!prescription.isEmpty()) {
                                                // Append the prescription to the existing prescription in Firebase
                                                DatabaseReference patientRef = FirebaseDatabase.getInstance().getReference().child("patients").child(patientID);
                                                patientRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                        Patient patient = snapshot.getValue(Patient.class);
                                                        if (patient != null) {
                                                            HealthInformation healthInformation = patient.getHealthInformation();
                                                            if (healthInformation != null) {
                                                                String existingPrescription = healthInformation.getPrescription();
                                                                String updatedPrescription;
                                                                if (existingPrescription.isEmpty()) {
                                                                    updatedPrescription = prescription;
                                                                } else {
                                                                    updatedPrescription = existingPrescription + "\n" + prescription;
                                                                }
                                                                healthInformation.setPrescription(updatedPrescription);
                                                                // Update the prescription in Firebase
                                                                patientRef.child("healthInformation").setValue(healthInformation);
                                                                Toast.makeText(DoctorViewAppointmentActivity.this, "Prescription added successfully", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError error) {
                                                        Toast.makeText(DoctorViewAppointmentActivity.this, "Failed to add prescription", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            } else {
                                                Toast.makeText(DoctorViewAppointmentActivity.this, "Please enter a prescription", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });

                                    builder.show();
                                }
                            });

                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}