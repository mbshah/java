import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

public class Q4 extends Applet implements MouseListener{
	int h,w,x,y,r,stop=0;
	String s[]={"","sounds/1.au","sounds/2.au","sounds/3.au","sounds/4.au"},str;
	AudioClip aud;
	AppletContext context;

	private static final long serialVersionUID = 1L;
	public void init(){
		addMouseListener(this);
	System.out.println("Click in the applet to play or change the audio");
	h=getHeight();
	w=getWidth();
		
	}
	public void paint(Graphics g){
		h=getHeight();
		w=getWidth();
		g.setColor(Color.white);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.red);
		str="Click in the Applet to play or change sound";
		g.drawString(str, 10, 10);
	}
	public void Start(){
		h=getHeight();
		w=getWidth();
		Graphics g=getGraphics();
		context= this.getAppletContext();
		try {
			URL url=new URL(getDocumentBase(),s[r]);
			aud=context.getAudioClip(url);
			//System.out.println(url+" "+r);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in url");
		}
		g.setColor(Color.white);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.red);
		str="Click in the Applet to play or change sound";
		g.drawString(str, 10, 10);
		str=" Playing audio file from";
		g.drawString(str, 10, 25);
		str=""+getDocumentBase();
		g.drawString(str, 10, 40);
		str="Playing file  "+r;
		g.drawString(str, 10, 55);

		aud.play();
		
	}
	public void Stop(){
		if (stop==1){
		aud.stop();}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Stop();
		r=(int)(1+Math.random() *4);
		Start();
		stop=1;
		
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
