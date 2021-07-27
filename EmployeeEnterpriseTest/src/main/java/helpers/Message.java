package helpers;

public class Message {

    /**
     * Print welcom msg
     */
    public static void printMsgWelcom(){
        System.out.println(Constante.MSG_WELCOME);
    }

    public static void printQuitMsg(){
        System.out.println(Constante.MSG_QUIT);
    }
    /**
     * Affichage du menu de choix
     */
    public static void  printMenu(){
        System.out.println(Constante.MAIN_MENU);
    }
}
