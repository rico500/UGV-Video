package Client;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class UGVKeyListener extends JTextField {
	
	public UGVKeyListener(String text){
		super(text);
		this.addUpKeyHandler();
		this.addDownKeyHandler();
		this.addWKeyHandler();
		this.addSKeyHandler();
		this.addLeftKeyHandler();
		this.addRightKeyHandler();
		this.addAKeyHandler();
		this.addDKeyHandler();
	}
	
	private void addUpKeyHandler(){
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed UP"), "UPpressed");
		this.getActionMap().put("UPpressed", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("UP pressed!");
				Client.forward = true;
				Client.sendMessage("|FOR|"+GUI.SpeedSlider.getValue());
			}
			
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "UPreleased");
		this.getActionMap().put("UPreleased", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("UP released!");
				Client.forward = false;
				Client.sendMessage("|STO|0");
			}
			
			
		});
	}
	
	private void addDownKeyHandler(){
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed DOWN"), "DOWNpressed");
		this.getActionMap().put("DOWNpressed", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("DOWN pressed!");
				Client.backward = true;
				Client.sendMessage("|BAK|"+GUI.SpeedSlider.getValue());
			}
			
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "DOWNreleased");
		this.getActionMap().put("DOWNreleased", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("DOWN released!");
				Client.backward = false;
				Client.sendMessage("|STO|0");
			}
			
			
		});
	}
	
	private void addWKeyHandler(){
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed W"), "Wpressed");
		this.getActionMap().put("Wpressed", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("w pressed!");
				Client.speed = GUI.SpeedSlider.getValue();
				
				Client.speed = Client.speed + 20;
				GUI.SpeedSlider.setValue(Client.speed);
				
				if (Client.forward){	
					Client.sendMessage("|FOR|"+GUI.SpeedSlider.getValue());
				}
			
			}
			
		});
		
	}
	
	private void addSKeyHandler(){
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed S"), "Spressed");
		this.getActionMap().put("Spressed", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("s pressed!");
				
				Client.speed = GUI.SpeedSlider.getValue();
				
				Client.speed = Client.speed - 20;
				GUI.SpeedSlider.setValue(Client.speed);		
			
				if (Client.backward){	
					Client.sendMessage("|BAK|"+GUI.SpeedSlider.getValue());
				}
		
			}
		
		});
	
	}
	
	private void addLeftKeyHandler(){
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed LEFT"), "LEFTpressed");
		this.getActionMap().put("LEFTpressed", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("LEFT pressed!");
				Client.left = true;
				Client.sendMessage("|LEF|"+ (90 -GUI.rotationSlider.getValue()));	
			}
			
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "LEFTreleased");
		this.getActionMap().put("LEFTreleased", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("LEFT released!");
				Client.left = false;
				Client.sendMessage("|CNT|0");
			}
			
			
		});
	}
	
	private void addRightKeyHandler(){
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed RIGHT"), "RIGHTpressed");
		this.getActionMap().put("RIGHTpressed", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("RIGHT pressed!");
				Client.right = true;
				Client.sendMessage("|RIG|"+(90 + GUI.rotationSlider.getValue()));
			}
			
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "RIGHTreleased");
		this.getActionMap().put("RIGHTreleased", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("RIGHT released!");
				Client.right = false;
				Client.sendMessage("|CNT|0");
			}
			
			
		});
	}
	
	private void addAKeyHandler(){
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed A"), "Apressed");
		this.getActionMap().put("Apressed", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("a pressed!");
				Client.rotation = GUI.rotationSlider.getValue();	
				
				Client.rotation = Client.rotation -10;
				GUI.rotationSlider.setValue(Client.rotation);
				
				if (Client.left){	
					Client.sendMessage("|LEF|"+(90 - GUI.rotationSlider.getValue()));
				}else if(Client.right){
					Client.sendMessage("|RIG|"+(90 + GUI.rotationSlider.getValue()));
				}
			
			}
			
		});
		
	}
	
	private void addDKeyHandler(){
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed D"), "Dpressed");
		this.getActionMap().put("Dpressed", new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("d pressed!");
				Client.rotation = GUI.rotationSlider.getValue();	
				
				Client.rotation = Client.rotation + 10;
				GUI.rotationSlider.setValue(Client.rotation);
				
				if (Client.left){	
					Client.sendMessage("|LEF|"+(90 - GUI.rotationSlider.getValue()));
				}else if(Client.right){
					Client.sendMessage("|RIG|"+(90 + GUI.rotationSlider.getValue()));
				}
			
			}
			
		});
		
	}
}