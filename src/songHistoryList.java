
public class songHistoryList {
	private Song last;
	
	songHistoryList() {
		last = null;
	}
	songHistoryList(Song l)
	{
		last = l;
	}
	public void addSong(Song temp) {
		if(last == null) {
			last = temp;
			last.setNext(null);
		}
		else {
			temp.setNext(last);
			last = temp;
		}
	}
	
	public String lastTrackName() {
		if(!isEmpty())
			return last.getTrack();
		else 
			return "No track history.";
		
	}
	public boolean isEmpty() {
		return last == null;
	}
	
	public void display() {
		Song temp = last;
		
		if(temp == null)
			System.out.println("History list is empty");
		else {
			System.out.println("History list: ");
			while(temp != null) {
				System.out.println(temp.getTrack());
				temp = temp.getNext();
				//temp.setNext(temp.getNext());
			}
		}
			
		
		System.out.println();
	}
	
	
}

