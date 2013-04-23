/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Tercero;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author inovate
 */
public class TerceroDao {
    
    
    public Tercero buscarPorTercero(Tercero ter)
    {
        Session se= HibernateUtil.getSessionFactory().openSession();
        String sql="select t from Tercero t where terDocumento=:documento and terClave=:clave";
        Query que= se.createQuery(sql);
        que.setInteger("documento", ter.getTerDocumento());
        que.setString("clave", ter.getTerClave());
        return (Tercero) que.uniqueResult();
    }
    
}
