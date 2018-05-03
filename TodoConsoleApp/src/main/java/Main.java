
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

// Don't forget to disable the parent handlers.
        logger.setUseParentHandlers(false);
        Scanner sc = new Scanner(System.in);
        TodoList l = new TodoList();
        Menu.displaymenu();
        boolean quit = false;
        do {
            String choice = sc.next();
            switch (choice) {

                case "add":
                    util.item_creator(l);
                    Menu.displaymenu();
                    break;
                case "del":
                    util.item_remover(l);
                    Menu.displaymenu();
                    break;
                case "edit":
                    util.item_updater(l);
                    Menu.displaymenu();
                    break;
                case "ls":
                    util.list_all(l);
                    Menu.displaymenu();
                    break;

                case "ls_name_asc":
                    l.sort_byname();
                    l.list_all();
                    Menu.displaymenu();
                    break;

                case "ls_name_desc":
                    l.sort_byname();
                    l.reverse_list();
                    l.list_all();
                    Menu.displaymenu();
                    break;
                case "ls_date":
                    l.sort_bydate();
                    l.list_all();
                    Menu.displaymenu();
                    break;

                case "exit":
                    quit = true;
                    break;

                default:
                    System.out.println("please enter one of the above mentioned command");
                    Menu.displaymenu();
                    break;

            }
        } while (!quit);
    }
}
