package spring.songs.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import spring.songs.Model.Song;
import spring.songs.Model.SongDataLoader;

@Component
public class SongService {
  List<Song> allSongs = SongDataLoader.allSongs;

  public int getNumberOfSongs(){
    return allSongs.size();
  }

  public Song getRandomSong(){
    Random rand = new Random();
    return allSongs.get(rand.nextInt(allSongs.size()));
  }

  public Song getSongById(int id) {
    return allSongs.stream()
        .filter(song -> matchId(song, id))
        .findAny()
        .orElse(null);
    //Todo: Should have warning for no such Id?
  }

  public Song updateSongById(int id, Map<String, String> body) {
    int indexOfSong = allSongs.stream()
        .map(song -> song.getId())
        .collect(Collectors.toList())
        .indexOf(id);
    if (indexOfSong != -1){
      return updateSong(indexOfSong, body);
    }
    return null;
  }

  private Song updateSong(int index, Map<String, String> body) {
    Song song = allSongs.get(index);
    if(body.containsKey("artistName")){
      song.setArtistName(body.get("artistName"));
    }
    if(body.containsKey("link")){
      song.setLink(body.get("link"));
    }
    allSongs.set(index, song);
    return song;
  }

  private boolean matchId(Song song, int id) {
    return (song.getId() == id);
  }

}
