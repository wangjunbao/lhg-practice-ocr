import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File imageFile = new File("E:\\lys.bmp");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(imageFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int height = bufferedImage.getHeight();
		int width = bufferedImage.getWidth();
		FileWriter fw = new FileWriter("E:\\pic.html");
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				int c = bufferedImage.getRGB(j, i) & 0x00FFFFFF;
				fw.write("<font size=\"1\" color=\"#"+Integer.toHexString(c)+"\">¨€</font>");
			}
			fw.write("<br>");
		}
		fw.close();
		
	}

}
