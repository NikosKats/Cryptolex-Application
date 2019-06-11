//Christos Topalidis icsd14203
//Nikolaos Katsilidis icsd14081

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;




public class Dictionary {
    
    Map<Integer,String> dictionary = new HashMap<>();

    //Xrhsimopoioume ton kwdika tou bibliou sxetika me thn anagnwsh arxeiwn sth selida 655-656    
    //**************************************************************************
    
    private static Scanner input;
    
    String word = new String();
    
    int i=0;
    
    Regular regular = new Regular();

    int []hCodes = new int[5000];
            
    //Sunarthsh gia to anoigma tou arxeiou
    public void openFile()
      {
        try
        {
            input = new Scanner(Paths.get("Dictionary.txt"));
        }
        catch(IOException ioException)
        {
            System.out.println("Error opening file. Terminating.");
            System.exit(1);
        }

       }

    //Sunarthsh gia to diabasma tou arxeiou
    public void readFile()
    {
        try
        {
            while(input.hasNext())
            {
                word = input.next(); //diabasma le3hs arxeiou
                
                dictionary.put(dictionary.hashCode(),word); //Eisagwgh ths le3hs apo to arxeio se map
                
               
                
                hCodes[i]=dictionary.hashCode(); //Eisagwgh twn hashcode se pinaka 
                
                i++;
            }
        }
        catch(NoSuchElementException elementException)
        {
            System.err.println("File improperly formed. Terminating.");
        }
        catch(IllegalStateException stateException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
    }

    //Sunarthsh gia kleisimo arxeiou
    public void closeFile()
        {
            if(input!=null)
                input.close();
        }

    //**************************************************************************
    
    //Sunarthsh gia ektupwsh tou map
    public void printMap()
    {
        for(Map.Entry<Integer,String> entry: dictionary.entrySet())
        {
            int key = entry.getKey();
            String value = entry.getValue();
            
            System.out.println("KEY: "+ key + " VALUE: " + value);
        }
    }
     
    //sunarthsh pou ftiaxnei string me panw apo 100 grammata
     StringBuilder getString()
     {
         StringBuilder str = new StringBuilder();
        StringBuilder prevStr = new StringBuilder();
        String str1;
        
         do
        {
            
            
            int randomHC = (int) (Math.random()*4400);
            str1 = dictionary.get(hCodes[randomHC]);
            
            str = prevStr.append(str1);
            prevStr = str;
            
            
        }while(str.length()<100);

        
        return str;
     }
     
     
   //Sunarthsh gia ton upologismo twn pontwn
   public int word_points(String word)
    {
      
        int size;
        int total_points=0;
        size = word.length();
        
        int pointArray[] = new int[size];
        
        
        //Domh epanalhpshs gia na broume th le3h apo th domh
        
        for(Map.Entry<Integer,String> entry: dictionary.entrySet())
        {
            String value = entry.getValue();
  
            //Elegxos gia to an brhke thn le3h
            if(word.equals(value))
            {
              
                //Domh epanalhpshs gia ola ta grammata ths le3hs pou edwse o xrhsths kai elegxos gia thn eisagwgh twn pontwn se ka8e gramma
                for(int i=0;i<word.length();i++)
                    {
                             
                             
                     if(word.charAt(i)=='Α' || word.charAt(i)=='Ε' || word.charAt(i)=='Η' || word.charAt(i)=='Ι' || word.charAt(i)=='Ν' || word.charAt(i)=='Ο' || word.charAt(i)=='Σ' || word.charAt(i)=='Τ')
                            {
                                regular.set_point(1);
                                pointArray[i] = regular.get_point(); 
                                     
                            }
                            else if(word.charAt(i)=='Κ' || word.charAt(i)=='Π' || word.charAt(i)=='Ρ' || word.charAt(i)=='Υ')
                            {
                                regular.set_point(2);
                                pointArray[i] = regular.get_point(); 
                            }
                            else if(word.charAt(i)=='Λ' || word.charAt(i)=='Μ' || word.charAt(i)=='Ω')
                            {
                                regular.set_point(3);
                                pointArray[i] = regular.get_point(); 
                            }
                            else if(word.charAt(i)=='Γ' || word.charAt(i)=='Δ')
                            {
                                regular.set_point(4);
                                pointArray[i] = regular.get_point();
                            }
                            else if(word.charAt(i)=='Β' || word.charAt(i)=='Ζ' || word.charAt(i)=='Θ' || word.charAt(i)=='Φ')
                            {
                                regular.set_point(8);
                                pointArray[i] = regular.get_point(); 
                            }
                            else if(word.charAt(i)=='Ξ' || word.charAt(i)=='Χ' || word.charAt(i)=='Ψ')
                            {
                                regular.set_point(10);
                                pointArray[i] = regular.get_point();
                            }
                        
                        
                    total_points+=pointArray[i]; //Eisagwgh se matablhth to plh8os twn pontwn

                    }
                
                System.out.println("Σωστά! Η λέξη που βρήκες σου έδωσε "+total_points+" πόντους.");
                
              
                
            }
            
            
            
        }
        
                return total_points; //Epistrofh twn pontwn

    }
}

