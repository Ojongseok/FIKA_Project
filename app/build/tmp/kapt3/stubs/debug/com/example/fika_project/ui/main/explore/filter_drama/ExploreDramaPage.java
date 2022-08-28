package com.example.fika_project.ui.main.explore.filter_drama;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010!\u001a\u00020\u00192\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006&"}, d2 = {"Lcom/example/fika_project/ui/main/explore/filter_drama/ExploreDramaPage;", "Landroidx/fragment/app/Fragment;", "Lcom/example/fika_project/ui/main/explore/filter_drama/ExploreDramaView;", "()V", "binding", "Lcom/example/fika_project/databinding/FragmentExploreDramaPageBinding;", "filter", "", "getFilter", "()Ljava/lang/String;", "setFilter", "(Ljava/lang/String;)V", "service", "Lcom/example/fika_project/ui/main/explore/filter_drama/ExploreService;", "getService", "()Lcom/example/fika_project/ui/main/explore/filter_drama/ExploreService;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onExploreFailure", "", "code", "", "message", "onExploreLoading", "onExploreSuccess", "response", "Lcom/example/fika_project/ui/main/explore/filter_drama/ExploreDramaResponse;", "setDramalist", "dramalist", "Ljava/util/ArrayList;", "Lcom/example/fika_project/ui/main/explore/filter_drama/result;", "Lkotlin/collections/ArrayList;", "app_debug"})
public final class ExploreDramaPage extends androidx.fragment.app.Fragment implements com.example.fika_project.ui.main.explore.filter_drama.ExploreDramaView {
    private com.example.fika_project.databinding.FragmentExploreDramaPageBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String filter = "all";
    @org.jetbrains.annotations.NotNull()
    private final com.example.fika_project.ui.main.explore.filter_drama.ExploreService service = null;
    private java.util.HashMap _$_findViewCache;
    
    public ExploreDramaPage() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilter() {
        return null;
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.fika_project.ui.main.explore.filter_drama.ExploreService getService() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onExploreLoading() {
    }
    
    @java.lang.Override()
    public void onExploreSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.explore.filter_drama.ExploreDramaResponse response) {
    }
    
    private final void setDramalist(java.util.ArrayList<com.example.fika_project.ui.main.explore.filter_drama.result> dramalist) {
    }
    
    @java.lang.Override()
    public void onExploreFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}