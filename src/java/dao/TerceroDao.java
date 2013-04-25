/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashSet;
import java.util.Set;
import model.Rol;
import model.Roles;
import model.Tercero;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author inovate
 */
public class TerceroDao
{

    /**
     * buscar un tercero con otro como filtro, tambien busca los perfiles de
     * dicho tercero
     *
     * @param ter
     * @return
     */
    public Tercero buscarPorTercero(Tercero ter)
    {
        System.out.println(ter.getTerDocumento() + " cons su madre " + ter.getTerClave());
        Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select t from Tercero t where terDocumento=:documento and terClave=:clave";



        Query que = se.createQuery(sql);
        que.setInteger("documento", ter.getTerDocumento());
        que.setString("clave", ter.getTerClave());
        ter = (Tercero) que.uniqueResult();
        if (ter != null)
        {
            ter.getRoleses();
        }

        return ter;
    }

    public void insertar(Tercero ter) throws Exception
    {
        Session se = HibernateUtil.getSessionFactory().openSession();
        try
        {
            se.beginTransaction();
            se.save(ter);
            se.beginTransaction().commit();
            se.close();
        } catch (HibernateException e)
        {
            se.beginTransaction().rollback();
            se.close();
//            e.printStacktrace();
            System.err.println("Error al Insertar Tercero: " + e.getMessage());
            throw new Exception("Error al Insertar intente con otro numero de documento");
            //System.out.println("Error al Insertar: " + e.getMessage());
        }
        
    }
}
