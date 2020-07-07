package com.example.mvvm.data.local;

import android.content.Context;
import android.util.Log;

import com.example.mvvm.data.AppDatabase;
import com.example.mvvm.data.LogInfo;
import com.example.mvvm.data.LogInfoDao;

import java.util.List;


public class LogInfoLocalModel {

    private Context context;

    public LogInfoLocalModel(Context context) {
        this.context = context;
    }

    public void saveLogInfo(final LogInfo logInfo){
        new Thread(){
            @Override
            public void run() {
                super.run();
                LogInfoDao logInfoDao = AppDatabase.getInstance(context).getLogInfoDao();
                logInfoDao.insert(logInfo);
            }
        }.start();

    }
    public List<LogInfo> getLogInfo(){
        //todo 需要处理回调
        new Thread(){
            @Override
            public void run() {
                super.run();
                LogInfoDao logInfoDao = AppDatabase.getInstance(context).getLogInfoDao();
                List<LogInfo> logInfos = logInfoDao.getLogInfos();
                Log.d("LogInfoLocalModel", "getLogInfo: "+logInfos.size());
            }
        }.start();

        return null;
    }
}
