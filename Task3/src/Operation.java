

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;




/**
 *
 * @author Maria Mikhaleva
 */
public class Operation {
    public static List<String> fillList(List<String> arr){
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");
        arr.add("C");
        arr.add("D");
        arr.add("C");
        arr.add("D");
        arr.add("E");
        arr.add("E");            
        return arr;
    }
    
    public static void findUnique(List<String> arr){
     
        Map<String, Integer> unique= new LinkedHashMap<>();
        int count;
        for (String a : arr){
            unique.put(a, 0);
        }
        
        for (Map.Entry<String, Integer> entry : unique.entrySet()){
            count = 0;
            for (String a : arr)
                if (entry.getKey().equals(a)) count++;
            unique.put(entry.getKey(), count);
        }
        System.out.println(unique.toString());
    }
    
    public static PhoneBook fillPhoneBook(PhoneBook phonebook){
        phonebook.add("Mikhaleva", "+7-999-500-50-50");
        phonebook.add("Mikhaleva", "24-56-23" );      
        phonebook.add("Ivanov", "+7-900-90-90");
        return phonebook;
    }
            
}
