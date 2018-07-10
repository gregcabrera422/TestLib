package com.gospce.adc.gospcelib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent;

import org.w3c.dom.Text;

import java.util.Observable;

import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class CustomSearch extends LinearLayout{

    private LinearLayout background;
    private ImageView ivSearch;
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
        setBackgroundResource(R.drawable.custom_search);

        background = findViewById(R.id.background);
        ivSearch = findViewById(R.id.ivSearch);
        etSearch = findViewById(R.id.etSearch);
        ivDelete = findViewById(R.id.ivDelete);

        GradientDrawable border = (GradientDrawable)getBackground();
        border.mutate();
        border.setColor(attributes.getColor(R.styleable.CustomSearch_searchColor, getResources().getColor(R.color.white)));
        border.setStroke(attributes.getInt(R.styleable.CustomSearch_searchBorderWidth,5), attributes.getColor(R.styleable.CustomSearch_searchBorderColor,getResources().getColor(R.color.black)));
        border.setCornerRadius(attributes.getDimension(R.styleable.CustomSearch_searchRadius,8));

//        RxTextView.textChanges(etSearch)
//            .map(new Function<CharSequence, Object>() {
//
//                @Override
//                public Object apply(CharSequence charSequence) throws Exception {
//                    ivDelete.setVisibility(TextUtils.isEmpty(charSequence) ? ImageView.INVISIBLE : ImageView.VISIBLE);
//
//                    return charSequence;
//                }
//
//            });

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

    public void setColor(String color){
        GradientDrawable background = (GradientDrawable)getBackground();
        background.setColor(Color.parseColor(color));
    }
    public void setRadius(int radius){
        GradientDrawable background = (GradientDrawable)getBackground();
        background.setCornerRadius(radius);
    }

    public void setStroke(int borderWidth, String color){
        GradientDrawable background = (GradientDrawable)getBackground();
        background.setStroke(borderWidth, Color.parseColor(color));
    }

    public void setCornerRadius(int radius){
        GradientDrawable background = (GradientDrawable)getBackground();
        background.setCornerRadius(Float.valueOf(radius));
    }

    public Editable getText() {
        return etSearch.getText();
    }

    public void setText(String str) {
        etSearch.setText(str);
    }
}
