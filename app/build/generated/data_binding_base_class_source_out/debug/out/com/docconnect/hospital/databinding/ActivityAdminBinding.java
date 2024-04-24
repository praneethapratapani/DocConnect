// Generated by view binder compiler. Do not edit!
package com.docconnect.hospital.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.docconnect.hospital.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAdminBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout adminActions;

  @NonNull
  public final TextView adminWelcome;

  @NonNull
  public final Button btnDeleteDoctor;

  @NonNull
  public final Button btnDeletePatient;

  @NonNull
  public final Button btnSignOut;

  @NonNull
  public final Spinner doctorsSpinner;

  @NonNull
  public final Spinner patientsSpinner;

  private ActivityAdminBinding(@NonNull RelativeLayout rootView, @NonNull LinearLayout adminActions,
      @NonNull TextView adminWelcome, @NonNull Button btnDeleteDoctor,
      @NonNull Button btnDeletePatient, @NonNull Button btnSignOut, @NonNull Spinner doctorsSpinner,
      @NonNull Spinner patientsSpinner) {
    this.rootView = rootView;
    this.adminActions = adminActions;
    this.adminWelcome = adminWelcome;
    this.btnDeleteDoctor = btnDeleteDoctor;
    this.btnDeletePatient = btnDeletePatient;
    this.btnSignOut = btnSignOut;
    this.doctorsSpinner = doctorsSpinner;
    this.patientsSpinner = patientsSpinner;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdminBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdminBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_admin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdminBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.admin_actions;
      LinearLayout adminActions = ViewBindings.findChildViewById(rootView, id);
      if (adminActions == null) {
        break missingId;
      }

      id = R.id.admin_welcome;
      TextView adminWelcome = ViewBindings.findChildViewById(rootView, id);
      if (adminWelcome == null) {
        break missingId;
      }

      id = R.id.btn_delete_doctor;
      Button btnDeleteDoctor = ViewBindings.findChildViewById(rootView, id);
      if (btnDeleteDoctor == null) {
        break missingId;
      }

      id = R.id.btn_delete_patient;
      Button btnDeletePatient = ViewBindings.findChildViewById(rootView, id);
      if (btnDeletePatient == null) {
        break missingId;
      }

      id = R.id.btn_sign_out;
      Button btnSignOut = ViewBindings.findChildViewById(rootView, id);
      if (btnSignOut == null) {
        break missingId;
      }

      id = R.id.doctors_spinner;
      Spinner doctorsSpinner = ViewBindings.findChildViewById(rootView, id);
      if (doctorsSpinner == null) {
        break missingId;
      }

      id = R.id.patients_spinner;
      Spinner patientsSpinner = ViewBindings.findChildViewById(rootView, id);
      if (patientsSpinner == null) {
        break missingId;
      }

      return new ActivityAdminBinding((RelativeLayout) rootView, adminActions, adminWelcome,
          btnDeleteDoctor, btnDeletePatient, btnSignOut, doctorsSpinner, patientsSpinner);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
