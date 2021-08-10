/*
 * @author  PashalisTsirts
 * @create  ‎5/28/2020, ‏‎‏‎8:37:06
 * @name Calculator.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener 
{
	private JTextField Result;
	private String FirstCharacter="",SecondCharacter="",ThirdCharacter="",GetCharacter="";
	private static final long serialVersionUID=1L;	
	public static void main  (String [] args)	
	{	
		new Calculator().setVisible(true);	
	}
	
	private Calculator() 
	{
		
		
	//Window settings	
		super("Calculator");
		setBackground(Color.gray);
		
		setSize(280,200);                                       
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setLayout(new GridLayout() );
		
	// Creating and initialising each button and text field
		
		JPanel buttonpanel1=new  JPanel();                      //Creating first panel
		buttonpanel1.setLayout(new FlowLayout());
		buttonpanel1.add(Result = new JTextField(15));
		Result.setHorizontalAlignment(JTextField.RIGHT);        //Place result to right
		Result.setEditable(false);                              //Not editable text
		
		JButton AC=new JButton("C");                              //Creating button clear
		AC.addActionListener(this);
		AC.setActionCommand("C");
		buttonpanel1.add(AC);
		
		
		
		JPanel buttonpanel2=new  JPanel();                        //Creating second panel  
		buttonpanel2.setLayout(new GridLayout(4,4));              //Creating gridlayout
		
		JButton b7 =new JButton ("7");	                          //Creating button 7 
		b7.addActionListener(this);
		b7.setActionCommand("7");
		buttonpanel2.add(b7);
		
		JButton b8 =new JButton ("8");                             //Creating button 8
		b8.addActionListener(this);
		b8.setActionCommand("8");
		buttonpanel2.add(b8);
		
		JButton b9 =new JButton ("9");                             //Creating button 9
		b9.addActionListener(this);
		b9.setActionCommand("9");
		buttonpanel2.add(b9);
		
		
		JButton bd =new JButton ("/");                             //Creating button slash
		bd.addActionListener(this);
		bd.setActionCommand("/");
		buttonpanel2.add(bd);
		
		
		JButton b4 =new JButton ("4");                             //Creating button 4
		b4.addActionListener(this);
		b4.setActionCommand("4");
		buttonpanel2.add(b4);
		
		JButton b5 =new JButton ("5");                             //Creating button 5
		b5.addActionListener(this);
		b5.setActionCommand("5");
		buttonpanel2.add(b5);
		 
		JButton b6 =new JButton ("6");                             //Creating button 6
		b6.addActionListener(this);
		b6.setActionCommand("6");
		buttonpanel2.add(b6);
		
		
		JButton bml =new JButton ("*");                            //Creating button for multiplication
		bml.addActionListener(this);
		bml.setActionCommand("*");
		buttonpanel2.add(bml);
		
			
		JButton b1 =new JButton ("1");                             //Creating button 1
		b1.addActionListener(this);
		b1.setActionCommand("1");
		buttonpanel2.add(b1);
		
		
		JButton b2 =new JButton ("2");                             //Creating button 2
		b2.addActionListener(this);
		b2.setActionCommand("2");
		buttonpanel2.add(b2);
		
		JButton b3 =new JButton ("3");                             //Creating button 3 
		b3.addActionListener(this);
		b3.setActionCommand("3");
		buttonpanel2.add(b3);
		
		
		JButton bm =new JButton ("-");                             //Creating button for minus
		bm.addActionListener(this);
		bm.setActionCommand("-");
		buttonpanel2.add(bm);
		
		JButton b0 =new JButton ("0");                             //Creating button 0
		b0.addActionListener(this);
		b0.setActionCommand("0");
		buttonpanel2.add(b0);
		
		
		JButton bp =new JButton (".");                             //Creating button point
		bp.addActionListener(this);
		bp.setActionCommand(".");
		buttonpanel2.add(bp);
		
		
		JButton be =new JButton ("=");                              //Creating button equal
		be.addActionListener(this);
		be.setActionCommand("=");
		buttonpanel2.add(be);
		
		JButton bpl =new JButton ("+");                             //Creating button plus
		bpl.addActionListener(this);
		bpl.setActionCommand("+");
		buttonpanel2.add(bpl);
		
		
		JPanel mainpanel = new JPanel();                            //Creating the main panel
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(buttonpanel1, BorderLayout.NORTH);
		mainpanel.add(buttonpanel2, BorderLayout.SOUTH);            //Place smaller panels
		
		add(mainpanel);                                             //Add main panel
		
		
	}
//actions
	public void actionPerformed(ActionEvent e) 
	{	
		GetCharacter=e.getActionCommand();       //Keypressed character
		 
        if ((GetCharacter.charAt(0) <= '9' && GetCharacter.charAt(0) >= '0') || GetCharacter.charAt(0) == '.')//If number
        {           
            if (!SecondCharacter.equals("")) 
            	ThirdCharacter = ThirdCharacter + GetCharacter; 
            else
            	FirstCharacter = FirstCharacter + GetCharacter;            
            Result.setText(FirstCharacter + SecondCharacter + ThirdCharacter);              //Print result
        } 
       
        else if (GetCharacter.charAt(0) == '=')                                             //Calculate
        {  
            double temp;           
            if (SecondCharacter.equals("*")) 
                temp = (Double.parseDouble(FirstCharacter) * Double.parseDouble(ThirdCharacter)); 
            else if (SecondCharacter.equals("/")) 
                temp = (Double.parseDouble(FirstCharacter) / Double.parseDouble(ThirdCharacter)); 
            else if (SecondCharacter.equals("+")) 
                temp = (Double.parseDouble(FirstCharacter) + Double.parseDouble(ThirdCharacter)); 
            else
                temp = (Double.parseDouble(FirstCharacter) - Double.parseDouble(ThirdCharacter));             
            Result.setText(FirstCharacter + SecondCharacter + ThirdCharacter + "=" + temp);    //Print result         
            FirstCharacter = Double.toString(temp);                                    //Convert to string
            SecondCharacter = ThirdCharacter = ""; 
        }  
        else if (GetCharacter.charAt(0) == 'C')                                          //If clear
        {            
        	FirstCharacter = SecondCharacter = ThirdCharacter = "";   
            Result.setText(FirstCharacter + SecondCharacter + ThirdCharacter);             //Clear  result
        }
        
        else                                                                      //If operator + calculate
        {         
            if (SecondCharacter.equals("") || ThirdCharacter.equals("")) 
            	SecondCharacter = GetCharacter;            
            else 
            { 
                double temp;                
                if (SecondCharacter.equals("*")) 
                    temp = (Double.parseDouble(FirstCharacter) * Double.parseDouble(ThirdCharacter)); 
                else if (SecondCharacter.equals("/")) 
                    temp = (Double.parseDouble(FirstCharacter) / Double.parseDouble(ThirdCharacter)); 
                else if (SecondCharacter.equals("+")) 
                    temp = (Double.parseDouble(FirstCharacter) + Double.parseDouble(ThirdCharacter)); 
                else
                    temp = (Double.parseDouble(FirstCharacter) - Double.parseDouble(ThirdCharacter));                
                FirstCharacter = Double.toString(temp);                                    //Convert to string
                SecondCharacter = GetCharacter;               
                ThirdCharacter = ""; 
            }              
            Result.setText(FirstCharacter + SecondCharacter + ThirdCharacter);              //Print result
        } 
    } 
}