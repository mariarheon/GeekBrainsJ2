/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Univer
 */
public class MySizeArrayDataException extends RuntimeException{
    
    private int column;
    private int row;

    public MySizeArrayDataException(int column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public String toString() {
        return "Произошла ошибка в преобразовании элемента\n\t{" + "column=" + column + ", row=" + row + '}';
    }

    

}
