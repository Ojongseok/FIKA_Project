package com.example.fika_project.ui.main.mycourse;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0004\u0016\u0017\u0018\u0019B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "data", "", "Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Item;", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "Companion", "Item", "ListChildViewHolder", "ListHeaderViewHolder", "app_debug"})
public final class ExpandableListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final java.util.List<com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item> data = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Companion Companion = null;
    public static final int HEADER = 0;
    public static final int CHILD = 1;
    
    public ExpandableListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item> data) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int type) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$ListHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "btn_expand_toggle", "Landroid/widget/ImageView;", "getBtn_expand_toggle", "()Landroid/widget/ImageView;", "setBtn_expand_toggle", "(Landroid/widget/ImageView;)V", "header_title", "Landroid/widget/TextView;", "getHeader_title", "()Landroid/widget/TextView;", "setHeader_title", "(Landroid/widget/TextView;)V", "refferalItem", "Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Item;", "getRefferalItem", "()Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Item;", "setRefferalItem", "(Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Item;)V", "app_debug"})
    static final class ListHeaderViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView header_title;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView btn_expand_toggle;
        @org.jetbrains.annotations.Nullable()
        private com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item refferalItem;
        
        public ListHeaderViewHolder(@org.jetbrains.annotations.Nullable()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getHeader_title() {
            return null;
        }
        
        public final void setHeader_title(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getBtn_expand_toggle() {
            return null;
        }
        
        public final void setBtn_expand_toggle(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item getRefferalItem() {
            return null;
        }
        
        public final void setRefferalItem(@org.jetbrains.annotations.Nullable()
        com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2 = {"Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$ListChildViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "btn", "Landroid/widget/ImageView;", "getBtn", "()Landroid/widget/ImageView;", "setBtn", "(Landroid/widget/ImageView;)V", "cardLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", "getCardLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setCardLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "childToggleBtn", "getChildToggleBtn", "setChildToggleBtn", "child_title", "Landroid/widget/TextView;", "getChild_title", "()Landroid/widget/TextView;", "setChild_title", "(Landroid/widget/TextView;)V", "refferalItem", "Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Item;", "getRefferalItem", "()Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Item;", "setRefferalItem", "(Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Item;)V", "app_debug"})
    static final class ListChildViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView child_title;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView btn;
        @org.jetbrains.annotations.Nullable()
        private com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item refferalItem;
        private androidx.constraintlayout.widget.ConstraintLayout cardLayout;
        private android.widget.ImageView childToggleBtn;
        
        public ListChildViewHolder(@org.jetbrains.annotations.Nullable()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getChild_title() {
            return null;
        }
        
        public final void setChild_title(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getBtn() {
            return null;
        }
        
        public final void setBtn(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item getRefferalItem() {
            return null;
        }
        
        public final void setRefferalItem(@org.jetbrains.annotations.Nullable()
        com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item p0) {
        }
        
        public final androidx.constraintlayout.widget.ConstraintLayout getCardLayout() {
            return null;
        }
        
        public final void setCardLayout(androidx.constraintlayout.widget.ConstraintLayout p0) {
        }
        
        public final android.widget.ImageView getChildToggleBtn() {
            return null;
        }
        
        public final void setChildToggleBtn(android.widget.ImageView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Item;", "", "()V", "type", "", "text", "", "(ILjava/lang/String;)V", "invisibleChildren", "", "getInvisibleChildren", "()Ljava/util/List;", "setInvisibleChildren", "(Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "app_debug"})
    public static final class Item {
        private int type = 0;
        @org.jetbrains.annotations.Nullable()
        private java.lang.String text;
        @org.jetbrains.annotations.Nullable()
        private java.util.List<com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item> invisibleChildren;
        
        public final int getType() {
            return 0;
        }
        
        public final void setType(int p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getText() {
            return null;
        }
        
        public final void setText(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item> getInvisibleChildren() {
            return null;
        }
        
        public final void setInvisibleChildren(@org.jetbrains.annotations.Nullable()
        java.util.List<com.example.fika_project.ui.main.mycourse.ExpandableListAdapter.Item> p0) {
        }
        
        public Item() {
            super();
        }
        
        public Item(int type, @org.jetbrains.annotations.Nullable()
        java.lang.String text) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/fika_project/ui/main/mycourse/ExpandableListAdapter$Companion;", "", "()V", "CHILD", "", "HEADER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}