package com.example.mvvm;

import android.app.Application;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.example.mvvm.data.LogInfo;
import com.example.mvvm.data.local.LogInfoLocalModel;

public class LogViewModel  {
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> content = new ObservableField<>();
    @NonNull
    private final Application application;
    private final LogInfoLocalModel model;

    public LogViewModel(@NonNull Application application , LogInfoLocalModel model) {
        this.application = application;
        this.model = model;
    }


    public void saveLog() {
        if (TextUtils.isEmpty(title.get()) || TextUtils.isEmpty(content.get())) {
            Toast.makeText(application, "标题或内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        LogInfo logInfo = new LogInfo(title.get(),content.get());
        model.saveLogInfo(logInfo);
        model.getLogInfo();
    }
}
