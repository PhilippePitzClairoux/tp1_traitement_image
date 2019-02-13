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

        ImageManager.copy(test, test1); //images will be the same after this
        System.out.println("Are the images the same ? " + ImageManager.areIdentical(test, test1));

        //openFile and writeFile with pgm
        File f = new File("test.pgm");
        ImageManager.openFile(test3 , f);
        ImageManager.brightness(test3, -30);
        File f1 = new File("output.pgm");
        ImageManager.writeFile(test3, f1);

        //openFile and writeFile with PPM
        File f2 = new File("wow.ppm");
        ImageManager.openFile(test, f2);
        test = (PPM) ImageManager.resize(test);
        File f3 = new File("output.ppm");
        ImageManager.writeFile(test, f3);

        //openFile and writeFile with pgm
        File f4 = new File("test.pgm");
        ImageManager.openFile(test3 , f4);
        test3 = (PGM) ImageManager.crop(test3, 0, 0, 3, 3);
        File f5 = new File("crop.pgm");
        ImageManager.writeFile(test3, f5);

        //openFile and writeFile with PPM
        File f6 = new File("wow.ppm");
        ImageManager.openFile(test, f6);
        test = (PPM) ImageManager.crop(test, 0, 0, 0, 5);
        File f7 = new File("crop.ppm");
        ImageManager.writeFile(test, f7);



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