package com.example.fika_project;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/fika_project/ApplicationClass;", "Landroid/app/Application;", "()V", "initRetrofitInstance", "", "onCreate", "Companion", "app_debug"})
public final class ApplicationClass extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.fika_project.ApplicationClass.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
<<<<<<< Updated upstream
    public static final java.lang.String X_ACCESS_TOKEN = "";
=======
    public static final java.lang.String X_ACCESS_TOKEN = "X_ACCESS_TOKEN";
>>>>>>> Stashed changes
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "FIKA-Prj";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_URL = "http://ec2-15-165-255-15.ap-northeast-2.compute.amazonaws.com:9090";
    public static android.content.SharedPreferences prefs;
    public static retrofit2.Retrofit retrofit;
    @org.jetbrains.annotations.Nullable()
    private static android.content.Context appContext;
    
    public ApplicationClass() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void initRetrofitInstance() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/example/fika_project/ApplicationClass$Companion;", "", "()V", "API_URL", "", "TAG", "X_ACCESS_TOKEN", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "setPrefs", "(Landroid/content/SharedPreferences;)V", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.SharedPreferences getPrefs() {
            return null;
        }
        
        public final void setPrefs(@org.jetbrains.annotations.NotNull()
        android.content.SharedPreferences p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final retrofit2.Retrofit getRetrofit() {
            return null;
        }
        
        public final void setRetrofit(@org.jetbrains.annotations.NotNull()
        retrofit2.Retrofit p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.content.Context getAppContext() {
            return null;
        }
        
        public final void setAppContext(@org.jetbrains.annotations.Nullable()
        android.content.Context p0) {
        }
    }
}