import net.sourceforge.tess4j.*;
import java.io.*;
public class App {


    public String getImgText(String imageLocation) {
      ITesseract instance = new Tesseract();
      
      instance.setDatapath("/usr/share/tesseract-ocr/");
      instance.setLanguage("eng");
      try 
      {
         String imgText = instance.doOCR(new File(imageLocation));
         return imgText;
      } 
      catch (TesseractException e) 
      {
         e.getMessage();
         return "Error while reading image";
      }
    }
    public static void main ( String[] args)
    {
      App app = new App();
      System.out.println(app.getImgText("/SurendraSample/Pan_I1.jpg"));
    }
}