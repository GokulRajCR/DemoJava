import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MySpecialButton extends Button implements ActionListener  
{  
MyCalculator cl;  
  
MySpecialButton(int x,int y, int width,int height,String cap, MyCalculator clc)  
{  
super(cap);  
setBounds(x,y,width,height);  
this.cl=clc;  
this.cl.add(this);  
addActionListener(this);  
}  
//////////////////////  
static String backSpace(String s)  
{  
String Res="";  
for(int i=0; i<s.length()-1; i++) Res+=s.charAt(i);  
return Res;  
}  
  
//////////////////////////////////////////////////////////  
public void actionPerformed(ActionEvent ev)  
{  
String opText=((MySpecialButton)ev.getSource()).getLabel();  
//check for backspace button  
if(opText.equals("Backspc"))  
{  
String tempText=backSpace(cl.displayLabel.getText());  
if(tempText.equals(""))   
    cl.displayLabel.setText("0");  
else   
    cl.displayLabel.setText(tempText);  
return;  
}  
//check for "C" button i.e. Reset  
if(opText.equals("C"))  
	//check the buttons
{  
cl.number=0.0; cl.op=' '; cl.memValue=0.0;  
cl.memLabel.setText(" ");  
//membeer  details
}  
  
//it must be CE button pressed  
cl.displayLabel.setText("0");cl.setClear=true;  
}//actionPerformed  
}//class  
  
/********************************************* 
Features not implemented and few bugs 
 
i)  No coding done for "+/-" button. 
ii) Menubar is not included. 
iii)Not for Scientific calculation 
iv)Some of the computation may lead to unexpected result 
   due to the representation of Floating point numbers in computer 
   is an approximation to the given value that can be stored 
   physically in memory. 
***********************************************/  