

public class playlist{
	
	private Song first;
	
	playlist() {
		first = null;
	}
	playlist(Song f) {
		first = f;
	}
	
	public void addSong(String t) {
		Song current;
		Song newSong = new Song(t);
		if(first==null || first.getTrack().compareToIgnoreCase(t) >= 0) {
			
			newSong.setNext(first);
			first = newSong;
		}
		else {
			current = first;
			
			while(current.getNext() != null && 
					current.getNext().getTrack().compareToIgnoreCase(t) < 0) 
				current = current.getNext();
			
			newSong.setNext(current.getNext());
			current.setNext(newSong);
		}
	}	
	
	public Song listenToSong() {	//removes first
		Song nextOnQueue = first;
		first = first.getNext();
		
		return nextOnQueue;
	}
	
	public void displayList() {
		Song temp = first;
		
		if(temp == null)
			System.out.println("Playlist is empty");
		else 
			while(temp != null) {
				System.out.println(temp.getTrack());
				temp = temp.getNext();
			}
		System.out.println();
	}
	
}


