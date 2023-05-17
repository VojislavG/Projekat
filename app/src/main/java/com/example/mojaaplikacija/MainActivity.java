package com.example.mojaaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.usage.UsageEvents;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        protected Crtac crtac;
        Button button4;
        Button button5;
    float o, p;
    private boolean isSelectMode = false;
    protected BHolder buttons;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSelect = (Button) findViewById(R.id.button4);
        Button buttonNext = (Button) findViewById(R.id.button5);
        buttons = new BHolder(buttonSelect, buttonNext);
        buttons.onClickListeners(view -> {
            if (isSelectMode) {
                isSelectMode = false;
                buttonSelect.setText("Select");

                crtac.setOnTouchListener((v,event) ->{
                    o = event.getX();
                    p = event.getY();
                    return true;
                });
                Linija selectedLine = crtac.getSelectedLine(o,p);
                Log.v("l",String.valueOf(view.getX()));
                if (selectedLine != null) {
                    String lineInfo = "Selected Line: startX=" + selectedLine.startX + ", startY=" + selectedLine.startY
                            + ", endX=" + selectedLine.endX + ", endY=" + selectedLine.endY;
                    Toast.makeText(MainActivity.this, lineInfo, Toast.LENGTH_LONG).show();
                }
            } else {
                // Enable select mode
                isSelectMode = true;
                buttonSelect.setText("Cancel");

                // Clear any previously selected line
                //crtac.clearSelectedLine();
            }
//            if (view.getId() == R.id.button4){
//                for(Linija l: crtac.getLinije()){
//                    boolean tako = l.selectedLine(view.getX(), view.getY());
//                    if (tako){
//                        Toast.makeText(MainActivity.this, "Tako liniju", Toast.LENGTH_LONG).show();
//                    }
                });
        crtac = findViewById(R.id.drawing_view);

    }



    }


