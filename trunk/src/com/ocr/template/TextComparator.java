package com.ocr.template;

import java.util.Comparator;
/**
 * 根据X坐标点，对结果集进行排序
 */
public class TextComparator implements Comparator<ImageInfo>{

	public int compare(ImageInfo arg0, ImageInfo arg1) {
		if(arg0.getX()>arg1.getX())
			return 1;
		else
			return 0;
	}




}
