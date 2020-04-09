import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumController {
    List<Album> albums=new ArrayList<>();
    public AlbumController() {
       try{ DataBase dt=new DataBase();
        Connection conn=dt.create("dbaa","sql");
        Statement st=conn.createStatement();
        ResultSet rs= st.executeQuery("select * from albums");
        while(rs.next()) {
            Album a = new Album(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            albums.add(a);
        }
        }catch (SQLException e){e.printStackTrace();}

    }
    public  void create(String name,int art_id,int rel_yr) {
       try {
           DataBase dt = new DataBase();
           Connection conn = dt.create("dbaa", "sql");
           Statement st = conn.createStatement();
           Album a = new Album(albums.size() + 1, name, art_id, rel_yr);
           albums.add(a);
           st.executeUpdate("insert into albums values(" + (albums.size() + 1) + ",'" + name + "'," + art_id + "," + rel_yr + ")");
       }catch(SQLException e){e.printStackTrace();}


    }
    public void findByArtist(int artid)
    {
        for(int i=0;i<albums.size();i++)
            if(albums.get(i).art_id==artid)
                System.out.println("Gasit "+albums.get(i).art_id+albums.get(i).name+albums.get(i).release_year);
    }

}
