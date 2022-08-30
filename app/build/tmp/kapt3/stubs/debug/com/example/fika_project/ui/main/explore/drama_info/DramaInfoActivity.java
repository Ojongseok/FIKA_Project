package com.example.fika_project.ui.main.explore.drama_info;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020%2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020%H\u0014J\b\u0010*\u001a\u00020%H\u0016J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020%H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006/"}, d2 = {"Lcom/example/fika_project/ui/main/explore/drama_info/DramaInfoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/fika_project/ui/main/explore/drama_info/DramaInfoView;", "Ljava/io/Serializable;", "()V", "_Binding", "Lcom/example/fika_project/databinding/ActivityDramaInfoBinding;", "binding", "getBinding", "()Lcom/example/fika_project/databinding/ActivityDramaInfoBinding;", "dramaName", "", "getDramaName", "()Ljava/lang/String;", "setDramaName", "(Ljava/lang/String;)V", "loadingDialog", "Lcom/example/fika_project/ui/main/LoadingDialog;", "getLoadingDialog", "()Lcom/example/fika_project/ui/main/LoadingDialog;", "setLoadingDialog", "(Lcom/example/fika_project/ui/main/LoadingDialog;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "spotlist", "Ljava/util/ArrayList;", "Lcom/example/fika_project/ui/main/explore/spotDataList;", "Lkotlin/collections/ArrayList;", "getSpotlist", "()Ljava/util/ArrayList;", "setSpotlist", "(Ljava/util/ArrayList;)V", "initData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onExploreLoading", "onExploreSuccess", "response", "Lcom/example/fika_project/ui/main/explore/DramaInfoResponse;", "onResume", "app_debug"})
public final class DramaInfoActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.fika_project.ui.main.explore.drama_info.DramaInfoView, java.io.Serializable {
    private com.example.fika_project.databinding.ActivityDramaInfoBinding _Binding;
    public java.util.ArrayList<com.example.fika_project.ui.main.explore.spotDataList> spotlist;
    public java.lang.String dramaName;
    private int position = 0;
    public com.example.fika_project.ui.main.LoadingDialog loadingDialog;
    private java.util.HashMap _$_findViewCache;
    
    public DramaInfoActivity() {
        super();
    }
    
    private final com.example.fika_project.databinding.ActivityDramaInfoBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.fika_project.ui.main.explore.spotDataList> getSpotlist() {
        return null;
    }
    
    public final void setSpotlist(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.fika_project.ui.main.explore.spotDataList> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDramaName() {
        return null;
    }
    
    public final void setDramaName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getPosition() {
        return 0;
    }
    
    public final void setPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.fika_project.ui.main.LoadingDialog getLoadingDialog() {
        return null;
    }
    
    public final void setLoadingDialog(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.LoadingDialog p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initData() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void onExploreLoading() {
    }
    
    @java.lang.Override()
    public void onExploreSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.explore.DramaInfoResponse response) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}