import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaintBrush extends Applet {
	
	int firstX, firstY, fontSize;
	
	Button lineButton, rectButton, ovalButton, eraserButton, blackButton, redButton, greenButton, blueButton, pencilButton;
	
	Checkbox solidBox;
	
	ArrayList<Shape> shapes;
    int index; 
	
	Color colorState;
	boolean isSolid;
	
	int shapeState;
	
    public void init() {
		
		colorState = Color.BLACK;
		isSolid = false;
		
		shapes = new ArrayList<Shape>();
		index = 0;
		
		//listener
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				switch(shapeState){
					case 0:
						shapes.add(new Line(e.getX(), e.getY(), e.getX(), e.getY(), isSolid, colorState));
						break;
					case 1:
						shapes.add(new Rectangle(e.getX(), e.getY(), e.getX(), e.getY(), isSolid, colorState));
						break;
					case 2:
						shapes.add(new Oval(e.getX(), e.getY(), e.getX(), e.getY(), isSolid, colorState));
						break;
				}
			}

			public void mouseReleased(MouseEvent e) {
				if(shapeState == 3 || shapeState == 4)
						return;
				Shape shape = shapes.get(index);
				shape.p3 = e.getX();
				shape.p4 = e.getY();
				repaint(); 
				index++;  
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(shapeState == 4){
					shapes.add(new Pencil(e.getX(), e.getY(), e.getX(), e.getY(), isSolid, colorState));
					index++;  
				} else if(shapeState == 3){
					shapes.add(new Eraser(e.getX(), e.getY(), e.getX(), e.getY(), isSolid, colorState));
					index++; 
				}
				else{
					Shape shape = shapes.get(index);
					shape.p3 = e.getX();
					shape.p4 = e.getY();
					
				}
				repaint();
			}
		});

		
		fontSize = 15;
		firstX = 350;
		firstY = 30;
		
		// Buttons
		lineButton = new Button("Line");
		lineButton.setBounds(firstX+90, firstY-20, 50, 25);
		lineButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeState = 0;
				repaint();
			}
		});
		
		rectButton = new Button("Rectangle");
		rectButton.setBounds(firstX+160, firstY-20, 70, 25);
		rectButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeState = 1;
				repaint();
			}
		});
		
		ovalButton = new Button("Oval");
		ovalButton.setBounds(firstX+240, firstY-20, 50, 25);
		ovalButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeState = 2;
				repaint();
			}
		});

		pencilButton = new Button("Pencil");
		pencilButton.setBounds(firstX+300, firstY-20, 50, 25);
		pencilButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeState = 4;
				repaint();
			}
		});

		eraserButton = new Button("Eraser");
		eraserButton.setBounds(firstX+360, firstY-20, 50, 25);
		eraserButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeState = 3;
				repaint();
			}
		});
		
		// Checkboxs
		solidBox = new Checkbox("Solid");
		solidBox.setBounds(firstX+440, firstY-20, 50, 25);
		solidBox.addItemListener(new ItemListener(){
			public void itemStateChanged (ItemEvent e) {
				isSolid = !isSolid;
				repaint();
			}
		});
		
		// Clors
		blackButton = new Button("Black");
		blackButton.setBounds(firstX+570, firstY-20, 40, 25);
		blackButton.setBackground(Color.BLACK);
		blackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				colorState = Color.BLACK;
				repaint();
			}
		});		
		
		redButton = new Button("Red");
		redButton.setBounds(firstX+620, firstY-20, 40, 25);
		redButton.setBackground(Color.RED);
		redButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				colorState = Color.RED;
				repaint();
			}
		});	

		greenButton = new Button("Green");
		greenButton.setBounds(firstX+670, firstY-20, 40, 25);
		greenButton.setBackground(Color.GREEN);
		greenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				colorState = Color.GREEN;
				repaint();
			}
		});	

		blueButton = new Button("Blue");
		blueButton.setBounds(firstX+720, firstY-20, 40, 25);
		blueButton.setBackground(Color.BLUE);
		blueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				colorState = Color.BLUE;
				repaint();
			}
		});	
		
		setLayout(null);
		add(lineButton);
		add(rectButton);
		add(ovalButton);
		add(pencilButton);
		add(eraserButton);
		add(solidBox);
		add(blackButton);
		add(redButton);
		add(greenButton);
		add(blueButton);
    }

    public void paint(Graphics g) {
		g.setFont(new Font("SansSerif", Font.BOLD, fontSize));
		g.drawString("Paint Mode: ", firstX, firstY);
		g.drawString("Colors: ", firstX+510, firstY-2);
		
		if(shapes.size() > 0){
			for (Shape shape : shapes) {
				shape.draw(g);
			}
		}
		
	
    }
}
