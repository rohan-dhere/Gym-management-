import java.awt.*;
import java.io.*;
import java.awt.event.*;
import BMI.calculate;

//  AWT program inherits the top-level container java.awt.Frame
public class gym extends Frame 
  {
    private TextField  logindisplay,memberid,nametxt,bmitxt,agetxt,contacttxt,gendertxt,weighttxt,heighttxt,display1,findtxt;
    private TextField  usertxt,passwordtxt;
    TextArea  txt;
    private Button login,logout,enter1, btnCLEAR,displaybtn,bmical,exit;
    String[] name = new String[100];
    String[] contact = new String[100];
    int[] age = new int[100];
    String[] gender = new String[100];
    float[] weight = new float[100];
    float[] height = new float[100];
    int i=0,find=0;
    double x=0;
 
// Constructor to setup the components and event handlers
 public gym () 
  {
  setLayout(new FlowLayout());

  add(new Label("User ID"));
  usertxt= new TextField("",5);
  usertxt.setEditable(true);
  add(usertxt);
  
  add(new Label("Password"));
  passwordtxt= new TextField("",8);
  passwordtxt.setEditable(true);
  passwordtxt.setEchoChar('*');
  add(passwordtxt);

  login = new Button("Login");
  add(login);

  logout = new Button("Logout");
  add(logout);


  logindisplay= new TextField("",230);
  logindisplay.setEditable(false);
  add(logindisplay);
 
  add(new Label("MEMBER ID"));
  memberid = new TextField("", 20);
  memberid.setEditable(false);
  add(memberid);

  add(new Label("NAME"));
  nametxt = new TextField("", 20);
  nametxt.setEditable(false);
  add(nametxt);

  add(new Label("AGE"));
  agetxt = new TextField("", 2);
  agetxt.setEditable(false);
  add(agetxt);

  add(new Label("CONTACT"));
  contacttxt = new TextField("", 10);
  contacttxt.setEditable(false);
  add(contacttxt);

  add(new Label("GENDER"));
  gendertxt = new TextField("",6);
  gendertxt.setEditable(false);
  add(gendertxt);

  add(new Label("WEIGHT(In kg)"));
  weighttxt = new TextField("", 10);
  weighttxt.setEditable(false);
  add(weighttxt);

  add(new Label("HEIGHT(In m)"));
  heighttxt = new TextField("", 10);
  heighttxt.setEditable(false);
  add(heighttxt);  

//Buttons
  enter1 = new Button("ENTER");
  add(enter1);  

  findtxt = new TextField("", 20);
  findtxt.setEditable(false);
  add(findtxt);

  displaybtn = new Button("DISPLAY");
  add(displaybtn);

  btnCLEAR = new Button("CLEAR");
  add(btnCLEAR);

  txt=new TextArea("",5,230);
  txt.setEditable(false);
  add(txt);

  bmical = new Button("Calculate BMI");
  add(bmical);

  bmitxt = new TextField("",10);
  bmitxt.setEditable(true);
  add(bmitxt);


  display1 = new TextField("",230);
  display1.setEditable(true);
  add(display1);
  display1.setVisible(true);
  
  exit = new Button("EXIT");
  add(exit);


//Allocate an instance of the  inner class BtnListener.
 BtnListener listener = new BtnListener();

// same listener instance for all  Buttons.
  enter1.addActionListener(listener);
  btnCLEAR.addActionListener(listener);
  displaybtn.addActionListener(listener);
  bmical.addActionListener(listener);
  login.addActionListener(listener);
  logout.addActionListener(listener);
  exit.addActionListener(listener);

 setTitle("APSIT GYM");
 setSize(1700, 350);
 setVisible(true);
 }


 // main method
  public static void main(String[] args)
  {
    new gym(); //
  }

  private class BtnListener implements ActionListener 
    {

    // getActionCommand() returns the Button's label
    public void actionPerformed(ActionEvent evt) 
    {
      String btnLabel = evt.getActionCommand();
          switch(btnLabel)
            {
               case "Login" :
                  if( usertxt.getText().equals("APSIT") && passwordtxt.getText().equals("apsit123") )
                  {
                      usertxt.setText("");
                      passwordtxt.setText("");
                      logindisplay.setText("Logged in as ADMIN");
                      memberid.setEditable(true);
                      nametxt.setEditable(true);
                      agetxt.setEditable(true);
                      contacttxt.setEditable(true);
                      gendertxt.setEditable(true);
                      weighttxt.setEditable(true);
                      heighttxt.setEditable(true);                            
                      findtxt.setEditable(true);

                  }  
                    
                  else
                  {
                      logindisplay.setText("Error! Invalid Login");
                      memberid.setEditable(false);
                      nametxt.setEditable(false);
                      agetxt.setEditable(false);
                      contacttxt.setEditable(false);
                      gendertxt.setEditable(false);
                      weighttxt.setEditable(false);
                      heighttxt.setEditable(false);
                      findtxt.setEditable(false);
                       }   

               break;   


               case "Logout" :
                      logindisplay.setText("Logged Out");
                      memberid.setEditable(false);
                      nametxt.setEditable(false);
                      agetxt.setEditable(false);
                      contacttxt.setEditable(false);
                      gendertxt.setEditable(false);
                      weighttxt.setEditable(false);
                      heighttxt.setEditable(false);
                      findtxt.setEditable(false);
               break;


               case "ENTER" :
                      txt.setText("GOT IT!!!");
                      i=Integer.parseInt(memberid.getText());
                      name[i]=(nametxt.getText());
                      contact[i]=(contacttxt.getText());
                      gender[i]=(gendertxt.getText());
                      age[i]=Integer.parseInt(agetxt.getText());
                      weight[i]=Float.parseFloat(weighttxt.getText());
                      height[i]=Float.parseFloat(heighttxt.getText());
              break;


              case "DISPLAY" :
                    find=Integer.parseInt(findtxt.getText());
                    
                    if(name[find]==null )
                      {
                      txt.setText("PLEASE ENTER VALID NUMBER!!!");
                      }
                    else 
                      {
                      txt.setText("Name- "+name[find]+"\t Age- "+age[find]+"\t       Contact- "+contact[find]+"     \t Gender- "+gender[find]+"\t Weight- "+weight[find]+"\t Height- "+height[find] );
                      }
              break;


              case  "CLEAR" :
                    memberid.setText("");
                    nametxt.setText("");
                    txt.setText("");
                    agetxt.setText("");
                    contacttxt.setText("");
                    gendertxt.setText("");
                    weighttxt.setText("");
                    heighttxt.setText("");
                    findtxt.setText("");
                    bmitxt.setText("");
                    display1.setText("");
              break;

               
              case "Calculate BMI" :
                    find=Integer.parseInt(findtxt.getText());
                      if(name[find]==null )
                          txt.setText("PLEASE ENTER VALID NUMBER!!!");
                      else
                        {     
                          float answer;
                          calculate c1 = new  calculate();
                          answer=c1.bmical(weight[find],height[find]);
                          bmitxt.setText(String.valueOf(answer));
                          if(answer<18.5)
                           {
                             display1.setText("Ohh!You are underweight");
                           }
                           else if (answer>18.5 && answer <24.9)
                           {
                             display1.setText("Healthy Weight");
                           }

                          else if (answer>25 && answer <29.9)
                           {
                             display1.setText("Above ideal range");
                           }

                           else if (answer>30)
                          {
                            display1.setText("Over Weight");

                          }
                
                        }
              break;

              case "EXIT" :
                  System.exit(0);
              break;

            }

    }
  }
}