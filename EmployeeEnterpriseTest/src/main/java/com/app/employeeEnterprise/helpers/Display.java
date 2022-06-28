package com.app.employeeEnterprise.helpers;

import com.app.employeeEnterprise.constantes.Constante;

public class Display implements IDisplay{

    /**
     * Print welcom msg
     *
     */
    public  void msgWelcom(){
        System.out.println(Constante.MSG_WELCOME);
    }

    public  void quitMsg(){
        System.out.println(Constante.MSG_QUIT);
    }
    /**
     * Affichage du menu de choix
     */
    public  void  menu(){
        System.out.println(Constante.MAIN_MENU);
    }
}
