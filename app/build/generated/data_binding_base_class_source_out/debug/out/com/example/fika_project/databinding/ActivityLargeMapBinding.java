// Generated by view binder compiler. Do not edit!
package com.example.fika_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fika_project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLargeMapBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final FrameLayout largeMap;

  @NonNull
  public final CardView largeMapBottomView;

  @NonNull
  public final TextView largeMapTitleName;

  @NonNull
  public final ImageView myholdBackBtn;

  @NonNull
  public final ImageView myholdHomeBtn;

  @NonNull
  public final FrameLayout myholdTitleBar;

  @NonNull
  public final FrameLayout viewpagerContainer;

  private ActivityLargeMapBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageView,
      @NonNull FrameLayout largeMap, @NonNull CardView largeMapBottomView,
      @NonNull TextView largeMapTitleName, @NonNull ImageView myholdBackBtn,
      @NonNull ImageView myholdHomeBtn, @NonNull FrameLayout myholdTitleBar,
      @NonNull FrameLayout viewpagerContainer) {
    this.rootView = rootView;
    this.imageView = imageView;
    this.largeMap = largeMap;
    this.largeMapBottomView = largeMapBottomView;
    this.largeMapTitleName = largeMapTitleName;
    this.myholdBackBtn = myholdBackBtn;
    this.myholdHomeBtn = myholdHomeBtn;
    this.myholdTitleBar = myholdTitleBar;
    this.viewpagerContainer = viewpagerContainer;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLargeMapBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLargeMapBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_large_map, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLargeMapBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.large_map;
      FrameLayout largeMap = ViewBindings.findChildViewById(rootView, id);
      if (largeMap == null) {
        break missingId;
      }

      id = R.id.large_map_bottom_view;
      CardView largeMapBottomView = ViewBindings.findChildViewById(rootView, id);
      if (largeMapBottomView == null) {
        break missingId;
      }

      id = R.id.large_map_title_name;
      TextView largeMapTitleName = ViewBindings.findChildViewById(rootView, id);
      if (largeMapTitleName == null) {
        break missingId;
      }

      id = R.id.myhold_back_btn;
      ImageView myholdBackBtn = ViewBindings.findChildViewById(rootView, id);
      if (myholdBackBtn == null) {
        break missingId;
      }

      id = R.id.myhold_home_btn;
      ImageView myholdHomeBtn = ViewBindings.findChildViewById(rootView, id);
      if (myholdHomeBtn == null) {
        break missingId;
      }

      id = R.id.myhold_title_bar;
      FrameLayout myholdTitleBar = ViewBindings.findChildViewById(rootView, id);
      if (myholdTitleBar == null) {
        break missingId;
      }

      id = R.id.viewpager_container;
      FrameLayout viewpagerContainer = ViewBindings.findChildViewById(rootView, id);
      if (viewpagerContainer == null) {
        break missingId;
      }

      return new ActivityLargeMapBinding((ConstraintLayout) rootView, imageView, largeMap,
          largeMapBottomView, largeMapTitleName, myholdBackBtn, myholdHomeBtn, myholdTitleBar,
          viewpagerContainer);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}