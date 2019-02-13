package com.anonymous.image;

import com.anonymous.pixel.Pixel;

/**
 * Contains a 2D array of pixels, a height, a width
 * @author Philippe Pitz Clairoux & Cynthia Vilanova
 * Date of creation: February 7, 2019
 */
public class Image {

    private Pixel[][] data;
    private Integer width;
    private Integer height;
    private Integer maxValue;

    /**
     * Format of the image
     * P3 = PPM
     * P2 = PGM
     */
    public final String header;


    /**
     * Constructs an Image with a given width, height and maxValue
     * and either of format PPM or PGM depending on the header.
     * @param width Width of the image
     * @param height Height of the image
     * @param maxValue The highest value a pixel can have
     * @param header The format of the image (PGM = P2, PPM = P3)
     */
    public Image(Integer width, Integer height, Integer maxValue, String header) {
        this.maxValue = maxValue;
        this.header = header;

        if (width == 0 || height == 0)
            throw new RuntimeException("Height and width CANNOT be zero.");

        this.width = width;
        this.height = height;
        this.data = new Pixel[height][width];
    }


    /**
     * Sets the value of a pixel
     * @param pix Value of the pixel
     * @param row The row in which the data is located
     * @param col The column in which the data is located
     */
    public void setPixel(Pixel pix, Integer col, Integer row) {

        if (pix == null)
            throw new RuntimeException("Null pixel has been passed.");

        data[row][col] = pix;
    }

    /**
     * Gets the pixel based on an (row, col) pair
     * @param row The row in which the data is located
     * @param col The column in which the data is located
     * @return Return the pixel at the position (row,col)
     */
    public Pixel getPixel(Integer col, Integer row) {
        return data[row][col];
    }

    /**
     * Gets the width of the image
     * @return The current width of the image
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the width of the image
     * @param width New width of the image
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Gets the height of the image
     * @return Height of the image
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets the height of the image
     * @param height New height of the image
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Gets the maximum value a pixel can have
     * @return Maximum value a pixel can have
     */
    public Integer getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the maximum value a pixel can have
     * @param maxval The maximum value a pixel can have
     */
    public void setMaxValue(Integer maxval) {
        this.maxValue = maxval;
    }

    /**
     * Creates new array of pixels to input new data 
     */
    public void updateInternalData() {
        this.data = new Pixel[height][width];
    }
}
