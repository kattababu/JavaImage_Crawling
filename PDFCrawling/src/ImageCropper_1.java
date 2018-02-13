/* ImageCropper.java */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCropper_1 {

	public static void main(String[] args) {
		try {
			BufferedImage originalImgage = ImageIO.read(new File("/home/headrun/workspace/PDFCrawling/src/Headrun.jpg"));
			
			System.out.println("Original Image Dimension: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());

			BufferedImage SubImgage = originalImgage.getSubimage(40,70,680,445);
			System.out.println("Cropped Image Dimension: "+SubImgage.getWidth()+"x"+SubImgage.getHeight());

			File outputfile = new File("/home/headrun/workspace/PDFCrawling/src/Headrun_croppedImage.jpg");
			ImageIO.write(SubImgage, "jpg", outputfile);

			System.out.println("Image cropped successfully: "+outputfile.getPath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}