package com.gospce.adc.gospcelib.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.gospce.adc.gospcelib.CustomButton;
import com.gospce.adc.gospcelib.CustomInputField;
import com.gospce.adc.gospcelib.R;
import com.gospce.adc.gospcelib.databinding.FragmentInputFieldBinding;
import com.gospce.adc.gospcelib.utility.TestMethods;

import org.w3c.dom.Text;

public class InputFieldFragment extends Fragment{

    TestMethods testMethods = new TestMethods();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentInputFieldBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_input_field, container, false);
        View view = binding.getRoot();

        binding.setProperties(testMethods);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
