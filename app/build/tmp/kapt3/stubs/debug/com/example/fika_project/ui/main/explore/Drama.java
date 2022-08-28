package com.example.fika_project.ui.main.explore;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u00c6\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tH\u00c6\u0003Ji\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R*\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R*\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/example/fika_project/ui/main/explore/Drama;", "", "dramaTitle", "", "genre", "thumbnailUrl", "spotDataList", "Ljava/util/ArrayList;", "Lcom/example/fika_project/ui/main/explore/spotDataList;", "Lkotlin/collections/ArrayList;", "courseList", "Lcom/example/fika_project/ui/main/explore/courseList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getCourseList", "()Ljava/util/ArrayList;", "getDramaTitle", "()Ljava/lang/String;", "getGenre", "getSpotDataList", "getThumbnailUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Drama {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "dramaTitle")
    private final java.lang.String dramaTitle = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "genre")
    private final java.lang.String genre = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "thumbnailUrl")
    private final java.lang.String thumbnailUrl = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "spotDataList")
    private final java.util.ArrayList<com.example.fika_project.ui.main.explore.spotDataList> spotDataList = null;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "courseList")
    private final java.util.ArrayList<com.example.fika_project.ui.main.explore.courseList> courseList = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.fika_project.ui.main.explore.Drama copy(@org.jetbrains.annotations.Nullable()
    java.lang.String dramaTitle, @org.jetbrains.annotations.Nullable()
    java.lang.String genre, @org.jetbrains.annotations.Nullable()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.example.fika_project.ui.main.explore.spotDataList> spotDataList, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.example.fika_project.ui.main.explore.courseList> courseList) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Drama(@org.jetbrains.annotations.Nullable()
    java.lang.String dramaTitle, @org.jetbrains.annotations.Nullable()
    java.lang.String genre, @org.jetbrains.annotations.Nullable()
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.example.fika_project.ui.main.explore.spotDataList> spotDataList, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.example.fika_project.ui.main.explore.courseList> courseList) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDramaTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGenre() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThumbnailUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.example.fika_project.ui.main.explore.spotDataList> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.example.fika_project.ui.main.explore.spotDataList> getSpotDataList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.example.fika_project.ui.main.explore.courseList> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.example.fika_project.ui.main.explore.courseList> getCourseList() {
        return null;
    }
}