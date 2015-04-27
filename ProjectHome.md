一个简单的根据图片解析数字的Java源代码，代码简单易懂（源代码不超过10个类），带有识别的范例，适合初学者作为练习项目。

# 实现功能 #
对图片中的字符进行识别，该项目中只做了简单的数字识别，允许有少量的干扰线，并且图片中的数字无缩放、变形处理。
项目源码中包含示例图片。

# 实现原理 #
根据要识别图片字符，制作特性模版，程序根据模版逐行逐列扫描被识别的图片，匹配模版，根据设定的匹配率进行判定字符。


# 代码示例 #
```
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
		
		ir.initTemplate("E:\\ProjectWorkspace\\OCR\\src\\com\\ocr\\template\\imagefile\\1_1");
	
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
		Discriminating discriminating = new Discriminating();

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
		
	}
	
}

```