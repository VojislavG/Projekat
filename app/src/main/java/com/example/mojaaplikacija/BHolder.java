package com.example.mojaaplikacija;

import android.view.View;
import android.widget.Button;


public class BHolder {

    Button buttonSelect;
    Button buttonNext;
    public BHolder(Button buttonSelect, Button buttonNext){
        this.buttonSelect = buttonSelect;
        this.buttonNext = buttonNext;
    }
    public void onClickListeners(View.OnClickListener listener){
        buttonNext.setOnClickListener(listener);
        buttonSelect.setOnClickListener(listener);
    }
}
