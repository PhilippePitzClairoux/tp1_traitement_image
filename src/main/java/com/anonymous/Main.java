package com.anonymous;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] argv) {

        PPM test = new PPM(10, 10, 255);
        PPM test1 = new PPM(10, 10, 255);
        PPM test2 = new PPM(10, 10, 1);
        PGM test3 = new PGM(10, 10, 1);

        //PGM test3 = new PGM(0, 0, 255);

        for (int i = 0; i < test.getWidth(); i++) {
            for (int j = 0; j < test.getHeight(); j++) {
                test1.setPixel(new PixelPPM((int) ((Math.random() * 100) % 255),(int) ((Math.random() * 100) % 255), (int) ((Math.random() * 100) % 255)), j, i);
                test.setPixel(new PixelPPM((int) ((Math.random() * 100) % 255),(int) ((Math.random() * 100) % 255), (int) ((Math.random() * 100) % 255)), j, i);
            }
        }

        ImageManager.copy(test, test1);
        System.out.println("Are the images the same ? " + ImageManager.areIdentical(test, test1));


        printArray(test);

        //test = (PPM) ImageManager.resize(test);
        System.out.println("New image : \n");
        printArray(test);

        //openFile and writeFile with pgm
        File f = new File("test.pgm");
        ImageManager.openFile(test3 , f);
        ImageManager.brightness(test3, 1024);
        File f1 = new File("output.pgm");
        ImageManager.writeFile(test3, f1);

        //openFile and writeFile with PPM
        File f2 = new File("wow.ppm");
        ImageManager.openFile(test, f2);
        test = (PPM) ImageManager.resize(test);
        File f3 = new File("output.ppm");
        ImageManager.writeFile(test, f3);




    }

    private static void printArray(Image test) {

        System.out.println("Width : " + test.getWidth());
        System.out.println("Height : " + test.getHeight());

        for (int i = 0; i < test.getHeight(); i++) {
            for (int j = 0; j < test.getWidth(); j++) {
                System.out.print(Arrays.toString(test.getPixel(i, j).getPixelValue()));
            }
            System.out.println();
        }
    }
}