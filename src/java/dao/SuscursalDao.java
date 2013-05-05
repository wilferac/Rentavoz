/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Sucursal;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wilferac
 */
public class SuscursalDao
{

    Session se;

    public SuscursalDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession()
    {
        se.close();
    }

    public Sucursal getOne(int id)
    {
        System.out.println(" buscando uno " + id);
        // Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select e from Sucursal e where idSucursal=:id";
        Query que = se.createQuery(sql);
        que.setInteger("id", id);
        Sucursal obj = (Sucursal) que.uniqueResult();
        //  se.close();
        return obj;
    }

    public List<Sucursal> getAll()
    {
        Query que = se.createQuery("from Sucursal");
        return que.list();
    }

    public void insert(Sucursal obj) throws Exception
    {
        try
        {
            se.beginTransaction();
            se.merge(obj);
            se.beginTransaction().commit();
            // se.close();
        } catch (HibernateException e)
        {
            se.beginTransaction().rollback();
            //  se.close();
//            e.printStacktrace();
            System.err.println("Error al Insertar Sucursal: " + e.getMessage());
            throw new Exception("Error al Insertar Sucursal" + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void update(Sucursal obj) throws Exception
    {
        try
        {
            se.beginTransaction();
            se.update(obj);
            se.beginTransaction().commit();
            //   se.close();
            System.out.println("se actualizo el registro");
        } catch (HibernateException e)
        {
            se.beginTransaction().rollback();
            //   se.close();
//            e.printStacktrace();
            System.err.println("Error al actualizar Sucursal: " + e.getMessage());
            throw new Exception("Error al Sucursal " + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void delete(Sucursal obj) throws Exception
    {
    }
}
