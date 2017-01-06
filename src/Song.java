
public class Song {
	private String fileName;
	private String title;
	private int length;
	private Artist artistObj;
	
	public Song(String fileName, String title, int length){
		this.fileName = fileName;
		this.title = title;
		
		//could also be handled by scanning each file as it's created; this assumes this has done before being fed into the JukeBox
		this.length = length;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getLength(){
		return length;
	}
	
	public void setArtist(Artist artistObj){
		this.artistObj = artistObj;
	}
}
