package tp1;


import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] argv) {

        PPM testPPM = new PPM(10, 10, 255);
        PPM test1PPM = new PPM(10, 50, 255);
        PGM testPGM = new PGM(10, 10, 255);

        //openFile and writeFile with pgm
        File f = new File("test.pgm");
        ImageManager.openFile(testPGM , f);
        //ImageManager.brightness(testPGM, 1024);
        File f1 = new File("output.pgm");
        ImageManager.writeFile(testPGM, f1);
        
        //openFile and writeFile with PPM
        File f2 = new File("wow.ppm");
        ImageManager.openFile(testPPM, f2);
        testPPM = (PPM) ImageManager.resize(testPPM);
        File f3 = new File("output.ppm");
        ImageManager.writeFile(testPPM, f3);
        
        ImageManager.copy(testPPM, test1PPM);
        System.out.println("Are the images the same ? " + ImageManager.areIdentical(testPPM, test1PPM));
        
        //Original image
        printArray(testPGM);
       
        // Resize
        testPGM = (PGM) ImageManager.resize(testPGM);
        System.out.println("\nNew image after resize: ");
        printArray(testPGM);
        
        // Rotate image
        testPGM = (PGM) ImageManager.rotate(testPGM);
        System.out.println("\nNew image after rotate: ");
        printArray(testPGM);
        
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