package com.example.fika_project.ui.main.explore.drama_info;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/example/fika_project/ui/main/explore/drama_info/LargeMapActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "_Binding", "Lcom/example/fika_project/databinding/ActivityLargeMapBinding;", "binding", "getBinding", "()Lcom/example/fika_project/databinding/ActivityLargeMapBinding;", "eventListener", "Lcom/example/fika_project/ui/main/explore/drama_info/LargeMapActivity$MarkerEventListener;", "markerList", "Ljava/util/ArrayList;", "Lnet/daum/mf/map/api/MapPOIItem;", "getMarkerList", "()Ljava/util/ArrayList;", "spotlist", "Lcom/example/fika_project/ui/main/explore/spotDataList;", "Lkotlin/collections/ArrayList;", "getSpotlist", "setSpotlist", "(Ljava/util/ArrayList;)V", "initData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CustomBalloonAdapter", "MarkerEventListener", "app_debug"})
public final class LargeMapActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.fika_project.databinding.ActivityLargeMapBinding _Binding;
    public java.util.ArrayList<com.example.fika_project.ui.main.explore.spotDataList> spotlist;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<net.daum.mf.map.api.MapPOIItem> markerList = null;
    private final com.example.fika_project.ui.main.explore.drama_info.LargeMapActivity.MarkerEventListener eventListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public LargeMapActivity() {
        super();
    }
    
    private final com.example.fika_project.databinding.ActivityLargeMapBinding getBinding() {
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
    public final java.util.ArrayList<net.daum.mf.map.api.MapPOIItem> getMarkerList() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initData() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/example/fika_project/ui/main/explore/drama_info/LargeMapActivity$CustomBalloonAdapter;", "Lnet/daum/mf/map/api/CalloutBalloonAdapter;", "context", "Landroid/content/Context;", "inflater", "Landroid/view/LayoutInflater;", "(Landroid/content/Context;Landroid/view/LayoutInflater;)V", "getContext", "()Landroid/content/Context;", "mCalloutBalloon", "Landroid/view/View;", "getMCalloutBalloon", "()Landroid/view/View;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "getCalloutBalloon", "poiItem", "Lnet/daum/mf/map/api/MapPOIItem;", "getPressedCalloutBalloon", "app_debug"})
    public static final class CustomBalloonAdapter implements net.daum.mf.map.api.CalloutBalloonAdapter {
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View mCalloutBalloon = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView name = null;
        
        public CustomBalloonAdapter(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.view.LayoutInflater inflater) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getMCalloutBalloon() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.view.View getCalloutBalloon(@org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapPOIItem poiItem) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.view.View getPressedCalloutBalloon(@org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapPOIItem poiItem) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/example/fika_project/ui/main/explore/drama_info/LargeMapActivity$MarkerEventListener;", "Lnet/daum/mf/map/api/MapView$POIItemEventListener;", "context", "Landroid/content/Context;", "markerList", "Ljava/util/ArrayList;", "Lnet/daum/mf/map/api/MapPOIItem;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getMarkerList", "()Ljava/util/ArrayList;", "onCalloutBalloonOfPOIItemTouched", "", "mapView", "Lnet/daum/mf/map/api/MapView;", "poiItem", "buttonType", "Lnet/daum/mf/map/api/MapPOIItem$CalloutBalloonButtonType;", "onDraggablePOIItemMoved", "p0", "p1", "p2", "Lnet/daum/mf/map/api/MapPoint;", "onPOIItemSelected", "app_debug"})
    public static final class MarkerEventListener implements net.daum.mf.map.api.MapView.POIItemEventListener {
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.ArrayList<net.daum.mf.map.api.MapPOIItem> markerList = null;
        
        public MarkerEventListener(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<net.daum.mf.map.api.MapPOIItem> markerList) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<net.daum.mf.map.api.MapPOIItem> getMarkerList() {
            return null;
        }
        
        @java.lang.Override()
        public void onPOIItemSelected(@org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapView mapView, @org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapPOIItem poiItem) {
        }
        
        @java.lang.Override()
        public void onCalloutBalloonOfPOIItemTouched(@org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapView mapView, @org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapPOIItem poiItem) {
        }
        
        @java.lang.Override()
        public void onCalloutBalloonOfPOIItemTouched(@org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapView mapView, @org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapPOIItem poiItem, @org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapPOIItem.CalloutBalloonButtonType buttonType) {
        }
        
        @java.lang.Override()
        public void onDraggablePOIItemMoved(@org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapView p0, @org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapPOIItem p1, @org.jetbrains.annotations.Nullable()
        net.daum.mf.map.api.MapPoint p2) {
        }
    }
}