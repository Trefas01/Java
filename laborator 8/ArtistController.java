import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistController {
    List<Artist> artists=new ArrayList<>();
    public ArtistController()  {
       try {
           DataBase dt = new DataBase();
           Connection conn = dt.create("dbaa", "sql");
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select * from artists");
           while (rs.next()) {
               Artist a = new Artist(rs.getInt(1), rs.getString(2), rs.getString(3));
               artists.add(a);
           }
       }catch (SQLException e){e.printStackTrace();}

    }
    public void create(String name,String country) {
        try {
            DataBase dt = new DataBase();
            Connection conn = dt.create("dbaa", "sql");
            Statement st = conn.createStatement();
            Artist a = new Artist(artists.size() + 1, name, country);
            artists.add(a);
            st.executeUpdate("insert into artists values(" + (artists.size() + 1) + ",'" + name + "','" + country + "')");
        }catch(SQLException e)
        {e.printStackTrace();}


    }
    public void findByName(String name)  {
        for(int i=0;i<artists.size();i++)
            if(artists.get(i).name.equals(name))
                System.out.println("Gasit "+artists.get(i).id+artists.get(i).name+artists.get(i).country);





    }


}
