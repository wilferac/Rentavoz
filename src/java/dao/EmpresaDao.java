/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Empresa;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author inovate
 */
public class EmpresaDao
{
    Session se;
    
    public EmpresaDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void closeSession()
    {
        se.close();
    }
    
    
    public Empresa getOne(int id)
    {
        System.out.println(" buscando uno " + id);
       // Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select e from Empresa e where idEmpresa=:id";
        Query que = se.createQuery(sql);
        que.setInteger("id", id);
        Empresa obj = (Empresa) que.uniqueResult();
      //  se.close();
        return obj;
    }
    
    public void insertar(Empresa obj) throws Exception
    {
        try
        {
            se.beginTransaction();
            se.save(obj);
            se.beginTransaction().commit();
           // se.close();
        } catch (HibernateException e)
        {
            se.beginTransaction().rollback();
          //  se.close();
//            e.printStacktrace();
            System.err.println("Error al Insertar Tercero: " + e.getMessage());
            throw new Exception("Error al Insertar Empresa"+e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }
    
    public void actualizar(Empresa obj) throws Exception
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
            System.err.println("Error al actualizar Tercero: " + e.getMessage());
            throw new Exception("Error al actualizar "+e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
    }
    
    public List<Empresa> getAll()
    {
        Query que = se.createQuery("from Empresa");
        return que.list();
    }
}
