import java.awt.*;

public abstract class Shape {
	
	public int p1, p2, p3, p4;
	public boolean isSolid;
	public Color color;
	
	public Shape(int p1, int p2, int p3, int p4, boolean isSolid, Color color){
		
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.isSolid = isSolid;
		this.color = color;
		
	}
	
	public abstract void draw(Graphics g);
}