
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Q2 extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	int x = 0, y = 0, h, w, speed= 50,speeda[]={5,20,70,50,90,10},rand;
	int xn = 2, yn = 5, r =35;
	Thread th;

	public void init() {
		h = getHeight();
		w = getWidth();
	}
	public void start(){
		Thread th=new Thread(this);
		th.start();
		
	}
	public void stop(){
		th=null;
	}
	public void paint(Graphics g) {

			g.setColor(Color.red);
			g.fillRect(0, 0, w, h);
			update(g);
	}
	public void update(Graphics g){
		g.setColor(Color.red);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.green);
		g.fillOval(x, y, r, r);
		if (x > w-r || x < 0) {
			xn = -xn;
			rand = (int) (1+Math.random() *5);
		}
		if (y > h-r || y < 0) {
			yn = -yn;
			rand = (int) (1+Math.random() * 5);
		}
		x += xn;
		y += yn;
	}
	public void run(){
		while(true){
			try {
				Thread.sleep(speeda[rand]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			//System.out.println(rand);
			repaint();
		}
	}

	

}
