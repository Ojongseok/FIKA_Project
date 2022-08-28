package com.example.fika_project.ui.main.explore;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0014J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/fika_project/ui/main/explore/CourseDetailDrama;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailView;", "()V", "_Binding", "Lcom/example/fika_project/databinding/ActivityCourseDetailDramaBinding;", "binding", "getBinding", "()Lcom/example/fika_project/databinding/ActivityCourseDetailDramaBinding;", "dramaAdapter", "Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailDramaAdapter;", "getDramaAdapter", "()Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailDramaAdapter;", "setDramaAdapter", "(Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailDramaAdapter;)V", "listOfYear", "Ljava/util/ArrayList;", "Lcom/example/fika_project/ui/main/SpinnerModel;", "initData", "", "initList", "Lcom/example/fika_project/ui/main/explore/course_detail/result;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onExploreFailure", "code", "", "message", "", "onExploreLoading", "onExploreSuccess", "response", "Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailResponse;", "setOnClickEvent", "app_debug"})
public final class CourseDetailDrama extends androidx.appcompat.app.AppCompatActivity implements com.example.fika_project.ui.main.explore.course_detail.CourseDetailView {
    private com.example.fika_project.databinding.ActivityCourseDetailDramaBinding _Binding;
    private final java.util.ArrayList<com.example.fika_project.ui.main.SpinnerModel> listOfYear = null;
    public com.example.fika_project.ui.main.explore.course_detail.CourseDetailDramaAdapter dramaAdapter;
    private java.util.HashMap _$_findViewCache;
    
    public CourseDetailDrama() {
        super();
    }
    
    private final com.example.fika_project.databinding.ActivityCourseDetailDramaBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.fika_project.ui.main.explore.course_detail.CourseDetailDramaAdapter getDramaAdapter() {
        return null;
    }
    
    public final void setDramaAdapter(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.explore.course_detail.CourseDetailDramaAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initData(com.example.fika_project.ui.main.explore.course_detail.result initList) {
    }
    
    private final void setOnClickEvent() {
    }
    
    @java.lang.Override()
    public void onExploreSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.explore.course_detail.CourseDetailResponse response) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onExploreLoading() {
    }
    
    @java.lang.Override()
    public void onExploreFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}