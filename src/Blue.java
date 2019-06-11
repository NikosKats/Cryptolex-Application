//Christos Topalidis icsd14203
//Nikolaos Katsilidis icsd14081

import java.text.Collator;
import java.util.Locale;


public class Blue extends Letter{
    
      char character;
      int point;
     
      public Blue()
        {
            
        }
    
     public Blue(char character)
        {
              this.character = character;
              //elegxos gia thn eisagwgh twn pontwn se ka8e gramma
                 if(character=='Α' || character=='Ε' || character=='Η' || character=='Ι' || character=='Ν' || character=='Ο' || character=='Σ' || character=='Τ')
                {
                    point = 1; 
                }
                else if(character=='Κ' || character=='Π' || character=='Ρ' || character=='Υ')
                {
                    point = 2; 
                }
                else if(character=='Λ' || character=='Μ' || character=='Ω')
                {
                   point = 3;  
                }
                else if(character=='Γ' || character=='Δ')
                {
                    point = 4; 
                }
                else if(character=='Β' || character=='Ζ' || character=='Θ' || character=='Φ')
                {
                    point = 8; 
                }
                else if(character=='Ξ' || character=='Χ' || character=='Ψ')
                {
                    point = 10;
                }
        }
    
    @Override
    void set_character(char character) {
         this.character=character;

         
    }

    @Override
    char get_character() {
        return character;
    }

    
    

   

    @Override
    int get_point() {
        return point;
        
                }

    @Override
    void set_point(int point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
