package HashStructure;

import Object.Movie;
import java.util.LinkedList;

/**
 *
 * @author Ben
 */
public class HashTableGenre {
    
    private int size;

    public final LinkedList<Movie>[] datagenre;
    
    public final String[] indexGenre = new String[1000];;
    
    public HashTableGenre(){

        datagenre = (LinkedList<Movie>[]) new LinkedList[1000];
        for(int x =0; x < indexGenre.length; x++)
        {
            indexGenre[x] = "";
            
        }
        size = 0;
    }
    
    public Movie put(Movie value){

         int hash = value.MyhashCodeGenre(indexGenre);
        
         int destinationIndex = hash;

        if(datagenre[destinationIndex] == null){

            LinkedList<Movie> list = new LinkedList();

            list.add(value);

            datagenre[destinationIndex] = list;
            System.out.println(" Genres stored in slot " + destinationIndex);
            
            size++;

            return null;
        }
        else{            

            datagenre[destinationIndex].addLast(value);

            return null;
        }
    }
    
    public Movie get(Movie value){
        int hash = value.MyhashCodeGenre(indexGenre);
        

        int destinationIndex = hash;
        
        if(datagenre[destinationIndex] != null){
                    System.out.println(" Genre found in slot " + destinationIndex);
                    return value;    
        }
        return null;
    }
    
    public String DisplayCommonContents(int index)
    {
        String Reponse = null;
        int destinationIndex = index;
        if(datagenre[destinationIndex] != null){
          for(int x = 0; x< datagenre[destinationIndex].size(); x++)
          {
            Reponse = Reponse + " Movies in Slot " + index + " = " + datagenre[destinationIndex].get(x).toString() + "\n";
          }
            
        return Reponse;
        }
        return Reponse;
    }
    
    public int size(){

        return size;
    }
}

