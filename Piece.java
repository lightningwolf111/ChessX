import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Piece extends JPanel {
	private byte id;
	private int c;
	private int r;
	private BufferedImage img;
	private int a;
	
	public Piece(byte id, int c, int r) {
		this.id = id;
		this.c = c;
		this.r = r;
	    img = null;
	    try {
	    	img = ImageIO.read(new File("./src/img/" + id + ".png"));
	    } catch (IOException e) {
	    }
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 51*(c+1) + 1, 51*(r+1) + 1, null);
	}
	
	public Piece movePiece(int c, int r) {
		this.c = c;
		this.r = r;
		return this;
	}
	
	public String toString() {
		return "" + id + " (" + r + ", " + c + ")";
	}
	
	public void changeA(int a) {
		this.a = a;
	}
}
