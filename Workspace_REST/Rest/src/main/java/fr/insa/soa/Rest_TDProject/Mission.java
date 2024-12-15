package fr.insa.soa.Rest_TDProject;
public class Mission {
	
	private String title ; 
	
	private String content ; 
	
	private int status ; 
	
	private int Id ;
	private int Id_Helper;
	private int Id_Asking;
	
	

	public int getId_Helper() {
		return Id_Helper;
	}



	public void setId_Helper(int id_Helper) {
		Id_Helper = id_Helper;
	}



	public int getId_Asking() {
		return Id_Asking;
	}



	public void setId_Asking(int iD_Asking) {
		Id_Asking = iD_Asking;
	}



	public Mission() {
		super();
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public Mission(int missionid, String title, String content, int status, int Id_Asking,int Id_Helper) {
		this.Id=missionid;
		this.title = title;
		this.content = content;
		this.status = status;
		this.Id_Asking= Id_Asking;
		this.Id_Helper = Id_Helper;
	}


}
