// Generated by view binder compiler. Do not edit!
package com.docconnect.hospital.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.docconnect.hospital.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginPageBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView emailError;

  @NonNull
  public final TextInputEditText emailText;

  @NonNull
  public final TextView existedUser;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final TextInputLayout loginEmail;

  @NonNull
  public final TextInputLayout loginPassword;

  @NonNull
  public final ProgressBar loginProgressBar;

  @NonNull
  public final TextView passwordError;

  @NonNull
  public final TextInputEditText passwordText;

  @NonNull
  public final Button signinAdmin;

  @NonNull
  public final Button signupDoctor;

  @NonNull
  public final Button signupPatient;

  private ActivityLoginPageBinding(@NonNull RelativeLayout rootView, @NonNull TextView emailError,
      @NonNull TextInputEditText emailText, @NonNull TextView existedUser,
      @NonNull Button loginButton, @NonNull TextInputLayout loginEmail,
      @NonNull TextInputLayout loginPassword, @NonNull ProgressBar loginProgressBar,
      @NonNull TextView passwordError, @NonNull TextInputEditText passwordText,
      @NonNull Button signinAdmin, @NonNull Button signupDoctor, @NonNull Button signupPatient) {
    this.rootView = rootView;
    this.emailError = emailError;
    this.emailText = emailText;
    this.existedUser = existedUser;
    this.loginButton = loginButton;
    this.loginEmail = loginEmail;
    this.loginPassword = loginPassword;
    this.loginProgressBar = loginProgressBar;
    this.passwordError = passwordError;
    this.passwordText = passwordText;
    this.signinAdmin = signinAdmin;
    this.signupDoctor = signupDoctor;
    this.signupPatient = signupPatient;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.email_error;
      TextView emailError = ViewBindings.findChildViewById(rootView, id);
      if (emailError == null) {
        break missingId;
      }

      id = R.id.email_text;
      TextInputEditText emailText = ViewBindings.findChildViewById(rootView, id);
      if (emailText == null) {
        break missingId;
      }

      id = R.id.existedUser;
      TextView existedUser = ViewBindings.findChildViewById(rootView, id);
      if (existedUser == null) {
        break missingId;
      }

      id = R.id.login_button;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.login_email;
      TextInputLayout loginEmail = ViewBindings.findChildViewById(rootView, id);
      if (loginEmail == null) {
        break missingId;
      }

      id = R.id.login_password;
      TextInputLayout loginPassword = ViewBindings.findChildViewById(rootView, id);
      if (loginPassword == null) {
        break missingId;
      }

      id = R.id.login_progressBar;
      ProgressBar loginProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (loginProgressBar == null) {
        break missingId;
      }

      id = R.id.password_error;
      TextView passwordError = ViewBindings.findChildViewById(rootView, id);
      if (passwordError == null) {
        break missingId;
      }

      id = R.id.password_text;
      TextInputEditText passwordText = ViewBindings.findChildViewById(rootView, id);
      if (passwordText == null) {
        break missingId;
      }

      id = R.id.signin_admin;
      Button signinAdmin = ViewBindings.findChildViewById(rootView, id);
      if (signinAdmin == null) {
        break missingId;
      }

      id = R.id.signup_doctor;
      Button signupDoctor = ViewBindings.findChildViewById(rootView, id);
      if (signupDoctor == null) {
        break missingId;
      }

      id = R.id.signup_patient;
      Button signupPatient = ViewBindings.findChildViewById(rootView, id);
      if (signupPatient == null) {
        break missingId;
      }

      return new ActivityLoginPageBinding((RelativeLayout) rootView, emailError, emailText,
          existedUser, loginButton, loginEmail, loginPassword, loginProgressBar, passwordError,
          passwordText, signinAdmin, signupDoctor, signupPatient);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
