import java.util.ArrayList;
//class that hooks up to interface
public class AlbumPage {
	ArrayList<Album> albumList;
	int pageNumber;
	
	public AlbumPage(ArrayList<Album> albumList, int pageNumber){
		this.albumList = albumList;
		this.pageNumber = pageNumber;
	}
}
