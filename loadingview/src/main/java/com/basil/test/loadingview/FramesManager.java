package com.basil.test.loadingview;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Basi on 27-06-2017.
 */

public class FramesManager {
    private int frames;
    private long lastFrame = TimeUnit.SECONDS.toMillis(0);
    private long timeSpan,currentFrame;
    private int fps;

    public void frame() {
         currentFrame = System.currentTimeMillis();
         timeSpan += currentFrame - lastFrame;
        if (timeSpan > TimeUnit.SECONDS.toMillis(1)) {
            fps=getFramesCount();
            frames = 0;
            timeSpan=0;
        }
        frames++;
        lastFrame = currentFrame;
    }

    public int getFramesCount() {
        return frames;
    }

    public int fps() {
        return fps;
    }
}
