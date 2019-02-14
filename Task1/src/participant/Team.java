
package participant;

import course.*;

/** Java2. Lesson 1. OOP
 *
 * @author Maria mikhaleva
 * @version dated Feb 12 2019
 */
public class Team {
   private String teamName;
   private Animal[] members;
   private String result;

    public Team(String teamName, Animal[] members) {
            
        this.teamName = teamName;
        this.members = members;
        result = "";
    }

    public void show(){
        System.out.println(teamName);
        System.out.println("--------------------------");
        
        for (Animal member : members)
            System.out.println(member.toString());
        
        System.out.println("--------------------------");
    }
   
    public void doIt(Obstacle o){
        result += o.toString() + ":\n";
        for (Animal member : members){
            result += "\t" + member.smallInfo() + " - " + o.doIt(member);
        }
        result += "\n";
    }
    
    public void showResult(){
        System.out.println(result);
    }
    
}
