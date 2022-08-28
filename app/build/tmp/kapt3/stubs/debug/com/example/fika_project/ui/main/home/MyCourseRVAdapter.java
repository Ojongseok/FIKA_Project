package com.example.fika_project.ui.main.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003&\'(B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000bH\u0016J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0015J\u0014\u0010#\u001a\u00020$*\u00020\u001f2\u0006\u0010%\u001a\u00020\u000bH\u0002R\u0014\u0010\n\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/fika_project/ui/main/home/MyCourseRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "courseList", "Ljava/util/ArrayList;", "Lcom/example/fika_project/ui/main/home/myCourseList;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "FOOTER", "", "getFOOTER", "()I", "HEADER", "getHEADER", "ITEM", "getITEM", "getContext", "()Landroid/content/Context;", "mItemClickListner", "Lcom/example/fika_project/ui/main/home/MyCourseRVAdapter$MyItemClickListener;", "tasks", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setMyItemClickListener", "itemClickListener", "inflate", "Landroid/view/View;", "layoutRes", "FooterViewHolder", "ItemViewHolder", "MyItemClickListener", "app_debug"})
public final class MyCourseRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final java.util.ArrayList<com.example.fika_project.ui.main.home.myCourseList> courseList = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final int HEADER = 0;
    private final int ITEM = 1;
    private final int FOOTER = 2;
    private com.example.fika_project.ui.main.home.MyCourseRVAdapter.MyItemClickListener mItemClickListner;
    private java.util.ArrayList<com.example.fika_project.ui.main.home.myCourseList> tasks;
    
    public MyCourseRVAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.fika_project.ui.main.home.myCourseList> courseList, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final int getHEADER() {
        return 0;
    }
    
    public final int getITEM() {
        return 0;
    }
    
    public final int getFOOTER() {
        return 0;
    }
    
    public final void setMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.home.MyCourseRVAdapter.MyItemClickListener itemClickListener) {
    }
    
    private final android.view.View inflate(android.view.ViewGroup $this$inflate, int layoutRes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/fika_project/ui/main/home/MyCourseRVAdapter$MyItemClickListener;", "", "onItemClick", "", "course", "Lcom/example/fika_project/ui/main/home/myCourseList;", "app_debug"})
    public static abstract interface MyItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.example.fika_project.ui.main.home.myCourseList course);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/fika_project/ui/main/home/MyCourseRVAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/fika_project/ui/main/home/MyCourseRVAdapter;Landroid/view/View;)V", "app_debug"})
    public final class FooterViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public FooterViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/fika_project/ui/main/home/MyCourseRVAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/fika_project/databinding/ItemHomeCourseBinding;", "(Lcom/example/fika_project/ui/main/home/MyCourseRVAdapter;Lcom/example/fika_project/databinding/ItemHomeCourseBinding;)V", "getBinding", "()Lcom/example/fika_project/databinding/ItemHomeCourseBinding;", "bind", "", "itemCourse", "Lcom/example/fika_project/ui/main/home/myCourseList;", "app_debug"})
    public final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.fika_project.databinding.ItemHomeCourseBinding binding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.fika_project.databinding.ItemHomeCourseBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.fika_project.databinding.ItemHomeCourseBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.fika_project.ui.main.home.myCourseList itemCourse) {
        }
    }
}