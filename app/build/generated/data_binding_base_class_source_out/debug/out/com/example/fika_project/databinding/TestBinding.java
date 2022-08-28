// Generated by view binder compiler. Do not edit!
package com.example.fika_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fika_project.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TestBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ImageView courseDetailDramaBackBtn;

  @NonNull
  public final ImageView courseDetailIvByDrama;

  @NonNull
  public final TextView courseDetailLocageTiltleByDrama;

  @NonNull
  public final TextView detailCourseHashTvByDrama;

  @NonNull
  public final RecyclerView detailCourseLocationRecyclerview;

  @NonNull
  public final RecyclerView detailCourseTogetherRecyclerview;

  @NonNull
  public final TextView dwdwedddsa;

  @NonNull
  public final LinearLayout filterDramaSortingBtn;

  @NonNull
  public final ImageView imageView14;

  @NonNull
  public final ImageView imageView16;

  @NonNull
  public final ImageView imageView17;

  @NonNull
  public final TextView textView27;

  @NonNull
  public final TextView textView30;

  @NonNull
  public final TextView textView31;

  @NonNull
  public final TextView textView33;

  private TestBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout constraintLayout, @NonNull ImageView courseDetailDramaBackBtn,
      @NonNull ImageView courseDetailIvByDrama, @NonNull TextView courseDetailLocageTiltleByDrama,
      @NonNull TextView detailCourseHashTvByDrama,
      @NonNull RecyclerView detailCourseLocationRecyclerview,
      @NonNull RecyclerView detailCourseTogetherRecyclerview, @NonNull TextView dwdwedddsa,
      @NonNull LinearLayout filterDramaSortingBtn, @NonNull ImageView imageView14,
      @NonNull ImageView imageView16, @NonNull ImageView imageView17, @NonNull TextView textView27,
      @NonNull TextView textView30, @NonNull TextView textView31, @NonNull TextView textView33) {
    this.rootView = rootView;
    this.constraintLayout = constraintLayout;
    this.courseDetailDramaBackBtn = courseDetailDramaBackBtn;
    this.courseDetailIvByDrama = courseDetailIvByDrama;
    this.courseDetailLocageTiltleByDrama = courseDetailLocageTiltleByDrama;
    this.detailCourseHashTvByDrama = detailCourseHashTvByDrama;
    this.detailCourseLocationRecyclerview = detailCourseLocationRecyclerview;
    this.detailCourseTogetherRecyclerview = detailCourseTogetherRecyclerview;
    this.dwdwedddsa = dwdwedddsa;
    this.filterDramaSortingBtn = filterDramaSortingBtn;
    this.imageView14 = imageView14;
    this.imageView16 = imageView16;
    this.imageView17 = imageView17;
    this.textView27 = textView27;
    this.textView30 = textView30;
    this.textView31 = textView31;
    this.textView33 = textView33;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TestBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.test, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TestBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.course_detail_drama_back_btn;
      ImageView courseDetailDramaBackBtn = ViewBindings.findChildViewById(rootView, id);
      if (courseDetailDramaBackBtn == null) {
        break missingId;
      }

      id = R.id.course_detail_iv_by_drama;
      ImageView courseDetailIvByDrama = ViewBindings.findChildViewById(rootView, id);
      if (courseDetailIvByDrama == null) {
        break missingId;
      }

      id = R.id.course_detail_locage_tiltle_by_drama;
      TextView courseDetailLocageTiltleByDrama = ViewBindings.findChildViewById(rootView, id);
      if (courseDetailLocageTiltleByDrama == null) {
        break missingId;
      }

      id = R.id.detail_course_hash_tv_by_drama;
      TextView detailCourseHashTvByDrama = ViewBindings.findChildViewById(rootView, id);
      if (detailCourseHashTvByDrama == null) {
        break missingId;
      }

      id = R.id.detail_course_location_recyclerview;
      RecyclerView detailCourseLocationRecyclerview = ViewBindings.findChildViewById(rootView, id);
      if (detailCourseLocationRecyclerview == null) {
        break missingId;
      }

      id = R.id.detail_course_together_recyclerview;
      RecyclerView detailCourseTogetherRecyclerview = ViewBindings.findChildViewById(rootView, id);
      if (detailCourseTogetherRecyclerview == null) {
        break missingId;
      }

      id = R.id.dwdwedddsa;
      TextView dwdwedddsa = ViewBindings.findChildViewById(rootView, id);
      if (dwdwedddsa == null) {
        break missingId;
      }

      id = R.id.filter_drama_sorting_btn;
      LinearLayout filterDramaSortingBtn = ViewBindings.findChildViewById(rootView, id);
      if (filterDramaSortingBtn == null) {
        break missingId;
      }

      id = R.id.imageView14;
      ImageView imageView14 = ViewBindings.findChildViewById(rootView, id);
      if (imageView14 == null) {
        break missingId;
      }

      id = R.id.imageView16;
      ImageView imageView16 = ViewBindings.findChildViewById(rootView, id);
      if (imageView16 == null) {
        break missingId;
      }

      id = R.id.imageView17;
      ImageView imageView17 = ViewBindings.findChildViewById(rootView, id);
      if (imageView17 == null) {
        break missingId;
      }

      id = R.id.textView27;
      TextView textView27 = ViewBindings.findChildViewById(rootView, id);
      if (textView27 == null) {
        break missingId;
      }

      id = R.id.textView30;
      TextView textView30 = ViewBindings.findChildViewById(rootView, id);
      if (textView30 == null) {
        break missingId;
      }

      id = R.id.textView31;
      TextView textView31 = ViewBindings.findChildViewById(rootView, id);
      if (textView31 == null) {
        break missingId;
      }

      id = R.id.textView33;
      TextView textView33 = ViewBindings.findChildViewById(rootView, id);
      if (textView33 == null) {
        break missingId;
      }

      return new TestBinding((ConstraintLayout) rootView, constraintLayout,
          courseDetailDramaBackBtn, courseDetailIvByDrama, courseDetailLocageTiltleByDrama,
          detailCourseHashTvByDrama, detailCourseLocationRecyclerview,
          detailCourseTogetherRecyclerview, dwdwedddsa, filterDramaSortingBtn, imageView14,
          imageView16, imageView17, textView27, textView30, textView31, textView33);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
