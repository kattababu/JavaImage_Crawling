import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.Page;
import com.snowtide.pdf.RegionOutputTarget;
import com.snowtide.pdf.SelectionOutputTarget;
import com.snowtide.pdf.layout.Block;
import com.snowtide.pdf.layout.Line;
import com.snowtide.pdf.layout.Table;
import com.snowtide.pdf.util.TableUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class RedBusPDF {
	public static void main(String args[])throws IOException
	{
		

		File file = new File("/home/headrun/workspace/PDFCrawling/src/Pan_1.pdf");
		InputStream inputSt = new FileInputStream(file);
		
		extractTables(inputSt)	;
		
	}

    
    



public static void extractTables(InputStream pdfIs)  {
	try
	{
		
		FileWriter fstream = new FileWriter(System.currentTimeMillis() + "RedBus.txt");
	    BufferedWriter out = new BufferedWriter(fstream);
		
		//java.io.StringWriter text = new java.io.StringWriter(1024);
		 //OutputTarget tgt = new OutputTarget(text);
		 
		  Document pdf = PDF.open(pdfIs, "foo");
    //FileWriter fstream = new FileWriter(System.currentTimeMillis() + "table.txt");
    //BufferedWriter out = new BufferedWriter(fstream);
    
		  
		  RegionOutputTarget tgt = new RegionOutputTarget();
		  System.out.println(tgt);
	         tgt.addRegion(200, 400, 600, 15, "Ticket");
	         tgt.addRegion(160, 570, 200, 15, "Seat Numbers1");
	         
	         tgt.addRegion(15, 555, 170, 25, "Seat Numbers2");
	         tgt.addRegion(20, 590, 100, 20, "Passenger1");
	         tgt.addRegion(160, 590, 215, 20, "Passenger2");
	         
	         
	         tgt.addRegion(160, 650, 100, 20, "Location");
	         tgt.addRegion(250, 650, 190, 20, "Land Mark");
	         
	         tgt.addRegion(450, 650, 350, 20, "Address");
	         tgt.addRegion(450, 635, 350, 15, "Mobile");
	         
	         
	         
	         
	         tgt.addRegion(160, 710, 100, 20, "ReportingTime");
	         
	         tgt.addRegion(200, 710, 200, 20, "ScheduleTime");
	         
	         
	         tgt.addRegion(350, 710,400, 20, "No of Passengers");
	         
	         
	         tgt.addRegion(10,680,130, 50, "Travels");
	         
	         tgt.addRegion(10,750,80, 30, "sourcecity");
	         
	         
	         tgt.addRegion(100,750,65, 30, "destinationcity");
	         
	         
	         tgt.addRegion(180,750,300, 30, "Date of Journey");
	         
	         Page p = pdf.getPage(0);
	         p.pipe(tgt);
	         //pdf.close();
	         
	         String name= tgt.getRegionText("Ticket");
	         //String address = tgt.getRegionText("product");
	        
	        
	        String seat1= tgt.getRegionText("Seat Numbers1");
	        
	        String seat2= tgt.getRegionText("Seat Numbers2");
	        
	        String location= tgt.getRegionText("Location");
	        String landmark= tgt.getRegionText("Land Mark");
	        String Pass= tgt.getRegionText("Passenger1").trim();
	        String Pass2= tgt.getRegionText("Passenger2").trim();
	        
	        String rt= tgt.getRegionText("ReportingTime").trim();
	        String st= tgt.getRegionText("ScheduleTime").trim();
	        String Nopass= tgt.getRegionText("No of Passengers").trim();
	        String travels= tgt.getRegionText("Travels").trim();
	        
	        String scity= tgt.getRegionText("sourcecity").trim();
	        String dcity= tgt.getRegionText("destinationcity").trim();
	        String doj= tgt.getRegionText("Date of Journey").trim();
	        
	        
	        
	        
	        
	        
	        String Address= tgt.getRegionText("Address").trim();
	        
	        
	        

	        //String sourcecity= tgt.getRegionText("scity");
	        
	        
	        String mobile= tgt.getRegionText("Mobile").replaceAll("[()]", "");
	        //System.out.println(sourcecity);
	        
	        
	       
	        seat1 = seat1.replaceAll("\\s+", "");
	        seat2 = seat2.replaceAll("\\s+", "");
	        
	        location = location.replaceAll("\\s+", "");
	        landmark = landmark.replaceAll("\\s+", "");
	        Address= Address.replaceAll("\\s+", " ");
	        mobile= mobile.replaceAll("\\s+", "");
	        rt= rt.replaceAll("\\s+", "");
	        st= st.replaceAll("\\s+", "");
	        scity= scity.replaceAll("\\s+", "");
	        
	        dcity= dcity.replaceAll("\\s+", "");
	        
	        Nopass= Nopass.replaceAll("\\s+", "");
	        travels= travels.replaceAll("\\s+", "");
	        
	        doj= doj.replaceAll("\\s+", "");
	        
	        
	        
	        
	        
	         String ticketsinfo =name.replaceAll("\n", "#<>#").replaceFirst("#<>#", "").replaceAll("\\s+", "");
	        String pass1info=Pass.replaceAll("\\s+", " ")+"#<>#"+seat2+"#<>#"+location+"#<>#"+landmark+"#<>#"+Address+"#<>#"+mobile+"#<>#"+rt+
	        "#<>#"+st+"#<>#"+scity+"#<>#"+dcity+"#<>#"+doj;
	        
	       String pass2info=Pass2.replaceAll("\\s+", " ")+"#<>#"+seat1+"#<>#"+location+"#<>#"+landmark+"#<>"+Address+"#<>#"+mobile+"#<>#"+rt+
	        "#<>#"+st+"#<>#"+scity+"#<>#"+dcity+"#<>#"+doj;
	       String travelingbus = travels;
	       String nop= Nopass;
	       
	       out.write(ticketsinfo+"\n");
	       out.write(pass1info+"\n");
   	  
	       out.write(pass2info+"\n");
	       out.write(travelingbus+"\n");
	       out.write(nop+"\n");
	       
	       
		  
		  /*
		  StringBuffer sb = new StringBuffer();
		  SelectionOutputTarget tgt = new SelectionOutputTarget(sb, 1, 400,200,100);
		  
		  pdf.getPage(0).pipe(tgt);
		  //p.pipe(tgt);
		  //pdf.close();
		  
		  String selectedText = sb.toString();
		  System.out.println(selectedText);
		  */
		  
		  
		  
		  
		  for (Page page : pdf.getPages()) {
			  
			 
	           List<Table> tables = TableUtils.getAllTables(page);
	           for (Table table : tables) {
	        	   
	        	   //table.pipe(tgt);
	        	     String tableCsv = TableUtils.convertToCSV(table, ',',"\n").trim().replaceAll("\\s+", " ");
	               //String mdtablecsv=tableCsv.replace(',', '#<>#');
	        	    String modifiedtcs=tableCsv.replaceAll("\",", "\"#<>#").replaceAll("\" ", "\" \n");
	        	    //System.out.println(modifiedtcs);
	           //System.out.println(tableCsv.replaceAll("\",", "\"#<>#").replaceAll("\" ", "\n"));
	               out.write(modifiedtcs);
	               
	                        }

	       }
	       //out.close();

    
          pdf.close();
    	   
    	       
       out.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }
}