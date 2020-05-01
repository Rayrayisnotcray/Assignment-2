//Raymond Xu
//23396897

import java.io.*;
import java.util.*;

public class A2musicPlaylist {

	public static void main(String[] args) {
		
		ArrayList<String> weekMusicList = new ArrayList<String>();
		
		playlist VIPplaylist = new playlist();
		songHistoryList historyList = new songHistoryList();
		
		String week1 = "data\\regional-global-weekly-2020-01-17--2020-01-24.csv";
		String week2 = "data\\\\regional-global-weekly-2020-01-24--2020-01-31.csv";
		String week3 = "data\\\\regional-global-weekly-2020-01-31--2020-02-07.csv";
		String[] weeksOfMusic = new String[] {week1, week2, week3};
		
		//Merges all files into one array
		for(String week: weeksOfMusic) {	
			try(BufferedReader br = new BufferedReader(new FileReader(new File(week)))){
				br.readLine(); 							//ignores first line 
				br.readLine(); 							//ignores second line
				String data = "";
				while((data = br.readLine()) != null) {		
					String [] Node = data.split(",");
					String tempTrack = Node[1];
					String tempArtist = Node[2];
					
					//gets rid of extra quotation marks on tracks if any are present
					if(Character.isLetter(tempTrack.charAt(0)) == false)
						tempTrack = tempTrack.substring(1, tempTrack.length()-1);	
					
					//gets rid of extra quotation marks on artist is any are present
					if(Character.isLetter(tempArtist.charAt(0)) == false)
						tempArtist = tempArtist.substring(1, tempArtist.length()-1);	
					
					String temp = tempTrack + " by " + tempArtist;
						int result = search(weekMusicList, temp);
						
						if(result == -1) 
							weekMusicList.add(temp);						
				}
						
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Initial print of unsorted arraylist
		//System.out.println(print(weekMusicList)); 
		
		//Adds tracks to a sorted Linkedlist 
		for(String s:weekMusicList)
			VIPplaylist.addSong(s);
		
		//test runs
		VIPplaylist.displayList();	//full playlist
		
		historyList.display();		//empty history
		
		displayLastListened(historyList);	//no last listened to
		
		listenToSong(VIPplaylist, historyList);	// add 1st track to historylist
		
		historyList.display();
		
		listenToSong(VIPplaylist, historyList);	// add 2st track to historylist
		
		listenToSong(VIPplaylist, historyList); // add 3st track to historylist
		
		listenToSong(VIPplaylist, historyList); // add 4st track to historylist
		
		VIPplaylist.displayList();		//display playlist with first four songs missing
		
		historyList.display();		//historylist should have 4 songs
		
		displayLastListened(historyList);	//prints last listened to song
		
	}
	public static int search(ArrayList<String> array, String value) {
		for(int i = 0; i < array.size() ; i++) {
			String temp = array.get(i);
			if(temp.equalsIgnoreCase(value))
				return i;
			
		}
		return -1;
	}
	
	public static String print(ArrayList<String> array) {
		String result ="";
		for(int i = 0; i < array.size(); i++)
			result += array.get(i) + "\n";
		return result;
	}
	
	public static void listenToSong(playlist VIP, songHistoryList hL) {
		hL.addSong(VIP.listenToSong());
	}
		
	public static void displayLastListened(songHistoryList hL) {
		System.out.println("Last listened to track is: ");
		System.out.println(hL.lastTrackName() + "\n");
	}
}