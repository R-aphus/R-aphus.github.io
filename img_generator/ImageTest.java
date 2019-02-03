import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageTest {
	public static void main(String[] args) {
		try {
            int l = 180;
            int x, y, x2, y2;
            Color top = new Color(243, 115, 53);
            Color bottom = new Color(253, 200, 48);
			BufferedImage img = new BufferedImage(l, l, BufferedImage.TYPE_3BYTE_BGR);
			Graphics g = img.getGraphics();
            g.setColor(Color.WHITE);
            g.drawRect(0, 0, l - 1, l - 1);
            for (int i = 0; i < l; i ++) {
                for (int j = 0; j < l; j ++) {
                    x = i - l / 2;
                    y = j - l / 2;
                    x2 = x * x;
                    y2 = y * y;
                    g.setColor(new Color(
                        (top.getRed() * (l - j) + bottom.getRed() * j) / l,
                        (top.getGreen() * (l - j) + bottom.getGreen() * j) / l,
                        (top.getBlue() * (l - j) + bottom.getBlue() * j) / l
                    ));
                    g.drawLine(i, j, i, j);
                }                    
            }
			g.dispose();
			ImageIO.write(img, "png", new File("./sample.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}