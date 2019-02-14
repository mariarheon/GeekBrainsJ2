
package participant;

import static participant.Dog.DEFAULT_RUN_VALUE;
import static participant.Dog.DEFAULT_SWIM_VALUE;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public class Human extends Animal implements Swimable, Jumpable{
    private Gender gender;

    private final static double DEFAULT_RUN_VALUE = 5;
    private final static double DEFAULT_JUMP_VALUE = 2;
    private final static double DEFAULT_SWIM_VALUE = 20;
    
    public Human(Gender gender, int age, String name) {
        super(age, name);
        this.gender = gender;
    }
    
    @Override
    public boolean run(double runDistance) {
        return runDistance <= DEFAULT_RUN_VALUE * ageCoeff(getAge()) * gender.getStrength();
    }
    
    @Override
    public boolean swim(double swimDistance) {
        return swimDistance <= DEFAULT_SWIM_VALUE * ageCoeff(getAge()) * gender.getStrength();
    }
    
    @Override
    public boolean jump(double jumpHeight) {
        return jumpHeight <= DEFAULT_JUMP_VALUE * ageCoeff(getAge()) * gender.getStrength();
    }
    
    public double ageCoeff(int age){
        if (age>= 0 && age <10)
            return 0.5;
        else if (age>=10 && age <14)
            return 0.7;
        else if (age>= 14 && age <25)
            return 1.5;
        else if (age>=25 && age <40)
            return 1;
        else if (age>=40 && age<65)
            return 0.5;
        else return 0.2;
    }

    @Override
    public String toString() {
        return "Human{" + " gender=" + gender + " age=" + getAge() + " name= " + getName() + "}"+ "\n\t"+
                "run=" + String.format("%.1f",DEFAULT_RUN_VALUE  * ageCoeff(getAge()) * gender.getStrength())  + "\t"+
                "swim=" +String.format("%.1f", DEFAULT_SWIM_VALUE * ageCoeff(getAge()) * gender.getStrength()) + "\t"+
                "jump=" +String.format("%.1f", DEFAULT_JUMP_VALUE * ageCoeff(getAge()) * gender.getStrength());
    }
    
    public String smallInfo(){
        return "Human: name = " + getName() + " age = " + getAge();
    }
   
}
