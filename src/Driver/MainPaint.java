package Driver;

import java.util.ArrayList;
import java.util.Iterator;

public class MainPaint {

    public static void main(String[] args) {
        ArrayList<String> ss = new ArrayList();
        ss.add("one"); ss.add("two"); ss.add("three");
        
        Iterator<String> strings = ss.iterator();
        while(strings.hasNext()){
            //strings.next()="Boom";
        }
        
        for(String s: ss){
            System.out.println(s);
        }
    }
}