/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Univer
 */
public class MyArraySizeException extends RuntimeException{
    
    private String info;

    public MyArraySizeException(String info) {
        this.info = info;
       
    }

    @Override
    public String toString() {
        return "MyArraySizeException{" + "info=" + info + '}';
    }
 
    
}
