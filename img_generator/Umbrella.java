import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Umbrella {
	public static void main(String[] args) {
		try {
            int l = 180;
            double k = 0;
            BufferedImage img = new BufferedImage(l, l, BufferedImage.TYPE_3BYTE_BGR);
            Graphics g = img.getGraphics();
            Color a = new Color(0, 63, 255);
            Color b = new Color(255, 63, 0);
//            Color a = new Color(255, 63, 0);
//            Color b = new Color(0, 106, 255);
//            Color d = new Color(0, 106, 255);
//            Color c = new Color(255, 63, 0);
            for (int i = 0; i < l; i ++) {
                for (int j = 0; j < l; j ++) {
/*                    g.setColor(new Color(
                        (a.getRed() * i * j + b.getRed() * i * (l - j) + c.getRed() * (l - i) * j + d.getRed() * (l - i) * (l - j)) / (l * l),
                        (a.getGreen() * i * j + b.getGreen() * i * (l - j) + c.getGreen() * (l - i) * j + d.getGreen() * (l - i) * (l - j)) / (l * l),
                        (a.getBlue() * i * j + b.getBlue() * i * (l - j) + c.getBlue() * (l - i) * j + d.getBlue() * (l - i) * (l - j)) / (l * l)
                    ));
*/
//                    k = Math.sqrt(Math.sqrt((Math.pow(j - l, 2) + Math.pow(i - l / 2.0f, 2)) / (Math.pow(l, 2) + Math.pow(l / 2.0f, 2))));
                    k = (Math.sqrt((Math.pow(j - l / 2.0f, 2) + Math.pow(i - l / 2.0f, 2)) / (Math.pow(l / 2.0f, 2) + Math.pow(l / 2.0f, 2))));
                    g.setColor(new Color(
                        (int)(a.getRed() * k + b.getRed() * (1.0f - k)),
                        (int)(a.getGreen() * k + b.getGreen() * (1.0f - k)),
                        (int)(a.getBlue() * k + b.getBlue() * (1.0f - k))
                    ));
                    g.drawLine(i, j, i, j);
                }
            }
			g.dispose();
            ImageIO.write(img, "png", new File("./Umbrella.png"));
/*
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
*/
		}catch(Exception e) {
            e.printStackTrace();
		}
    }
}