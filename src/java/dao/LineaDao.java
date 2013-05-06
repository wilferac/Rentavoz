/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Linea;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author inovate
 */
public class LineaDao
{

    Session se;

    public LineaDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }

    public void cerrar()
    {
        se.close();
    }

    public Linea getOne(int id)
    {
        System.out.println(" buscando uno " + id);
        // Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select l from Linea l where idLinea=:id";
        Query que = se.createQuery(sql);
        que.setInteger("id", id);
        Linea obj = (Linea) que.uniqueResult();
        //  se.close();
        return obj;
    }

    public List<Linea> getAll()
    {
        Query que = se.createQuery("from Linea");
        return que.list();
    }
    
    public List<Linea> getFreeLines()
    {
        Query que = se.createQuery("FROM Linea as l WHERE NOT EXISTS (FROM Simcard as s WHERE s.linea = l AND s.simEstado = 1)");
        return que.list();
    }

    public void insert(Linea obj) throws Exception
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
            System.err.println("Error al Insertar Linea: " + e.getMessage());
            throw new Exception("Error al Insertar Linea" + e.getMessage());
        }
    }

    public void update(Linea obj) throws Exception
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
            System.err.println("Error al actualizar Linea: " + e.getMessage());
            throw new Exception("Error al actualizar Linea" + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void delete(Linea obj)throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
