package spring.songs.Model;

public class Song {

  private final String artistName;
  private final String songName;
  private String link;
  private String lyrics;

  @Override
  public String toString() {
    return "Song{" +
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
  }

  public String getArtistName() {
    return artistName;
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

  public void setLyrics(String lyrics) {
    this.lyrics = lyrics;
  }
}
