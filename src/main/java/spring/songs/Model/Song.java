package spring.songs.Model;

public class Song {

  private int id;
  private String artistName;
  private final String songName;
  private String link;
  private final String lyrics;
  private static int songIdCounter = 0;

  @Override
  public String toString() {
    return "Song{" +
        ", id='" + id + "\"" +
        "artistName='" + artistName + '\'' +
        ", songName='" + songName + '\'' +
        ", link='" + link + '\'' +
        ", lyrics='" + lyrics + '\'' +
        '}';
  }

  public Song(String artistName, String songName, String link, String lyrics) {
    this.artistName = artistName;
    this.songName = songName;
    this.link = link;
    this.lyrics = lyrics;
    this.id = ++songIdCounter;
  }

  public String getArtistName() {
    return artistName;
  }

  public void setArtistName(String name){
    this.artistName = name;
  }

  public String getSongName() {
    return songName;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getLyrics() {
    return lyrics;
  }

  public int getId() {
    return id;
  }
}
