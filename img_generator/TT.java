import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class TT {
	public static void main(String[] args) {
		try {
            int l = 180;
            Color Top1 = new Color(243, 115, 53);
            Color Top2 = new Color(43, 50, 178);
            Color Bottom1 = new Color(253, 200, 48);
            Color Bottom2 = new Color(20, 136, 204);
			BufferedImage img = new BufferedImage(l, l, BufferedImage.TYPE_3BYTE_BGR);
            Graphics g = img.getGraphics();
            for (int i = 0; i < l; i++) {
                for (int j = 0; j  < l; j++) {
                    g.setColor(Color.BLACK);
                    if (j  >= 0 && j  < l / 5) {
                        if (i  < l * 3 / 5) g.setColor(Color.WHITE);
                    } else if (j  >= l / 5 && j  < l * 2 / 5) {
                        if (i  >= l * 1 / 5 && i  < l * 2 / 5) g.setColor(Color.WHITE);
                    } else if (j  >= l * 2 / 5 && j  < l * 3 / 5) {
                        if (i  >= l * 1 / 5 && i  < l * 5 / 5) g.setColor(Color.WHITE);
                    } else if (j  >= l * 3 / 5 && j  < l * 4 / 5) {
                        if (i  >= l * 3 / 5 && i  < l * 4 / 5) g.setColor(Color.WHITE);
                    } else if (j  >= l * 4 / 5 && j  < l * 5 / 5) {
                        if (i  >= l * 3 / 5 && i  < l * 4 / 5) g.setColor(Color.WHITE);
                    }
                    g.drawLine(i, j, i, j);
                }
            }
			g.dispose();
			ImageIO.write(img, "png", new File("./TT.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}