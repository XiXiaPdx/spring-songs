package spring.songs.Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SongLoaderService {

  private static final Logger logger = LoggerFactory.getLogger(SongLoaderService.class);

  @PostConstruct
  private void loadSongs() {
    try {
      Reader in = new FileReader("src/main/resources/songdata.csv");
      logger.info("Loading Song Data...");
      Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader("Artist","Song","Link","Text").parse(in);
      for(CSVRecord record: records){
        //just to prove the data is loading as expected and can be accessed
//        System.out.printf("Artist: %s, Song: %s, Lyrics: %s",
//            record.get("Artist"), record.get("Song"), record.get("Link"));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
