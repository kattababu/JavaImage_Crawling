//import java.awt.color.ColorSpace;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
//import java.awt.image.ColorConvertOp;
import java.io.File;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.*;
//import net.sourceforge.tess4j.util.ImageHelper;

public class TesseractExample {

    public static void main(String[] args) throws Exception {
        //File imageFile = new File("/home/headrun/workspace/PDFCrawling/src/HDSCAN.v3.jpg");
        File imageFile = new File("/home/headrun/workspace/PDFCrawling/src/Sample.jpg");
        ITesseract instance = new Tesseract();  // JNA Interface Mappin
       
        BufferedImage img = ImageIO.read(imageFile);
        instance.setDatapath("/usr/share/tesseract-ocr");
        instance.setLanguage("eng");

        try {
        	
        	/*
        	//Rectangle rect = new Rectangle(17,75,265,35);
        	//String name = instance.doOCR(img, rect).trim();
            //System.out.println("Name:"+name);
        	
        	Rectangle rect = new Rectangle(17,135,545,90);
        	String name = instance.doOCR(img, rect).trim();
            System.out.println("Name:"+name);
            
            
            
            //Rectangle rect2 = new Rectangle(17,95,275,60);
        	//String name2 = instance.doOCR(img, rect2).trim();
            //System.out.println("Name:"+name2);
           
            //Rectangle rect3 = new Rectangle(17,145,195,68);
        	//String name3 = instance.doOCR(img, rect3).trim();
            //System.out.println("Name:"+name3);
          
            
            Rectangle rect4 = new Rectangle(17,275,275,55);
        	String name4 = instance.doOCR(img, rect4).trim();
            System.out.println("DOJ:"+name4);
            
            Rectangle rect5 = new Rectangle(17,355,275,55);
        	String name5 = instance.doOCR(img, rect5).trim();
            System.out.println("PAN NO:"+name5);
            */
              	
        	Rectangle rect = new Rectangle(20,77,200,60);
        	String name = instance.doOCR(img, rect).trim();
            System.out.println("Name:"+name);
        	Rectangle rect1 = new Rectangle(20, 100, 160, 69);
        	String Fath_name = instance.doOCR(img, rect1).trim();
        	System.out.println("Father_Name:"+Fath_name);
        	Rectangle rect3 = new Rectangle(20, 144, 200, 70);
        	String DOB = instance.doOCR(img, rect3).replace(" ","").trim();
        	System.out.println("DOB:"+DOB.replace(" ","").trim());
        	
        	Rectangle rect4 = new Rectangle(20, 225,170, 70);
        	String Panno = instance.doOCR(img, rect4).trim();
        	System.out.println("PAN:"+Panno.replace(" ","").trim());
        	
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}