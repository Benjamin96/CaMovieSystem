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

    /**
     *
     */
    public final LinkedList<Movie>[] data;
    
    /**
     *
     */
    public final ArrayList<String> noRepeatsCommon = new ArrayList();
    
    /**
     *
     */
    public HashTableGeneral(){

        data = (LinkedList<Movie>[]) new LinkedList[11];
        
        size = 0;
    }
    
    /**
     *
     * @param value
     * @return
     */
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
    
    /**
     *
     * @param value
     * @return Movies
     */
    public Movie get(Movie value){
        int hash = value.MyhashCode();;
        

        int destinationIndex = hash;
        
        if(data[destinationIndex] != null){
                    System.out.println(" Movie found in slot " + destinationIndex +  "\n");
                    return value;    
        }
        return null;
    }
    

    
    /**
     *
     */
    public void ScoreSort()
    {
        
    }
    
    /**
     *
     * @return size
     */
    public int size(){

        return size;
    }
}
