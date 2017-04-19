/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Saunarooms;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MingWai
 */
@Local
public interface SaunaroomsFacadeLocal {

    void create(Saunarooms saunarooms);

    void edit(Saunarooms saunarooms);

    void remove(Saunarooms saunarooms);

    Saunarooms find(Object id);

    List<Saunarooms> findAll();

    List<Saunarooms> findRange(int[] range);

    int count();
    
}
