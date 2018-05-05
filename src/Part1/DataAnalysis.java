package Part1;

import HashStructure.HashTableGeneral;
import Object.Movie;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;


/**
 *
 * @author Ben
 */
public class DataAnalysis {
     public static void main(String[] args) 
    {
        HashTableGeneral<Movie> MovieHashTable = new HashTableGeneral();
        ArrayList < Movie > MovieList = new ArrayList();
        
        String csvFile = "C:\\Users\\Ben\\Documents\\NetBeansProjects\\CaMovieSystemBen&Chris\\src\\Part1\\samplemovies.csv";
        String line = "";
        //Main Hash table for overview of Movies from CSV
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
 
                    String[] lineArray = line.split(",");
                    MovieList.add(new Movie(lineArray[0], lineArray[1], lineArray[2], lineArray[3]));
                    for(int x = 0; x< MovieList.size(); x++)
                    {
                        MovieHashTable.put(MovieList.get(x));
                    }
                    
                    for(int x = 0; x< MovieList.size(); x++)
                    {
                        
                    }
            }
            System.out.println("--------Checking Find-------");
            for(int x = 0; x< MovieList.size(); x++)
               {
                   System.out.println("Index = " + MovieHashTable.get(MovieList.get(x)));
               }
            System.out.println("-------Most Common Genre------");
            
            int Common = 0;
            
             for(int x = 0; x< MovieList.size(); x++)
               {
                   if(Common != MovieHashTable.getCommonGenre(MovieList.get(x)))
                   {
                       Common = MovieHashTable.getCommonGenre(MovieList.get(x));
                   }
               }
              System.out.println("Common Genre = " + Common);
              
              
        } catch (IOException e) {
        }
    }
}


