import java.util.*;
import java.util.stream.Collectors;

public class Mainu {
    public static void main(String[] args)
    {
        Resident r0 = new Resident("R0");
        Resident r1 = new Resident("R1");
        Resident r2 = new Resident("R2");
        Resident r3 = new Resident("R3");
        Hospital h0=new Hospital("H0");
        Hospital h1=new Hospital("H1");
        Hospital h2=new Hospital("H2");
        List<Resident> residentList = new ArrayList<>();
        residentList.add(r0);
        residentList.add(r1);
        residentList.add(r2);
        residentList.add(r3);
        SortedSet<Hospital> h = new TreeSet<>();
        h.add(h0);
        h.add(h1);
        h.add(h2);
        Collections.sort(residentList);
        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        resPrefMap.put(residentList.get(0), Arrays.asList(h0,h1,h2));
        resPrefMap.put(residentList.get(1), Arrays.asList(h0,h1,h2));
        resPrefMap.put(residentList.get(2), Arrays.asList(h0,h1));
        resPrefMap.put(residentList.get(3), Arrays.asList(h0,h2));
        Map<Hospital, List<Resident>> hosPrefMap = new HashMap<>();
        hosPrefMap.put(h0,Arrays.asList(r3,r0,r1,r2));
        hosPrefMap.put(h1,Arrays.asList(r0,r2,r1));
        hosPrefMap.put(h2,Arrays.asList(r0,r1,r3));
        System.out.println(resPrefMap);
        System.out.println(hosPrefMap);
        residentList.stream()
                .filter(res -> resPrefMap.get(res).contains(h0))
                .filter(res -> resPrefMap.get(res).contains(h2))
                .forEach(System.out::println);
        h.stream()
                .filter(da -> hosPrefMap.get(da).get(0)==r0)
                .forEach(System.out::println);



    }
}
