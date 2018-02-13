import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;

public class Main_1 extends Canvas {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Main_1() {
    setBackground(Color.white);
  }

  public void paint(Graphics g) {
    try {
      Graphics2D g2D;
      g2D = (Graphics2D) g;
      g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      String fileName = "/home/headrun/workspace/PDFCrawling/src/Headrun.jpg";
      Image img = getToolkit().getImage(fileName);
      AffineTransform aTran = new AffineTransform();
      aTran.translate(100.0f, 100.0f);
      g2D.transform(aTran);

      g2D.drawImage(img, new AffineTransform(), this);

      g2D.setColor(Color.red);
      g2D.drawRect(1, 1, 171, 228);

      FontRenderContext frc = g2D.getFontRenderContext();
      Font font1 = new Font("Courier", Font.BOLD, 8);
      String str1 = new String("Copyright");
      TextLayout tl = new TextLayout(str1, font1, frc);
      g2D.setColor(Color.white);
      tl.draw(g2D, 125, 228);
    } catch (Exception e) {
    }
  }

  public static void main(String s[]) {
    JFrame frame1 = new JFrame("2D Images ");
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.getContentPane().add("Center", new Main_1());
    frame1.pack();
    frame1.setSize(new Dimension(300, 300));
    frame1.setVisible(true);
  }
}