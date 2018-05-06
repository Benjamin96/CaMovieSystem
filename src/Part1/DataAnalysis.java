package Part1;

import HashStructure.*;
import Object.Movie;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Ben
 */
public class DataAnalysis {
     public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        
        HashTableGeneral MovieHashTable = new HashTableGeneral();
        HashTableGenre GenresHashTable = new HashTableGenre();
        HashTableRating RateHashTable = new HashTableRating();
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
                        RateHashTable.put(MovieList.get(x));
                    }

            }
            Boolean check = false;
            while(check.equals(false)){
            System.out.println("1) Check all" + "\n" +
                    "2) Most Common genre" + "\n"
                    + "3) Average score for each genre" + "\n"
                    + "4)  All movies in a particular genre (in order of their score)" + "\n"
                    +"5)  The movies within each score grouping (0-3, 4-5, 6-8, 9-10)" + "\n"
                    +"6) Recommendation " + "\n" 
                    +"7) End Program") ;
            
            System.out.println("Please enter a number");
            String Choice = sc.nextLine();
            
             switch(Choice) {
                 
             case "1":
                 
             System.out.println("\n");
            System.out.println("--------Checking Get-------");
            for(int x = 0; x< MovieList.size(); x++)
               {
                   System.out.println("= " + MovieHashTable.get(MovieList.get(x)) + "\n");
               }
            break;
             case "2":
            System.out.println("\n");
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
              System.out.println("\n");
              GenresHashTable.DisplayCommonContents(BiggestSlot);
             break;
             
             case "3":
             System.out.println("\n");
             System.out.println("-------Average score's------");
             
             for(int x = 0; x < GenresHashTable.indexGenre.length; x++)
             {
             String Genre = GenresHashTable.indexGenre[x];
             
             System.out.println(GenresHashTable.GenreAverage(Genre));
             }
            break;
             case "4":
             System.out.println("\n");
             System.out.println("-------Movies in a particular genre (in order of their score------");
             for(int x = 0; x < GenresHashTable.indexGenre.length; x++)
             {
               String Genre = GenresHashTable.indexGenre[x];
               
               GenresHashTable.GenreScoreSort(Genre);
             }
             break;
             
             case "5":
             System.out.println("\n");
             System.out.println("-------Movies within each score grouping (0-3, 4-5, 6-8, 9-10)------");
             System.out.println("\n");
             
             System.out.println("(0-3)" + "\n");
             
             for(int x = 0; x < RateHashTable.size(); x++)
             {
                 RateHashTable.ScoreGrouping(0, 3, MovieList.get(x));
             }
             
             System.out.println("(4-5)" + "\n");
             
             for(int x = 0; x < RateHashTable.size(); x++)
             {
                 RateHashTable.ScoreGrouping(4, 5, MovieList.get(x));
             }
             
             System.out.println("(6-8)" + "\n");
             
             for(int x = 0; x < RateHashTable.size(); x++)
             {
                 RateHashTable.ScoreGrouping(6, 8, MovieList.get(x));
             }
             
             System.out.println("(9-10)" + "\n");
             
             for(int x = 0; x < RateHashTable.size(); x++)
             {
                 RateHashTable.ScoreGrouping(9, 10, MovieList.get(x));
             }
             break;
             
             case "6":
                 System.out.println("Enter Movie name");
                 String name = sc.nextLine();
                 
                 for(int x = 0; x< MovieList.size(); x++)
                 {
                     if(MovieList.get(x).getTitle().equals(name))
                     {
                         GenresHashTable.DisplayRecommendations(MovieList.get(x));
                     }
                 }
                 
             break;
             
             case "7":
             check = true;
             break;
             }
        }
        } catch (IOException e) {
        }
    
    }
}


