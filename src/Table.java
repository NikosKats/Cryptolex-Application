//Christos Topalidis icsd14203
//Nikolaos Katsilidis icsd14081

import java.util.Scanner;


public class Table {
    
    //Dhmiourgia antikeimenwn
   Dictionary dictionary = new Dictionary(); 
   
  
   
   Regular regular = new Regular();
   Red red = new Red();
   Blue blue = new Blue();
   Wildcard wildcard = new Wildcard();
   
   Regular tmpRegular = new Regular();
   Red tmpRed = new Red();
   
   
   Player player = new Player();
   
   Scanner scanner = new Scanner(System.in);
   int choice;
   
   
   //Dhmiourgia pinaka antikeimenwn
   Letter array[][] = new Letter[5][5];
   Letter array2[][] = new Letter[8][8];
   Letter array3[][] = new Letter[10][10];
   
   //Sunarthsh startTable
    void startTable()
    {
        
        
        
        
       int j=0;
       String name;
       
    //Kalesma sunartshs apo thn Dictionary gia anoigma arxeiou
    dictionary.openFile();
    //Kalesma sunartshs apo thn Dictionary gia diabasma arxeiou
    dictionary.readFile();
    
    
    
    
    //Eisagwgiko menou
    
    System.out.println("ΚΑΛΩΣΗΡΘΕΣ ΣΤΟ ΗΛΕΚΤΡΟΝΙΚΟ ΚΡΥΠΤΟΛΕΞΟ.");
    System.out.println();
    
    System.out.println("Δώσε το όνομα σου.");
    name = scanner.next();
    
    player.set_name(name);
    
    System.out.println();
    
    System.out.println(player.get_name()+ " διάλλεξε έναν από τους παρακάτω τρόπους παιχνιδιού.");
    System.out.println();
    System.out.println("1.Παιχνίδι σε ταμπλό 5χ5");
    System.out.println("2.Παιχνίδι σε ταμπλό 8χ8");
    System.out.println("3.Παιχνίδι σε ταμπλό 10χ10");
    System.out.println("4.Έξοδος");
    
    choice = scanner.nextInt();
    int sum=0;
    
    
    //Domh elegxou gia thn epilogh tou xrhsth apo to menou
    switch(choice)
    {
        //Dhmiourgia pinaka 5x5
        case 1:
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
            
             System.out.println("1.Αλλαγή ταμπλό.");
             System.out.println("2.Βρήκα λέξη.");
             System.out.println("3.Αναδιάταξη.");
             System.out.println("4.Έξοδος.");
             
             choice = scanner.nextInt();
             
            while(choice!=4)
            {
                //Elegxos gia thn epilogh tou xrhsth kai antistoixes leitourgies
                if(choice==1)
                {
                    StringBuilder str1 = dictionary.getString();
                    
                   counter=0;

                    for(i1=0;i1<5;i1++)
                    {
                        for(j1=0;j1<5;j1++){



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
                    
                                  for(i1=0;i1<5;i1++)
                                        {
                                            for(j1=0;j1<5;j1++){

                                                System.out.print(array[i1][j1].get_character());

                                                System.out.print(array[i1][j1].get_point());

                                            }
                                            System.out.println();
                                         }
                    
                    System.out.println("1.Αλλαγή ταμπλό.");
                    System.out.println("2.Βρήκα λέξη.");
                    System.out.println("3.Αναδιάταξη.");
                    System.out.println("4.Έξοδος.");
                    choice = scanner.nextInt();
                }
                //Elegxos gia thn epilogh tou xrhsth kai antistoixes leitourgies
                if(choice==2)
                {
                    System.out.println("Δώσε τη λέξη που βρήκες.");
                    String word = scanner.next();       
                    sum += dictionary.word_points(word); //Upologismos pontwn ths ka8e le3hs kai eisagwgh tous sth metablhth sum pou periexei to sunolo tous
                    
                    player.set_total_points(sum); //Kanoume set tous sunolikous pontous ston player
                    
                    //Ektupwsh
                    System.out.println("Οι συνολικοί σου πόντοι είναι: "+sum);
                    
                    System.out.println("Θέλεις να συνεχίσεις?(ΝΑΙ = 1 Ή ΟΧΙ = 4)");
                    choice = scanner.nextInt();
                    
                }
                //Elegxos gia epilogh 3 kai anadiata3h pinaka
                if(choice==3)
                {
                    tmpRegular = (Regular) array[0][0];
                    array[0][0] = array[2][0];
                    array[2][0] = tmpRegular;
                    
                    tmpRegular = (Regular) array[1][4];
                    array[1][4] = array[2][3];
                    array[2][3] = tmpRegular;
                    
                    tmpRegular = (Regular) array[1][0];
                    array[1][0] = array[2][3];
                    array[2][3] = tmpRegular;
                    
                    tmpRegular = (Regular) array[3][2];
                    array[3][2] = array[2][4];
                    array[2][4] = tmpRegular;
                    
                    for(i1=0;i1<5;i1++)
                      {
                        for(j1=0;j1<5;j1++){

                            System.out.print(array[i1][j1].get_character());

                           System.out.print(array[i1][j1].get_point());

                       }
                          System.out.println();
                      }
                    System.out.println("1.Αλλαγή ταμπλό.");
             System.out.println("2.Βρήκα λέξη.");
             System.out.println("3.Αναδιάταξη.");
             System.out.println("4.Έξοδος.");
             
             choice = scanner.nextInt();
                }
                
            }
            
            
            break;
            
            //Dhmiourgia pinaka 8x8
        case 2:
            
            StringBuilder str2 = dictionary.getString();
           
            int i2,j2;
        int counter2=0;
        
        //Arxikopoihsh pinaka 8x8 me katallhla antikeimena
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
        
             
            System.out.println("1.Αλλαγή ταμπλό.");
             System.out.println("2.Βρήκα λέξη.");
             System.out.println("3.Αναδιάταξη.");
             System.out.println("4.Έξοδος.");
             choice = scanner.nextInt();
             
            while(choice!=4)
            {
                //elegxos gia epilogh 1 kai allagh tamplo
                if(choice==1)
                {
                   
                    StringBuilder str3 = dictionary.getString();
                    counter2=0;
            
        
        for(i2=0;i2<8;i2++)
        {
            for(j2=0;j2<8;j2++){
        
             
                
                if(counter2<61){
                    array2[i2][j2] =new Regular(str3.charAt(counter2));
                }
                
                if(counter2>60 && counter2<63)
                {
                    array2[i2][j2] =new Red(str3.charAt(counter2)); 
                }
                
                
                if(counter2==63)
                {
                 array2[i2][j2] =new Blue(str3.charAt(counter2));
                }
                
                
                if(counter2==64)
                {
                    array2[i2][j2] =new Wildcard(str3.charAt(counter2));
                }
               
                
                counter2++;
            }
        }
            
        
        
        for(i2=0;i2<8;i2++)
        {
            for(j2=0;j2<8;j2++){
        
                System.out.print(array2[i2][j2].get_character());
                
                System.out.print(array2[i2][j2].get_point());

            }
            System.out.println();
        }
                    
                    System.out.println("1.Αλλαγή ταμπλό.");
                    System.out.println("2.Βρήκα λέξη.");
                    System.out.println("3.Αναδιάταξη.");
                    System.out.println("4.Έξοδος.");
                    choice = scanner.nextInt();
                }
                //elegxos gia epilogh 2 eisagwgh le3hs apo to xrhsth
                if(choice==2)
                {
                    System.out.println("Δώσε τη λέξη που βρήκες.");
                    String word = scanner.next();  
                    
                    
                    
                    sum += dictionary.word_points(word);
                    
                    player.set_total_points(sum);
                    
                    System.out.println("Οι συνολικοί σου πόντοι είναι: "+sum);
                    
                    System.out.println("Θέλεις να συνεχίσεις?(ΝΑΙ = 1 Ή ΟΧΙ = 4)");
                    choice = scanner.nextInt();
                    
                }
                //Epilogh 3 anadiata3h
                if(choice==3)
                {
                    tmpRegular = (Regular) array2[0][0];
                    array2[0][0] = array2[2][0];
                    array2[2][0] = tmpRegular;
                    
                    tmpRegular = (Regular) array2[1][4];
                    array2[1][4] = array2[2][3];
                    array2[2][3] = tmpRegular;
                    
                    tmpRegular = (Regular) array2[1][0];
                    array2[1][0] = array2[2][3];
                    array2[2][3] = tmpRegular;
                    
                    tmpRegular = (Regular) array2[3][2];
                    array2[3][2] = array2[2][4];
                    array2[2][4] = tmpRegular;
                    
                    for(i1=0;i1<8;i1++)
                      {
                        for(j1=0;j1<8;j1++){

                            System.out.print(array2[i1][j1].get_character());

                           System.out.print(array2[i1][j1].get_point());

                       }
                          System.out.println();
                      }
                    System.out.println("1.Αλλαγή ταμπλό.");
             System.out.println("2.Βρήκα λέξη.");
             System.out.println("3.Αναδιάταξη.");
             System.out.println("4.Έξοδος.");
             
             choice = scanner.nextInt();
                }
                
            };
            
            break;
        //Dhmiourgia pinaka 10x10 
        case 3:
            
            StringBuilder str4 = dictionary.getString();
           
            int i3,j3;
            int counter3=0;
        
            //Arxikopoihsh pinaka 10x10
        for(i3=0;i3<10;i3++)
        {
            for(j3=0;j3<10;j3++){
        
             
                
                if(counter3<97){
                    array3[i3][j3] =new Regular(str4.charAt(counter3));
                }
                
                if(counter3>95 && counter3<98)
                {
                    array3[i3][j3] =new Red(str4.charAt(counter3)); 
                }
                
                
                if(counter3==98)
                {
                 array3[i3][j3] =new Blue(str4.charAt(counter3));
                }
                
                
                if(counter3==99)
                {
                    array3[i3][j3] =new Wildcard(str4.charAt(counter3));
                }
               
                
                counter3++;
            }
        }
            
        
        //Ektupwsh 10x10
        for(i3=0;i3<10;i3++)
        {
            for(j3=0;j3<10;j3++){
        
                System.out.print(array3[i3][j3].get_character());
                
                System.out.print(array3[i3][j3].get_point());

            }
            System.out.println();
        }
        
            
             
             System.out.println("1.Αλλαγή ταμπλό.");
             System.out.println("2.Βρήκα λέξη.");
             System.out.println("3.Αναδιάταξη.");
             System.out.println("4.Έξοδος.");
             choice = scanner.nextInt();
             
            while(choice!=4)
            {
                //Epilogh 1 gia allagh tamplo
                if(choice==1)
                {
                    StringBuilder str5 = dictionary.getString();
           
            
            counter3=0;
        
        for(i3=0;i3<10;i3++)
        {
            for(j3=0;j3<10;j3++){
        
             
                
                if(counter3<97){
                    array3[i3][j3] =new Regular(str5.charAt(counter3));
                }
                
                if(counter3>95 && counter3<98)
                {
                    array3[i3][j3] =new Red(str5.charAt(counter3)); 
                }
                
                
                if(counter3==98)
                {
                 array3[i3][j3] =new Blue(str5.charAt(counter3));
                }
                
                
                if(counter3==99)
                {
                    array3[i3][j3] =new Wildcard(str5.charAt(counter3));
                }
               
                
                counter3++;
            }
        }
            
        
        
        for(i3=0;i3<10;i3++)
        {
            for(j3=0;j3<10;j3++){
        
                System.out.print(array3[i3][j3].get_character());
                
                System.out.print(array3[i3][j3].get_point());

            }
            System.out.println();
        }
        
                    
                    System.out.println("1.Αλλαγή ταμπλό.");
                    System.out.println("2.Βρήκα λέξη.");
                    System.out.println("3.Αναδιάταξη.");
                    System.out.println("4.Έξοδος.");
                    choice = scanner.nextInt();
                }
                //Epilogh 2 kai katametrhsh pontwn 
                if(choice==2)
                {
                    System.out.println("Δώσε τη λέξη που βρήκες.");
                    String word = scanner.next();       
                    sum += dictionary.word_points(word);
                    
                    player.set_total_points(sum);
                    
                    System.out.println("Οι συνολικοί σου πόντοι είναι: "+sum);
                    
                    System.out.println("Θέλεις να συνεχίσεις?(ΝΑΙ = 1 Ή ΟΧΙ = 4)");
                    choice = scanner.nextInt();
                    
                }
                //Epilogh 3 anadiata3h
                if(choice==3)
                {
                    tmpRegular = (Regular) array3[0][0];
                    array3[0][0] = array3[2][0];
                    array3[2][0] = tmpRegular;
                    
                    tmpRegular = (Regular) array3[1][4];
                    array3[1][4] = array3[2][3];
                    array3[2][3] = tmpRegular;
                    
                    tmpRegular = (Regular) array3[1][0];
                    array3[1][0] = array3[2][3];
                    array3[2][3] = tmpRegular;
                    
                    tmpRegular = (Regular) array3[3][2];
                    array3[3][2] = array3[2][4];
                    array3[2][4] = tmpRegular;
                    
                    for(i1=0;i1<10;i1++)
                      {
                        for(j1=0;j1<10;j1++){

                            System.out.print(array3[i1][j1].get_character());

                           System.out.print(array3[i1][j1].get_point());

                       }
                          System.out.println();
                      }
                    System.out.println("1.Αλλαγή ταμπλό.");
             System.out.println("2.Βρήκα λέξη.");
             System.out.println("3.Αναδιάταξη.");
             System.out.println("4.Έξοδος.");
             
             choice = scanner.nextInt();
                }
                
            };
            
            break;
            
            //E3odos
        case 4:
            
            break;
            //Default epilogh se tuxon la8os tou xrhsth
        default:
            System.out.println("Η επιλογή που δώσατε δεν υπάρχει.");
            break;
    }
    
    
    //Kleisimo arxeiou
         dictionary.closeFile();
       
        
    }
    
}
