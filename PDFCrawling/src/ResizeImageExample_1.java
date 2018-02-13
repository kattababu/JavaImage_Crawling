import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResizeImageExample_1 {

    public static void main(String... args) throws IOException {

        File input = new File("/home/headrun/workspace/PDFCrawling/src/Headrun_croppedImage.jpg");
        BufferedImage image = ImageIO.read(input);

        BufferedImage resized = resize(image, 554, 858);

        File output = new File("/home/headrun/workspace/PDFCrawling/src/Headrun-858x554.jpg");
        ImageIO.write(resized, "jpg", output);

    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}