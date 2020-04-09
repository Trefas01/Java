public class Album {
    int id;
    int art_id;
    int release_year;
    String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getArt_id() {
        return art_id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public String getName() {
        return name;
    }

    public Album(int id, String name,int art_id, int release_year) {
        this.id = id;
        this.art_id = art_id;
        this.release_year = release_year;
        this.name = name;
    }
}
