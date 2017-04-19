/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Studyrooms;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MingWai
 */
@Local
public interface StudyroomsFacadeLocal {

    void create(Studyrooms studyrooms);

    void edit(Studyrooms studyrooms);

    void remove(Studyrooms studyrooms);

    Studyrooms find(Object id);

    List<Studyrooms> findAll();

    List<Studyrooms> findRange(int[] range);

    int count();
    
}
