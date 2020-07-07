package com.example.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogFragment extends Fragment implements Contract.IView<Contract.IPresent> {
    private Contract.IPresent logPresent;

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
                logPresent.saveLog(etTitle.getText().toString(), etContent.getText().toString());
            }
        });
    }

    @Override
    public void logHasEmpty() {
        Toast.makeText(getContext(), "标题或内容不能为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresent(Contract.IPresent logPresent) {
        this.logPresent = logPresent;
    }
}