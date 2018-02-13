import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.asprise.ocr.Ocr; 
public class ReadTextfrImage {
    public static void main(String[] args) {
  
    	try
    	{
    		Image src = ImageIO.read(new File("/home/headrun/workspace/PDFCrawling/src/myimage.jpg"));

    		int x = 22, y = 30, w = 240, h = 154;

    		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);

    		ImageIO.write(dst, "jpg", new File("/home/headrun/workspace/PDFCrawling/src/duke_cropped.jpg"));
    		
    		
    		String file = "/SurendraSample/Pan_I1.jpg";
    	Ocr.setUp(); // one time setup
    	Ocr ocr = new Ocr(); // create a new OCR engine
    	
    	ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
  
    		
    		
    		//String s = ocr.recognize(new File[] {new File("/NutchCrawl/Nutch/runtime/local/pdf/brochure234/0-0.png")},
    	  //Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
    	
    	String name = ocr.recognize("/home/headrun/workspace/PDFCrawling/src/HDSCAN.jpg",-1,17,135,195,65,Ocr.RECOGNIZE_TYPE_ALL,Ocr.OUTPUT_FORMAT_PLAINTEXT);
    	System.out.println("Result: " + name);
 
    	//String namef = ocr.recognize("/home/headrun/workspace/PDFCrawling/src/duke_cropped.png",-1,20,100, 160,90,Ocr.RECOGNIZE_TYPE_ALL,Ocr.OUTPUT_FORMAT_PLAINTEXT);
    	//System.out.println("Result: " + namef);
    	
    	//String DOB = ocr.recognize("/home/headrun/workspace/PDFCrawling/src/duke_cropped.png",-1,20,144, 160,75,Ocr.RECOGNIZE_TYPE_ALL,Ocr.OUTPUT_FORMAT_PLAINTEXT);
    	//System.out.println("Result: " + DOB);
    	
    	
    	//String pan = ocr.recognize("/home/headrun/workspace/PDFCrawling/src/duke_cropped.png",-1,20,225, 160,90,Ocr.RECOGNIZE_TYPE_ALL,Ocr.OUTPUT_FORMAT_PLAINTEXT).trim();
    	//System.out.println("Result: " + pan.replace(" ", "").trim());
    	
    
    	
    	
    	
        ocr.stopEngine(); 
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*
    	BufferedImage image = ImageIO.read(new File("/NutchCrawl/Nutch/runtime/local/pdf/brochure234/0-0.png"));     
    	 String imageText = new OCR().recognizeCharacters((RenderedImage) image);    
    	 System.out.println("Text From Image : \n"+ imageText);    
    	 System.out.println("Length of total text : \n"+ imageText.length());     
    	
    	*/
    	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}