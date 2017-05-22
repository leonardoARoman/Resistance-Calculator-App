/*
	Implemnting ComboBoxes JComboBox objects
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ResistorCalculator{
	private static class WindowApplication extends JFrame{
	//Atributes
	//Panels,field,boxes and buttons
	private JPanel displayPanel,boxPanel,buttonPanel,picPanelWest,picPanelEast;
	//outPut object is part of panel 1 "displayPanel"
	private JTextField outPut;
	private JLabel resistorValue,piclabel1,piclabel2,piclabel3;
	//box1,box2,box3 share same String array list bandColorList
	//and is all part of panel 2 "boxPanel"
	private String[] bandColorList = {"Black","Brown","Red","Orange","Yellow","Green",
								"Blue","Violet","Grey","White"};
	private JComboBox box1, box2, box3;
	//calcButton button object is part of panel 3 "buttonPanel"
	private JButton calcButton;
	//constructor
		public WindowApplication(){
			super("Resistor Calculator App");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			buildDisplayPanel();
			buildBoxPanel();
			buildButtonPanel();
			buildPic1();
			buildPic2();

			add(displayPanel,BorderLayout.NORTH);
			add(boxPanel,BorderLayout.CENTER);
			add(buttonPanel,BorderLayout.SOUTH);
			add(picPanelWest,BorderLayout.WEST);
			add(picPanelEast,BorderLayout.EAST);

			pack();
			setVisible(true);
		}
		private void buildPic1(){
			picPanelWest = new JPanel();
			picPanelWest.setBackground(Color.WHITE);
			piclabel1 = new JLabel("");
			piclabel1.setIcon(new ImageIcon("r2.jpg"));
			piclabel1.setText(null);
			picPanelWest.add(piclabel1);
		}
		private void buildPic2(){
			picPanelEast = new JPanel();
			picPanelEast.setBackground(Color.WHITE);
			piclabel2 = new JLabel("");
			piclabel2.setIcon(new ImageIcon("r2.jpg"));
			piclabel2.setText(null);
			picPanelEast.add(piclabel2);
		}
		private void buildDisplayPanel(){
		//Panel 1
			displayPanel = new JPanel();
			displayPanel.setBackground(Color.WHITE);
			resistorValue = new JLabel("Resistor Value");
			displayPanel.add(resistorValue);
			outPut = new JTextField(17);
			outPut.setEditable(false);
			displayPanel.add(outPut);
		}

		private void buildBoxPanel(){
			//Panel 2
			boxPanel = new JPanel();
			boxPanel.setBackground(Color.WHITE);
			box1 = new JComboBox(bandColorList);
			box1.addActionListener(new ListenedAction());
	 		box2 = new JComboBox(bandColorList);
	 		box2.addActionListener(new ListenedAction());
	 		box3 = new JComboBox(bandColorList);
	 		box3.addActionListener(new ListenedAction());
			boxPanel.add(box1);
			boxPanel.add(box2);
			boxPanel.add(box3);
			
		}

		private void buildButtonPanel(){
			//Panel 3
			buttonPanel = new JPanel();
			buttonPanel.setBackground(Color.WHITE);
			calcButton = new JButton("EXIT");
			calcButton.addActionListener(new ButtonHandler());
			buttonPanel.add(calcButton);
		}
		//Exits when "EXIT" button is clicked.
		private class ButtonHandler implements ActionListener{
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		}

		private class ListenedAction implements ActionListener{
			public void actionPerformed(ActionEvent e){
				int result;
				if (box1.getSelectedItem() == "Black") {
					result = getColor2((String) box2.getSelectedItem()) * 
					         getColor3((String) box3.getSelectedItem());
					outPut.setText(Integer.toString(result)+" ohms");

				}
				else{
				result = (getColor1((String) box1.getSelectedItem()) + 
						  getColor2((String) box2.getSelectedItem())) * 
					      getColor3((String) box3.getSelectedItem());
				outPut.setText(Integer.toString(result)+" ohms");
				}
			}
		}
	}
	
	public static void main(String[] args){
		new WindowApplication();
	}

	private static int getColor1(String str){
		if (str == "Black") {
			return 0;
		}else if (str == "Brown") {
			return 10;
		}else if (str == "Red") {
			return 20;
		}else if (str == "Orange") {
			return 30;
		}else if (str == "Yellow") {
			return 40;
		}else if (str == "Green") {
			return 50;
		}else if (str == "Blue") {
			return 60;
		}else if (str == "Violet") {
			return 70;
		}else if (str == "Grey") {
			return 80;
		}else if (str == "White") {
			return 90;
		}
		return -1;
	}
	private static int getColor2(String str){
		if (str == "Black") {
			return 0;
		}else if (str == "Brown") {
			return 1;
		}else if (str == "Red") {
			return 2;
		}else if (str == "Orange") {
			return 3;
		}else if (str == "Yellow") {
			return 4;
		}else if (str == "Green") {
			return 5;
		}else if (str == "Blue") {
			return 6;
		}else if (str == "Violet") {
			return 7;
		}else if (str == "Grey") {
			return 8;
		}else if (str == "White") {
			return 9;
		}
		return -1;
	}
	private static int getColor3(String str){
		if (str == "Black") {
			return 1;
		}else if (str == "Brown") {
			return 10;
		}else if (str == "Red") {
			return 100;
		}else if (str == "Orange") {
			return 1000;
		}else if (str == "Yellow") {
			return 10000;
		}else if (str == "Green") {
			return 100000;
		}else if (str == "Blue") {
			return 1000000;
		}else if (str == "Violet") {
			return 10000000;
		}else if (str == "Grey") {
			return 100000000;
		}else if (str == "White") {
			return 1000000000;
		}
		return -1;
	}
}
/*
Black	= 0		Black 	= 1
Brown	= 1		Brown 	= 10
Red		= 2		Red		= 100
Orange	= 3		Orange	= 1000
Yellow	= 4		Yellow	= 10000
Green	= 5		Green	= 100000
Blue 	= 6		Blue 	= 1000000
Violet	= 7		Violet	= 10000000
Grey 	= 8 	Grey 	= 100000000
White	= 9		White	= 1000000000
*/