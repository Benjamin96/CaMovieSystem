package Part1;

import HashStructure.*;
import Object.Movie;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
                    if("".equals(lineArray[0]) || "".equals(lineArray[1]) || lineArray[2].equals("") || lineArray[3].equals("") )
                     {
                         
                     } else {
                            MovieList.add(new Movie(lineArray[0], lineArray[1], lineArray[2], lineArray[3]));
                            MovieList.add(new Movie(lineArray[0], lineArray[1], lineArray[2], lineArray[3]));
                            }


                     }
            
                    for(int x = 0; x< MovieList.size(); x++)
                    {
                        MovieHashTable.put(MovieList.get(x));
                        GenresHashTable.put(MovieList.get(x));
                        RateHashTable.put(MovieList.get(x));
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
            for(int x = 0; x< MovieHashTable.data.length; x++)
               {
                   System.out.println("Slot " + x);

                        Iterator<Movie> itr = MovieHashTable.data[x].iterator();
                        while(itr.hasNext())
                        {
                            System.out.println(itr.next() + "\n");
                        }


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
             
              if(!(GenresHashTable.GenreAverage(Genre).equals(null)))
                {
                  System.out.println(GenresHashTable.GenreAverage(Genre));
                }
              else
              {
                System.out.println("The file imported does not support this functionality");
              }
              
             }
            break;
             case "4":
             System.out.println("\n");
             System.out.println("-------Movies in a particular genre (in order of their score------");
                
             System.out.println("Enter Genre name");
             String Genre = sc.nextLine();
             Genre = Genre.toLowerCase();
             Movie Fed = new Movie();
             for(int x = 0; x< MovieHashTable.data.length; x++)
               {


                        Iterator<Movie> itr = MovieHashTable.data[x].iterator();
                        while(itr.hasNext())
                        {
                            Fed = itr.next();
                            if(Fed.getGenre().toLowerCase().contains(Genre))
                            {
                            System.out.println(Fed + "\n");
                            }
                        }

                   
               }
             
             break;
             
             case "5":
             System.out.println("\n");
             System.out.println("-------Movies within each score grouping (0-3, 4-5, 6-8, 9-10)------");
             System.out.println("\n");
             
             System.out.println("(0-3)" + "\n");
             
             
             PrintRange(0, 3, MovieHashTable);
                          
             System.out.println("(4-5)" + "\n");
             
             PrintRange(4, 5, MovieHashTable);
             
             System.out.println("(6-8)" + "\n");
             
             PrintRange(6, 8, MovieHashTable);
             
             System.out.println("(9-10)" + "\n");
             
             PrintRange(9, 10, MovieHashTable);
             break;
             
             case "6":
                 System.out.println("Enter Movie name");
                 String name = sc.nextLine();
                 Boolean Found = false;
                 name = name.toLowerCase();
                 for(int x = 0; x< MovieList.size(); x++)
                 {
                     if(MovieList.get(x).getTitle().toLowerCase().contains(name))
                     {
                         GenresHashTable.DisplayRecommendations(MovieList.get(x));
                         Found = true;
                     }
                     
                     
                 }
                 if(!Found)
                 {
                     System.out.println("Couldnt find that movie");
                 }
                 
             break;
             
             case "7":
                 System.out.println("GoodBye See you Soon");
             check = true;
             break;
             }
        }
        } catch (IOException e) {
        }
    
    }
     
     public static void PrintRange(int start, int end, HashTableGeneral MovieHashTable)
     {
         Movie Fed = new Movie();
         for(int x = start; (x<= end) && (x < MovieHashTable.data.length); x++)
               {

                        Iterator<Movie> itr = MovieHashTable.data[x].iterator();
                        while(itr.hasNext())
                        {
                            Fed = itr.next();
                            
                            System.out.println(Fed + "\n");
                            
                        }

                    
               }
     }
}


