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
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author inovate
 */
public class TerceroDao {
    
    /**
     * buscar un tercero con otro como filtro, tambien busca los perfiles de dicho tercero
     * @param ter
     * @return 
     */
    public Tercero buscarPorTercero(Tercero ter)
    {
        System.out.println(ter.getTerDocumento()+" cons su madre "+ter.getTerClave());
        Session se= HibernateUtil.getSessionFactory().openSession();
        String sql="select t from Tercero t where terDocumento=:documento and terClave=:clave";
        
        
        
        Query que= se.createQuery(sql);
        que.setInteger("documento", ter.getTerDocumento());
        que.setString("clave", ter.getTerClave());
        ter= (Tercero) que.uniqueResult();
        if(ter != null)
        {
            ter.getRoleses();
        }
        
        
        
//        from Cat as cat
//    inner join cat.mate as mate
//    left outer join cat.kittens as kitten
        
//        String sql2="select rl FROM Roles rl INNER JOIN rl.tercero t WHERE t.idTecero =:idTer";
//        
//        Query que2= se.createQuery(sql2);
//        que2.setInteger("idTer", ter.getIdTecero());
//        Set<Roles> setRoles=  new HashSet(que2.list());
//        ter.setRoleses(setRoles);
        return ter;
    }

    
}
