/**
 * 
 */
package Maulwurf;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author a
 *
 */
public class Maulwurf implements ActionListener {

	int i = 0;
	JDialog dia = new JDialog();
	JButton bd = new JButton("00");
	// boolean b = true;
	int actualIcon = 1;
	private int Position;
	JFrame Mainwindow = new JFrame();
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	/**
	 * @param args
	 */
	JButton button00 = new JButton();
	JButton button01 = new JButton();
	JButton button02 = new JButton();

	JButton button10 = new JButton();
	JButton button11 = new JButton();
	JButton button12 = new JButton();

	JButton button20 = new JButton();
	JButton button21 = new JButton();
	JButton button22 = new JButton();

	public void InitBoardView() {
		InitButtons();
		Mainwindow.setLayout(new GridLayout(3, 3));
		Mainwindow.setSize(1200, 800);
		// Mainwindow.pack();

		JPanel jpane = new JPanel();
		for (int i = 0; i < 10; i++) {
			jpane.add((JButton) (buttons.get(i)));

		}
		Mainwindow.add(button00);
		button00.addActionListener(this);
		Mainwindow.add(button01);
		button01.addActionListener(this);
		Mainwindow.add(button02);
		button02.addActionListener(this);
		Mainwindow.add(button10);
		button10.addActionListener(this);
		Mainwindow.add(button11);
		button11.addActionListener(this);
		Mainwindow.add(button12);
		button12.addActionListener(this);
		Mainwindow.add(button20);
		button20.addActionListener(this);
		Mainwindow.add(button21);
		button21.addActionListener(this);
		Mainwindow.add(button22);
		button22.addActionListener(this);
		Mainwindow.setVisible(true);
		// InitBlank();
		try {
			Thread.sleep(1500);

			try {

				for (int i = 0; i < 10; i++) {
					Position = new Random().nextInt(10);
					Image img = ImageIO.read(getClass().getResource("click.jpg"));
					Image img0 = ImageIO.read(getClass().getResource("zero.jpg"));
					buttons.get(Position).setIcon(new ImageIcon(img));
					buttons.get(Position).repaint();
					Mainwindow.invalidate();
					Mainwindow.validate();
					Mainwindow.repaint();
					Thread.sleep(1400);
					buttons.get(Position).setIcon(new ImageIcon(img0));
				}

			} catch (Exception ex) {
				buttons.add(button22);

				ex.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	void InitBlank() {

		for (int i = 0; i < 50; i++) {
			Image img;
			try {
				img = ImageIO.read(getClass().getResource("zero.jpg"));

				buttons.get(Position).setIcon(new ImageIcon(img));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	void initScoreBoard() {
		dia.setLayout(new GridLayout(1, 1));
		dia.setSize(100, 100);
		bd.setSize(200, 100);
		bd.setFont(new Font("Arial", Font.PLAIN, 40));
		dia.getContentPane().add(bd);
		// dia.setSize(40,60);
		dia.setVisible(true);
	}

	void InitButtons() {

		try {
			Image img = ImageIO.read(getClass().getResource("zero.jpg"));
			button00.setIcon(new ImageIcon(img));
			buttons.add(button00);
			// Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
			button01.setIcon(new ImageIcon(img));
			buttons.add(button01);

			// Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
			button02.setIcon(new ImageIcon(img));
			buttons.add(button02);

//		    Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
			button10.setIcon(new ImageIcon(img));
			buttons.add(button10);

//		    Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
			button11.setIcon(new ImageIcon(img));
			buttons.add(button11);

			// Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
			button12.setIcon(new ImageIcon(img));
			buttons.add(button12);

			// Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
			button20.setIcon(new ImageIcon(img));
			buttons.add(button20);

			// Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
			button21.setIcon(new ImageIcon(img));
			buttons.add(button21);

			// Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
			button22.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			buttons.add(button22);

			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maulwurf m = new Maulwurf();

		m.initScoreBoard();

		m.InitButtons();
		m.InitBoardView();
		m.Mainwindow.dispose();
		System.exit(0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		try {
			Image img1 = ImageIO.read(getClass().getResource("click1.jpg"));
			Image img0 = ImageIO.read(getClass().getResource("zero.jpg"));
			Image img = ImageIO.read(getClass().getResource("click.jpg"));

			ImageIcon imic = (ImageIcon) b.getIcon();
			ImageIcon imic2 = new ImageIcon(img);
			BufferedImage imic3 = toBufferedImage(imic.getImage());
			BufferedImage imic4 = toBufferedImage(imic2.getImage());

			if (compareImage(imic3, imic4)) {
				i = i + 10;
				((JButton) (dia.getContentPane().getComponent(0))).setText(new Integer(i).toString());
				dia.repaint();
				b.setIcon(new ImageIcon(img1));
				b.repaint();
			}
			Mainwindow.invalidate();
			Mainwindow.validate();
			Mainwindow.repaint();

			Thread.sleep(1000);
			b.setIcon(new ImageIcon(img0));

			// else if (imic.equals(new ImageIcon(img1))) {

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	// This API will compare two image file //
	// return true if both image files are equal else return false//**
	public static boolean compareImage(BufferedImage biA, BufferedImage biB) {
		try {
			// take buffer data from botm image files //
			/// BufferedImage biA = ImageIO.read(fileA);
			DataBuffer dbA = biA.getData().getDataBuffer();
			int sizeA = dbA.getSize();
			// BufferedImage biB = ImageIO.read(fileB);
			DataBuffer dbB = biB.getData().getDataBuffer();
			int sizeB = dbB.getSize();
			// compare data-buffer objects //
			if (sizeA == sizeB) {
				for (int i = 0; i < sizeA; i++) {
					if (dbA.getElem(i) != dbB.getElem(i)) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Failed to compare image files ...");
			return false;
		}
	}

	/**
	 * Converts a given Image into a BufferedImage
	 *
	 * @param img The Image to be converted
	 * @return The converted BufferedImage
	 */
	public static BufferedImage toBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;
	}
}
