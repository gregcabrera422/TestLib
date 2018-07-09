package com.gospce.adc.gospcelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomSearch extends LinearLayout{

    private EditText etSearch;
    private ImageView ivDelete;

    public CustomSearch(@NonNull Context context) {
        super(context);
    }

    public CustomSearch(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomSearch(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs){
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.custom_search, this, true);

        TypedArray attributes = getContext().obtainStyledAttributes(attrs,R.styleable.CustomSearch);

        etSearch = findViewById(R.id.etSearch);
        ivDelete = findViewById(R.id.ivDelete);

        etSearch.setHint(attributes.getString(R.styleable.CustomSearch_searchHint));

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                if(count!=0){
                    ivDelete.setVisibility(ImageView.VISIBLE);
                }else{
                    ivDelete.setVisibility(ImageView.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ivDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setText("");
            }
        });

    }

    public Editable getText() {
        return etSearch.getText();
    }

    public void setText(String str) {
        etSearch.setText(str);
    }
}
