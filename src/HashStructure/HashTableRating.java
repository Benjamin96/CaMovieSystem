/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashStructure;

import Object.Movie;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Ben
 */
public class HashTableRating {
 private int size;

    /**
     *
     */
    public final LinkedList<Movie>[] datarate;
    
    /**
     *
     */
    public final String[] indexRate = new String[100];
    
    /**
     *
     */
    public final ArrayList<String> noRepeatsCommon = new ArrayList();
    
    /**
     *
     */
    public HashTableRating(){

        datarate = (LinkedList<Movie>[]) new LinkedList[100];
        for(int x =0; x < indexRate.length; x++)
        {
            indexRate[x] = "";
            
        }
        size = 0;
    }
    
    /**
     *
     * @param value
     * @return Movies added to Hash
     */
    public Movie put(Movie value){

         int hash = value.MyhashCodeRate(indexRate);
        
         int destinationIndex = hash;

        if(datarate[destinationIndex] == null){

            LinkedList<Movie> list = new LinkedList();

            list.add(value);
           
            datarate[destinationIndex] = list;
            System.out.println(" Rates stored in slot " + destinationIndex) ;
            
            size++;

            return null;
        }
        else{            

            datarate[destinationIndex].addLast(value);

            return null;
        }
    }
    
    /**
     *
     * @param value
     * @return Special Display For Movies
     */
    public Movie Displayget(Movie value){
        int hash = value.MyhashCodeRate(indexRate);
        

        int destinationIndex = hash;
        
        if(datarate[destinationIndex] != null){
                    System.out.println(destinationIndex +  "\n");
                    return value;    
        }
        return null;
    }
      
    /**
     *
     * @param start
     * @param end
     * @param value
     * 
     */
    /*
    public void ScoreGrouping(int start, int end, Movie value)
    {
        int hash = value.MyhashCodeRate(indexRate);
        double MovieRating = Double.parseDouble(value.getRating());

        int destinationIndex = hash;
        
        if(datarate[destinationIndex] != null){
         for(int x =0; x< datarate[destinationIndex].size(); x++)
         {  
                if((start <= MovieRating) && (end >= MovieRating))
                {
                  if(!(noRepeatsCommon.contains(datarate[destinationIndex].get(x).toString())))
                    {
                        noRepeatsCommon.add(datarate[destinationIndex].get(x).toString());
                        System.out.println(datarate[destinationIndex].get(x).toString() +  "\n");
                    }
                }
          } 
     
        }

    }
   
    /**
     *
     * @return size
     */
    public int size(){

        return size;
    }
}


