package com.example.fika_project.ui.main.explore.course_detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002/0B%\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001aH\u0016J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010\'\u001a\u00020\u001cH\u0016J\u0018\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0016R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u00061"}, d2 = {"Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailLocationOthersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/example/fika_project/ui/main/hold_and_scrap/LocationHoldView;", "locationList", "Ljava/util/ArrayList;", "Lcom/example/fika_project/ui/main/explore/course_detail/spotList;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "checkStateList", "", "", "getCheckStateList", "()[Ljava/lang/Boolean;", "setCheckStateList", "([Ljava/lang/Boolean;)V", "[Ljava/lang/Boolean;", "getContext", "()Landroid/content/Context;", "itemClickListener", "Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailLocationOthersAdapter$OnItemClickListener;", "getLocationList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onExploreFailure", "code", "message", "", "onExploreLoading", "onExploreSuccess", "response", "Lcom/example/fika_project/ui/main/hold_and_scrap/LocationHoldResponse;", "iv", "Landroid/widget/ImageView;", "setItemClickListener", "onItemClickListener", "CustomViewHolder", "OnItemClickListener", "app_debug"})
public final class CourseDetailLocationOthersAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> implements com.example.fika_project.ui.main.hold_and_scrap.LocationHoldView {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.fika_project.ui.main.explore.course_detail.spotList> locationList = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private com.example.fika_project.ui.main.explore.course_detail.CourseDetailLocationOthersAdapter.OnItemClickListener itemClickListener;
    @org.jetbrains.annotations.NotNull()
    private java.lang.Boolean[] checkStateList;
    
    public CourseDetailLocationOthersAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.fika_project.ui.main.explore.course_detail.spotList> locationList, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.fika_project.ui.main.explore.course_detail.spotList> getLocationList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Boolean[] getCheckStateList() {
        return null;
    }
    
    public final void setCheckStateList(@org.jetbrains.annotations.NotNull()
    java.lang.Boolean[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.explore.course_detail.CourseDetailLocationOthersAdapter.OnItemClickListener onItemClickListener) {
    }
    
    @java.lang.Override()
    public void onExploreLoading() {
    }
    
    @java.lang.Override()
    public void onExploreSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.hold_and_scrap.LocationHoldResponse response, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView iv) {
    }
    
    @java.lang.Override()
    public void onExploreFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a2\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailLocationOthersAdapter$OnItemClickListener;", "", "notClick", "", "view", "Landroid/view/View;", "position", "", "list", "", "", "(Landroid/view/View;I[Ljava/lang/Boolean;)V", "onClick", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position, @org.jetbrains.annotations.NotNull()
        java.lang.Boolean[] list);
        
        public abstract void notClick(@org.jetbrains.annotations.NotNull()
        android.view.View view, int position, @org.jetbrains.annotations.NotNull()
        java.lang.Boolean[] list);
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
        public static final class DefaultImpls {
            
            public static void onClick(@org.jetbrains.annotations.NotNull()
            com.example.fika_project.ui.main.explore.course_detail.CourseDetailLocationOthersAdapter.OnItemClickListener $this, @org.jetbrains.annotations.NotNull()
            android.view.View view, int position, @org.jetbrains.annotations.NotNull()
            java.lang.Boolean[] list) {
            }
            
            public static void notClick(@org.jetbrains.annotations.NotNull()
            com.example.fika_project.ui.main.explore.course_detail.CourseDetailLocationOthersAdapter.OnItemClickListener $this, @org.jetbrains.annotations.NotNull()
            android.view.View view, int position, @org.jetbrains.annotations.NotNull()
            java.lang.Boolean[] list) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailLocationOthersAdapter$CustomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailLocationOthersAdapter;Landroid/view/View;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "app_debug"})
    public final class CustomViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.view.View view;
        
        public CustomViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getView() {
            return null;
        }
        
        public final void setView(@org.jetbrains.annotations.NotNull()
        android.view.View p0) {
        }
    }
}