package com.example.mvvm;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.mvvm.data.local.LogInfoLocalModel;
import com.example.mvvm.databinding.FragmentLogBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogFragment extends Fragment  {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FragmentActivity activity = getActivity();
//        if (activity==null) {
//            return super.onCreateView(inflater, container, savedInstanceState);
//        }
        final LogViewModel logViewModel = new LogViewModel
                (activity.getApplication(),new LogInfoLocalModel(getContext()));
        FragmentLogBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_log,container, false);
        binding.setViewmodel(logViewModel);
        binding.changeScreenOri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else {
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });
        return binding.getRoot();
    }

}