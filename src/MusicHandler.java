import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MusicHandler {
	private class genericMP3PlayerObj{
		private Song currSong;
		private boolean playingStatus;
		
		public genericMP3PlayerObj(Song n){
			//... takes Song and sets up to read the file
			this.currSong = n;
		}
		public void Pause(){
			//...	
		}
		
		public void Play(){
			//... reads in file as fast as possible and plays what has been read in, as it is reading. too large for scope of question
		}
		
		public Song getCurrSong(){
			return currSong;
		}
		
		public boolean getPlayingStatus(){
			return playingStatus;
		}
		
	}
	
	private HashMap<String, Artist> artists;
	private HashMap<String, Song> songs;
	private HashMap<String, Album> albums;
	
	private ArrayList<AlbumPage> albumPages;
	
	private genericMP3PlayerObj playing;
	
	private Queue<Song> upNext = new LinkedList<Song>();
	
	public MusicHandler(){
		//takes a bunch of additional files, reads them in, constructs songs first, then albums, then artists
		//which assigns artist field to the two previous things, then constructs all albumPages based on list of all albums, using sorted arraylist

	}
	//returns currently playing song
	public Song skip(){
		Song next = upNext.remove();
		genericMP3PlayerObj upNext = new genericMP3PlayerObj(next);
		Song curr = playing.getCurrSong();
		playing = upNext;
		play();
		return curr;
	}

	public void play() {
		if(!playing.getPlayingStatus()){
			playing.Play();
		}
	}
	
	public void pause(){
		if(playing.getPlayingStatus()){
			playing.Pause();
		}
	}
	
	public void stop(){
		playing = null;
	}
}
