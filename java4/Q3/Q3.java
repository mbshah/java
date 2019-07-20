
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

public class Q3 extends Applet implements MouseListener{
	int h,w,x,y,r;
	String s[]={"images/1.jpg","images/2.jpg","images/3.jpg","images/4.jpg"};
	Image myimg;
	AppletContext context;

	private static final long serialVersionUID = 1L;
	public void init(){
		addMouseListener(this);
		context= this.getAppletContext();
		h=getHeight();
		w=getWidth();
		
	}
	public void paint(Graphics g){

		update(g);
	}
	public void update(Graphics g){
		try {
			URL url=new URL(getDocumentBase(),s[r]);
			myimg=context.getImage(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in url");
		}
		g.drawImage(myimg, x, y,120	,120, this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		r=(int) (1+Math.random()*4);
		x=(int) (Math.random()*(w-120));
		y=(int) (Math.random()*(h-120));
		repaint();
		System.out.println(r+" "+x+" "+y);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
