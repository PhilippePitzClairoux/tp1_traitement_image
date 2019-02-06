package com.anonymous;

public abstract class Pixel {

    private Integer maxValue;


    /**
     * Default constructor
     * @param maxValue The max value a pixel can have
     */
    public Pixel(Integer maxValue) {

        if (maxValue == 0)
            throw new RuntimeException("maxValue MUST be higher than 0.");

        this.maxValue = maxValue;
    }

    /**
     * Method that returns the value of the current pixel
     * @return value of the pixel (either a single value or RGB)
     */
    public abstract Integer[] getPixelValue();

    public Integer getMaxValue() {
        return maxValue;
    }

    /**
     * Set the value of "maxValue"
     * @param maxValue Value to give to maxValue.
     */
    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }
}
