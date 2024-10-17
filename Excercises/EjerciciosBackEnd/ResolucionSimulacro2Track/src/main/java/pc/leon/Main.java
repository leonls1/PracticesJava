package pc.leon;

import pc.leon.repositories.connection.DbContext;
import pc.leon.service.TrackService;

import java.io.IOException;

import java.net.URISyntaxException;
import java.nio.file.Path;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws URISyntaxException {

        Path path = Path.of(Main.class.getResource("/Tracks_Data.txt").toURI());

        DbContext context = DbContext.getInstance();
        TrackService service = new TrackService(context.getEm());

        service.loadTracks(path);
        System.out.println((service.totalTracksAndTotalDuration()));

        service.generateFileGenrePerTracks("ArchivoPunto3.txt");


        //punto 4
        service.getAlbumsInf();

        //punto 5
        service.saveAllTracks();


    }
}