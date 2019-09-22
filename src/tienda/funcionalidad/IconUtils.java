package tienda.funcionalidad;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class IconUtils {
	
	public static ImageIcon createIcon(String file, Component component) throws IOException {		
		return new ImageIcon((ImageIO.read(new File(file))).getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_SMOOTH));
	}
	
	public static ImageIcon createIcon(String file) throws IOException {		
		return new ImageIcon((ImageIO.read(new File(file))));
	}

}
