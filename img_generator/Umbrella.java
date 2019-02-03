import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Umbrella {
	public static void main(String[] args) {
		try {
            int l = 180;
            boolean flag = false;
            float x, y, x2, y2, r2, R2;
            Color Top1 = new Color(243, 115, 53);
            Color Top2 = new Color(43, 50, 178);
            Color Bottom1 = new Color(253, 200, 48);
            Color Bottom2 = new Color(20, 136, 204);
			BufferedImage img = new BufferedImage(l, l, BufferedImage.TYPE_3BYTE_BGR);
            Graphics g = img.getGraphics();
            R2 = l * l / 4.0f;
            for (int i = 0; i < l; i ++) {
                for (int j = 0; j < l; j ++) {
                    flag = false;
                    x = l / 2.0f - i;
                    y = - j + l / 2.0f;
                    x2 = x * x;
                    y2 = y * y;
                    r2 = x2 + y2;
                    if (flag) {
                        g.setColor(new Color(
                            (Top2.getRed() * (l - j) + Bottom2.getRed() * j) / l,
                            (Top2.getGreen() * (l - j) + Bottom2.getGreen() * j) / l,
                            (Top2.getBlue() * (l - j) + Bottom2.getBlue() * j) / l
                        ));
                    } else {
                        g.setColor(new Color(
                            (Top1.getRed() * (l - j) + Bottom1.getRed() * j) / l,
                            (Top1.getGreen() * (l - j) + Bottom1.getGreen() * j) / l,
                            (Top1.getBlue() * (l - j) + Bottom1.getBlue() * j) / l
                        ));
                    }
                    g.drawLine(i, j, i, j);
                }
            }
			g.dispose();
			ImageIO.write(img, "png", new File("./Umbrella.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}