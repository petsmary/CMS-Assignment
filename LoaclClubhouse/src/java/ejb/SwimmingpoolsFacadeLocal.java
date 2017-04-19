/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Swimmingpools;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MingWai
 */
@Local
public interface SwimmingpoolsFacadeLocal {

    void create(Swimmingpools swimmingpools);

    void edit(Swimmingpools swimmingpools);

    void remove(Swimmingpools swimmingpools);

    Swimmingpools find(Object id);

    List<Swimmingpools> findAll();

    List<Swimmingpools> findRange(int[] range);

    int count();
    
}
