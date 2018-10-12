package com.company;


public class User {
    private String user_name, user_surname, user_address, login, password;
    private int user_id;
  //  private Basket basketOfUser;

    public User(String name, String surname, String address, String login, String password){
        this.user_name = name;
        this.user_surname = surname;
        this.user_address = address;
        this.login = login;
        this.password = password;
       // this.user_id = (short) (NewSQL_Worker.getIdOfLastUserInDb()+1);
     //   this.user_id = (short) ((tmp.GetTheIdOfLastUser())+1);
//        basketOfUser = new Basket();
    }
    public User(String name){
        this.user_name = name;
    }
    public String getUser_name(){
        return user_name;
    }
    public String getUser_surname(){
        return user_surname;
    }
    public String getUser_address(){
        return user_address;
    }
    public String getLogin(){
        return login;
    }
    public short getUser_id(){
        return (short) user_id;
    }
    public String getUser_password(){
        return password;
    }
    public void setUser_id(int user_id){
        this.user_id = user_id;
    }
}
