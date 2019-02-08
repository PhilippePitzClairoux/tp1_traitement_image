package com.anonymous;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] argv) {

        PGM test = new PGM(10, 10, 255);
        PPM test1 = new PPM(10, 10, 255);
        //PGM test3 = new PGM(0, 0, 255);

        for (int i = 0; i < test.getWidth(); i++) {
            for (int j = 0; j < test.getHeight(); j++) {
                test.setPixel(new PixelPGM(255, (int) ((Math.random() * 100) % 255)), i, j);
                test1.setPixel(new PixelPPM(255, (int) ((Math.random() * 100) % 255), i, j), i, j);
            }
        }


        for (int i = 0; i < test.getWidth(); i++) {
            for (int j = 0; j < test.getHeight(); j++) {
                System.out.print(Arrays.toString(test.getPixel(i, j).getPixelValue()));
            }
            System.out.println();
        }



    }

}
