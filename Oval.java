import java.awt.*;

public class Oval extends Shape {
	
	
	public Oval(int p1, int p2, int p3, int p4, boolean isSolid, Color color){
		super(p1, p2, p3, p4, isSolid, color);
	}
	
	public void draw(Graphics g){
		
		int x = Math.min(p1, p3);
		int y = Math.min(p2, p4);
		int width = Math.abs(p3 - p1);
		int height = Math.abs(p4 - p2);

		g.setColor(color);
		if (isSolid) {
			g.fillOval(x, y, width, height);
		} else {
			g.drawOval(x, y, width, height);
		}
	}
}