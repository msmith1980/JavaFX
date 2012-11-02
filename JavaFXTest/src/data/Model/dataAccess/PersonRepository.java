/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Model.dataAccess;

import data.Model.Person;
import java.util.List;

/**
 *
 * @author Mark
 */
public class PersonRepository implements IRepository<Person>{
    
    public PersonRepository()
    {
        
    }
    

    @Override
    public List<Person> getAllItems() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
