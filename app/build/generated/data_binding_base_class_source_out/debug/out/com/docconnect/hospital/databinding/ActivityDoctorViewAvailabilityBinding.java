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

public final class ActivityDoctorViewAvailabilityBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout availableTimeSlots;

  @NonNull
  public final ScrollView scrollView3;

  @NonNull
  public final TextView textView5;

  private ActivityDoctorViewAvailabilityBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout availableTimeSlots, @NonNull ScrollView scrollView3,
      @NonNull TextView textView5) {
    this.rootView = rootView;
    this.availableTimeSlots = availableTimeSlots;
    this.scrollView3 = scrollView3;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDoctorViewAvailabilityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDoctorViewAvailabilityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_doctor_view_availability, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDoctorViewAvailabilityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.available_time_slots;
      LinearLayout availableTimeSlots = ViewBindings.findChildViewById(rootView, id);
      if (availableTimeSlots == null) {
        break missingId;
      }

      id = R.id.scrollView3;
      ScrollView scrollView3 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView3 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new ActivityDoctorViewAvailabilityBinding((LinearLayout) rootView, availableTimeSlots,
          scrollView3, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}