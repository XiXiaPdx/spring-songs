package spring.songs.Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SongLoaderService {

  private final Logger logger = LoggerFactory.getLogger(SongLoaderService.class);
  private final Set<Song> allSongs = new HashSet<>();

  @PostConstruct
  private void loadSongs() {
    try {
      Reader in = new FileReader("src/main/resources/songdata.csv");
      logger.info("Loading Song Data...");
      Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader("Artist","Song","Link","Text").parse(in);
      for(CSVRecord record: records){
        Song song = new Song(record.get("Artist"), record.get("Song"),record.get("Link"),record.get("Text"));
        allSongs.add(song);
      }
      logger.info(allSongs.size() +" songs loaded.");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
