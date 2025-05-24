package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import hust.soict.hedspi.aims.comparator.*;
import hust.soict.hedspi.aims.comparator.MediaComparatorByTitleCost;

public abstract class Media {
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    public Media(String title){
        nbMedia++;
        this.id = nbMedia;
        this.title = title;
    }
    public Media(String title, String category, float cost){
        nbMedia++;
        this.id = nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public String toString(){
        return null;
    }
    public boolean isMatch(int id){
        if(this.getId() == id) return true;
        return false;
    }
    public boolean isMatch(String title){
        if(this.title.equals(title)) return true;
        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null) return false; 
        if (!(o instanceof Media)) return false; 
        
        Media media = (Media) o;

        // So sanh title, kiem tra null
        if (this.title == null) {
            if (media.title != null) return false;
        } else if (!this.title.equalsIgnoreCase(media.title)) {
            return false;
        }

       
        return this.cost == media.cost;
    }
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("Khong the so sanh voi Media null");
        }

        // So sanh title
        if (this.title == null && other.title != null) {
            return -1;
        }
        if (this.title != null && other.title == null) {
            return 1;
        }
        if (this.title != null && other.title != null) {
            int titleCompare = this.title.compareToIgnoreCase(other.title);
            if (titleCompare != 0) {
                return titleCompare;
            }
        }
        // Neu title giong nhau thi so sanh cost
        return Float.compare(this.cost, other.cost);
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}