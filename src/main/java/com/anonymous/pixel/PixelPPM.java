package com.anonymous.pixel;

/**
 *
 * @author Thia
 */
public class PixelPPM extends Pixel {

    private Integer red;
    private Integer green;
    private Integer blue;


    /**
     * PixelPPM constrcutor with a pixels maxValue (RGB set at 0)
     * @param maxValue
     */
    public PixelPPM(Integer maxValue) {

        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    /**
     * Get the value of the pixel
     * @return Returns an array with the RGB value [Red, Green, Blue]
     */
    public Integer[] getPixelValue() {
        return new Integer[] { this.getRed(), this.getGreen(), this.getBlue() };
    }

    /**
     * PixelPPM constrcutor that takes a max value and RGB value
     * @param red The red value of the pixel
     * @param green The green value of the pixel
     * @param blue The blue value of the pixel
     */
    public PixelPPM(Integer red, Integer green, Integer blue) {
        super();

        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Get the current value of red
     * @return The value of red
     */
    public Integer getRed() {
        return red;
    }

    /**
     * Set the value of red
     * @param red The new value of red
     */
    public void setRed(Integer red) {
        this.red = red;
    }

    /**
     * Get the value of green
     * @return The value of green
     */
    public Integer getGreen() {
        return green;
    }

    /**
     * Set the value of green
     * @param green The new value of green
     */
    public void setGreen(Integer green) {
        this.green = green;
    }

    /**
     * Get the value of blue
     * @return The value of blue
     */
    public Integer getBlue() {
        return blue;
    }

    /**
     * Set the value of blue
     * @param blue The new value of blue
     */
    public void setBlue(Integer blue) {
        this.blue = blue;
    }
}
