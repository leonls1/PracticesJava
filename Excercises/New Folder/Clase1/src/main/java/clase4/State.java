/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clase4;

/**
 *
 * @author leon
 */
public interface State {
    
    public void toBooom(Song song);
    
    public void toRegular(Song song);
    
    public void toTrend(Song song);
}
