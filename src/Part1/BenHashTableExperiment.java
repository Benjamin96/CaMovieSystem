
package Part1;

import HashStructure.HashTableGeneral;
import java.util.Hashtable;
import Object.Movie;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;


/**
 *
 * @author Ben
 */
public class BenHashTableExperiment{
    
     public static void main(String[] args) 
    {
        Hashtable<String, Movie> MoviesHashTable = new Hashtable();
        ArrayList < Movie > MovieList = new ArrayList();

        Enumeration names;
        String key;
        
        String csvFile = "C:\\Users\\Ben\\Desktop\\Duo Ca\\MovieSystem\\samplemovies.csv";
        String line = "";
        //Main Hash table for overview of Movies from CSV
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                    String[] lineArray = line.split(",");
                    MovieList.add(new Movie(lineArray[0], lineArray[1], lineArray[2], lineArray[3]));
                    for(int x = 0; x< MovieList.size(); x++)
                    {
                        MoviesHashTable.put(MovieList.get(x).getTitle(), MovieList.get(x));
                    }
            }
            names = MoviesHashTable.keys();
            while(names.hasMoreElements()) 
            {
                key = (String) names.nextElement();
                System.out.println("Key = " + key + " Values = " + MoviesHashTable.get(key));
            }
            
        
            

        } catch (IOException e) {
        }
         
    }
     
}
