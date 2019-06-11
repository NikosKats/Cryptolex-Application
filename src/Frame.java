//Christos Topalidis icsd14203
//Nikolaos Katsilidis icsd14081




import java.awt.Container;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.SwingUtilities;



public class Frame extends JFrame{
    

    
    public Frame(){
     
        
        super("Κρυπτόλεξο");

     
      
       
    
    
    /*************************************************************************************************************
     * ************************************************************************************************************
     * **************************************************************************************************************
     */

    
    
    
    
    
    
    
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    
    Container pane = getContentPane();
    GridLayout glayout = new GridLayout(1,2);
    pane.setLayout(glayout);
     
    Object[] options = {"Παιχνίδι σε ταμπλό 10X10",
                    "Παιχνίδι σε ταμπλό 8X8",
                    "Παιχνίδι σε ταμπλό 5x5"};
    int n = JOptionPane.showOptionDialog(pane,
    "Διάλλεξε έναν από τους παρακάτω τρόπους παιχνιδιού.",
    "Επιλογή παιχνιδιού",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[2]);
    
    
      // Tamplo 5x5
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
    
          if (n == JOptionPane.CANCEL_OPTION)
  {
      
      Frame5 f = new Frame5();
      

      
                
  }
          // Tamplo 8x8
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
          
               if (n == JOptionPane.NO_OPTION)
  {
   
    Frame8 f = new Frame8();
      
    
    
  }
               // Tamplo 10x10
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
      
      if (n == JOptionPane.YES_OPTION)
  {
      JOptionPane.showMessageDialog(null, "10X10");
 
  }
          
    }  
    
    
    
    }



class MenuHandler implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}

class ButtonsHandler implements MouseListener
{

         @Override
              public void mouseClicked(MouseEvent e) {
                  
                  
                  
                  
                  if (SwingUtilities.isRightMouseButton(e))
                  {
                      
                  }
                  
                  
              }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
   
}

class ButtonHandler implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

