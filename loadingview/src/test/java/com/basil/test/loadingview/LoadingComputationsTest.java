package com.basil.test.loadingview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Basi on 26-06-2017.
 */
public class LoadingComputationsTest {

    private LoadingComputations loadingComputations;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void checksComputerAbilityToMultiply() {
        loadingComputations = new LoadingComputations(2.5f);
        assertEquals(2.5f, loadingComputations.dpToPx(1), 0.001f);
    }

    @Test
    public void doubleCheckConversionIsCorrect() {
        loadingComputations = new LoadingComputations(2.5f);
        assertEquals(7.5f, loadingComputations.dpToPx(3), 0.001);
    }

    @Test
    public void convertForDensityEqual3() {
        loadingComputations = new LoadingComputations(3f);
        assertEquals(9f, loadingComputations.dpToPx(3), 0.001);
    }

    @Test
    public void convertForDensityEqual5() {
        loadingComputations = new LoadingComputations(5f);
        assertEquals(25f, loadingComputations.dpToPx(5), 0.001f);
    }


    @Test
    public void calculatesSinusoidResultBasedOnTime() {
        loadingComputations = new LoadingComputations(0.f);
        assertEquals((0. + 1) / 2, loadingComputations.verticalPosition(0, 0), 0.002);
        assertEquals((1.0 / 2 + 1) / 2, loadingComputations.verticalPosition(83, 0), 0.002);
//      sin(π/6) = 1/2     --------- 500ms/6=83 -----------------360(2π)=1sec=1000ms
        assertEquals((Math.sqrt(2) / 2 + 1) / 2, loadingComputations.verticalPosition(125, 0), 0.002);
//      sin(π/4) = √2 / 2  --------- 500ms/4=125 -----------------360(2π)=1sec
        assertEquals((1 + 1) / 2, loadingComputations.verticalPosition(250, 0), 0.002);
//      sin(π/2) = 1       --------- 500ms/2=250 -----------------360(2π)=1sec
    }


    @Test
    public void calculatesSinusoidResultBasedOnTimeWithOffset125ms() {
        loadingComputations=new LoadingComputations(0.f);

        assertEquals((0. + 1)/2, loadingComputations.verticalPosition(-125, 125L), 0.002); /// for 0ms (-125 + 125)
        assertEquals((Math.sqrt(2)/2 + 1)/2, loadingComputations.verticalPosition(0, 125L), 0.002);/// for 125ms (0 + 125)
        assertEquals((1 + 1)/2, loadingComputations.verticalPosition(125, 125L), 0.002);/// for 250ms (125 + 125)
    }
}