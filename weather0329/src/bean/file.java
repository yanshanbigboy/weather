package bean;

public class file{
	private String fileName;
	private String realFileName;
	private String fileMess;
	private String fileURL;	
	private float fileSize;
	public file(){
		
	}
	public file(String fileName,String realFileName,String fileMess,String fileURL,float fileSize){
		this.fileName=fileName;
		this.realFileName=realFileName;
		this.fileMess=fileMess;
		this.fileURL=fileURL;
		this.fileSize=fileSize;
	}
	public file(String fileName,String realFileName,String fileMess,String fileURL){
		this.fileName=fileName;
		this.realFileName=realFileName;
		this.fileMess=fileMess;
		this.fileURL=fileURL;
	}
	public file(String fileName,String fileMess,String fileURL){
		this.fileName=fileName;
		this.fileMess=fileMess;
		this.fileURL=fileURL;
	}
	public String getRealFileName(){
		return realFileName;
	}
	public void setRealFileName(String realFileName){
		this.realFileName=realFileName;
	}
	 public String getFileName(){
		 return fileName;
	 }
	 public void setFileName(String fileName){
		 this.fileName=fileName;
	 }
	 public String getFileMess(){
		 return fileMess;
	 }
	 public void setFileMess(String fileMess){
		 this.fileMess=fileMess;
	 }
	 public String getFileURL(){
		 return fileURL;
	 }
	 public void setFileURL(String fileURL){
		 this.fileURL=fileURL;
	 }
	 public float getFileSize(){
		 return fileSize;
	 }
	 public void setFileSize(float fileSize){
		 this.fileSize=fileSize;
	 }
}