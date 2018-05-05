package Object;

import java.util.Objects;

/**
 *
 * @author Ben
 */
public class Movie {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Rating);
        return hash;
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
    public String toString() {
        return "Movie{" + "Title=" + Title + ", Genre=" + Genre + ", Age=" + Age + ", Rating=" + Rating + '}';
    }

}