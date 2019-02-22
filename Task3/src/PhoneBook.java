
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Mikhaleva Maria
 */
public class PhoneBook {
    private Map<String, List<String>> phonebook;

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }
    
    
    public void add (String name, String number){
        if (phonebook.containsKey(name)){
            List<String> numbers = phonebook.get(name);
            if(!numbers.contains(number))
                numbers.add(number);
        } else {
            phonebook.put(name, new ArrayList<>(Arrays.asList(number)));
        }
    }
    
    public List<String> get(String name){
        if (phonebook.containsKey(name)){
            System.out.print("Номера " + name);
            return phonebook.get(name);
        }
        System.out.print("По фамилии " + name +" записей не обнаружено");
        return new ArrayList<>();
    }
            
    public void print(){
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        
    }  
}
