package com.example.mvvm.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "logInfo")
public class LogInfo {
     @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")  public int uid;
//     @ColumnInfo(name = "first_name")
     public String title;
//     @ColumnInfo(name = "last_name")
     public String content;

     public LogInfo(String etTitle, String etContent) {
          title = etTitle;
          content = etContent;
     }

     public LogInfo() {
     }

     public int getUid() {
          return uid;
     }

     public void setUid(int uid) {
          this.uid = uid;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getContent() {
          return content;
     }

     public void setContent(String content) {
          this.content = content;
     }
}
