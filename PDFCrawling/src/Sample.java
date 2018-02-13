import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 * 
 */

/**
 * @author headrun
 *
 */
public class Sample {

	/**
	 * 
	 */
	public Sample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("/home/headrun/workspace/PDFCrawling/src/Pan_1.pdf");
	    PDDocument document = PDDocument.load(file);
	    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	    stripper.setSortByPosition(true);
	    Rectangle rect1 = new Rectangle();
	    Rectangle rect2 = new Rectangle(54, 275, 40, 100); 
	    stripper.addRegion("row1column1", rect1);
	    stripper.addRegion("row1column2", rect2);
	    Iterable<PDPage> allPages = document.getDocumentCatalog().getPages();
	    Iterable<PDPage> pages = document.getDocumentCatalog().getPages();
	    int j = 0;

	    for (PDPage page : pages) {
	        stripper.extractRegions(page);
	        stripper.setSortByPosition(true);
	        List<String> regions = stripper.getRegions();
	        for (String region : regions) {
	            String text = stripper.getTextForRegion(region);
	            System.out.println("Region: " + region + " on Page " + j);
	            System.out.println("\tText: \n" + text);
	        }

	}

}
}
