
//Christos Topalidis icsd14203
//Nikolaos Katsilidis icsd14081



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Frame8 extends JFrame{
    
    private JPanel row1,row2;
    private JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
    private JMenuBar menuBar;
    private JMenu fileM,toolsM;
    private JMenuItem newGame,endGame,newPlayer,settings,search,exit;
    private JMenuItem help,about;
    
    private MenuHandler handler;
    private ButtonHandler bHandler;
    private ButtonsHandler buttonsHandler;
    
    
    
    private Label label,label1,label2,label3,label4,label5,label6,label7,label8;
    
    private JButton button;
    
   private JButton button1,button2,button3,button4,button5;
    
    
    private JButton[] buttons2= new JButton[64];
    
    public Frame8()
    {
         super("Κρυπτόλεξο");
        
     //Dhmiourgia antikeimenwn
   Dictionary dictionary = new Dictionary(); 
   
   
   //Dhmiourgia pinaka antikeimenwn
   Letter array2[][] = new Letter[8][8];
   
  
       
    //Kalesma sunartshs apo thn Dictionary gia anoigma arxeiou
    dictionary.openFile();
    //Kalesma sunartshs apo thn Dictionary gia diabasma arxeiou
    dictionary.readFile();
    
   
  
        StringBuilder str2 = dictionary.getString();
           
            int i2,j2;
        int counter2=0;
        
        //Arxikopoihsh pinaka 8x8 me katallhla antikeimena
        
         /*************************************************************************************************************
     * ************************************************************************************************************
     * **************************************************************************************************************
     */
        
        for(i2=0;i2<8;i2++)
        {
            for(j2=0;j2<8;j2++){
        
             
                
                if(counter2<61){
                    array2[i2][j2] =new Regular(str2.charAt(counter2));
                }
                
                if(counter2>60 && counter2<63)
                {
                    array2[i2][j2] =new Red(str2.charAt(counter2)); 
                }
                
                
                if(counter2==63)
                {
                 array2[i2][j2] =new Blue(str2.charAt(counter2));
                }
                
                
                if(counter2==64)
                {
                    array2[i2][j2] =new Wildcard(str2.charAt(counter2));
                }
               
                
                counter2++;
            }
        }
            
        
        //Ektupwsh pinaka
        for(i2=0;i2<8;i2++)
        {
            for(j2=0;j2<8;j2++){
        
                System.out.print(array2[i2][j2].get_character());
                
                System.out.print(array2[i2][j2].get_point());

            }
            System.out.println();
        }
        
          
    
    //Kleisimo arxeiou
         dictionary.closeFile();
         
         
         row1 = new JPanel();
    row2 = new JPanel();
    
    
    
    
    
    
    setSize(800,650);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setVisible(true);
    
    Container pane = getContentPane();
    GridLayout glayout = new GridLayout(1,2);
    pane.setLayout(glayout);
    
    handler = new MenuHandler();
    
    bHandler = new ButtonHandler();
       
    //Grammh menu
    menuBar = new JMenuBar();
            
    //Dhmiourgia menu fileM
    fileM = new JMenu("Μενού");
            
    //Dhmiourgia menu item newGame
    newGame = new JMenuItem("Νέο παιχνίδι");
    newGame.addActionListener(handler);
    fileM.add(newGame);
            
    //Dhmiourgia menu item endGame
    endGame = new JMenuItem("Ακύρωση/Τερματισμός παιχνιδιού");
    endGame.addActionListener(handler);
    fileM.add(endGame);
            
    //Dhmiourgia menu item newPlayer
    newPlayer = new JMenuItem("Εισαγωγή στοιχείων παίχτη");
    newPlayer.addActionListener(handler);
    fileM.add(newPlayer);
            
    //Dhmiourgia menu item settings
    settings = new JMenuItem("Ρυθμίσεις βοηθειών");
    settings.addActionListener(handler);
    fileM.add(settings);
            
    //Dhmiourgia menu item search
    search = new JMenuItem("Αναζήτηση αρχείου λέξεων");
    search.addActionListener(handler);
    fileM.add(search);
            
    //Dhmiourgia menu item exit
    exit = new JMenuItem("Έξοδος");
    exit.addActionListener(handler);
    fileM.add(exit);
            
    //Pros8hkh fileM sth grammh
    menuBar.add(fileM);
    
    //Dhmiourgia menu toolsM
    toolsM = new JMenu("Εργαλεία");
            
    //Dhmiourgia menu item help
    help = new JMenuItem("Βοήθεια");
    help.addActionListener(handler);
    toolsM.add(help);
            
    //Dhmiourgia menu item about
    about = new JMenuItem("About");
    about.addActionListener(handler);
    toolsM.add(about);
            
    //Pros8hkh toolsM sth grammh
    menuBar.add(toolsM);
  
            
    setJMenuBar(menuBar);
    
    
    
     newGame.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){

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
    
    if (n == JOptionPane.CANCEL_OPTION)
        {
            Frame5 f = new Frame5();
        }
        
        else if (n == JOptionPane.NO_OPTION)
        {
            Frame8 f = new Frame8();
        }  
       else if (n == JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Η λειτουργία βρίσκεται υπό κατασκευή\n");
        }
                                  
            
    
        } 
    });
     
     //----------->DONE<-------------------------\\
     
     endGame.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){

         System.exit(0);
    
        } 
    });
    
     //----------->DONE<-------------------------\\
     
     newPlayer.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
            
            String age;
            age = JOptionPane.showInputDialog("Δώσε ηλικία");

            String last_name;
            last_name = JOptionPane.showInputDialog("Δώσε επώνυμο");
            
            String first_name;
            first_name = JOptionPane.showInputDialog("Δώσε όνομα");
            
            String full_name;
            full_name = "Ο νέος παίκτης είναι ο/η " + first_name + " " + last_name + ", " + age +" χρονών";
            
            JOptionPane.showMessageDialog( null, full_name );
            
        }
        
    });
     
     settings.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){

    
    
        } 
    });
     
     
     
     search.addActionListener(new ActionListener(){
        
    public void actionPerformed(ActionEvent e){

    
    
        } 
    });
     
     //----------->DONE<-------------------------\\
     
     exit.addActionListener(new ActionListener(){
        
    public void actionPerformed(ActionEvent e){

        
        System.exit(0);
    
    
        } 
    });
     
     //----------->DONE<-------------------------\\
     
     help.addActionListener(new ActionListener(){
        
    public void actionPerformed(ActionEvent e){

        JOptionPane.showMessageDialog(null, "Το παιχνίδι «Ηλεκτρονικό  κρυπτόλεξο»\n");
    
        } 
    });
     
     
     //----------->DONE<-------------------------\\
     
     about.addActionListener(new ActionListener(){
        
    public void actionPerformed(ActionEvent e){

         JOptionPane.showMessageDialog(null, "Το παιχνίδι «Ηλεκτρονικό  κρυπτόλεξο»\n" 
                +"\nΗ βασική οθόνη (κεντρικό πάνελ) του παιχνιδιού αποτελείται από ένα σύνολο ελληνικών γραμμάτων. \n"
                + "Ο βασικός στόχος του παίκτη είναι να δημιουργήσει όσο το δυνατόν μεγαλύτερες λέξεις επιλέγοντας \n κατάλληλα γράμματα ακολουθώντας τους κανόνες του παιχνιδιού.\n"
                + "Σε κάθε γράμμα του Ελληνικού αλφαβήτου που είναι τοποθετημένο στο κεντρικό πάνελ αναγράφεται ένας \n ακέραιος θετικός αριθμός που "
                + "αντιστοιχεί στους πόντους που θα λάβει ο παίκτης αν χρησιμοποιήσει το συγκεκριμένο γράμμα για την \n δημιουργία μιας λέξης."
                + "Έτσι, αν ο παίκτης επιλέξει και τα 2 αυτά γράμματα για την διαμόρφωση της λέξης του θα έχει \n συγκεντρώσει τουλάχιστον 12 πόντους"
                + "Ο παίκτης κερδίζει στο παιχνίδι όταν θα έχει καταφέρει να συγκεντρώσει ένα συγκεκριμένο αριθμό \n πόντων καθορισμένο από το παιχνίδι, δημιουργώντας ένα προκαθορισμένο πλήθος λέξεων.\n"
                + "Το παιχνίδι ολοκληρώνεται με αποτυχία σε περίπτωση που ο χρήστης δημιουργήσει τον συγκεκριμένο αριθμό \n λέξεων που ζητείται από το παιχνίδι αλλά δεν έχει καταφέρει να συγκεντρώσει το επιθυμητό αριθμό των πόντων.\n"
                );
    
        } 
    });
     
    addMouseListener(
                
            new MouseListener()
                {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                    
                        
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
            );
    
   GridLayout glayout1 = new GridLayout(9,1);
   row1.setLayout(glayout1);
   
   int x = 0;
   int y = 0;
   
   
   
   for(int i=0;i<64;i++){
       
      
       
      if(x%8==0 && x!=0)
      {
          x=0;
          y++;
      }
      
      
      
      
       
       if(array2[y][x].get_character()=='Α')
       {
            buttons2[i] = new JButton("Α 1");
            buttons2[i].setBackground(Color.GRAY);
            
            
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]); 
       }
       if(array2[y][x].get_character()=='Β')
       {
           
            buttons2[i] = new JButton("Β 8");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       
       if(array2[y][x].get_character()=='Γ'){
           
           buttons2[i] = new JButton("Γ 4");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Δ'){
           
           buttons2[i] = new JButton("Δ 4");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
           
       }
       if(array2[y][x].get_character()=='Ε'){
           
           buttons2[i] = new JButton("Ε 1");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Ζ'){
           
           buttons2[i] = new JButton("Ζ 8");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Η'){
           
           buttons2[i] = new JButton("Η 1");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Θ'){
           
           buttons2[i] = new JButton("Θ 8");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Ι'){
           
           buttons2[i] = new JButton("Ι 1");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Κ'){
           
           buttons2[i] = new JButton("Κ 2");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Λ'){
           
           buttons2[i] = new JButton("Λ 3");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Μ'){
           
           buttons2[i] = new JButton("Μ 3");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Ν'){
           
           buttons2[i] = new JButton("Ν 1");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Ξ'){
           
           buttons2[i] = new JButton("Ξ 10");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Ο'){
           
           buttons2[i] = new JButton("Γ 4");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Π'){
           
           buttons2[i] = new JButton("Π 2");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Ρ'){
           
           buttons2[i] = new JButton("Ρ 2");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Σ'){
           
           buttons2[i] = new JButton("Σ 1");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Τ'){
           
           buttons2[i] = new JButton("Τ 1");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Υ'){
           
           buttons2[i] = new JButton("Υ 2");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Φ'){
           
           buttons2[i] = new JButton("Φ 8");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Χ'){
           
           buttons2[i] = new JButton("Χ 10");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Ψ'){
           
           buttons2[i] = new JButton("Ψ 10");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       if(array2[y][x].get_character()=='Ω'){
           
           buttons2[i] = new JButton("Ω 3");
            buttons2[i].setBackground(Color.GRAY);
            buttons2[i].setOpaque(true);
            buttons2[i].setBorderPainted(false);
            row1.add(buttons2[i]);
       }
       
     
      x++;
   }
   
 
  
   
for(int i=0;i<64;i++){
       
       buttons2[i].addMouseListener(
  
  new MouseListener()
  {
  
  @Override
  public void mouseClicked(MouseEvent e) {
  
    
    
    for(int i=0;i<64;i++)
    {
                 
                if(e.getSource() == buttons2[i])
                {
                    buttons2[i].setBackground(Color.YELLOW);
                }

                
            if (SwingUtilities.isRightMouseButton(e))
            {

                if(e.getSource() == buttons2[i])
                {
                    buttons2[i].setBackground(Color.GRAY);
                }

            }
  
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
  );
   
   }
  
   /**************************************************************************
    **************************************************************************
    **************************************************************************
    */
   
  /*
  
  buttons2[0].addMouseListener(
  
  new MouseListener()
  {
  
  @Override
  public void mouseClicked(MouseEvent e) {
  
  buttons2[0].setBackground(Color.YELLOW);
  buttons2[0].setOpaque(true);
  buttons2[0].setBorderPainted(false);
  
  
  if (SwingUtilities.isRightMouseButton(e))
  {
  buttons2[0].setBackground(Color.GRAY);
  buttons2[0].setOpaque(true);
  buttons2[0].setBorderPainted(false);
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
  );
  
  
 
   */
    
    
   
  /**************************************************************************
   **************************************************************************
   **************************************************************************
   */
  
   
   button = new JButton("OK");
   button.setPreferredSize(new Dimension(40, 80));
   
   button.setForeground(Color.BLACK);
   button.setBackground(Color.GREEN);
   button.setOpaque(true);
   button.setBorderPainted(false);
   
  
   
   button.addMouseListener(
                
            new MouseListener()
                {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                    
                        
                          
                        if (SwingUtilities.isRightMouseButton(e))
                        {
                            text1.setText("");
                            
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
            );
   
   
   //button.addActionListener(bHandler);
   
   button.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
           
           
          text1.setText("Εμφάνισε την λέξη που βρήκε ο χρήστης");
       }
   
   });
   
   row1.add(button);
   
   pane.add(row1);
    
    GridLayout glayout2 = new GridLayout(12,2);
    row2.setLayout(glayout2);
    
    
    
    button1 = new JButton("Διαγραφή Γραμμής");           //text1
    button2 = new JButton("Αναδιάταξη Γραμμής");         //text2
    button3 = new JButton("Αναδιάταξη Στήλης");          //text3
    button4 = new JButton("Αναδιάταξη Ταμπλό");          //text4
    button5 = new JButton("Εναλλαγή Γραμμάτων");         //text5

    label = new Label("Εισαγωγή Γραμμών/Στηλών & Αποτελέσματα");
    label1 = new Label("Βοήθειες");
    
    label2 = new Label("Στόχος:");                            //text6
    label3 = new Label("Συνολική Βαθμολογία:");               //text7
    label4 = new Label("Βαθμολογία Λέξης:");                  //text8
    label5 = new Label("Λέξεις που βρέθηκαν:");               //text9
    label6 = new Label("Συγχαρητήρια βρήκες τη λέξη:");       //text10
    
    label7 = new Label(" ");
    label8 = new Label(" ");
    
    text1 = new JTextField();
    text2 = new JTextField();
    text3 = new JTextField();
    text4 = new JTextField();
    text5 = new JTextField();
    text6 = new JTextField();
    text7 = new JTextField();
    text8 = new JTextField();
    text9 = new JTextField();
    text10 = new JTextField();
    
    
    row2.add(label1);
    row2.add(label);
    
    row2.add(button1);
    row2.add(text1);
    
    
    row2.add(button2);
    row2.add(text2);
    
    
    row2.add(button3);
    row2.add(text3);
    
    
    row2.add(button4);
    row2.add(label7);
    
    
    row2.add(button5);
    row2.add(label8);
    

    
    row2.add(label2);
    row2.add(text6);
    
    row2.add(label3);
    row2.add(text7);
    
    row2.add(label4);
    row2.add(text8);
    
    row2.add(label5);
    row2.add(text9);
    
    row2.add(label6);
    row2.add(text10);
    
    
    
    
    
    
    button1.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
           
           
          
       }
   
   });
    
    button2.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
           
           
          
       }
   
   });
    
    button3.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
           
           
          
       }
   
   });
    
    button4.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
           
           
          
       }
   
   });
    
    button5.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
           
           
          
       }
   
   });
    
    
    
    
   
    

    
    pane.add(row2);
    
    
    
          pack();
    
         
         
        
        
    }
    
    
    
}
