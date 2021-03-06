import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TrimWhite {
    private BufferedImage img;

    public TrimWhite(File input) {
        try {
            img = ImageIO.read(input);
            System.out.println(img);
        } catch (IOException e) {
            throw new RuntimeException( "Problem reading image", e );
        }
    }

    public void trim() {
        int width  = getTrimmedWidth();
        int height = getTrimmedHeight();

        BufferedImage newImg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = newImg.createGraphics();
        g.drawImage( img, 0, 0, null );
        img = newImg;
        System.out.println(img);
    }
    
    public void write(File f) {
        try {
            ImageIO.write(img, "bmp", f);
        } catch (IOException e) {
            throw new RuntimeException( "Problem writing image", e );
        }
    }

    private int getTrimmedWidth() {
        int height       = this.img.getHeight();
        int width        = this.img.getWidth();
        int trimmedWidth = 0;

        for(int i = 0; i < height; i++) {
            for(int j = width - 1; j >= 0; j--) {
                if(img.getRGB(j, i) != Color.WHITE.getRGB() &&
                        j > trimmedWidth) {
                    trimmedWidth = j;
                    break;
                }
            }
        }

        return trimmedWidth;
    }
    
    
    private int getTrimmedHeight() {
        int width         = this.img.getWidth();
        int height        = this.img.getHeight();
        int trimmedHeight = 0;

        for(int i = 0; i < width; i++) {
            for(int j = height - 1; j >= 0; j--) {
                if(img.getRGB(i, j) != Color.WHITE.getRGB() &&
                        j > trimmedHeight) {
                    trimmedHeight = j;
                    break;
                }
            }
        }

        return trimmedHeight;
    }

    public static void main(String[] args) {
        TrimWhite trim = new TrimWhite(new File("/home/headrun/workspace/PDFCrawling/src/Headrun.bmp"));
        trim.trim();
        trim.write(new File("/home/headrun/workspace/PDFCrawling/src/Headrun_M.bmp"));
    }
}