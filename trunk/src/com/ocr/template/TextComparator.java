package com.ocr.template;

import java.util.Comparator;
/**
 * ����X����㣬�Խ������������
 */
public class TextComparator implements Comparator<ImageInfo>{

	public int compare(ImageInfo arg0, ImageInfo arg1) {
		if(arg0.getX()>arg1.getX())
			return 1;
		else
			return 0;
	}




}
