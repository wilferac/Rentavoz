/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Convenio;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author wilferac
 */
public class ConvenioDao
{

    Session se;

    public ConvenioDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession()
    {
        se.close();
    }

    public Convenio getOne(int id)
    {
        System.out.println(" buscando uno " + id);
        // Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select e from Convenio e where idConvenio=:id";
        Query que = se.createQuery(sql);
        que.setInteger("id", id);
        Convenio obj = (Convenio) que.uniqueResult();
        //  se.close();
        return obj;
    }

    public List<Convenio> getAll()
    {
        Query que = se.createQuery("from Convenio");
        return que.list();
    }

    public void insert(Convenio obj) throws Exception
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
            System.err.println("Error al Insertar Convenio: " + e.getMessage());
            throw new Exception("Error al Insertar Convenio" + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void update(Convenio obj) throws Exception
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
            System.err.println("Error al actualizar Convenio: " + e.getMessage());
            throw new Exception("Error al Convenio " + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void delete(Convenio obj) throws Exception
    {
    }
}
