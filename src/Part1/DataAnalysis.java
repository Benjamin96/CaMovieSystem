package Part1;

import HashStructure.*;
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
        HashTableGeneral MovieHashTable = new HashTableGeneral();
        HashTableGenre GenresHashTable = new HashTableGenre();
        ArrayList < Movie > MovieList = new ArrayList();
        
        String csvFile = "C:\\Users\\Ben\\Documents\\NetBeansProjects\\CaMovieSystemBen&Chris\\samplemovies.csv";
        String line = "";
        //Main Hash table for overview of Movies from CSV
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
 
                    String[] lineArray = line.split(",");
                    MovieList.add(new Movie(lineArray[0], lineArray[1], lineArray[2], lineArray[3]));
                    for(int x = 0; x< MovieList.size(); x++)
                    {
                        MovieHashTable.put(MovieList.get(x));
                        GenresHashTable.put(MovieList.get(x));
                    }

            }
            System.out.println("--------Checking Find-------");
            for(int x = 0; x< MovieList.size(); x++)
               {
                   System.out.println("= " + MovieHashTable.get(MovieList.get(x)));
               }
            System.out.println("-------Most Common Genre------");
            
            int Biggest = 0;
            int BiggestSlot = 0;
            
             for(int x = 0; x< GenresHashTable.size(); x++)
               {
                if(Biggest < GenresHashTable.datagenre[x].size())
                {
                    Biggest = GenresHashTable.datagenre[x].size();
                    BiggestSlot = x;
                }  
               }
              System.out.println("Most Common Genre = " + GenresHashTable.indexGenre[BiggestSlot]);
              //System.out.println(GenresHashTable.DisplayCommonContents(Common));
              
              
        } catch (IOException e) {
        }
    }
}


