package com.anonymous;

public class ImageManager {

    /**
     * Open "filename" and load it's content inside "img"
     * @param img Object to fill information in.
     * @param filename The name of the file to open.
     */
    public static void openFile(Image img, String filename){

    }

    /**
     * Write an image to a file based on it's type (PPM or PGM)
     * @param img The image to write to the file
     * @param filename The name of the file the image is going to be outputed in.
     */
    public static void writeFile(Image img, String filename) {

    }

    /**
     * Copy img1 into img2
     * @param src To copy from
     * @param dest To copy to
     */
    public static void copy(Image src, Image dest) {

    }

    /**
     * Returns the most common pixel in an image
     * @param img The image to fetch the pixel from
     * @return The most used pixel/color
     */
    public static Pixel predominantColor(Image img) {

        return new PixelPGM(255);
    }

    /**
     * Change the brightness of an image
     * @param img Image that's going to be modify
     * @param i The level of brightness
     */
    public static void brightness(Image img, Integer i) {

    }

    /**
     * Extract a smaller image from an image based on two points
     * @param img Image to extract from
     * @param x1 X value of the first point
     * @param y1 Y value of the first point
     * @param x2 X value of the second point
     * @param y2 Y value of the second point
     * @return The extracted image
     */
    public static Image crop(Image img, Integer x1, Integer y1, Integer x2, Integer y2){

        return new Image(100, 100, img.getMaxValue());
    }

    /**
     * Resize the current image
     * @param img Image to resize
     * @param width Width of the new image
     * @param height Height of the new image
     * @return The new image
     */
    public static Image resize(Image img, Integer width, Integer height) {

        return new Image(100, 100, img.getMaxValue());
    }

    /**
     * Check if two images are the same
     * @param img1 First image
     * @param img2 Second image
     * @return Returns true of they are the same and false if they aren't
     */
    public static boolean areIdentical(Image img1, Image img2) {

        if (img1.getClass() != img1.getClass())
            return false;

        if ((!img1.getWidth().equals(img2.getWidth())) && (!img1.getHeight().equals(img2.getHeight())))
            return false;

        for (int i = 0; i < img1.getWidth(); i++) {
            for (int j = 0; j < img1.getHeight(); j++) {
                if (img1.getPixel(i, j).getPixelValue() != img2.getPixel(i, j).getPixelValue())
                    return false;
            }
        }

        return true;
    }

    /**
     * Perform a 90 degree rotation on an image
     * @param img Image to rotate
     */
    public static void rotate(Image img) {

    }
}
