
public class Song {
	private String track;
	private Song next;

	Song() {
		track = "";
		next = null;
	}
	Song(String s){
		track = s;
		next = null;
	}
	Song(String s, Song n){
		track = s;
		next = n;
	}
	public String getTrack() {
		return track;
	}
	public Song getNext() {
		return next;
	}
	public void setNext(Song n) {
		next = n;
	}
	
	
}