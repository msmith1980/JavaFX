/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Model.dataAccess;

import java.util.List;

/**
 *
 * @author Mark
 */
public interface IRepository<T> {
    
    List<T> getAllItems();
}
