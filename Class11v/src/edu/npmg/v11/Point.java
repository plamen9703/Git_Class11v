package edu.npmg.v11;

public class Point {
	private String name;
	private double x;
	private double y;
	
	public Point() {
		this("O",3,4);
	}
	
	public Point(String name, double x, double y) {
		setName(name);
		setX(x);
		setY(y);
	}
	
	public Point(Point p) {
		this(p.name,p.x,p.y);
	}
	
	public void setName(String name) {
		if(name!=null && name.isEmpty()==false) 
			this.name=name;
		else{
			this.name="O";
		}
	}
	
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %.2f,%.2f", name,x,y);
	}
	
	public int getQadrent() {
		if(x==0 && y!=0) {
			if(y>0)return 5;
			else return 6;
		}
		if(y==0 && x!=0) {
			if(x>0)return 7;
			else return 8;
		}
		if(x>0 &&y>0)return 1;
		if(x>0 &&y<0)return 4;
		if(x<0 &&y>0)return 2;
		if(x<0 &&y<0)return 3;
		return 0;
	}
	
	public double getDistanceFromOrigin() {
		return Math.sqrt(x*x+y*y);
	}
	
	public double getDistanceFromPoint(Point p) {
		return Math.sqrt(Math.pow(x-p.x, 2)+Math.pow(y-p.y, 2));
	}
	
	public Point rotateOrigin(int alpha) {
		double radians=Math.toRadians(alpha);
		double cos=Math.cos(radians);
		double sin=Math.sin(radians);
		
		double x=this.x*cos-this.y*sin;
		double y=this.x*sin+this.y*cos;
		return new Point(name+"'",x,y);
	}
	
	public Point rotateOrigin(int alpha,Point p) {
		this.x-=p.x;
		this.y-=p.y;
		Point toReturn=rotateOrigin(alpha);
		this.x+=p.x;
		this.y+=p.y;
		toReturn.x+=p.x;
		toReturn.y+=p.y;
		return toReturn;
	}
}
