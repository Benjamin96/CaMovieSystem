package HashStructure;


import java.util.LinkedList;
import Object.Movie;
import java.util.ArrayList;
/**
 *
 * @author Ben
 *
 * 
 */
public class HashTableGeneral{
 
    private int size;

    public final LinkedList<Movie>[] data;
    
    public final ArrayList<String> noRepeatsCommon = new ArrayList();
    
    public HashTableGeneral(){

        data = (LinkedList<Movie>[]) new LinkedList[11];
        
        size = 0;
    }
    
    public Movie put(Movie value){

        int hash = value.MyhashCode();

        int destinationIndex = hash;

        if(data[destinationIndex] == null){

            LinkedList<Movie> list = new LinkedList();

            list.add(value);

            data[destinationIndex] = list;
            System.out.println(" Movie stored in slot " + destinationIndex);
            
            size++;

            return null;
        }
        else{            

            data[destinationIndex].add(value);

            return null;
        }
    }
    
    public Movie get(Movie value){
        int hash = value.MyhashCode();;
        

        int destinationIndex = hash;
        
        if(data[destinationIndex] != null){
                    System.out.println(" Movie found in slot " + destinationIndex +  "\n");
                    return value;    
        }
        return null;
    }
    
    
    public String DisplayCommonContents(int index)
    {
        String Reponse = null;
        int destinationIndex = index;
        if(data[destinationIndex] != null){
          for(int x = 0; x< data[destinationIndex].size(); x++)
          {
            Reponse = Reponse + " Movies in Slot " + index + " = " + data[destinationIndex].get(x).toString() + "\n";
          }
            
        return Reponse;
        }
        return Reponse;
    }
    
    public void ScoreSort()
    {
        
    }
    
    
    
    public int size(){

        return size;
    }
}
