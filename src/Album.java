import java.util.ArrayList;

public class Album {
	ArrayList<Song> songs;
	String title;
	Artist artistObj;
	
	public Album(ArrayList<Song> songs, String title){
		this.songs = songs;
		this.title = title;
	}
	
	public void setArtist(Artist artistObj){
		this.artistObj = artistObj;
		for(Song a : songs){
			a.setArtist(artistObj);
		}
	}
}
