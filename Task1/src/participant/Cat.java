
package participant;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public class Cat extends Animal implements Jumpable{
    private String breed;

    public final static String BREED_BENGAL = "BENGAL";
    public final static String BREED_SIAMESE = "SIAMESE";
    
    public static double DEFAULT_RUN_VALUE = 10;
    public static double DEFAULT_JUMP_VALUE = 3;
    
    public Cat(String name, int age, String breed) {
        super(age, name);
        this.breed = breed;
    }

    @Override
    public boolean run(double runDistance) {
        return runDistance <= DEFAULT_RUN_VALUE  * (1.0 / getAge()) * strength(breed);
    }

    @Override
    public boolean jump(double jumpHeight) {
        return jumpHeight <= DEFAULT_JUMP_VALUE * (1.0 / getAge()) * strength(breed);
    }
    
    public double strength(String breed){
        if (breed.equals(BREED_BENGAL))
            return 1.2;
        else if (breed.equals(BREED_SIAMESE))
            return 1.5;
        else return 0;
    }
 
    @Override
    public String toString() {
        return "Cat{age=" + getAge() + " name= " + getName() + "}" + "\n\t"+
                "run=" + String.format("%.1f",DEFAULT_RUN_VALUE  * (1.0 / getAge()) * strength(breed))  + "\t"+
                "jump=" + String.format("%.1f",DEFAULT_JUMP_VALUE * (1.0 / getAge()) * strength(breed));
    }
    
    public String smallInfo(){
        return "Cat: name = " + getName() + " age = " + getAge();
    }
   
    
}
