package com.gospce.adc.gospcelib.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.gospce.adc.gospcelib.CustomButton;
import com.gospce.adc.gospcelib.R;
import com.gospce.adc.gospcelib.databinding.FragmentButtonBinding;
import com.gospce.adc.gospcelib.utility.TestMethods;

public class ButtonFragment extends Fragment{

    TestMethods testMethods = new TestMethods();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentButtonBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_button, container, false);
        View view = binding.getRoot();

        binding.setProperties(testMethods);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
