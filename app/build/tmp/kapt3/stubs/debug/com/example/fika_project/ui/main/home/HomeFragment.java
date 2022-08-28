package com.example.fika_project.ui.main.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020\u00162\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$H\u0002J \u0010%\u001a\u00020\u00162\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\'0\"j\b\u0012\u0004\u0012\u00020\'`$H\u0002J \u0010(\u001a\u00020\u00162\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020*0\"j\b\u0012\u0004\u0012\u00020*`$H\u0002J \u0010+\u001a\u00020\u00162\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020-0\"j\b\u0012\u0004\u0012\u00020-`$H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006."}, d2 = {"Lcom/example/fika_project/ui/main/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/fika_project/ui/main/home/HomeView;", "()V", "_binding", "Lcom/example/fika_project/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/example/fika_project/databinding/FragmentHomeBinding;", "service", "Lcom/example/fika_project/ui/main/home/HomeService;", "getService", "()Lcom/example/fika_project/ui/main/home/HomeService;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onHomeFailure", "code", "", "message", "", "onHomeLoading", "onHomeSuccess", "response", "Lcom/example/fika_project/ui/main/home/HomeResponse;", "setCourseRVAdapter", "scrapCourserankList", "Ljava/util/ArrayList;", "Lcom/example/fika_project/ui/main/home/coursesSortBySaved;", "Lkotlin/collections/ArrayList;", "setDramaRankRVAdapter", "dramaRankList", "Lcom/example/fika_project/ui/main/home/dramaList;", "setMyCourseRVAdapter", "courseList", "Lcom/example/fika_project/ui/main/home/myCourseList;", "setPlaceRankRVAdapter", "placeRankList", "Lcom/example/fika_project/ui/main/home/spotsSortBySaved;", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment implements com.example.fika_project.ui.main.home.HomeView {
    private com.example.fika_project.databinding.FragmentHomeBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final com.example.fika_project.ui.main.home.HomeService service = null;
    private java.util.HashMap _$_findViewCache;
    
    public HomeFragment() {
        super();
    }
    
    private final com.example.fika_project.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.fika_project.ui.main.home.HomeService getService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setMyCourseRVAdapter(java.util.ArrayList<com.example.fika_project.ui.main.home.myCourseList> courseList) {
    }
    
    private final void setDramaRankRVAdapter(java.util.ArrayList<com.example.fika_project.ui.main.home.dramaList> dramaRankList) {
    }
    
    private final void setCourseRVAdapter(java.util.ArrayList<com.example.fika_project.ui.main.home.coursesSortBySaved> scrapCourserankList) {
    }
    
    private final void setPlaceRankRVAdapter(java.util.ArrayList<com.example.fika_project.ui.main.home.spotsSortBySaved> placeRankList) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onHomeLoading() {
    }
    
    @java.lang.Override()
    public void onHomeSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.home.HomeResponse response) {
    }
    
    @java.lang.Override()
    public void onHomeFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}