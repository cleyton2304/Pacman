package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener,KeyListener{

	private Timer timer;

	int pacmanPosX = 0;
	int pacmanPosY = 0;
	int velX = 1;
	int velY = 0;
	int newVelX = 1;
	int newVelY = 0;

	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(this);
		timer = new Timer(3, this);
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			newVelY=0;
			newVelX=1;
			break;
		case KeyEvent.VK_LEFT:
			newVelY=0;
			newVelX=-1;
			break;
		case KeyEvent.VK_UP:
			newVelY=-1;
			newVelX=0;
			break;
		case KeyEvent.VK_DOWN:
			newVelY=1;
			newVelX=0;
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		if(System.getProperty("os.name").equals("Linux"))
			Toolkit.getDefaultToolkit().sync();
	}

	private void update() {

		//Atualiza Pacman
		if(pacmanPosX%40==0 && pacmanPosY%40==0) {
			velX = newVelX;
			velY = newVelY;
		}
		pacmanPosX+=velX;
		pacmanPosY+=velY;

		repaint();
	}

	public void paint(Graphics g) {

		//pinta background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		//pinta pacman
		g.setColor(Color.YELLOW);
		g.fillOval(pacmanPosX, pacmanPosY, 40, 40);
	}


}
