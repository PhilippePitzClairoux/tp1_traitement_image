package com.anonymous;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] argv) {

        PGM test = new PGM(10, 10, 255);
        PGM test1 = new PGM(10, 10, 255);

        //PGM test3 = new PGM(0, 0, 255);

        for (int i = 0; i < test.getWidth(); i++) {
            for (int j = 0; j < test.getHeight(); j++) {
                test.setPixel(new PixelPGM(255, (int) ((Math.random() * 100) % 255)), i, j);
                test1.setPixel(new PixelPGM(255, (int) ((Math.random() * 100) % 255)), i, j);
            }
        }


        printArray(test);

        ImageManager.areIdentical(test, test1);
        test = (PGM) ImageManager.resize(test);
        System.out.println("New image : \n");
        printArray(test);

    }

    private static void printArray(PGM test) {

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