package com.anonymous.image;

import com.anonymous.pixel.PixelPPM;
import com.anonymous.pixel.Pixel;


/**
 *
 * @author Philippe Pitz Clairoux & Cynthia Vilanova
 * Date of creation: February 7, 2019
 */
public class PPM extends Image {

    /**
     * PPM constructor
     * @param width The Width of the PPM image
     * @param height The height of the PPM image
     * @param maxValue Max value a PPM image pixel can have
     */
    public PPM(Integer width, Integer height, Integer maxValue) {
        super(width, height, maxValue, "P3");
    }

    @Override
    public void setPixel(Pixel pix, Integer x, Integer y) {

        if (pix == null)
            throw new RuntimeException("Cannot pass a null pixel");

        if (!(pix instanceof PixelPPM))
            throw new RuntimeException("Must instanciate PixelPPM for PPM images.");

        super.setPixel(pix, x, y);
    }
}
