/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author USER-PC
 */
public class User {
    private int id;
    private String User_name;
    private int Enabled;
    private String Email;
    private String Password;
    private String Last_login;
    private String Confirmation_token;
    private String Password_request_at;
    private String Roles;
    private String First_name;
    private String Last_name;
    private String Preferance;
    private int Warning;
    private int Stars;
    private int NbRating;

    public User(int id, String User_name, int Enabled, String Email, String Password, String Last_login, String Confirmation_token, String Password_request_at, String Roles, String First_name, String Last_name, String Preferance, int Warning, int Stars, int NbRating) {
        this.id = id;
        this.User_name = User_name;
        this.Enabled = Enabled;
        this.Email = Email;
        this.Password = Password;
        this.Last_login = Last_login;
        this.Confirmation_token = Confirmation_token;
        this.Password_request_at = Password_request_at;
        this.Roles = Roles;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Preferance = Preferance;
        this.Warning = Warning;
        this.Stars = Stars;
        this.NbRating = NbRating;
    }

    public User() {
    }
    
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", Nom=" + User_name + ", Enabled=" + Enabled + ", Email=" + Email + ", Password=" + Password + ", Last_login=" + Last_login + ", Confirmation_token=" + Confirmation_token + ", Password_request_at=" + Password_request_at + ", Roles=" + Roles + ", First_name=" + First_name + ", Last_name=" + Last_name + ", Preferance=" + Preferance + ", Warning=" + Warning + ", Stars=" + Stars + ", NbRating=" + NbRating + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String Nom) {
        this.User_name = Nom;
    }

    public int getEnabled() {
        return Enabled;
    }

    public void setEnabled(int Enabled) {
        this.Enabled = Enabled;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getLast_login() {
        return Last_login;
    }

    public void setLast_login(String Last_login) {
        this.Last_login = Last_login;
    }

    public String getConfirmation_token() {
        return Confirmation_token;
    }

    public void setConfirmation_token(String Confirmation_token) {
        this.Confirmation_token = Confirmation_token;
    }

    public String getPassword_request_at() {
        return Password_request_at;
    }

    public void setPassword_request_at(String Password_request_at) {
        this.Password_request_at = Password_request_at;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String Roles) {
        this.Roles = Roles;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public String getPreferance() {
        return Preferance;
    }

    public void setPreferance(String Preferance) {
        this.Preferance = Preferance;
    }

    public int getWarning() {
        return Warning;
    }

    public void setWarning(int Warning) {
        this.Warning = Warning;
    }

    public int getStars() {
        return Stars;
    }

    public void setStars(int Stars) {
        this.Stars = Stars;
    }

    public int getNbRating() {
        return NbRating;
    }

    public void setNbRating(int NbRating) {
        this.NbRating = NbRating;
    }
    
}
