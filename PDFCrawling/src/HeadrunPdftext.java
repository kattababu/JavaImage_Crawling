

import java.io.BufferedWriter;
import java.io.FileWriter;

import pdfts.examples.XMLOutputTarget;

import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import com.snowtide.pdf.RegionOutputTarget;
import com.snowtide.pdf.VisualOutputTarget;
import com.snowtide.pdf.layout.Rectangle;
 

public class HeadrunPdftext {
  public static void main (String[] args) throws java.io.IOException {
    String pdfFilePath = "/home/headrun/workspace/PDFCrawling/src/jpg2pdf.pdf";
	  //String pdfFilePath ="/NutchCrawl/Nutch/runtime/local/pdf/brochure.pdf";
    
    FileWriter fstream = new FileWriter(System.currentTimeMillis() + "Pan_data.txt");
    BufferedWriter out = new BufferedWriter(fstream);
	
    //java.io.StringWriter text = new java.io.StringWriter(1024);
	//VisualOutputTarget tgt = new VisualOutputTarget(text);
    //Rectangle rect = new Rectangle();
    
	 
	RegionOutputTarget tgt = new RegionOutputTarget();
	 System.out.print(tgt);
	 
	 tgt.addRegion(40,70,80,50, "INCOME");
	 //tgt.addRegion(100, 10, 50, 16, "address");
	 
	 
	 
 
    Document pdf = PDF.open(pdfFilePath);
    System.out.println(pdf);
        //StringBuilder text = new StringBuilder(1024)
    pdf.pipe(tgt);
    pdf.close();
    String name = tgt.getRegionText("INCOME");
    
    //String address = tgt.getRegionText("address");
    System.out.println(name);
    //System.out.println(address);
    
    //out.write(text.toString());
    out.close();
  }
}