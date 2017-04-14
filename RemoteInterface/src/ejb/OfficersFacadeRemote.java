/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Officers;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author MingWai
 */
@Remote
public interface OfficersFacadeRemote {

    void create(Officers officers);

    void edit(Officers officers);

    void remove(Officers officers);

    Officers find(Object id);

    List<Officers> findAll();

    List<Officers> findRange(int[] range);

    int count();
    
}
