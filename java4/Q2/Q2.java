

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Q2 extends Applet {
	private static final long serialVersionUID = 1L;
	int x = 0, y = 0, h, w, speed = 50,speeda;
	int xn = 2, yn = 5, r =35;
	boolean exitflag = true;

	public void init() {
		h = getHeight();
		w = getWidth();
	}

	public void paint(Graphics g) {

		update(g);
	}

	public void update(Graphics g) {

		while (exitflag) {
			g.setColor(Color.red);
			g.fillRect(0, 0, w, h);
			g.setColor(Color.green);
			g.fillOval(x, y, r, r);
			if (x > w-r || x < 0) {
				xn = -xn;
				speed = (int) (20 + Math.random() * 75);
			}
			if (y > h-r || y < 0) {
				yn = -yn;
				speed = (int) (20 + Math.random() * 75);
			}
			x += xn;
			y += yn;
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			speeda=95-speed;
			System.out.println("x:" + x + " y:" + y + " speed:" + speeda);

		}
	}
	

}
