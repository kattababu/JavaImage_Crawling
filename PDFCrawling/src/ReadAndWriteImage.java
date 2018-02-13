import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ReadAndWriteImage
{	
	public static void main(String[] args)
	{	
		File file = new File("/home/headrun/workspace/PDFCrawling/src/Headrun.jpg");
		
		BufferedImage image = null;
		
		String name = "/home/headrun/workspace/PDFCrawling/src/Headrun.jpg";
		
		try 
		{
			image = ImageIO.read(file);
			
			ImageIO.write(image, "jpg", new File("/home/headrun/workspace/PDFCrawling/src/Headrun_M.jpg"));
			
			autoCrop(image);
			getCroppedImage(name);
			
			//ImageIO.write(image, "png", new File("I:/output.png"));
			
			//ImageIO.write(image, "gif", new File("I:/output.gif"));
			
			//ImageIO.write(image, "bmp", new File("I:/output.bmp"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("done");
	}


private static void autoCrop(BufferedImage sourceImage) throws IOException {
    int left = 0;
    int right = 0;
    int top = 0;
    int bottom = 0;
    boolean firstFind = true;
    System.out.println(sourceImage);
    for (int x = 0; x < sourceImage.getWidth(); x++) {
        for (int y = 0; y < sourceImage.getWidth(); y++) {
            // pixel is not empty
            if (sourceImage.getRGB(x, y) != 0) {

                // we walk from left to right, thus x can be applied as left on first finding
                if (firstFind) {
                    left = x;
                }

                // update right on each finding, because x can grow only
                right = x;

                // on first find apply y as top
                if (firstFind) {
                    top = y;
                } else {
                    // on each further find apply y to top only if a lower has been found
                    top = Math.min(top, y);
                }

                // on first find apply y as bottom
                if (bottom == 0) {
                    bottom = y;
                } else {
                    // on each further find apply y to bottom only if a higher has been found
                    bottom = Math.max(bottom, y);
                }
                firstFind = false;
            }
        }
    }

    BufferedImage SubImgage = sourceImage.getSubimage(left, top, right - left, bottom - top);
    
    
    File outputfile = new File("/home/headrun/workspace/PDFCrawling/src/Headrun_croppedImage.jpg");
	ImageIO.write(SubImgage, "jpg", outputfile);
}


private static Image getCroppedImage(String address) throws IOException{
    BufferedImage source = ImageIO.read(new File(address)) ;

    boolean flag = false ;
    int upperBorder = -1 ; 
    do{
        upperBorder ++ ;
        for (int c1 =0 ; c1 < source.getWidth() ; c1++){
            if(source.getRGB(c1, upperBorder) != Color.WHITE.getRGB() ){
                flag = true;
                break ;
            }
        }

        if (upperBorder >= source.getHeight())
            flag = true ;
    }while(!flag) ;

    BufferedImage destination = new BufferedImage(source.getWidth(), source.getHeight() - upperBorder, BufferedImage.TYPE_INT_ARGB) ;
    destination.getGraphics().drawImage(source, 0, upperBorder*-1, null) ;

    return destination ;
}


}



