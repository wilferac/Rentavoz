/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cuentas;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wilferac
 */
public class CuentasDao
{
    Session se;

    public CuentasDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession()
    {
        se.close();
    }

    public Cuentas getOne(int id)
    {
        System.out.println(" buscando uno " + id);
        // Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select e from Cuentas e where idCuentas=:id";
        Query que = se.createQuery(sql);
        que.setInteger("id", id);
        Cuentas obj = (Cuentas) que.uniqueResult();
        //  se.close();
        return obj;
    }

    public List<Cuentas> getAll()
    {
        Query que = se.createQuery("from Cuentas");
        return que.list();
    }

    public void insert(Cuentas obj) throws Exception
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
            System.err.println("Error al Insertar Cuentas: " + e.getMessage());
            throw new Exception("Error al Insertar Cuentas" + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void update(Cuentas obj) throws Exception
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
            System.err.println("Error al actualizar Cuentas: " + e.getMessage());
            throw new Exception("Error al Cuentas " + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void delete(Cuentas obj) throws Exception
    {
    }
}
