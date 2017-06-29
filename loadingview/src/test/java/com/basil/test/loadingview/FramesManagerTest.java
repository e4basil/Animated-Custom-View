package com.basil.test.loadingview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Basi on 27-06-2017.
 */
public class FramesManagerTest {

    private FramesManager framesManager;

    @Before
    public void setUp() throws Exception {
        framesManager = new FramesManager();
    }

    @Test
    public void framesManagerMonitorsFramesProgress() {

        framesManager.frame();
        assertEquals(1, framesManager.getFramesCount());
    }

    @Test
    public void makeSureFramesManagerIsAwareOfFramesPassed() {

        framesManager.frame();
        framesManager.frame();
        framesManager.frame();
        assertEquals(3, framesManager.getFramesCount());
    }

    @Test
    public void resetsFramesCountAfterOneSecond() throws InterruptedException {
        framesManager.frame();
        framesManager.frame();
        framesManager.frame();
        Thread.sleep(1001);
        framesManager.frame();
        assertEquals(1, framesManager.getFramesCount());
    }

    @Test
    public void resetsFramesCountsAfterOneSecondInTotal() throws InterruptedException {
        framesManager.frame();
        Thread.sleep(300);
        framesManager.frame();
        Thread.sleep(300);
        framesManager.frame();
        Thread.sleep(300);
        framesManager.frame();
        Thread.sleep(300);
        framesManager.frame();
        assertEquals(1,framesManager.getFramesCount());
    }


    @Test
    public void resetsFramesCountsAfterOneSecondRepeatedly() throws InterruptedException {
        framesManager.frame();
        Thread.sleep(300); // 300ms
        framesManager.frame();
        Thread.sleep(300); // 600ms
        framesManager.frame();
        Thread.sleep(300); // 900ms
        framesManager.frame();
        Thread.sleep(300); // 1200ms
//      ----------------------------------
        framesManager.frame();
        Thread.sleep(300); // 300ms
        framesManager.frame();
        Thread.sleep(300); // 600ms
        framesManager.frame();
        Thread.sleep(300); // 900ms
        framesManager.frame();
        Thread.sleep(300); // 1200ms
        framesManager.frame();
        assertEquals(1,framesManager.getFramesCount());
    }

    @Test
    public void showsFramesPerSecond() throws InterruptedException {
        framesManager.frame();
        framesManager.frame();
        framesManager.frame();
        Thread.sleep(1001);
        framesManager.frame();
        assertEquals(3,framesManager.fps());
    }

    /**
     * frames per *second*
     * @throws InterruptedException
     */
    @Test
    public void showsCorrectFramesPerSecond() throws InterruptedException {
        framesManager.frame();
        framesManager.frame();
        framesManager.frame();
        Thread.sleep(1001);
//      ----------- 1s ---- 3 frames
        framesManager.frame();
        framesManager.frame();
        Thread.sleep(1001);
//      ----------- 2s---- 2 frames
        framesManager.frame();
        framesManager.frame();
        Thread.sleep(1001);
//       ---------- 3s---- 2 frames
        framesManager.frame();
        framesManager.frame();
        framesManager.frame();
        framesManager.frame();
        Thread.sleep(1001);
//      ----------- 4s---- 4 frames
        framesManager.frame();
        assertEquals(4,framesManager.fps());
    }
}