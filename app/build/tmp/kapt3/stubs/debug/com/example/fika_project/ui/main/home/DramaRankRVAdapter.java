package com.example.fika_project.ui.main.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/fika_project/ui/main/home/DramaRankRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/fika_project/ui/main/home/DramaRankRVAdapter$ViewHolder;", "dramaRankList", "Ljava/util/ArrayList;", "Lcom/example/fika_project/ui/main/home/dramaList;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mItemClickListner", "Lcom/example/fika_project/ui/main/home/DramaRankRVAdapter$MyItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "setMyItemClickListener", "itemClickListener", "MyItemClickListener", "ViewHolder", "app_debug"})
public final class DramaRankRVAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.fika_project.ui.main.home.DramaRankRVAdapter.ViewHolder> {
    private final java.util.ArrayList<com.example.fika_project.ui.main.home.dramaList> dramaRankList = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private com.example.fika_project.ui.main.home.DramaRankRVAdapter.MyItemClickListener mItemClickListner;
    
    public DramaRankRVAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.fika_project.ui.main.home.dramaList> dramaRankList, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setMyItemClickListener(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.home.DramaRankRVAdapter.MyItemClickListener itemClickListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.fika_project.ui.main.home.DramaRankRVAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.home.DramaRankRVAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/fika_project/ui/main/home/DramaRankRVAdapter$MyItemClickListener;", "", "onItemClick", "", "dramaRank", "Lcom/example/fika_project/ui/main/home/dramaList;", "app_debug"})
    public static abstract interface MyItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.example.fika_project.ui.main.home.dramaList dramaRank);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/fika_project/ui/main/home/DramaRankRVAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/fika_project/databinding/ItemHomeDramarankBinding;", "(Lcom/example/fika_project/ui/main/home/DramaRankRVAdapter;Lcom/example/fika_project/databinding/ItemHomeDramarankBinding;)V", "getBinding", "()Lcom/example/fika_project/databinding/ItemHomeDramarankBinding;", "bind", "", "itemdramaRank", "Lcom/example/fika_project/ui/main/home/dramaList;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.fika_project.databinding.ItemHomeDramarankBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.fika_project.databinding.ItemHomeDramarankBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.fika_project.databinding.ItemHomeDramarankBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.fika_project.ui.main.home.dramaList itemdramaRank) {
        }
    }
}