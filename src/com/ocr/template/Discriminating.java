package com.ocr.template;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Discriminating {

	
	private int templateBackColor;
	private int backColor;
	
	public Discriminating(){}
	
	public Discriminating(int templateBackColor,int backColor){
		this.templateBackColor = templateBackColor;
		this.backColor = backColor;
	}
	
	
	public int getTemplateBackColor() {
		return templateBackColor;
	}

	public void setTemplateBackColor(int templateBackColor) {
		this.templateBackColor = templateBackColor;
	}

	public int getBackColor() {
		return backColor;
	}

	public void setBackColor(int backColor) {
		this.backColor = backColor;
	}

	public ImageInfo readValidateCodeFile(String filePath){
		return new ImageReader().readFromDisk(filePath);
	}
	
	public String discriminatingBySteam(InputStream imageSteam){
		ImageInfo target = new ImageReader().readFromInputStream(imageSteam);
		List<ImageInfo> result = matchingText(target);
		Collections.sort(result,new TextComparator());
		StringBuffer code = new StringBuffer();
		for(ImageInfo imageInfo : result){
			code.append(imageInfo.getName().substring(0,imageInfo.getName().indexOf(".")));
			System.out.print(imageInfo.getName().substring(0,imageInfo.getName().indexOf(".")));
		}
		System.out.println();
		return code.toString();
	}
	
	public String discriminating(String validateCodeFile){
		ImageInfo target = readValidateCodeFile(validateCodeFile);
		List<ImageInfo> result = matchingText(target);
		Collections.sort(result,new TextComparator());//根据X坐标点，对结果集进行排序
		StringBuffer code = new StringBuffer();
		for(ImageInfo imageInfo : result){
			code.append(imageInfo.getName().substring(0,imageInfo.getName().indexOf(".")));
			System.out.print(imageInfo.getName().substring(0,imageInfo.getName().indexOf(".")));
		}
		System.out.println();
		return code.toString();
	}
	
	public List<ImageInfo> matchingText(ImageInfo target){
		List<ImageInfo> result = new ArrayList<ImageInfo>();//最终匹配的结果集
		int widthTimes = target.getWidth()-TemplateBuffer.getInstance().getMinWidth();//循环匹配的最大宽像素数：目标图片宽度-模板宽度
		int heightTimes = target.getHeight()-TemplateBuffer.getInstance().getMinHeight();//循环匹配的最大高像素数：目标图片高度-模板高度
		for(int heightIndex =0;heightIndex<=heightTimes;heightIndex++){
			for(int widthIndex=0;widthIndex<=widthTimes;widthIndex++){
				Iterator<String> keys = TemplateBuffer.getInstance().getKeys();
				double value = 0.0;//当前最高的匹配正确率
				ImageInfo resultImageInfo = null;
				ImageInfo resource = null;
				//循环所有模板对象，对要验证的图片进行匹配
				while(keys.hasNext()){
					resource = TemplateBuffer.getInstance().getTemplate(keys.next());
					//匹配模板，返回匹配的正确率
					double resemble = templateMatching(heightIndex,widthIndex,resource,target);
					//如果当前匹配正确率大于之前匹配的最高正确率
					//则设置当前匹配的模板为当前最高正确率
					if(resemble>value){
						resultImageInfo = new ImageInfo();
						resultImageInfo.setName(resource.getName());
						resultImageInfo.setY(heightIndex);
						resultImageInfo.setX(widthIndex);
						value = resemble;
					}	
				}
				//如果所有匹配后的模板最高正确率大于规定值，则认为本次匹配成功，将匹配的文字/数字加入到结果集中
				if(value >= Config.RESEMBLE_GRADE){
					result.add(resultImageInfo);
					
				}
			}
		}
		return result;
	}
	
	//	resource -- 0~9的图片
	/*
	 * x,y ：当前匹配的坐标位置
	 * resource ：当前匹配的模板
	 * target ：要匹配的图片
	 */
	private double templateMatching(int x,int y,ImageInfo resource,ImageInfo target){
		double matchingCount = 0.0;//匹配的像素点数（来自目标图片）
		double totalCount = 0.0;//所有需要匹配的像素点数（来自模板）
		boolean matching = false;
		for(int h = 0;h<resource.getHeight();h++){
			if(target.getColor().length<=h+x){
				break;
			}
			for(int w = 0;w<resource.getWidth();w++){
				if(target.getColor()[h].length<=w+y){
					break;
				}
				
				if(matching == false && resource.getColor()[h][w] != getTemplateBackColor()){
					if(target.getColor()[x+h][y+w] != getBackColor())
						matching = true;
					else
						totalCount++;
				}
				if(!matching) continue;
				
				
					if(resource.getColor()[h][w] != getTemplateBackColor() && target.getColor()[x + h][y + w] != getBackColor()){
						//TODO 对于某像素必须为背景色，这里暂时写死成红色。（仅限于模板颜色，与目标图片颜色无关）
						if(resource.getColor()[h][w] != 0xFF0000){
							matchingCount++;
						}
					}
					
					if(resource.getColor()[h][w] != getTemplateBackColor()){
						totalCount++;
					}
					
//				}
				
				if (resource.getColor()[h][w] != getTemplateBackColor()
						&& (target.getColor()[x + h][y + w] != getBackColor())) {
					matchingCount++;
					totalCount++;
				}else if(resource.getColor()[h][w] != getTemplateBackColor()){
					totalCount++;
				}
			}
		}
//		计算匹配正确率：匹配的像素点书/总像素点数*100
		return matchingCount/totalCount*100.0;
	}	
}
