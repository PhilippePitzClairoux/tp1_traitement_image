package com.anonymous;

public abstract class Pixel {



    /**
     * Default constructor
     */
    public Pixel() {}

    /**
     * Method that returns the value of the current pixel
     * @return value of the pixel (either a single value or RGB)
     */
    public abstract Integer[] getPixelValue();
}
