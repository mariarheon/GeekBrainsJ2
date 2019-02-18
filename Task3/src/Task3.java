
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Java 2. Lesson 3. Collections
 *
 * @author Maria Mikhaleva
 * @version dated Feb 18 2019
 */
public class Task3 {


    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>();
        wordList = Operation.fillList(wordList);
        Operation.findUnique(wordList);
        
       PhoneBook phonebook = new PhoneBook();
       Operation.fillPhoneBook(phonebook);
        System.out.println("Телефонная книга:");
        phonebook.print();
        System.out.println("------------------");
        
        System.out.println(phonebook.get("Mikhaleva"));
        System.out.println(phonebook.get("Putin"));
        
    }
    
}
