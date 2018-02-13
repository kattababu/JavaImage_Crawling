import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.image.ImageParser;
import org.apache.tika.parser.jpeg.JpegParser;
import org.apache.tika.parser.ocr.TesseractOCRConfig;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.BodyContentHandler;


import org.xml.sax.SAXException;

public class JpegParse {

   public static void main(final String[] args) throws IOException,SAXException, TikaException {

      //detecting the file type
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File("/home/headrun/workspace/PDFCrawling/src/Pan_1.pdf"));
      ParseContext pcontext = new ParseContext();
      
      //Jpeg Parse
      //JpegParser  JPpegParser = new JpegParser();
      /*
      ImageParser Iparser = new ImageParser();
      //JpegParser.parse(inputstream, handler, metadata,pcontext);
      Iparser.parse(inputstream, handler, metadata,pcontext);
      System.out.println("Contents of the document:" + handler.toString());
      System.out.println("Metadata of the document:");
      String[] metadataNames = metadata.names();
      
      for(String name : metadataNames) { 		        
         System.out.println(name + ": " + metadata.get(name));
      }
      */
      
      
      
      
     // InputStream stream = new FileInputStream(inputFile);

      Parser parser = new AutoDetectParser();
      BodyContentHandler handler1 = new BodyContentHandler(
              Integer.MAX_VALUE);

      TesseractOCRConfig config = new TesseractOCRConfig();
      config.setTesseractPath("/usr/share/tesseract-ocr/tessdata/");
      PDFParserConfig pdfConfig = new PDFParserConfig();
      ParseContext parseContext = new ParseContext();

      parseContext.set(TesseractOCRConfig.class, config);
      parseContext.set(PDFParserConfig.class, pdfConfig);
      parseContext.set(Parser.class, parser); // need to add this to make
                                              // sure recursive parsing
                                              // happens!
      Metadata metadata1 = new Metadata();
      metadata.set(Metadata.CONTENT_TYPE, "image/jpg");
      parser.parse(inputstream, handler1, metadata1, parseContext);
      
      String text = handler1.toString().trim();
      System.out.println(text);
      
      
      
      
      
      
      
    /*
      
      Parser parser = new AutoDetectParser();
      BodyContentHandler handler1 = new BodyContentHandler();
      Metadata metadata1 = new Metadata();

      TesseractOCRConfig config = new TesseractOCRConfig();
      config.setTesseractPath("/usr/share/tesseract-ocr/");
      ParseContext parseContext = new ParseContext();
      parseContext.set(TesseractOCRConfig.class, config);



      try {
          parser.parse(inputstream, handler1, metadata1, parseContext);
      } finally {
          inputstream.close();
      }

      System.out.println(handler1.toString());
      */
      
   }
}