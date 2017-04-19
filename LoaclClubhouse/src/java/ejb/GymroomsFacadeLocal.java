/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Gymrooms;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MingWai
 */
@Local
public interface GymroomsFacadeLocal {

    void create(Gymrooms gymrooms);

    void edit(Gymrooms gymrooms);

    void remove(Gymrooms gymrooms);

    Gymrooms find(Object id);

    List<Gymrooms> findAll();

    List<Gymrooms> findRange(int[] range);

    int count();
    
}
