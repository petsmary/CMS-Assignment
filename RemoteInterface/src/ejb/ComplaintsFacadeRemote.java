/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Complaints;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author MingWai
 */
@Remote
public interface ComplaintsFacadeRemote {

    void create(Complaints complaints);

    void edit(Complaints complaints);

    void remove(Complaints complaints);

    Complaints find(Object id);

    List<Complaints> findAll();

    List<Complaints> findRange(int[] range);

    int count();
    
}
