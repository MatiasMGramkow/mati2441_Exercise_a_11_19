import java.util.*;

public class Exercise19 {

    /*
Write a method called rarest that accepts a map whose keys are strings and whose values are integers as a parameter
and returns the integer value that occurs the fewest times in the map. If there is a tie, return the smaller integer value. If
the map is empty, throw an exception.
     */

    public static void main(String[] args)
    {
        Map<String,Integer> map = new HashMap<>();

        map.put("q",1);
        map.put("w",2);
        map.put("e",22);
        map.put("r",44);
        map.put("t",11);
        map.put("y",11);
        map.put("u",22);
        map.put("i",11);
        map.put("o",44);
        map.put("p",44);
        map.put("å",44);
        map.put("a",44);

        try
        {
            if (map.isEmpty())
            {
                throw new Exception();
            }else
            {
                System.out.println("Map: " + map);

                int ele;
                ele = rarest(map);
                System.out.println("Færreste gange: " + ele);
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static int rarest (Map<String,Integer> map)
    {
        List<Integer> liste = new LinkedList<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for (String v :
                map.keySet()) {
            liste.add(map.get(v));
        }

        for (int i = 0; i < liste.size(); i++) {
            int q = liste.get(i);
            if (!counter.containsKey(q))
            {
                counter.put(q,1);
            }else
            {
                int tal = counter.get(q);
                counter.put(q, tal + 1);
            }
        }

        liste.clear();

        for (int key :
                counter.keySet()) {
            int value = counter.get(key);
            liste.add(value);
        }

        Collection<Integer> nøgler = counter.values();

        List<Integer> nøgleListe = new LinkedList<>();

        Set<Integer> set = counter.keySet();

        for (int t :
                set) {
            nøgleListe.add(t);
        }

        int argh = -1;

        int mValue = liste.get(0);

        for (int i = 1; i <counter.size() ; i++) {
            if(liste.get(i) < mValue)
            {
                mValue = liste.get(i);
                argh = i;
            }
        }
        return nøgleListe.get(argh);


    }


}
