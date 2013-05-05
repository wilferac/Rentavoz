/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TipoPago;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wilferac
 */
public class TipoPagoDao
{
    Session se;

    public TipoPagoDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession()
    {
        se.close();
    }

    public TipoPago getOne(int id)
    {
        System.out.println(" buscando uno " + id);
        // Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select e from TipoPago e where idTipoPago=:id";
        Query que = se.createQuery(sql);
        que.setInteger("id", id);
        TipoPago obj = (TipoPago) que.uniqueResult();
        //  se.close();
        return obj;
    }

    public List<TipoPago> getAll()
    {
        Query que = se.createQuery("from TipoPago");
        return que.list();
    }

    public void insert(TipoPago obj) throws Exception
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
            System.err.println("Error al Insertar TipoPago: " + e.getMessage());
            throw new Exception("Error al Insertar TipoPago" + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void update(TipoPago obj) throws Exception
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
            System.err.println("Error al actualizar TipoPago: " + e.getMessage());
            throw new Exception("Error al TipoPago " + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void delete(TipoPago obj) throws Exception
    {
    }
}
