/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4.states;

import clase4.Icon;
import clase4.Song;

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

        }else{
            System.out.println("Requeriments aren't satisfaced");
        }
    }

    @Override
    public void toRegular(Song song) {
        System.out.println("NOOO, you are right now in regular");
    }

    @Override
    public void toTrend(Song song) {
        if (song.getTotalViews() > 50000 && song.getLikes() > 20000) {
            song.setState(new Trend());
            song.setIcon(Icon.FIRE);
            song.setCaption(song.getTitle() + " - " + song.getArtistName()
                    + "(" + song.getAlbumName() + "-" + song.getAlbumYear() + ")");
        }else{
            System.out.println("Some requirements aren't satisfaced");
        }
        
    }

}
