package Object;

import java.util.Objects;

/**
 *
 * @author Ben
 */
public class Movie implements Comparable<Movie>{
    private String Title;
    private String Genre;
    private String Age;
    private String Rating;



    public Movie(String Title, String Genre, String Age, String Rating) {
        this.Title = Title;
        this.Genre = Genre;
        this.Age = Age;
        this.Rating = Rating;
    }

    public String getTitle() {
        return Title;
    }

    public String getGenre() {
        return Genre;
    }

    public String getAge() {
        return Age;
    }

    public String getRating() {
        return Rating;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }

    public int MyhashCode() 
    {
        Double HashRate = Double.parseDouble(this.getRating());
        int intHash = (int) Math.floor(HashRate);
        return intHash;
    }
    
    public int MyhashCodeGenre(String[] Array)
    {
        for(int x = 0; x< Array.length; x++)
        {
            if(Array[x].equals(""))
            {
                Array[x] = this.getGenre();
                return x;
            }
                
            else if(Array[x].equals(this.getGenre()))
            {
                return x;
            }
        }
        return 0;
    }
    
    public int MyhashCodeRate(String[] Array)
    {
        for(int x = 0; x< Array.length; x++)
        {
            if(Array[x].equals(""))
            {
                Array[x] = this.getRating();
                return x;
            }
                
            else if(Array[x].equals(this.getRating()))
            {
                return x;
            }
        }
        return 0;
    }
    
    
  
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.Title, other.Title)) {
            return false;
        }
        if (!Objects.equals(this.Genre, other.Genre)) {
            return false;
        }
        if (!Objects.equals(this.Age, other.Age)) {
            return false;
        }
        if (!Objects.equals(this.Rating, other.Rating)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public int compareTo(Movie o) {
        
        String title = o.getTitle();
        if(this.Title.equals(title))
        {
            return 0;
        }
        else if(this.Title.compareTo(title) < 1)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
    
    

    @Override
    public String toString() {
        return "Movie{" + "Title=" + Title + ", Genre=" + Genre + ", Age=" + Age + ", Rating=" + Rating + '}';
    }

}