/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4.states;

import clase4.Icon;
import clase4.Song;
import clase4.State;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author leon
 */
public class Trend implements State {

    @Override
    public void toBooom(Song song) {
        System.out.println("NOPE");
               }

    @Override
    public void toRegular(Song song) {
        //si paso mas de un dia(comparar fechas) vuevle a regular
        
        Date fechaActual = new Date();
        
        /*if (song.getLastView()) LocalDate.now() {
            song.setState(new Regular());
            song.setIcon(Icon.MUSICAL_NOTE);
            song.setCaption(song.getArtistName() + " - "
                    + song.getAlbumName() + " - " + song.getTitle());
        }*/
        
        //TimeUnit.MILLISECONDS.toHours(fechaActual.getTime() - fechaPasada.getTime());

    }

    @Override
    public void toTrend(Song song) {
        System.out.println("NOPE");
    }

}
