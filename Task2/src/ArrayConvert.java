
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Java 2. Lesson 2. Exceptions
 * 
 * @author Maria Mikhaleva
 * @dated Feb 14 2019
 */
public class ArrayConvert {

    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "5"}, {"2", "3", "4", "5"}, {"3", "4", "5", "6"},{"4", "5", "6", "7"}}; // OK
        //String[][] array = {{"1", "2", "3", "."}, {"2", "3", "4", "5"}, {"4", "5", "6", "7"}}; // MyArraySizeException rows
        //String[][] array = {{"1", "2", "3"}, {"2", "3", "4", "5"}, {"3", "4", "5", "6"},{"4", "5", "6", "7"}}; // MyArraySizeException columns
        //String[][] array = {{"1", "2", "3", "."}, {"2", "3", "4", "5"}, {"3", "4", "5", "6"},{"4", "5", "6", "7"}}; // MySizeArrayDataException
        int sumOfElements = convertToIntArray(array);
        System.out.println(sumOfElements);
    }
    
    public static int convertToIntArray (String[][] strArray){
        int sum = 0;
        
        //checking size 
            if (strArray.length == 4){
                for (int i = 0; i < 4; i++){
                    if (strArray[i].length != 4)
                        throw new MyArraySizeException("Есть строки, в которых количество элементов не равно 0");
                   
                }                           
            }
            else throw new MyArraySizeException("Количество строк не равно 4");
        
        //convert to int
        for (int i = 0; i < strArray.length; i++){
            for (int j = 0; j < strArray[i].length; j++)
                try{
                    sum += Integer.parseInt(strArray[i][j]);
                }
                catch(RuntimeException e){
                    throw new MySizeArrayDataException(i, j);
                }
        }
        
        
        return sum;       
    }
    
}
