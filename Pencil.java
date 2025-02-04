import java.awt.*;

public class Pencil extends Shape {
	
	
	public Pencil(int p1, int p2, int p3, int p4, boolean isSolid, Color color){
		super(p1, p2, p3, p4, isSolid, color);
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(p1, p2, 10, 10);
	}
}