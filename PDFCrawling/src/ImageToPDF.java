import java.io.FileOutputStream;

//com.lowagie...   old version
//com.itextpdf...  recent version
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;


public class ImageToPDF {
  public static void main(String ... args) {
    Document document = new Document();
    String input = "/home/headrun/workspace/PDFCrawling/src/Headrun_Smaller.jpg"; // .gif and .jpg are ok too!
    String output = "/home/headrun/workspace/PDFCrawling/src/capture.pdf";
    try {
      FileOutputStream fos = new FileOutputStream(output);
      PdfWriter writer = PdfWriter.getInstance(document, fos);
      writer.open();
      document.open();
      document.add(Image.getInstance(input));
      document.close();
      writer.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}