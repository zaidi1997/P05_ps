package sg.edu.rp.c346.p05_ps;

public class Song {

    private int _id;
    private String title;
    private String slingers;
    private int year;
    private int stars;

    public Song(String title, String slingers, int year, int stars) {
        this.title = title;
        this.slingers = slingers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlingers() {
        return slingers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }
}
