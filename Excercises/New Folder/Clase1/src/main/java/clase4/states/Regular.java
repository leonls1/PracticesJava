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
public class Regular implements State {

    @Override
    public void toBooom(Song song) {
        if (song.getTotalViews() > 1000) {
            song.setState(new Boom());
            song.setIcon(Icon.ROCKET);
            song.setCaption(song.getArtistName() + "-"
                    + song.getTitle() + "("
                    + song.getAlbumName() + "-"
                    + song.getAlbumYear() + ")");

        }
    }

    @Override
    public void toRegular(Song song) {
        System.out.println("NOOO, you are right now in regular");
    }

    @Override
    public void toTrend(Song song) {
        System.out.println("you can't, need to be in boom state first");
    }

}
