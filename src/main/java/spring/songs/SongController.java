package spring.songs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {
  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Songs Boot!";
  }
}
