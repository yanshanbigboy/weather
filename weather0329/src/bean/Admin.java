package bean��//1111

public class Admin {
	private int adminId;     //˽�б����������ڲ���ʹ����߿��Ե���
    private String adminName;
    private String adminPassword;
    
    public Admin(){
    	
    }
    public Admin(String adminName,String adminPassword){
    	this.adminName=adminName;
    	this.adminPassword=adminPassword;
    }
    
    public String getAdminName(){
    	return adminName;
    }
    public void setAdminName(String adminName){
    	this.adminName=adminName;
    }
    public String getAdminPassword(){
    	return adminPassword;
    }
    public void setadminPassword(String adminPassword){
    	this.adminPassword=adminPassword;
    }
}
