/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.LocalDate;
import model.User;

/**
 * Singleton class for save logins and manage logouts from the players
 * @author chw99
 */
public class ApplicationState {
    
    /**
     * Private constructor
     */
    private ApplicationState(){};
    
    /**
     * Saves the state of the players logs
     */
    private static ApplicationState INSTANCE;
    
    /**
     * Saves players info
     */
    private User User;
    
    private String forgotPassNickName;
    
    public boolean playerLogin = false;
    
    public boolean darkMode = true;
    
    public String styleSheetUrl = "/view/style.css";
    
    private LocalDate startDate;
    
    private LocalDate endDate;
         
    private User changingUser = null;
    
    /**
     * Makes (if necessary) a new instance
     * @return New or existent ApllicationState
     */
    public static synchronized ApplicationState getInstance() {
        // Create singleton object if isn't created already
        if(INSTANCE == null) {
            INSTANCE = new ApplicationState();
        }
        return INSTANCE;
    }
    
    /**
     * Logs a player into de the ApplicationState as firts if there is no one
     * and as a second in other case
     * @param p User to be loged in
     * @return True if everything went okay or false if the player is already logged in
     */
    public boolean loginUser(User p){
        if(User == null) {
            User = p;
        } else if(User.getNickName().equals(p.getNickName())) { // Check that we don't log in the same player twice
            return false;
        }
        else {
            User = p;
        }
        return true;
    }
    
    public boolean registerUser(User p){
        if(User == null) {
            User = p;
        } 
        else if(User.getNickName().equals(p.getNickName())) {
            return false;
        }
        else {
            User = p;
        }
        return true;
    }
    /**
     * Returns the logged firts player
     * @return Firts player
     */
    public User getUser(){
        return User;
    }
    
    /**
     * Returns the logged second player
     * @return Second player
     */

    public String getForgotPassNickName() {
        return forgotPassNickName;
    }

    public void setForgotPassNickName(String forgotPassNickName) {
        this.forgotPassNickName = forgotPassNickName;
    }
    
    /**
     * Logs out the firts player
     * @return False if there is no second player, true if second player is authorized
     */
    public boolean logOutUser() {
        playerLogin = false;
        if(User == null) {
            User = null;
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Logs out the second player
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
