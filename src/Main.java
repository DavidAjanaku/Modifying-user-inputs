import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static name Names = new name("David");
    public static void main(String[] args) {

        boolean exit= false;
        printActions();

        while (!exit){
            System.out.println("Enter the  available actions");
            System.out.println("1. to add a name\n" +

                    "2.Edit a name\n" +
                    "3. Remove a name\n" +
                    "4. To print names\n" +
                    "0. To exist.");
            int action  = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("closing program...");
                    exit = true;
                    break;
                case 1:
                    addNewNames();
                    break;
                case 2:
                    editName();
                    break;
                case 3:
                    removeName();
                    break;
                case 4:
                    printName();
                    break;
            }


        }
    }


    private static void addNewNames(){
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        PeoplesNames newName = PeoplesNames.createNames(name);
        if (Names.addNewName(newName)){
            System.out.println("New name added: " + name );
        }else {
            System.out.println("Cannot add , " + name + " already on file.");
        }
    }

    private static void editName() {
        System.out.println("Enter existing name");
        String name = scanner.nextLine();
        PeoplesNames existingName = Names.queryContact(name);
        if (existingName == null) {
            System.out.println("Contact not found!!");
            return;
        }

        System.out.println("Enter new name: ");
        String newName = scanner.nextLine();
        PeoplesNames userName = PeoplesNames.createNames(newName);
        if (Names.editContact(existingName, userName)) {
            System.out.println("Successfully updated..");
        } else {
            System.out.println("Error updating..");
        }
    }

    private static void removeName() {
        System.out.println("Enter existing name");
        String name = scanner.nextLine();
        PeoplesNames existingName = Names.queryContact(name);
        if (existingName == null) {
            System.out.println("Contact not found!!");
            return;
        }

        if (Names.removeName(existingName)) {
            System.out.println("Successfully deleted.");
        }else {
            System.out.println("Error deleting name");
        }
    }

    private static void printActions(){
        System.out.println("Press the available Options");
        System.out.println("1. to add a name\n" +

                            "2.Edit a name\n" +
                "3. Remove a name\n" +
                "4. To print names\n" +
                "0. To exist.");
    }

    private static void printName(){
        Names.printNames();
    }
}
