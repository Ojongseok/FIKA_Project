package com.example.fika_project.ui.main.mycourse;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/example/fika_project/ui/main/mycourse/MyCourseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/fika_project/ui/main/mycourse/MyCourseView;", "()V", "binding", "Lcom/example/fika_project/databinding/FragmentMycourseBinding;", "data", "", "Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Item;", "service", "Lcom/example/fika_project/ui/main/mycourse/MyCourseService;", "getService", "()Lcom/example/fika_project/ui/main/mycourse/MyCourseService;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onMyCourseLoading", "", "onMyCourseSuccess", "response", "Lcom/example/fika_project/ui/main/mycourse/MyCourseResponse;", "onViewCreated", "view", "app_debug"})
public final class MyCourseFragment extends androidx.fragment.app.Fragment implements com.example.fika_project.ui.main.mycourse.MyCourseView {
    private com.example.fika_project.databinding.FragmentMycourseBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final com.example.fika_project.ui.main.mycourse.MyCourseService service = null;
    private final java.util.List<com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item> data = null;
    private java.util.HashMap _$_findViewCache;
    
    public MyCourseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.fika_project.ui.main.mycourse.MyCourseService getService() {
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
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onMyCourseLoading() {
    }
    
    @java.lang.Override()
    public void onMyCourseSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.mycourse.MyCourseResponse response) {
    }
}