
package participant;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public class Dog extends Animal implements Swimable{
     private String breed;

    public final static String BREED_BULLDOG = "BULLDOG";
    public final static String BREED_GREYHOUND = "GREYHOUND";
    
    public static double DEFAULT_RUN_VALUE = 30;
    public static double DEFAULT_SWIM_VALUE = 10;
    
    public Dog(String name, int age, String breed) {
        super(age, name);
        this.breed = breed;
    }

    @Override
    public boolean run(double runDistance) {
        return runDistance <= DEFAULT_RUN_VALUE * (1.0 / getAge()) * strength(breed);
    }
    
    @Override
    public boolean swim(double swimDistance) {
        return swimDistance <= DEFAULT_SWIM_VALUE * (1.0 / getAge()) * strength(breed);
    }
    
    public double strength(String breed){
        if (breed.equals(BREED_BULLDOG))
            return 0.8;
        else if (breed.equals(BREED_GREYHOUND))
            return 2;
        else return 0;
        
    }
   
    @Override
    public String toString() {
        return "Dog{age=" + getAge() + " name= " + getName() + "}"+ "\n\t"+
                "run=" + String.format("%.1f",DEFAULT_RUN_VALUE  * (1.0 / getAge()) * strength(breed))  + "\t"+
                "swim=" +String.format("%.1f", DEFAULT_SWIM_VALUE * (1.0 / getAge()) * strength(breed));
    }
    
    public String smallInfo(){
        return "Dog: name = " + getName() + " age = " + getAge();
    }
   
    
}
