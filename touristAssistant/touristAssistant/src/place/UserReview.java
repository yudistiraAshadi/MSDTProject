package place;

public class UserReview
{
    private String username;
    private int placeId;
    private String comment;
    private float rating;
    
    public UserReview(String username, int placeId, String comment, float rating)
    {
        this.username = username;
        this.placeId = placeId;
        this.comment = comment;
        this.rating = rating;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public float getRating()
    {
        return rating;
    }

    public void setRating(float rating)
    {
        this.rating = rating;
    }

    public String getUsername()
    {
        return username;
    }

    public int getPlaceId()
    {
        return placeId;
    }
    
    
    
    
}
