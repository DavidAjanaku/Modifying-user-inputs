import java.util.ArrayList;
import java.util.Scanner;

public class name {
   private String names;
   private ArrayList<PeoplesNames> personNames;

   public name(String names){
       this.names = names;
       this.personNames = new ArrayList<PeoplesNames>();
   }

   public  boolean addNewName(PeoplesNames peoplenames){
       if (findName(peoplenames.getName()) >= 0){
           System.out.println("Name is already on file.");
           return false;
       }

       personNames.add(peoplenames);
       return true;
   }

   public boolean editContact(PeoplesNames oldName, PeoplesNames newName){
       int foundPosition = findName(oldName);
       if (foundPosition < 0){
           System.out.println(oldName.getName() + ", was not found.");
           return false;
       }
       this.personNames.set(foundPosition, newName);
       System.out.println(oldName.getName() + ", was replaced with " + newName.getName());
       return true;
   }

   public boolean removeName(PeoplesNames peoplesnames){
       int foundPosition = findName(peoplesnames);
       if (foundPosition < 0){
           System.out.println(peoplesnames.getName() + ", was not found.");
           return false;
       }
       this.personNames.remove(foundPosition);
       System.out.println(peoplesnames.getName() + ", was deleted.");
       return true;
   }


   private int findName(PeoplesNames peoplesnames){
       return this.personNames.indexOf(peoplesnames);
   }



   private int findName(String userName){
       for (int i=0 ; i<this.personNames.size(); i++){
           PeoplesNames peoplesnames = this.personNames.get(i);
           if (peoplesnames.getName().equals(userName)){
               return i;
           }
       }
       return  -1;
   }

public String queryContact(PeoplesNames peoplesname){
       if (findName(peoplesname) >= 0){
           return peoplesname.getName();
       }
       return null;
}

public PeoplesNames queryContact(String name){
       int position = findName(name);
       if (position >=0){
           return this.personNames.get(position);
       }
       return null;
}
    public void printNames(){
        System.out.println("Names: ");
        for (int i=0; i<this.personNames.size(); i++){
            System.out.println((i+1) + "." +
                    this.personNames.get(i).getName());

        }
    }

}


