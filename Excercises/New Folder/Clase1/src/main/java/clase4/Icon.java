/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase4;

/**
 *
 * @author leon
 */
public class Icon {

    public static Icon MUSICAL_NOTE = new Icon(new int[]{0xD83C, 0xDFB5});
    public static Icon ROCKET = new Icon(new int[]{0xD83D, 0xDE80});
    public static Icon FIRE = new Icon(new int[]{0xD83D, 0xDD25});
    private int[] internalEncoding;

    Icon(int[] internalEncoding) {
        this.internalEncoding = internalEncoding;
    }

    public String texto() {
        return new String(internalEncoding, 0, internalEncoding.length);
    }
}
