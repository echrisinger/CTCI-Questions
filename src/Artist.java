import java.util.ArrayList;

public class Artist {
	ArrayList<Album> albums = null;
	String name;
	
	public Artist(ArrayList<Album> albums, String name){
		this.albums = albums;
		this.name = name;
		for(Album a : albums){
			a.setArtist(this);
		}
	}
	
	public ArrayList<Album> getAlbums(){
		return albums;
	}
	
	public String getName(){
		return name;
	}
	
}

