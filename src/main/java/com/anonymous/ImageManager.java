package com.anonymous;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

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
     * @param file The name of the file to open.
     */
    public static void openFile(Image img, File file){
        try {
            Scanner input = new Scanner(file);
            String buff, header = "";

            //get header
            while((buff = input.nextLine()) != null) {

                if (buff.contains("#"))
                    continue;

                if (!buff.equals("P3") && !buff.equals("P2"))
                    throw new RuntimeException("Invalid header found");
                else {
                    header = buff;
                    break;
                }
            }

            while((buff = input.nextLine()) != null) {

                if (!buff.matches(" ") && !buff.startsWith("#")){
                    String[] stats = buff.split(" ");
                    if (stats.length != 2)
                        throw new RuntimeException("Invalid Size");
                    else {
                        img.setWidth(Integer.parseInt(stats[0]));
                        img.setHeight(Integer.parseInt(stats[1]));
                        img.updateInternalData();
                        break;
                    }
                }
            }

            while((buff = input.nextLine()) != null)
                if(!buff.startsWith("#") && !buff.equals("")) {
                    img.setMaxValue(Integer.parseInt(buff));
                    break;
                }

            img.updateInternalData();
            if (img.header.equals("P3")) {
                for (int i = 0; i < img.getHeight(); i++) {
                    for (int j = 0; j < img.getWidth(); j++) {
                        img.setPixel(new PixelPPM(input.nextInt(),
                                input.nextInt(), input.nextInt()), j, i);
                    }
                }
            } else {

                for (int i = 0; i < img.getHeight(); i++) {
                    for (int j = 0; j < img.getWidth(); j++) {
                        img.setPixel(new PixelPGM(Integer.parseInt(input.next())), j, i);
                    }
                }

            }

            input.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    /**
     * Write an image to a file based on it's type (PPM or PGM)
     * @param img The image to write to the file
     * @param file File to write image in
     */
    public static void writeFile(Image img, File file) {

        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(file));

            //write header!
            out.write(String.format("%s%n", img.header));
            //write width and height!
            out.write(String.format("%d %d%n", img.getWidth(), img.getHeight()));
            //write max value!
            out.write(String.format("%d%n", img.getMaxValue()));

            if (img.header.equals("P2")) {
                for (int i = 0; i < img.getHeight(); i++) {
                    for (int j = 0; j < img.getWidth(); j++) {
                        Integer[] vals = img.getPixel(j, i).getPixelValue();
                        out.write(String.format("%d ", vals[0]));
                    }
                    out.write(String.format("%n"));
                }
            } else {
                for (int i = 0; i < img.getHeight(); i++) {
                    for (int j = 0; j < img.getWidth(); j++) {
                        Integer[] vals = img.getPixel(j, i).getPixelValue();
                        out.write(String.format("%d %d %d ", vals[0], vals[1], vals[2]));
                    }
                    out.write(String.format("%n"));
                }
            }

            out.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Copy img1 into img2
     * @param src To copy from
     * @param dest To copy to
     */
    public static void copy(Image src, Image dest) {

        if (ImageManager.areIdentical(src, dest))
            throw new RuntimeException("Images are already Identical");

        if (!src.header.equals(dest.header))
            throw new RuntimeException("Classes differenciate. This cannot happen.");

        dest.setWidth(src.getWidth());
        dest.setHeight(src.getHeight());
        dest.updateInternalData();

        if (src.header.equals("P3")) {
            for (int i = 0; i < src.getHeight(); i++) {
                for (int j = 0; j < src.getWidth(); j++) {
                    Integer[] vals = src.getPixel(j, i).getPixelValue();
                    dest.setPixel(new PixelPPM(vals[0], vals[1], vals[2]), j, i);
                }
            }
        } else {
            for (int i = 0; i < src.getHeight(); i++) {
                for (int j = 0; j < src.getWidth(); j++) {
                    dest.setPixel(new PixelPGM(src.getPixel(j, i).getPixelValue()[0]), j, i);
                }
            }
        }
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

        return new Image(100, 100, img.getMaxValue(), "");
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

        if (img.header.equals("P2"))
            for (int i = 0; i < img.getHeight(); i+=2) {
                for (int j = 0; j < img.getWidth(); j+=2) {

                    int average = img.getPixel(i, j).getPixelValue()[0];

                    if (i + 1 <= img.getHeight() && j + 1 <= img.getWidth()) {
                        average += img.getPixel(i, j+1).getPixelValue()[0];
                        average += img.getPixel(i + 1, j).getPixelValue()[0];
                        average += img.getPixel(i + 1, j + 1).getPixelValue()[0];
                    }

                    newimg.setPixel(new PixelPGM(average / 4), i / 2, j / 2);
                }
            }
        else
            for (int i = 0; i < img.getHeight(); i += 2) {
                for (int j = 0; j < img.getWidth(); j += 2) {

                    Integer[] average = img.getPixel(j, i).getPixelValue();
                    Integer[] tmp;

                    if (j + 1 < img.getWidth() && i + 1 < img.getWidth()){
                        tmp = img.getPixel(j + 1, i + 1).getPixelValue();
                        addArrays(average, tmp);
                    } else if (j + 1 < img.getWidth()) {
                        tmp = img.getPixel(j + 1, i).getPixelValue();
                        addArrays(average, tmp);
                    } else if (i + 1 < img.getHeight()) {
                        tmp = img.getPixel(j, i + 1).getPixelValue();
                        addArrays(average, tmp);
                    }

                    newimg.setPixel(new PixelPPM(average[0] / 4,
                            average[1] / 4, average[2] / 4), j /2 , i / 2);
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

        if (!img1.header.equals(img2.header))
            return false;

        if ((!img1.getWidth().equals(img2.getWidth())) && (!img1.getHeight().equals(img2.getHeight())))
            return false;

        for (int i = 0; i < img1.getHeight(); i++) {
            for (int j = 0; j < img1.getWidth(); j++) {
                if (!Arrays.equals(img1.getPixel(j, i).getPixelValue(), img2.getPixel(j, i).getPixelValue()))
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
