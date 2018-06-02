
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public abstract class Piece implements Highlight {
	//constructor!!!!

	int team;
	boolean alive = true;




	void haveAttacked() {
	    alive = false;
    }

    abstract BufferedImage imageSetting(int team);
	@Override
	public void highlight() {
		
	}

}
        
     

    

