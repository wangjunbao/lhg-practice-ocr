package com.ocr.template;

import java.util.Hashtable;
import java.util.Iterator;

public class TemplateBuffer {

	private static TemplateBuffer templateBuffer;
	
	private Hashtable<String,ImageInfo> templateMap = new Hashtable<String,ImageInfo>();
	
	private int minWidth = Integer.MAX_VALUE;
	private int minHeight = Integer.MAX_VALUE;
	
	private int maxWidth;
	private int maxHeight;
	
	private TemplateBuffer(){}

	public static TemplateBuffer getInstance(){
		if(templateBuffer == null){
			templateBuffer = new TemplateBuffer();
		}
		return templateBuffer;
	}
	
	public void addTemplate(String name,ImageInfo value){
		minWidth=Math.min(minWidth, value.getWidth());
		maxWidth=Math.max(maxWidth, value.getWidth());
		
		minHeight=Math.min(minHeight, value.getHeight());
		maxHeight=Math.max(maxHeight, value.getHeight());
		
		templateMap.put(name, value);
	}
	
	public void clear(){
		templateMap.clear();
	}
	
	public ImageInfo getTemplate(String name){
		return templateMap.get(name);
	}
	
	public Iterator<String> getKeys(){
		return templateMap.keySet().iterator();
	}

	public int getMinWidth() {
		return minWidth;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMaxHeight() {
		return maxHeight;
	}
}
