package tweakup.ru.retrofitrestapimvvm.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Recipe implements Parcelable {

    /**
     * Primary key
     */
    private String pk;

    /**
     * String recipe title
     */
    private String title;

    /**
     * String recipe publisher
     */
    private String publisher;

    /**
     * Array of ingredients
     */
    private String[] ingredients;

    /**
     * String recipe featured image
     */
    private String featured_image;

    /**
     * Float recipe total rating
     */
    private float rating;

    public Recipe(String pk, String title, String publisher, String[] ingredients, String featured_image, float rating) {
        this.pk = pk;
        this.title = title;
        this.publisher = publisher;
        this.ingredients = ingredients;
        this.featured_image = featured_image;
        this.rating = rating;
    }

    public Recipe() {
    }

    protected Recipe(Parcel in) {
        pk = in.readString();
        title = in.readString();
        publisher = in.readString();
        ingredients = in.createStringArray();
        featured_image = in.readString();
        rating = in.readFloat();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "pk='" + pk + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", featured_image='" + featured_image + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(pk);
        parcel.writeString(title);
        parcel.writeString(publisher);
        parcel.writeStringArray(ingredients);
        parcel.writeString(featured_image);
        parcel.writeFloat(rating);
    }
}
