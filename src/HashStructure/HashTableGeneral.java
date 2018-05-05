package HashStructure;


import java.util.LinkedList;

/**
 *
 * @author Ben
 * @param <V>
 * 
 */
public class HashTableGeneral<V>{
 
    private int size;

    private final LinkedList<V>[] data;
    
    public HashTableGeneral(){

        data = (LinkedList<V>[]) new LinkedList[10];
        
        size = 0;
    }
    
    public V put(V value){

        int hash = value.hashCode();

        int destinationIndex = hash % data.length;

        if(data[destinationIndex] == null){

            LinkedList<V> list = new LinkedList();

            list.add(value);

            data[destinationIndex] = list;
            System.out.println(" Movie stored in slot " + destinationIndex);
            
            size++;

            return null;
        }
        else{            

            data[destinationIndex].addLast(value);

            return null;
        }
    }
    
    public V get(V value){
        int hash = Math.abs(value.hashCode());

        int destinationIndex = hash % data.length;
        
        if(data[destinationIndex] != null){
                    System.out.println(" Movie found in slot " + destinationIndex);
                    return value;    
        }
        return null;
    }
    
    public int getCommonGenre(V value)
    {
        int hash = value.hashCode();
        
        int destinationIndex = hash % data.length;
        
        int CommonGenre = 0;

          if(data[destinationIndex].size() > CommonGenre)
          {
            CommonGenre = destinationIndex;  
          }
        
        return CommonGenre;
    }
    
    public int size(){

        return size;
    }
}
