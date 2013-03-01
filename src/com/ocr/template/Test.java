package com.ocr.template;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Test {

	public static void main(String[] args) {
		ImageReader ir = new ImageReader();
		//模板越多，性能越差
		ir.initTemplate("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_1");
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/0.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/1.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/2.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/3.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/4.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/5.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/6.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/7.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/8.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_1/9.bmp").getPath());
		
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/0.bmp").getPath());
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/1.bmp").getPath());
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/2.bmp").getPath());
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/3.bmp").getPath());
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/4.bmp").getPath());
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/5.bmp").getPath());
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/6.bmp").getPath());
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/7.bmp").getPath());
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/8.bmp").getPath());
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/9.bmp").getPath());		
		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/G.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/up.bmp").getPath());
//		ir.initTemplate(ImageReader.class.getResource("imagefile/1_2/down.bmp").getPath());
		Discriminating discriminating = new Discriminating();
//		try {
//			URL u = new URL("http://k1.bizlife.com.cn/service/imgcode.php?t=1254034781");
//			discriminating.discriminatingBySteam(u.openConnection().getInputStream());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		long time = System.currentTimeMillis();
		discriminating.setTemplateBackColor(13364479);
		discriminating.setBackColor(13364479);
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\0.gif");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\1.gif");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\2.gif");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\3.gif");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\4.gif");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\5.gif");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\6.gif");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\7.gif");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\8.gif");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\9.gif");
		
		System.out.println("=============== [ "+(System.currentTimeMillis()-time)+"ms"+" ] ==================");
		time = System.currentTimeMillis();
		
		discriminating.setTemplateBackColor(0xFFFFFF);
		discriminating.setBackColor(0xFFFFFF);
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题.bmp");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题2.bmp");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题3.bmp");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题4.bmp");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题5.bmp");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题6.bmp");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题7.bmp");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题8.bmp");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题9.bmp");
		discriminating.discriminating("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_2_code\\无标题10.bmp");
		System.out.println("================ [ "+(System.currentTimeMillis()-time)+"ms"+" ] =================");
//		ir.initTemplate("C:\\EventServerWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\2");
//		discriminating.discriminating("C:\\EventServerWorkspace\\OCR\\code2_1.bmp");
//		discriminating.discriminating("C:\\EventServerWorkspace\\OCR\\code2_2.bmp");
	}
	public static void main2(String[] args) {
//		new ImageReader().initTemplate("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile");
//		TemplateBuffer.getInstance();
		try {
			String currentJarPath = URLDecoder.decode(ImageReader.class.getProtectionDomain().getCodeSource().getLocation().getFile(), "UTF-8");
			JarFile currentJar = new JarFile("/C:/Documents and Settings/scarlet/Local Settings/Temp/e4jD8.tmp_dir3873/biz_1.0_fat.jar");
			JarEntry dbEntry = currentJar.getJarEntry("com/ocr/template/imagefile/1_1/");//获取当前Jar文件名，并对其解码，防止出现中文乱码
			InputStream in = currentJar.getInputStream(dbEntry); 
			System.out.println(in);
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
