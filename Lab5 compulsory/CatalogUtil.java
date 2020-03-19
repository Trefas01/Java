import java.awt.*;
import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    public static Catalog load(String path)
            throws InvalidCatalogException {


        try {
            ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(path));
            Catalog tmp = new Catalog();
            tmp = (Catalog) objInput.readObject();
            objInput.close();
            return tmp;
        } catch (FileNotFoundException e) {
            e.getStackTrace();
            return null;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }
    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
       System.out.println(desktop);
    }


}

