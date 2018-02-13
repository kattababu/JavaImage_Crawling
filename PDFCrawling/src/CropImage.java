import java.awt.*;
import javax.swing.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

public class CropImage extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
	Insets insets;

  public CropImage() {
    super("Crop Image");
    ImageIcon icon = new ImageIcon("/home/headrun/workspace/PDFCrawling/src/Headrun.jpg");
    image = icon.getImage();
    image = createImage(new FilteredImageSource(image.
       getSource(),new CropImageFilter(22, 30, 240, 154)));
  }

  public void paint(Graphics g) {
    super.paint(g);
    if (insets == null) {
      insets = getInsets();
    }
    g.drawImage(image, insets.left, insets.top, this);
  }
  public static void main(String args[]) {
    JFrame frame = new CropImage();
    frame.setSize(250, 250);
    frame.show();
  }
}




