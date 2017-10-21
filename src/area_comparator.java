
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gellert_Zelenak
 */
public class area_comparator implements Comparator<item>{

    @Override
    public int compare(item t, item t1) {
        return Integer.compare(t.height*t.width, t1.height*t1.width);
    }
    
}
