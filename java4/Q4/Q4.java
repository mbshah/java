

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

public class Q4 extends Applet implements MouseListener{
	int h,w,x,y,r;
	String s[]={"sounds/1.au","sounds/2.au","sounds/3.au","sounds/4.au"};
	AudioClip aud;
	AppletContext context;

	private static final long serialVersionUID = 1L;
	public void init(){
		addMouseListener(this);
		context= this.getAppletContext();
		try {
			URL url=new URL(getDocumentBase(),s[r]);
			aud=context.getAudioClip(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error in url");
		}
		
	}

	public void Start(){

		aud.play();
		
	}
	public void Stop(){
		aud.stop();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		start();
		
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
