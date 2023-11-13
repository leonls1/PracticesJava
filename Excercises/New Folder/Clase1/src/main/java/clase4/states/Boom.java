/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4.states;

import clase4.Icon;
import clase4.Song;
import clase4.State;

/**
 *
 * @author leon
 */
public class Boom implements State {

    @Override
    public void toBooom(Song song) {
        System.out.println("NOPE");
    }

    @Override
    public void toRegular(Song song) {
        if (song.getDislikes() > 4999) {
            song.setState(new Regular());
            song.setIcon(Icon.MUSICAL_NOTE);
            song.setCaption(song.getArtistName() + " - "
                    + song.getAlbumName() + " - " + song.getTitle());

        }
    }

    @Override
    public void toTrend(Song song) {
        if (song.getTotalViews() > 50000 && song.getLikes() > 20000) {
            song.setState(new Trend());
            song.setIcon(Icon.FIRE);
            song.setCaption(song.getTitle() + " - " + song.getArtistName()
                    + "(" + song.getAlbumName() + "-" + song.getAlbumYear() + ")");
        }
    }

}
