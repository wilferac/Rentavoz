/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Ciudad;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wilferac
 */
public class CiudadDao
{

    Session se;

    public CiudadDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession()
    {
        se.close();
    }


    public List<Ciudad> getAll()
    {
        Query que = se.createQuery("from Ciudad");
        return que.list();
    }


}
