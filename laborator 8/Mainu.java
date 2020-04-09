
public class Mainu {
    public static void main(String[] args)  {
        ArtistController art=new ArtistController();
        art.create("Rud","England");
        art.findByName("Rud");
        AlbumController alb=new AlbumController();
        alb.create("Nume de film",1,1998);
        alb.findByArtist(3);
    }
}
