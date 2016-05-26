package com.itrainasia.multitouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.RelativeLayout1);

        myLayout.setOnTouchListener(new RelativeLayout.OnTouchListener() {
                                        public boolean onTouch(View v, MotionEvent m) {
                                            handleTouch(m);
                                            return true;
                                        }
                                    }
        );

    }
    void handleTouch(MotionEvent motion) {
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        int pointerCount = motion.getPointerCount();

        for (int i = 0; i < pointerCount; i++) {
            int x = (int) motion.getX(i);
            int y = (int) motion.getY(i);
            int id = motion.getPointerId(i);
            int action = motion.getActionMasked();
            int actionIndex = motion.getActionIndex();
            String actionString;

            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    actionString = "DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "POINTER DOWN";
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "POINTER UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "MOVE";
                    break;
                default:
                    actionString = "";
            }

            String status = "Action: " + actionString + " Index: "
                    + actionIndex + " ID: " + id + " X: " + x + " Y: " + y;

            if (id == 0)
                textView1.setText(status);
            else
                textView2.setText(status);
        }

    }
}
