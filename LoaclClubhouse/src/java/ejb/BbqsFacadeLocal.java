/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Bbqs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MingWai
 */
@Local
public interface BbqsFacadeLocal {

    void create(Bbqs bbqs);

    void edit(Bbqs bbqs);

    void remove(Bbqs bbqs);

    Bbqs find(Object id);

    List<Bbqs> findAll();

    List<Bbqs> findRange(int[] range);

    int count();
    
}
