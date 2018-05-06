package HashStructure;

import Object.Movie;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Ben
 */
public class HashTableGenre {
    
    private int size;

    public final LinkedList<Movie>[] datagenre;
    
    public final String[] indexGenre = new String[13];
    
    public final ArrayList<String> noRepeatsCommon = new ArrayList();
    
    public HashTableGenre(){

        datagenre = (LinkedList<Movie>[]) new LinkedList[41];
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
            System.out.println(" Genres stored in slot " + destinationIndex) ;
            
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
                    System.out.println(" Genre found in slot " + destinationIndex +  "\n");
                    return value;    
        }
        return null;
    }
    
        public Movie Displayget(Movie value){
        int hash = value.MyhashCodeGenre(indexGenre);
        

        int destinationIndex = hash;
        
        if(datagenre[destinationIndex] != null){
                    System.out.println(destinationIndex +  "\n");
                    return value;    
        }
        return null;
    }
    
    public void DisplayCommonContents(int index)
    {
        int destinationIndex = index;
        if(datagenre[destinationIndex] != null){
          for(int x = 0; x< datagenre[destinationIndex].size(); x++)
          {
            if(!(noRepeatsCommon.contains(datagenre[destinationIndex].get(x).toString())))
            {
                noRepeatsCommon.add(datagenre[destinationIndex].get(x).toString());
                System.out.println(datagenre[destinationIndex].get(x).toString() + "\n");
            }
          }
            
   
        }

    }
    
    public String GenreAverage(String Genre)
    {
        String Response = null;
        double Count = 0;
        double Total = 0;
        double Average =0;
        
        for(int x = 0; x< indexGenre.length; x++)
        {
            for(int y = 0; y < datagenre[x].size(); y++)
            {
               if(datagenre[x].get(y).getGenre().equals(Genre))
               {
               Total = Total + Double.parseDouble(datagenre[x].get(y).getRating());
               Count++;
               }
            }
        }
        Average = Total/Count;
        
        Response = "Genre = " + Genre + " Average Score = " + Average;
        return Response;
    }
    
    public int size(){

        return size;
    }
}

