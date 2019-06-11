
//Christos Topalidis icsd14203
//Nikolaos Katsilidis icsd14081



import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Frame5 extends JFrame {
    
    
    
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
    
    
    private JButton[] buttons= new JButton[25];
    
    private int[] positions = new int[50];
    
    private char[] word = new char[50];
    
    Blue blue = new Blue();
    Red red = new Red();
    Wildcard wildcard = new Wildcard();
    Regular regular = new Regular();
    
    int sum=0;
    
    
    int x1=-1, y1=-1;
    int prev = -1;
    int count=1;
    
    int a,b;
    
    int clicks = 0;
    
    
    
    
    public Frame5(){
     
        
        super("Κρυπτόλεξο");
        
     //Dhmiourgia antikeimenwn
   Dictionary dictionary = new Dictionary(); 
   
   
   //Dhmiourgia pinaka antikeimenwn
   Letter array[][] = new Letter[5][5];
   Letter array2[][] = new Letter[8][8];
   Letter array3[][] = new Letter[10][10];
  
       
    //Kalesma sunartshs apo thn Dictionary gia anoigma arxeiou
    dictionary.openFile();
    //Kalesma sunartshs apo thn Dictionary gia diabasma arxeiou
    dictionary.readFile();
    
   
  
        StringBuilder str = dictionary.getString();
            
           
        int i1,j1;
        int counter=0;
        
        //Arxikopoihsh pinaka antikeimenwn me ta katallhla antikeimena
        for(i1=0;i1<5;i1++)
        {
            for(j1=0;j1<5;j1++){
        
             
                
                if(counter<=3){
                    array[i1][j1] =new Regular(str.charAt(counter));
                    
                }
                    if(counter==4)
                {
                    array[i1][j1] =new Red(str.charAt(counter)); 
                }
                    if(counter>=5 && counter<=11){
                    array[i1][j1] =new Regular(str.charAt(counter));
                    
                }
                    
                      if(counter==12)
                {
                    array[i1][j1] =new Red(str.charAt(counter)); 
                }
                if(counter>=13 && counter<=15){
                    array[i1][j1] =new Regular(str.charAt(counter));
                    
                }
                
                if(counter==16)
                {
                 array[i1][j1] =new Blue(str.charAt(counter));
                }
                
                if(counter>=17 && counter<=19){
                    array[i1][j1] =new Regular(str.charAt(counter));
                    
                }
                
                if(counter==20)
                {
                    array[i1][j1] =new Wildcard(str.charAt(counter));
                }
                if(counter>=21 && counter<=24)
                {
                    array[i1][j1] =new Regular(str.charAt(counter));
                }
                
                
                
               
                
                counter++;
            }
        }
        
        
        
        //Ektupwsh pinaka antikeimenwn
        for(i1=0;i1<5;i1++)
        {
            for(j1=0;j1<5;j1++){
        
                System.out.print(array[i1][j1].get_character());
                
                System.out.print(array[i1][j1].get_point());

            }
            System.out.println();
        }
        
        
           System.out.println();
            
           
                
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
    
    
    /*************************************************************************************************************
     * ************************************************************************************************************
     * **************************************************************************************************************
     */
        
        
    
    
    row1 = new JPanel();
    row2 = new JPanel();
    
    
    
    
    
    
    setSize(800,650);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setVisible(true);
    
    Container pane = getContentPane();
    GridLayout glayout = new GridLayout(1,2);
    pane.setLayout(glayout);
     
    
    
    
      // Tamplo 5x5
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
 
    
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
     

    
   GridLayout glayout1 = new GridLayout(6,1);
   row1.setLayout(glayout1);
   
   int x = 0;
   int y = 0;
   
   
   
   for(int i=0;i<25;i++){
       
      
       
      if(x%5==0 && x!=0)
      {
          x=0;
          y++;
      }
      
      
      
      
       
       if(array[y][x].get_character()=='Α')
       {
            buttons[i] = new JButton("Α 1");
            
            
           
            if(array[y][x].getClass().isInstance(b))
            {
                buttons[i].setBackground(Color.RED);
                
            }
            
            
            
            
            buttons[i].setBackground(Color.GRAY);
            
            
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]); 
       }
       if(array[y][x].get_character()=='Β')
       {
           
           System.out.println(array[y][x].getClass());
           
            buttons[i] = new JButton("Β 8");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       
       if(array[y][x].get_character()=='Γ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Γ 4");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Δ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Δ 4");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
           
       }
       if(array[y][x].get_character()=='Ε'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Ε 1");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Ζ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Ζ 8");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Η'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Η 1");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Θ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Θ 8");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Ι'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Ι 1");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Κ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Κ 2");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Λ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Λ 3");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Μ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Μ 3");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Ν'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Ν 1");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Ξ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Ξ 10");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Ο'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Γ 4");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Π'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Π 2");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Ρ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Ρ 2");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Σ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Σ 1");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Τ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Τ 1");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Υ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Υ 2");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Φ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Φ 8");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Χ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Χ 10");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Ψ'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Ψ 10");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       if(array[y][x].get_character()=='Ω'){
           
           System.out.println(array[y][x].getClass());
           
           buttons[i] = new JButton("Ω 3");
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            row1.add(buttons[i]);
       }
       
    
      x++;
   }
   
    
   
   for(int i=0;i<25;i++){
       
       buttons[i].addMouseListener(
  
  new MouseListener()
  {
  
  @Override
  public void mouseClicked(MouseEvent e) {
  
    
    
    
    
    for(int i=0;i<25;i++)
    {
        
        
                if(e.getSource() == buttons[i])
                {
                   
                    a = i/5;
                    b = i%5;
                       
                   
                    
                    if(prev == -1 )
                    {
                        clicks++;
                        x1 = i/5;
                        y1 = i%5;
                        prev = 0;
                        positions[count -1] = x1;
                        positions[count] = y1;
                        count +=2;
                        sum++;
                        
                        
                        buttons[i].setBackground(Color.YELLOW);
                        
                        
                       System.out.println(array[x1][y1].get_character());
                       System.out.println(array[x1][y1].get_point());
                        
                       word[sum] = array[x1][y1].get_character();
                       
                       
                        
                        

                    }
                    
                    else if(Math.abs(positions[count-3] - a) <=1 && Math.abs(positions[count-2] - b)<=1)
                    {
                        clicks++;
                        x1 = i/5;
                        y1 = i%5;
                        
                        positions[count -1] = x1;
                        positions[count] = y1;
                        
                        count +=2;
                        sum++;
                        
                        
                        buttons[i].setBackground(Color.YELLOW);
                        
                        word[sum] = array[x1][y1].get_character();
                        
                        System.out.println(array[x1][y1].get_character());
                        System.out.println(array[x1][y1].get_point());
                        
                    }
                    
                    
                    
                 
                 
                 
                        
                         
                 
                    
                }

                
            if (SwingUtilities.isRightMouseButton(e))
            {

                if(e.getSource() == buttons[i])
                {
                    
                    clicks--;
                    if(clicks>0)
                    {
                    count-=4;
                    
                    word[sum] = ' ';
                    
                    sum-=1;
                    
                    
                    }
                    
                    if(count==1)
                    {
                        prev=-1;
                    }
                    
                    buttons[i].setBackground(Color.GRAY);
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

   
   button = new JButton("OK");
   
   
   button.setForeground(Color.BLACK);
   button.setBackground(Color.GREEN);
   button.setOpaque(true);
   button.setBorderPainted(false);
   
  
   
   button.addMouseListener(
                
            new MouseListener()
                {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                    
                        String w = new String(word);
                        
                        text9.setText(w);
                        
                        if(dictionary.word_points(w)==0)
                        {
                            text7.setText("0");
                            text8.setText("0");
                            text10.setText("Δεν βρέθηκε η λέξη στο λεξικό");
                            
                        }
                        else{
                            
                            Double.parseDouble(text7.getText());
                            Double.parseDouble(text8.getText());
                            
                            //text7.setText("0");
                            //text8.setText("0");
                            
                            text10.setText(w);
                            
                            text8.setText(w);
                            
                            
                        }
                        
                        if (SwingUtilities.isRightMouseButton(e))
                        {
                            
                            text7.setText("");
                            text8.setText("");
                            text9.setText("");
                            text10.setText("");
                            
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
           
           
           
          text10.setText("Εμφάνισε τη λέξη που βρήκε ο χρήστης");
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
    label5 = new Label("Η λέξη που βρήκες είναι:");           //text9
    label6 = new Label("Συγχαρητήρια βρήκες τη λέξη:");       //text10
    
    label7 = new Label(" ");
    label8 = new Label(" ");
    
    
    text1 = new JTextField();
    text2 = new JTextField();
    text3 = new JTextField();
    text4 = new JTextField();
    text5 = new JTextField();
    text6 = new JTextField("200 πόντοι");
    text7 = new JTextField();
    text8 = new JTextField();
    text9 = new JTextField();
    text10 = new JTextField();
    
    //Boh8eies  
    row2.add(label1);
    //Eisagwgh
    row2.add(label);
    
    //Diagrafh grammhs
    row2.add(button1);
    //Diplano textfield
    row2.add(text1);
    
    //Anadiata3h grammhs
    row2.add(button2);
    //Diplano textfield
    row2.add(text2);
    
    //Anadiata3h sthlhs
    row2.add(button3);
    //Diplano textfield
    row2.add(text3);
    
    //Anadiata3h tamplo
    row2.add(button4);
    //Diplano textfield
    row2.add(label7);
    
    //Enallagh grammatwn
    row2.add(button5);
    //Diplano textfield
    row2.add(label8);
    

    //Stoxos
    row2.add(label2);
    //Diplano textfield
    row2.add(text6);
    
    //Sunolikh ba8mologia
    row2.add(label3);
    //Diplano textfield
    row2.add(text7);
    
    //Ba8mologia le3hs
    row2.add(label4);
    //Diplano textfield
    row2.add(text8);
    
    //Le3eis pou bre8hkan
    row2.add(label5);
    //Diplano textfield
    row2.add(text9);
    
    //Sugxarhthria brhkes th le3h
    row2.add(label6);
    //Diplano textfield
    row2.add(text10);
    
    
    
    
    
    
    button1.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
          double input = Double.parseDouble(text1.getText());
           
          
          
       }
   
   });
    
    button2.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
           double input = Double.parseDouble(text1.getText());
           
          
       }
   
   });
    
    button3.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
           double input = Double.parseDouble(text1.getText());
           
           String in = text1.getText();
           
           text10.setText(in+"hello");
           
       }
   
   });
    
    button4.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           
           StringBuilder str1 = dictionary.getString();
                    
                   int counter=0;

                    for(int i1=0;i1<5;i1++)
                    {
                        for(int j1=0;j1<5;j1++){



                            if(counter<=3){
                    array[i1][j1] =new Regular(str1.charAt(counter));
                    
                }
                    if(counter==4)
                {
                    array[i1][j1] =new Red(str1.charAt(counter)); 
                }
                    if(counter>=5 && counter<=11){
                    array[i1][j1] =new Regular(str1.charAt(counter));
                    
                }
                    
                      if(counter==12)
                {
                    array[i1][j1] =new Red(str1.charAt(counter)); 
                }
                if(counter>=13 && counter<=15){
                    array[i1][j1] =new Regular(str1.charAt(counter));
                    
                }
                
                if(counter==16)
                {
                 array[i1][j1] =new Blue(str1.charAt(counter));
                }
                
                if(counter>=17 && counter<=19){
                    array[i1][j1] =new Regular(str1.charAt(counter));
                    
                }
                
                if(counter==20)
                {
                    array[i1][j1] =new Wildcard(str1.charAt(counter));
                }
                if(counter>=21 && counter<=24)
                {
                    array[i1][j1] =new Regular(str1.charAt(counter));
                }

                            counter++;
                        }
                    }
                    
                                  for(int i1=0;i1<5;i1++)
                                        {
                                            for(int j1=0;j1<5;j1++){

                                                System.out.print(array[i1][j1].get_character());

                                                System.out.print(array[i1][j1].get_point());

                                            }
                                            System.out.println();
                                         }
                                  
                                  
                                  
           
          
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
    

    

