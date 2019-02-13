package tp1;

/**
 *
 * @author Thia
 */
public class PGM extends Image {

    private final String header = "P2";

    /**
     * PGM constructor
     * @param width Width of the PGM image
     * @param height Height of the PGM image
     * @param maxValue Max value a PGM image pixel can have
     */
    public PGM(Integer width, Integer height, Integer maxValue) {

        super(width, height, maxValue, "P2");
    }

    @Override
    public void setPixel(Pixel pix, Integer x, Integer y) {

        if (pix == null)
            throw new RuntimeException("Cannot pass a null pixel");

        if (!(pix instanceof PixelPGM))
            throw new RuntimeException("Must instanciate PixelPGM for PGM images.");


        super.setPixel(pix, x, y);
    }
}
