package com.anonymous;

import java.io.File;
import java.util.Arrays;

/**
 * Read a PGM or PPM image from a file and test operations on the image
 * @author Philippe Pitz Clairoux & Cynthia Vilanova
 * Date of creation: February 7, 2019
 */
public class Main {

    /**
     *
     * @param argv
     */
    public static void main(String[] argv) {

        PPM testPPM = new PPM(10, 10, 255);
        PPM test1PPM = new PPM(10, 50, 255);
        PGM testPGM = new PGM(10, 10, 255);

        //openFile and writeFile with pgm
        File f = new File("test2.pgm");
        ImageManager.openFile(testPGM , f);
        //ImageManager.brightness(testPGM, 1024);
        File f1 = new File("output.pgm");
        ImageManager.writeFile(testPGM, f1);
        
        //openFile and writeFile with PPM
        File f2 = new File("wow.ppm");
        ImageManager.openFile(testPPM, f2);
        
        // Original PPM
        System.out.println("\nOriginal PPM image:");
        printArray(testPPM);
        
        
        testPPM = (PPM) ImageManager.resize(testPPM);
        System.out.println("\nNew image PGM after resize: ");
        printArray(testPPM);
        
        File f3 = new File("output.ppm");
        ImageManager.writeFile(testPPM, f3);
        
        // Rotate image PPM
        testPPM = (PPM) ImageManager.rotate(testPPM);
        System.out.println("\nNew image PPM after rotate: ");
        printArray(testPPM);
        testPPM = (PPM) ImageManager.rotate(testPPM);
        System.out.println("\nNew image PPM after second rotate: ");
        printArray(testPPM);
        
        //ImageManager.copy(testPPM, test1PPM);
        //System.out.println("Are the images the same ? " + ImageManager.areIdentical(testPPM, test1PPM));
        
        //Original image
        System.out.println("\nOriginal PGM image:");
        printArray(testPGM);
       
        // Resize
        testPGM = (PGM) ImageManager.resize(testPGM);
        System.out.println("\nNew image PGM after resize: ");
        printArray(testPGM);
        
        // Rotate image PGM
        testPGM = (PGM) ImageManager.rotate(testPGM);
        System.out.println("\nNew image PGM after rotate: ");
        printArray(testPGM);
        
        //Dominant color
        Pixel dominantColorPPM = ImageManager.dominantColor(testPPM);
        System.out.println("\nDominant color in PPM: " + Arrays.toString(dominantColorPPM.getPixelValue()));
        Pixel dominantColorPGM = ImageManager.dominantColor(testPGM);
        System.out.println("Dominant color in PGM: " + Arrays.toString(dominantColorPGM.getPixelValue()));
        
    }

    private static void printArray(Image test) {

        System.out.println("Width : " + test.getWidth());
        System.out.println("Height : " + test.getHeight());

        for (int i = 0; i < test.getHeight(); i++) {
            for (int j = 0; j < test.getWidth(); j++) {
                System.out.print(Arrays.toString(test.getPixel(j, i).getPixelValue()));
            }
            System.out.println();
        }
    }
}