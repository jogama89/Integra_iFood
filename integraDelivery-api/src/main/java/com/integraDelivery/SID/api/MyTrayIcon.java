package com.integraDelivery.SID.api;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;


import com.integraDelivery.SID.IntegraDeliveryApiApplication;

// http://www.javawenti.com/?post=84683

public class MyTrayIcon extends TrayIcon {

//    private static final String IMAGE_PATH = "/PATH.png";
	
	private static final String IMAGE_PATH = "C:/Teste/1.png";
    private static final String TOOLTIP = "Running";
    private PopupMenu popup;
    final SystemTray tray;

    public MyTrayIcon(){
        super(createImage(IMAGE_PATH,TOOLTIP),TOOLTIP);
        
        setImageAutoSize(true);
        
        popup = new PopupMenu();
        tray = SystemTray.getSystemTray();
        try {
            setup();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    @PostConstruct
    private void setup() throws AWTException{
        // Create a pop-up menu components
        MenuItem exitItem = new MenuItem("Exit");
        popup.add(exitItem);
        exitItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                final int exitCode = 0;
                ExitCodeGenerator exitCodeGenerator = new ExitCodeGenerator() {

                    @Override
                    public int getExitCode() {
                      return exitCode;
                    }

                  };

                  tray.remove(MyTrayIcon.this);
                  SpringApplication.exit(IntegraDeliveryApiApplication.context, exitCodeGenerator);
            }
        });
        // popup.addSeparator();
        setPopupMenu(popup);
        tray.add(this);

    }

    protected static Image createImage(String path, String description){

    	//  ImageIcon figura2=new ImageIcon("C:/Teste/2.png");
    	
    	
    	
    	return new ImageIcon("C:/Teste/1.png",description).getImage();
    	
/*
        URL imageURL = MyTrayIcon.class.getResource(path);
        if(imageURL == null){
            System.err.println("Failed Creating Image. Resource not found: "+path);
            return null;
        }else {
            return new ImageIcon(imageURL,description).getImage();
        }
 */
    	
    }
}