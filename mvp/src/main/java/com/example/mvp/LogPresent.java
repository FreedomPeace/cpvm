package com.example.mvp;

import android.text.TextUtils;

import com.example.mvp.data.LogInfo;
import com.example.mvp.data.local.LogInfoLocalModel;

class LogPresent implements Contract.IPresent {
    private LogInfoLocalModel model;
    private Contract.IView iView;

    public LogPresent(LogInfoLocalModel model, Contract.IView iView) {
        this.model = model;
        this.iView = iView;
    }

    @Override
    public void saveLog(final String etTitle, final String etContent) {
        if (TextUtils.isEmpty(etTitle) || TextUtils.isEmpty(etContent)) {
            iView.logHasEmpty();
            return;
        }
        LogInfo logInfo = new LogInfo(etTitle,etContent);
        model.saveLogInfo(logInfo);
        model.getLogInfo();
    }
}
