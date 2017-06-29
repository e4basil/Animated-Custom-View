package com.basil.test.loadingview;

/**
 * Created by Basi on 26-06-2017.
 */

public class LoadingComputations {
    private static final double ANIMATION_LENGTH = 1000; ///1000ms=1s
    private float density;

    public LoadingComputations(float density) {
        this.density = density;
    }

    public float dpToPx(int i) {
        return i * density;
    }

    public double verticalPosition(long seconds, long offset) {
        return (Math.sin(2*Math.PI*(seconds+offset)/ANIMATION_LENGTH)+1)/2;
    }
}
