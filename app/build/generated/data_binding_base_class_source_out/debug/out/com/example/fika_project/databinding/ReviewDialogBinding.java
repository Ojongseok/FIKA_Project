// Generated by view binder compiler. Do not edit!
package com.example.fika_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fika_project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ReviewDialogBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button sejongLoginDialogNo;

  @NonNull
  public final TextView sejongLoginDialogTv;

  @NonNull
  public final Button sejongLoginDialogYes;

  private ReviewDialogBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button sejongLoginDialogNo, @NonNull TextView sejongLoginDialogTv,
      @NonNull Button sejongLoginDialogYes) {
    this.rootView = rootView;
    this.sejongLoginDialogNo = sejongLoginDialogNo;
    this.sejongLoginDialogTv = sejongLoginDialogTv;
    this.sejongLoginDialogYes = sejongLoginDialogYes;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ReviewDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ReviewDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.review_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ReviewDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.sejong_login_dialog_no;
      Button sejongLoginDialogNo = ViewBindings.findChildViewById(rootView, id);
      if (sejongLoginDialogNo == null) {
        break missingId;
      }

      id = R.id.sejong_login_dialog_tv;
      TextView sejongLoginDialogTv = ViewBindings.findChildViewById(rootView, id);
      if (sejongLoginDialogTv == null) {
        break missingId;
      }

      id = R.id.sejong_login_dialog_yes;
      Button sejongLoginDialogYes = ViewBindings.findChildViewById(rootView, id);
      if (sejongLoginDialogYes == null) {
        break missingId;
      }

      return new ReviewDialogBinding((ConstraintLayout) rootView, sejongLoginDialogNo,
          sejongLoginDialogTv, sejongLoginDialogYes);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}