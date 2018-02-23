package ru.mflops;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;

public class myRunnable extends Button implements Runnable {
    int id=0;
    String result = "";
    Handler h;

    public myRunnable(Context c, int i) {
        super(c);
        id=i;
        h = new Handler() {
            public void handleMessage(android.os.Message msg) {
                //setText(id + ": " + msg.what + " MFlops");
                setText(result);
            };
        };
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            float X = 0.0F;
            long t1 = System.currentTimeMillis();
            for (long i = 0; i < 1000000; i++) X = 6.345F*3.1415F;
            long t2 = System.currentTimeMillis();
            float time = t2-t1;
            float value = 1000/time;
            //try { Thread.sleep(2000); }
            //catch (InterruptedException e) {}
            result = id + ": " + String.format("%.2f", value) + " MFLOPS  " + String.format("%.2f", time) + " ms";
            h.sendEmptyMessage(0);
        }
    }
}
