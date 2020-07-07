package com.example.cpvm;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.cpvm.data.LogInfo;
import com.example.cpvm.data.local.LogInfoLocalModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log, container, false);
        initView(view);
        return view;
    }


    private void initView(@NonNull View view) {
        final EditText etTitle = view.findViewById(R.id.et_title);
        final EditText etContent = view.findViewById(R.id.et_content);
        view.findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存用户数据
                save(etTitle.getText().toString(), etContent.getText().toString());
            }
        });
    }

    private void save(String etTitle, String etContent) {
        if (TextUtils.isEmpty(etTitle) || TextUtils.isEmpty(etContent)) {
            Toast.makeText(getContext(), "标题或内容不能为空", Toast.LENGTH_SHORT).show();
        }
        final LogInfoLocalModel logInfoModel = new LogInfoLocalModel(getContext());
        LogInfo logInfo = new LogInfo(etTitle,etContent);
        logInfoModel.saveLogInfo(logInfo);
        logInfoModel.getLogInfo();
    }
}