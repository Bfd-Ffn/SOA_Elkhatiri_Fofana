package fr.insa.soa.Rest_TDProject;
public class Mission {
	
	private String title ; 
	
	private String content ; 
	
	private int status ; 
	
	private int Id ;
	
	

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



	public Mission(int missionid, String title, String content, int status) {
		this.Id=missionid;
		this.title = title;
		this.content = content;
		this.status = status;
	}


}
