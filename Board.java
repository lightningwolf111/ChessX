import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Board extends JPanel {
	private final JFrame frame;
	private Position pos;
	private Piece[][] pieces;
	private boolean init = true;
	
	public Board(Position pos) {
		this.setPreferredSize(new Dimension(510, 510));
		this.frame = new JFrame("ChessX");
		frame.setBackground(new Color(255, 255, 255));
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		this.pieces = setUp(pos);
		this.pos = pos;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		/*if (init) {*/
			for (int i = 0; i < 9; i++) {
				g.drawLine(51, 51*(i+1), 459, 51*(i+1));
				g.drawLine(51*(i+1), 51, 51*(i+1), 459);
			}
			for (int c = 0; c < 8; c++) {
				g.drawString("" + c, 51*(c+1) + 25, 40);
				g.drawString("" + c, 40, 51*(c+1) + 25);
			}
			g.setColor(new Color(150, 0, 200));
			for (int c = 0; c < 8; c++) {
				for (int r = 0; r < 8; r++) {
					if ((c + r)%2 == 1) {
						g.fillRect(51*(c+1) + 1, 51*(r+1) + 1, 50, 50);
					}
				}
			}
			g.setColor(new Color(255, 255, 255));
			for (int c = 0; c < 8; c++) {
				for (int r = 0; r < 8; r++) {
					if ((c + r)%2 != 1) {
						g.fillRect(51*(c+1) + 1, 51*(r+1) + 1, 50, 50);
					}
				}
			}
			g.setColor(Color.BLACK);
			//init = false;
		/*}*/
	}
	
	public Piece[][] setUp(Position pos) {
		Piece[][] pieces = new Piece[8][8];
		//if (init) {
			//Piece[][] pieces = new Piece[8][8];
			for (int c = 0; c < 8; c++) {
				for (int r = 0; r < 8; r++) {
					if (pos.position[r][c] != 0) {
						pieces[r][c] = new Piece(pos.position[r][c], c, r);
						frame.add(pieces[r][c]);
						frame.revalidate();
						pieces[r][c].repaint();
					}
				}
			}
			//init = false;
			//return pieces;
			
			//init = false;
		//}
		return pieces;
	}
	
	public void move(Move mov) {
		int rI = mov.rI;
		int cI = mov.cI;
		int rF = mov.rF;
		int cF = mov.cF;
		
		pos.position[rF][cF] = pos.position[rI][cI];
		pos.position[rI][cI] = 0;
		refresh();
		setUp(pos);
		
		/* frame.remove(pieces[rI][cI]);
		
		if (pieces[rF][cF] != null) {
			frame.remove(pieces[rF][cF]);
		}
		pieces[rF][cF] = pieces[rI][cI].movePiece(cF, rF);
		frame.add(pieces[rF][cF]);
		pieces[rI][cI] = null;
		//frame.remove(pieces[rI][cI]);
		refresh();
		*/
		//refresh();
		
	}
	
	public void refresh() {
	      frame.revalidate();
	      frame.repaint();
   }
	
	public Piece[][] getPieces() {
		return pieces;
	}
}
