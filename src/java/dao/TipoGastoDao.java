/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TipoGasto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wilferac
 */
public class TipoGastoDao
{

    Session se;

    public TipoGastoDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession()
    {
        se.close();
    }

    public TipoGasto getOne(int id)
    {
        System.out.println(" buscando uno " + id);
        // Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select e from TipoGasto e where idTipoGasto=:id";
        Query que = se.createQuery(sql);
        que.setInteger("id", id);
        TipoGasto obj = (TipoGasto) que.uniqueResult();
        //  se.close();
        return obj;
    }

    public List<TipoGasto> getAll()
    {
        Query que = se.createQuery("from TipoGasto");
        return que.list();
    }

    public void insert(TipoGasto obj) throws Exception
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
            System.err.println("Error al Insertar TipoGasto: " + e.getMessage());
            throw new Exception("Error al Insertar TipoGasto" + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void update(TipoGasto obj) throws Exception
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
            System.err.println("Error al actualizar TipoGasto: " + e.getMessage());
            throw new Exception("Error al TipoGasto " + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void delete(TipoGasto obj) throws Exception
    {
    }
}
