package com.example.fika_project.ui.main.hold_and_scrap;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/example/fika_project/ui/main/hold_and_scrap/LocationHoldView;", "", "onExploreFailure", "", "code", "", "message", "", "onExploreLoading", "onExploreSuccess", "response", "Lcom/example/fika_project/ui/main/hold_and_scrap/LocationHoldResponse;", "iv", "Landroid/widget/ImageView;", "app_debug"})
public abstract interface LocationHoldView {
    
    public abstract void onExploreLoading();
    
    public abstract void onExploreSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.hold_and_scrap.LocationHoldResponse response, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView iv);
    
    public abstract void onExploreFailure(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message);
}