
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Q1 extends Applet {
	private static final long serialVersionUID = 1L;
	int x = 0, y = 0, h, w, rcount=0,ccount=0, bflag = 1;

	public void init() {

	}

	public void paint(Graphics g) {
		w = getWidth();
		h = getHeight();
		//System.out.println("\nw:"+w+" h:"+h);
		w=w/8;
		h=h/8;
		//System.out.println("w:"+w+" h:"+h);
		ccount=0;
		rcount=0;
		x=0;
		y=0;
		while(ccount<=7){
			if(rcount==8){
				y=y+h;
				x=0;
				rcount=0;
				bflag=-bflag;
				ccount++;
				//System.out.print("c"+ccount);
				
			}
		
			if(bflag==1){
				g.setColor(Color.black);
				g.fillRect(x, y, w, h);
				bflag=-bflag;
				rcount++;
				x=x+w;
				//System.out.print("r"+rcount);
				continue;
			}
			if(bflag==-1){
				g.setColor(Color.white);
				g.fillRect(x, y, w, h);
				bflag=-bflag;
				rcount++;
				x=x+w;
				//System.out.print("r"+rcount);
				continue;
			}
			repaint();
	}

	}
} 
