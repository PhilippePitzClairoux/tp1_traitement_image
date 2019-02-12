package com.anonymous;

public class Image {

    private Pixel[][] data;
    private Integer width;
    private Integer height;
    final private Integer maxValue;


    public void updateInternalData() {
        this.data = new Pixel[height][width];
    }

    /**
     * The only constructor Image has.
     * @param width Width of the image
     * @param height Height of the image
     * @param maxValue The highest value a pixel can have
     */
    public Image(Integer width, Integer height, Integer maxValue) {
        this.maxValue = maxValue;

        if (width == 0 && height == 0)
            throw new RuntimeException("Height and width CANNOT be at 0 at the same time.");

        this.width = width;
        this.height = height;
        this.data = new Pixel[width][height];
    }

    /**
     * Set the value of a pixel
     * @param pix Value of the pixel
     * @param x X position in data
     * @param y Y position in data
     */
    public void setPixel(Pixel pix, Integer x, Integer y) {

        if (pix == null)
            throw new RuntimeException("Null pixel has been passed.");

        data[x][y] = pix;
    }

    /**
     * Get the pixel based on an (X, Y) pair
     * @param x X position in data
     * @param y Y position in data
     * @return
     */
    public Pixel getPixel(Integer x, Integer y) {
        return data[x][y];
    }

    /**
     * Get the width
     * @return The current width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Set the width of the image
     * @param width New width to give to the image
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Get the height of the image
     * @return Height of the image
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Set the height of the image
     * @param height New height of the image
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Get the maximum value a pixel can have.
     * @return Maximum value a pixel can have
     */
    public Integer getMaxValue() {
        return maxValue;
    }
}
