package com.ocr.template;

/**
 * ͼƬ��Ϣ����
 */
public class ImageInfo {

	private String name;//ͼƬ��
	private String path;//·��
	private int width;//ͼƬ��
	private int height;//ͼƬ��
	private int x;
	private int y;
	private int[][] color;//ͼƬ��ɫ
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int[][] getColor() {
		return color;
	}
	public void setColor(int[][] color) {
		this.color = color;
	}
}
