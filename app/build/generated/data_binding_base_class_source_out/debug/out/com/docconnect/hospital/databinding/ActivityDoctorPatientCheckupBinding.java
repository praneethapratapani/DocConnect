// Generated by view binder compiler. Do not edit!
package com.docconnect.hospital.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.docconnect.hospital.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDoctorPatientCheckupBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout patientList;

  @NonNull
  public final ScrollView scrollView2;

  @NonNull
  public final TextView textView7;

  private ActivityDoctorPatientCheckupBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout patientList, @NonNull ScrollView scrollView2,
      @NonNull TextView textView7) {
    this.rootView = rootView;
    this.patientList = patientList;
    this.scrollView2 = scrollView2;
    this.textView7 = textView7;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDoctorPatientCheckupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDoctorPatientCheckupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_doctor_patient_checkup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDoctorPatientCheckupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.patient_list;
      LinearLayout patientList = ViewBindings.findChildViewById(rootView, id);
      if (patientList == null) {
        break missingId;
      }

      id = R.id.scrollView2;
      ScrollView scrollView2 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView2 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      return new ActivityDoctorPatientCheckupBinding((LinearLayout) rootView, patientList,
          scrollView2, textView7);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
