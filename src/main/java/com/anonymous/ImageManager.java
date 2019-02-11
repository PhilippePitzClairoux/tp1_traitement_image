package com.anonymous;

import java.util.Arrays;

public class ImageManager {

    private static void addArrays(Integer[] toAddTo, Integer[] toAddFrom) {

        if (toAddTo.length != toAddFrom.length)
            throw new RuntimeException("Must pas two arrays with the same length");

        for (int i = 0; i < toAddTo.length; i++) {
            toAddTo[i] += toAddFrom[i];
        }

    }

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
     * @return The new image
     */
    public static Image resize(Image img) {

        if (img == null)
            throw new RuntimeException("Cannot pass null object");

        if (img.getHeight() <= 2 || img.getWidth() <= 2)
            throw new RuntimeException("Image is already too small to resize");


        final int newWidth = img.getWidth() / 2;
        final int newHeight = img.getHeight() / 2;

        Image newimg = (img instanceof PGM ? new PGM(newWidth, newHeight, img.getMaxValue()) :
                new PPM(newWidth, newHeight, img.getMaxValue()));

        if (img.getPixel(0, 0) instanceof PixelPGM)
            for (int i = 0; i < img.getHeight(); i+=2) {
                for (int j = 0; j < img.getWidth(); j+=2) {

                    int average = img.getPixel(i, j).getPixelValue()[0];

                    if (i + 1 <= img.getHeight() && j + 1 <= img.getWidth()) {
                        average += img.getPixel(i, j+1).getPixelValue()[0];
                        average += img.getPixel(i + 1, j).getPixelValue()[0];
                        average += img.getPixel(i + 1, j + 1).getPixelValue()[0];
                    }

                    newimg.setPixel(new PixelPGM(img.getMaxValue(), average / 4), i / 2, j / 2);
                }
            }
        else
            for (int i = 0; i < img.getHeight(); i += 2) {
                for (int j = 0; j < img.getWidth(); j += 2) {

                    Integer[] average = img.getPixel(i, j).getPixelValue();

                    if (i + 1 < img.getWidth() && j + 1 < img.getHeight()) {

                        Integer[] tmp = img.getPixel(i, j + 1).getPixelValue();
                        addArrays(average, tmp);

                        tmp = img.getPixel(i + 1, j).getPixelValue();
                        addArrays(average, tmp);

                        tmp = img.getPixel(i + 1, j + 1).getPixelValue();
                        addArrays(average, tmp);

                    }

                    newimg.setPixel(new PixelPPM(img.getMaxValue(), average[0] / 4,
                            average[1] / 4, average[2] / 4), i /2 , j / 2);
                }
            }

        return newimg;
    }

    /**
     * Check if two images are the same
     * @param img1 First image
     * @param img2 Second image
     * @return Returns true of they are the same and false if they aren't
     */
    public static boolean areIdentical(Image img1, Image img2) {

        if (img1 == img2)
            return true;

        if (img1.getClass() != img1.getClass())
            return false;

        if ((!img1.getWidth().equals(img2.getWidth())) && (!img1.getHeight().equals(img2.getHeight())))
            return false;

        for (int i = 0; i < img1.getHeight(); i++) {
            for (int j = 0; j < img1.getWidth(); j++) {
                if (Arrays.equals(img1.getPixel(i, j).getPixelValue(), img2.getPixel(i, j).getPixelValue()))
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
