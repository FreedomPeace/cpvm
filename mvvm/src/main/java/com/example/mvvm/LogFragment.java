package com.example.mvvm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.mvvm.data.local.LogInfoLocalModel;
import com.example.mvvm.databinding.FragmentLogBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogFragment extends Fragment  {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LogViewModel logViewModel = new LogViewModel
                (getActivity().getApplication(),new LogInfoLocalModel(getContext()));
        FragmentLogBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_log,container, false);
        binding.setViewmodel(logViewModel);
        return binding.getRoot();
    }

}