/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.EstadoLinea;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author inovate
 */
public class EstadoLineaDao
{

    Session se;

    public EstadoLineaDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }

    public void cerrar()
    {
        se.close();
    }

    public EstadoLinea getOne(int id)
    {
        System.out.println(" buscando uno " + id);
        // Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select e from EstadoLinea e where idEstadoLinea=:id";
        Query que = se.createQuery(sql);
        que.setInteger("id", id);
        EstadoLinea obj = (EstadoLinea) que.uniqueResult();
        //  se.close();
        return obj;
    }

    public List<EstadoLinea> getAll()
    {
        Query que = se.createQuery("from EstadoLinea");
        return que.list();
    }

    public void insert(EstadoLinea obj) throws Exception
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
            System.err.println("Error al Insertar EstadoLinea: " + e.getMessage());
            throw new Exception("Error al Insertar EstadoLinea" + e.getMessage());
        }
    }

    public void update(EstadoLinea obj) throws Exception
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
            System.err.println("Error al actualizar EstadoLinea: " + e.getMessage());
            throw new Exception("Error al actualizar EstadoLinea" + e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }

    public void delete(EstadoLinea obj) throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
