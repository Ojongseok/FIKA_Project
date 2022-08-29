// Generated by view binder compiler. Do not edit!
package com.example.fika_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class FragmentExploreCoursePageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView exploreCoursePageRecyclerview;

  @NonNull
  public final TextView exploreCoursepageSearchNumber;

  @NonNull
  public final TextView filerCourseTv1;

  @NonNull
  public final LinearLayout filterCoursePageBtn1;

  @NonNull
  public final LinearLayout filterCoursePageBtn2;

  @NonNull
  public final LinearLayout filterCourseSortingBtn;

  @NonNull
  public final TextView filterCourseTv2;

  @NonNull
  public final TextView filterSortTvCourse;

  @NonNull
  public final TextView textView24;

  private FragmentExploreCoursePageBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView exploreCoursePageRecyclerview,
      @NonNull TextView exploreCoursepageSearchNumber, @NonNull TextView filerCourseTv1,
      @NonNull LinearLayout filterCoursePageBtn1, @NonNull LinearLayout filterCoursePageBtn2,
      @NonNull LinearLayout filterCourseSortingBtn, @NonNull TextView filterCourseTv2,
      @NonNull TextView filterSortTvCourse, @NonNull TextView textView24) {
    this.rootView = rootView;
    this.exploreCoursePageRecyclerview = exploreCoursePageRecyclerview;
    this.exploreCoursepageSearchNumber = exploreCoursepageSearchNumber;
    this.filerCourseTv1 = filerCourseTv1;
    this.filterCoursePageBtn1 = filterCoursePageBtn1;
    this.filterCoursePageBtn2 = filterCoursePageBtn2;
    this.filterCourseSortingBtn = filterCourseSortingBtn;
    this.filterCourseTv2 = filterCourseTv2;
    this.filterSortTvCourse = filterSortTvCourse;
    this.textView24 = textView24;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentExploreCoursePageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentExploreCoursePageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_explore_course_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentExploreCoursePageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.explore_course_page_recyclerview;
      RecyclerView exploreCoursePageRecyclerview = ViewBindings.findChildViewById(rootView, id);
      if (exploreCoursePageRecyclerview == null) {
        break missingId;
      }

      id = R.id.explore_coursepage_search_number;
      TextView exploreCoursepageSearchNumber = ViewBindings.findChildViewById(rootView, id);
      if (exploreCoursepageSearchNumber == null) {
        break missingId;
      }

      id = R.id.filer_course_tv_1;
      TextView filerCourseTv1 = ViewBindings.findChildViewById(rootView, id);
      if (filerCourseTv1 == null) {
        break missingId;
      }

      id = R.id.filter_course_page_btn_1;
      LinearLayout filterCoursePageBtn1 = ViewBindings.findChildViewById(rootView, id);
      if (filterCoursePageBtn1 == null) {
        break missingId;
      }

      id = R.id.filter_course_page_btn_2;
      LinearLayout filterCoursePageBtn2 = ViewBindings.findChildViewById(rootView, id);
      if (filterCoursePageBtn2 == null) {
        break missingId;
      }

      id = R.id.filter_course_sorting_btn;
      LinearLayout filterCourseSortingBtn = ViewBindings.findChildViewById(rootView, id);
      if (filterCourseSortingBtn == null) {
        break missingId;
      }

      id = R.id.filter_course_tv_2;
      TextView filterCourseTv2 = ViewBindings.findChildViewById(rootView, id);
      if (filterCourseTv2 == null) {
        break missingId;
      }

      id = R.id.filter_sort_tv_course;
      TextView filterSortTvCourse = ViewBindings.findChildViewById(rootView, id);
      if (filterSortTvCourse == null) {
        break missingId;
      }

      id = R.id.textView24;
      TextView textView24 = ViewBindings.findChildViewById(rootView, id);
      if (textView24 == null) {
        break missingId;
      }

      return new FragmentExploreCoursePageBinding((ConstraintLayout) rootView,
          exploreCoursePageRecyclerview, exploreCoursepageSearchNumber, filerCourseTv1,
          filterCoursePageBtn1, filterCoursePageBtn2, filterCourseSortingBtn, filterCourseTv2,
          filterSortTvCourse, textView24);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}