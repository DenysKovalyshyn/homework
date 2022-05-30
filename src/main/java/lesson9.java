import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lesson9 {
    public static void main(String[] args) {
        String kitkit = "kit tik";
        kitkit = kitkit.replaceAll("\\s", "");

        String makimaki = "maki maki";
        makimaki = makimaki.replaceAll("\\s", "");

        List<String> mainList = new ArrayList<>();
        mainList.add(kitkit);
        mainList.add("foo");
        mainList.add("bar");
        mainList.add(makimaki);
        mainList.add("baz");
        mainList.add("quiz");
        mainList.add("song");
        mainList.add("chacha");

        ArrayList<String> pairList = new ArrayList<>();
        for (int i = 0; i < mainList.size(); i++) {
            if(mainList.get(i).toCharArray().length % 2 == 0) {
                pairList.add(mainList.get(i));
                if(pairList.size() == 2){
                    break;
                }
            }
        }
        ArrayList<Character> letterList = new ArrayList<>();
        for (int i = 0; i < pairList.size(); i++) {
            char[] charList = pairList.get(i).toCharArray();
            for (int j = 0; j < charList.length; j++) {
                letterList.add((charList[j]));
            }
        }
        HashSet<Character> mySet = new HashSet<>();
        mySet.addAll(letterList);
        System.out.println(mySet);
    }
}
