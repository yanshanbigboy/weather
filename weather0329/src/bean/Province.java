package bean;

public class Province {
    String provinceName;
    int population;
    
    public Province(String provinceName,int population){
    	this.provinceName=provinceName;
    	this.population=population;
    }
    
    public String getProvinceName(){
    	return provinceName;
    }
    public void setProvinceName(String provinceName){
    	this.provinceName=provinceName;
    }
    
    public int getPopulation(){
    	return population;
    }
    public void setPopulation(){
    	this.population=population;
    }
    
}
