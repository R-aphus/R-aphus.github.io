import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class CoverPick {
	public static void main(String[] args) {
		try {
            int l = 180;
            int bright;
            float x, y, x2, y2, r, sin2, cos4, cos2;
			BufferedImage img = new BufferedImage(l, l, BufferedImage.TYPE_3BYTE_BGR);
			Graphics g = img.getGraphics();
            for (int i = 0; i < l; i ++) {
                for (int j = 0; j < l; j ++) {
                    x = l / 2.0f - i;
                    y = j - l / 2.0f;
                    x2 = x * x;
                    y2 = y * y;
                    sin2 = y2 / (x2 + y2);
                    cos2 = x2 / (x2 + y2);
                    cos4 = 1.0f - 8.0f * sin2 * cos2;
                    bright = (int)(255 * cos4);
                    if (bright < 0) bright = 0;
                    if (!((y > x && y < -x) || (y > -x && y < x))) {
                        bright = 0;
                    }
                    if (x2 + y2 < l * l / 4.0f / 64.0f) {
                        bright = (int)(255.0f * Math.cos(2.0f * Math.PI * Math.sqrt(x2 + y2) / (l / 2.0f / 8.0f) + Math.PI));
                        if (bright < 0) bright = 0;
                        g.setColor(new Color(bright, bright, bright));
                        g.drawLine(i, j, i, j);
                    } else {
                        bright *= Math.cos(2.0f * Math.PI * Math.sqrt(x2 + y2) / (l / 2.0f / 8.0f) + Math.PI);
                        if (bright < 0) bright = 0;
                        if (x2 + y2 > l * l / 4.0f) bright = 0;
                        g.setColor(new Color(bright, bright, bright));
                        g.drawLine(i, j, i, j);
                    }
                }
            }
			g.dispose();
			ImageIO.write(img, "png", new File("./CoverPick.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}