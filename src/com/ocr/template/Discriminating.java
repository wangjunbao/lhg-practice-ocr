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
		Collections.sort(result,new TextComparator());//����X����㣬�Խ������������
		StringBuffer code = new StringBuffer();
		for(ImageInfo imageInfo : result){
			code.append(imageInfo.getName().substring(0,imageInfo.getName().indexOf(".")));
			System.out.print(imageInfo.getName().substring(0,imageInfo.getName().indexOf(".")));
		}
		System.out.println();
		return code.toString();
	}
	
	public List<ImageInfo> matchingText(ImageInfo target){
		List<ImageInfo> result = new ArrayList<ImageInfo>();//����ƥ��Ľ����
		int widthTimes = target.getWidth()-TemplateBuffer.getInstance().getMinWidth();//ѭ��ƥ���������������Ŀ��ͼƬ���-ģ����
		int heightTimes = target.getHeight()-TemplateBuffer.getInstance().getMinHeight();//ѭ��ƥ���������������Ŀ��ͼƬ�߶�-ģ��߶�
		for(int heightIndex =0;heightIndex<=heightTimes;heightIndex++){
			for(int widthIndex=0;widthIndex<=widthTimes;widthIndex++){
				Iterator<String> keys = TemplateBuffer.getInstance().getKeys();
				double value = 0.0;//��ǰ��ߵ�ƥ����ȷ��
				ImageInfo resultImageInfo = null;
				ImageInfo resource = null;
				//ѭ������ģ����󣬶�Ҫ��֤��ͼƬ����ƥ��
				while(keys.hasNext()){
					resource = TemplateBuffer.getInstance().getTemplate(keys.next());
					//ƥ��ģ�壬����ƥ�����ȷ��
					double resemble = templateMatching(heightIndex,widthIndex,resource,target);
					//�����ǰƥ����ȷ�ʴ���֮ǰƥ��������ȷ��
					//�����õ�ǰƥ���ģ��Ϊ��ǰ�����ȷ��
					if(resemble>value){
						resultImageInfo = new ImageInfo();
						resultImageInfo.setName(resource.getName());
						resultImageInfo.setY(heightIndex);
						resultImageInfo.setX(widthIndex);
						value = resemble;
					}	
				}
				//�������ƥ����ģ�������ȷ�ʴ��ڹ涨ֵ������Ϊ����ƥ��ɹ�����ƥ�������/���ּ��뵽�������
				if(value >= Config.RESEMBLE_GRADE){
					result.add(resultImageInfo);
					
				}
			}
		}
		return result;
	}
	
	//	resource -- 0~9��ͼƬ
	/*
	 * x,y ����ǰƥ�������λ��
	 * resource ����ǰƥ���ģ��
	 * target ��Ҫƥ���ͼƬ
	 */
	private double templateMatching(int x,int y,ImageInfo resource,ImageInfo target){
		double matchingCount = 0.0;//ƥ������ص���������Ŀ��ͼƬ��
		double totalCount = 0.0;//������Ҫƥ������ص���������ģ�壩
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
						//TODO ����ĳ���ر���Ϊ����ɫ��������ʱд���ɺ�ɫ����������ģ����ɫ����Ŀ��ͼƬ��ɫ�޹أ�
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
//		����ƥ����ȷ�ʣ�ƥ������ص���/�����ص���*100
		return matchingCount/totalCount*100.0;
	}	
}
