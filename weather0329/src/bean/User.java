package bean;

public class User {
	private int userId;     //私有变量，仅有内部类和创建者可以调用
    private String userName;
    private String userPassword;
    
    public User(){
    	
    }
    public User(String userName,String userPassword){
    	this.userName=userName;
    	this.userPassword=userPassword;
    }
    
    public String getUserName(){
    	return userName;
    }
    public void setUserName(String userName){
    	this.userName=userName;
    }
    public String getUserPassword(){
    	return userPassword;
    }
    public void setUserPassword(String userPassword){
    	this.userPassword=userPassword;
    }
}
