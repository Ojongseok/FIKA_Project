package com.example.fika_project.ui.main.mycourse.placeinfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001cH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/example/fika_project/ui/main/mycourse/placeinfo/PlaceinfoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/fika_project/ui/main/mycourse/placeinfo/PlaceinfoView;", "()V", "binding", "Lcom/example/fika_project/databinding/ActivityPlaceinfoLocateBinding;", "getBinding", "()Lcom/example/fika_project/databinding/ActivityPlaceinfoLocateBinding;", "setBinding", "(Lcom/example/fika_project/databinding/ActivityPlaceinfoLocateBinding;)V", "courseId", "", "getCourseId", "()I", "service", "Lcom/example/fika_project/ui/main/mycourse/placeinfo/PlaceinfoService;", "getService", "()Lcom/example/fika_project/ui/main/mycourse/placeinfo/PlaceinfoService;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onLoading", "onPlaceinfoSuccess", "response", "Lcom/example/fika_project/ui/main/mycourse/placeinfo/PlaceInfoResponse;", "onReviewReportSuccess", "Lcom/example/fika_project/ui/main/mycourse/placeinfo/ReportResponse;", "app_debug"})
public final class PlaceinfoActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.fika_project.ui.main.mycourse.placeinfo.PlaceinfoView {
    public com.example.fika_project.databinding.ActivityPlaceinfoLocateBinding binding;
    private final int courseId = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.example.fika_project.ui.main.mycourse.placeinfo.PlaceinfoService service = null;
    private java.util.HashMap _$_findViewCache;
    
    public PlaceinfoActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.fika_project.databinding.ActivityPlaceinfoLocateBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.databinding.ActivityPlaceinfoLocateBinding p0) {
    }
    
    public final int getCourseId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.fika_project.ui.main.mycourse.placeinfo.PlaceinfoService getService() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    @java.lang.Override()
    public void onLoading() {
    }
    
    @java.lang.Override()
    public void onPlaceinfoSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.mycourse.placeinfo.PlaceInfoResponse response) {
    }
    
    @java.lang.Override()
    public void onReviewReportSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.mycourse.placeinfo.ReportResponse response) {
    }
}