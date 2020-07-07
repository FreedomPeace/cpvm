package com.example.cpvm.data.local;

import android.content.Context;
import android.util.Log;

import com.example.cpvm.data.AppDatabase;
import com.example.cpvm.data.LogInfo;
import com.example.cpvm.data.LogInfoDao;

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
