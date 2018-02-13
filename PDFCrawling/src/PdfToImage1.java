import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
public class PdfToImage1 {

   public static void main(String args[]) throws Exception {

      //Loading an existing PDF document
	   ITesseract instance = new Tesseract();
      File file = new File("/home/headrun/workspace/PDFCrawling/src/capture.pdf");
      PDDocument document = PDDocument.load(file);
       
      //Instantiating the PDFRenderer class
      PDFRenderer renderer = new PDFRenderer(document);
      instance.setDatapath("/usr/share/tesseract-ocr");
      instance.setLanguage("eng");

      //Rendering an image from the PDF document
      BufferedImage image = renderer.renderImage(0);
      
      Rectangle rect = new Rectangle(200,25,70,45);
      String name = instance.doOCR(image, rect).trim();
      System.out.println("Name:"+name);

      //Writing the image to a file
      ImageIO.write(image, "JPEG", new File("/home/headrun/workspace/PDFCrawling/src/myimage.jpg"));
       
      System.out.println("Image created");
       
      //Closing the document
      document.close();

   }
}