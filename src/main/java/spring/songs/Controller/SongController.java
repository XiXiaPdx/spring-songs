package spring.songs.Controller;


import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.songs.Model.Song;
import spring.songs.Service.SongService;


@RestController
public class SongController {

  SongService service = new SongService();

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Songs Boot!";
  }

  @GetMapping("/numberOfSongs")
  public int numberOfSongs() {
    return service.getNumberOfSongs();
  }

  @GetMapping("/random")
  public Song randomSong() {
    return service.getRandomSong();
  }

  @GetMapping("/song/{id}")
  public Song songById(@PathVariable int id){
    return service.getSongById(id);
  }

  @PutMapping("/song/{id}")
  public Song updateSongById(@PathVariable int id, @RequestBody Map<String, String> body){
    return service.updateSongById(id, body);
  }

}
