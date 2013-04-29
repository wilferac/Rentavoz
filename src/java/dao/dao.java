/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 * Esta clase es un modelo de los metedos que debo implementar en cada uno de
 * los dao.
 *
 * @author wilferac
 */
public interface dao
{

    /**
     * obtiene un registro del tipo dao implementado
     *
     * @return
     */
    public Object getOne(int id);

    public List<Object> getAll();

    public void insert(Object obj) throws Exception;

    public void update(Object obj) throws Exception;
    //TODO implementar la funcion de borrar en cada dao
    public void delete(Object obj) throws Exception;
}
