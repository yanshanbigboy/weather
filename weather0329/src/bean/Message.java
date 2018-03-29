package bean;

public class Message {
     String name;
     String content;
     int telephone;
     String email;
     
     public Message(){
    	 
     }
     
     public Message(String name,String content){
    	 this.name=name;
    	 this.content=content;
     }
     
     public Message(String name,String content,int telephone,String email){
    	 this.name=name;
         this.content=content;
         this.telephone=telephone;
         this.email=email;
     }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
     
}

