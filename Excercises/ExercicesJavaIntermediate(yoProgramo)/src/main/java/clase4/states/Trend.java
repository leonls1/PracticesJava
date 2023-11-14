/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4.states;

import clase4.Icon;
import clase4.Song;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
        
        Date actualDate = new Date();
        
        if ((TimeUnit.MILLISECONDS.toHours(actualDate.getTime()) - 
                TimeUnit.MILLISECONDS.toHours(song.getLastView().getTime())) > 23)  {
            song.setState(new Regular());
            song.setIcon(Icon.MUSICAL_NOTE);
            song.setCaption(song.getArtistName() + " - "
                    + song.getAlbumName() + " - " + song.getTitle());
        }
        
        //TimeUnit.MILLISECONDS.toHours(fechaActual.getTime() - fechaPasada.getTime());

    }

    @Override
    public void toTrend(Song song) {
        System.out.println("NOPE");
    }

}
