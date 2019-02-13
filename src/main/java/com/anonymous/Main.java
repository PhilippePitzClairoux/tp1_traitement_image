package com.anonymous;


import com.anonymous.image.Image;
import com.anonymous.image.PGM;
import com.anonymous.image.PPM;
import com.anonymous.pixel.PixelPGM;
import com.anonymous.pixel.PixelPPM;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] argv) {

        PPM test = new PPM(10, 10, 255);
        PPM test1 = new PPM(10, 10, 255);
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
        File f = new File("test_images/test.pgm");
        ImageManager.openFile(test3 , f);
        printArray(test3);
        ImageManager.brightness(test3, -30);
        File f1 = new File("test_images/resize.pgm");
        ImageManager.writeFile(test3, f1);

        //openFile and writeFile with PPM
        File f2 = new File("test_images/wow.ppm");
        ImageManager.openFile(test, f2);
        test = (PPM) ImageManager.resize(test);
        File f3 = new File("test_images/resize.ppm");
        ImageManager.writeFile(test, f3);

        //openFile and writeFile with pgm
        File f4 = new File("test_images/test.pgm");
        ImageManager.openFile(test3 , f4);
        test3 = (PGM) ImageManager.crop(test3, 0, 0, 3, 3);
        File f5 = new File("test_images/crop.pgm");
        ImageManager.writeFile(test3, f5);

        //openFile and writeFile with PPM
        File f6 = new File("test_images/wow.ppm");
        ImageManager.openFile(test, f6);
        test = (PPM) ImageManager.crop(test, 0, 0, 0, 5);
        File f7 = new File("test_images/crop.ppm");
        ImageManager.writeFile(test, f7);

        //openFile and writeFile with PPM
        File f8 = new File("test_images/wow.ppm");
        ImageManager.openFile(test, f8);
        test = (PPM) ImageManager.rotate(test);
        File f9 = new File("test_images/rotate.ppm");
        ImageManager.writeFile(test, f9);

        //openFile and writeFile with PPM
        File f10 = new File("test_images/test.pgm");
        ImageManager.openFile(test3, f10);
        test3 = (PGM) ImageManager.rotate(test3);
        File f11 = new File("test_images/rotate.pgm");
        ImageManager.writeFile(test3, f11);

        PixelPGM ppgm = (PixelPGM) ImageManager.dominantColor(test3);
        PixelPPM  ppm = (PixelPPM) ImageManager.dominantColor(test);

        printArray(test3);
        printArray(test);

        System.out.printf("Predominant color of test.pgm : %s%n", Arrays.toString(ppgm.getPixelValue()));
        System.out.printf("Predominant color of test.pgm : %s%n", Arrays.toString(ppm.getPixelValue()));

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