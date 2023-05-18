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

import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected Crtac crtac;
    Button button4, button5, backButton;
    private boolean isSelectMode = false;
    protected BHolder buttons;

    private Linija selectedLine;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSelect = (Button) findViewById(R.id.button4);
        Button buttonNext = (Button) findViewById(R.id.button5);
        Button nazad = (Button) findViewById(R.id.backButton);
        buttons = new BHolder(buttonSelect, buttonNext);
        buttons.onClickListeners(new View.OnClickListener() {
            private boolean isFirstClick = true;

            public void onClick(View v) {
                if (v.getId() == R.id.button4) {
                    if (buttonSelect.getText().equals("select")) {
                        if (isFirstClick) {
                            // Entering line selection mode
                            Toast.makeText(MainActivity.this, "Click on a line to select", Toast.LENGTH_LONG).show();
                            isFirstClick = false;
                        } else {
                            // Exiting line selection mode
                            buttonSelect.setText("cancel");
                            isSelectMode = true;
                            isFirstClick = true;
                            Toast.makeText(MainActivity.this, "Line selection mode enabled", Toast.LENGTH_LONG).show();
                        }
                    } else if (buttonSelect.getText().equals("cancel")) {
                        buttonSelect.setText("select");
                        isSelectMode = false;
                        isFirstClick = true;
                        Toast.makeText(MainActivity.this, "Line selection mode disabled", Toast.LENGTH_LONG).show();
                    }
                } else if (isSelectMode && isFirstClick) {
                    // Check if a line is clicked
                    selectedLine = crtac.getSelectedLine(v.getX(), v.getY());
                    if (selectedLine != null) {
                        // Line selected
                        Toast.makeText(MainActivity.this, "Selected line: StartX=" + selectedLine.getXstart() + ", StartY=" + selectedLine.getYstart() + ", EndX=" + selectedLine.getEndX() + ", EndY=" + selectedLine.getEndY(), Toast.LENGTH_LONG).show();
                        isFirstClick = false;
                    } else {
                        // No line selected
                        Toast.makeText(MainActivity.this, "No line selected", Toast.LENGTH_LONG).show();
                    }
                }
            }});
        nazad.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
                {
                List<Linija> linije = crtac.getLinije();
                crtac.setLinije(linije);
                }
            });

        crtac = findViewById(R.id.drawing_view);
    };

    }




