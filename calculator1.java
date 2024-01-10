import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class calculatorException extends Exception
{
	public calculatorException()
	{ 
	System.out.println("Invalid Number ...Please Enter answer");
	}
}
class calculator1 extends JFrame  implements ActionListener
{
	JFrame f;
	JTextField txt;
	JButton []numberbuttons=new JButton[10];//buttons from 0 to 9
	JButton []functionbuttons=new JButton[8];//function buttons i.e add,subtract,multiply etc.
	JButton addbutton,subtractbutton,multiplybutton,dividebutton;
	JButton decbutton,equalbutton,deletebutton,clearbutton;
	JPanel panel;
	  double a=0,b=0,result=0;
	 char operator=0;
	 //this is an constructor of class calculator1.
	calculator1()
		{
			f=new JFrame(" Calculator ");
			f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(420,550);
			f.setResizable(false);
			f.setBackground(Color.BLACK);
			Font fb=new Font("Arial",Font.BOLD,20);
			txt=new JTextField();
			txt.setFont(fb);
			txt.setBackground(Color.BLACK);
			txt.setForeground(Color.WHITE);
			txt.setBounds(50,25,300,50);
			addbutton=new JButton("+");
			subtractbutton=new JButton("-");
			multiplybutton=new JButton("*");
			dividebutton=new JButton("/");
			decbutton=new JButton(".");
			equalbutton=new JButton("=");
			deletebutton=new JButton("delete");
			clearbutton=new JButton("clear");

			functionbuttons[0]=addbutton;
			functionbuttons[1]=subtractbutton;
			functionbuttons[2]=multiplybutton;
			functionbuttons[3]=dividebutton;
			functionbuttons[4]=decbutton;
			functionbuttons[5]=equalbutton;
			functionbuttons[6]=deletebutton;
			functionbuttons[7]=clearbutton;

			for(int i=0;i<8;i++)
			{
				functionbuttons[i].addActionListener(this);
				functionbuttons[i].setFont(fb);
				functionbuttons[i].setFocusable(false);
			}			
			for(int i=0;i<10;i++)
			{
				numberbuttons[i]=new JButton(String.valueOf(i));
				numberbuttons[i].addActionListener(this);
				numberbuttons[i].setFont(fb);
				numberbuttons[i].setFocusable(false);
			}
			deletebutton.setBounds(50,430,145,50);
			clearbutton.setBounds(205,430,145,50);
			//panel for buttons.
				panel =new JPanel();
				panel.setBounds(50,100,300,300);
				panel.setLayout(new GridLayout(4,4,10,10));
				panel.add(numberbuttons[1]);
				panel.add(numberbuttons[2]);
				panel.add(numberbuttons[3]);
				panel.add(addbutton);
				panel.add(numberbuttons[4]);
				panel.add(numberbuttons[5]);
				panel.add(numberbuttons[6]);
				panel.add(subtractbutton);
				panel.add(numberbuttons[7]);
				panel.add(numberbuttons[8]);
				panel.add(numberbuttons[9]);
				panel.add(multiplybutton);
				panel.add(decbutton);
				panel.add(numberbuttons[0]);
				panel.add(equalbutton);
				panel.add(dividebutton);
				f.add(panel);
			f.add(deletebutton);
			f.add(clearbutton);
			f.add(txt);
			f.setVisible(true);
		}
		// add action listener that button performs functionality.
		 public void actionPerformed(ActionEvent e)
		 {
			for(int i=0;i<10;i++)
			{
				if(e.getSource()==numberbuttons[i])
				{
					txt.setText(txt.getText().concat(String.valueOf(i)));
				}
			}
			//if(e.getSource()==decbutton)
				//{
					//txt.setText(txt.getText().concat(String.valueOf(.)));
				//}
				if(e.getSource()==addbutton)
				{
					a=Double.parseDouble(txt.getText());
					operator='+';
					txt.setText("");
				}
				if(e.getSource()==subtractbutton)
				{
					a=Double.parseDouble(txt.getText());
					operator='-';
					txt.setText("");
				}
				if(e.getSource()==multiplybutton)
				{
					a=Double.parseDouble(txt.getText());
					operator='*';
					txt.setText("");
				}
				if(e.getSource()==dividebutton)
				{
					a=Double.parseDouble(txt.getText());
					operator='/';
					txt.setText("");
				}
				if(e.getSource()==equalbutton)
				{
					b=Double.parseDouble(txt.getText());
					switch(operator)
					{
					case '+':
						result=a+b;
						break;

						case '-':
						result=a-b;
						break;

					case '*':
						result=a*b;
						break;

					case '/':
						try{
						result=a/b;
						throw new calculatorException();
						}
						catch(calculatorException ex)
						{
							System.out.println(ex);
						}
					}
						txt.setText(String.valueOf(result));
						a=result;
				}
				if(e.getSource()==clearbutton)
				{
					txt.setText("");
				}
				if(e.getSource()==deletebutton)
				{
				String string=txt.getText();
					txt.setText("");
				for(int i=0;i<string.length()-1;i++)
					{
						txt.setText(txt.getText()+string.charAt(i));
					}
				}
				}
				
		public static void main(String args[])
 {
 		calculator1 j1=new calculator1();
		 }	
}