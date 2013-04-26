/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashSet;
import java.util.List;
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

    Session se;
    public TerceroDao()
    {
        se = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void closeSession()
    {
        se.close();
    }

    
    
    
    /**
     * buscar un tercero con otro como filtro, tambien busca los perfiles de
     * dicho tercero
     *
     * @param ter Tercero
     * @return el tercero que se obtiene de la BD
     */
    public Tercero buscarPorTercero(Tercero ter)
    {
        //System.out.println(ter.getTerDocumento() + " cons su madre " + ter.getTerClave());
      //  Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select t from Tercero t where terDocumento=:documento and terClave=:clave";



        Query que = se.createQuery(sql);
        que.setInteger("documento", ter.getTerDocumento());
        que.setString("clave", ter.getTerClave());
        ter = (Tercero) que.uniqueResult();
       // se.close();
        if (ter != null)
        {
            ter.getRoleses();
        }

        return ter;
    }

    /**
     * obtiene un tercero de la Bd buscandolo por su id
     *
     * @param id int el identificador unico del tercero
     * @return retorna el tercero que coincide con el id
     */
    public Tercero getOne(int id)
    {
        System.out.println(" buscando uno " + id);
       // Session se = HibernateUtil.getSessionFactory().openSession();
        String sql = "select t from Tercero t where idTecero=:id";
        Query que = se.createQuery(sql);
        que.setInteger("id", id);
        Tercero ter = (Tercero) que.uniqueResult();
      //  se.close();
        return ter;
    }

    /**
     * inserta un tercero en la bd
     *
     * @param ter Tercero el tercero que sera insertado en la BD
     * @throws Exception lanza una execpcion en caso de fallar al momento de
     * insertar
     */
    public void insertar(Tercero ter) throws Exception
    {
      //  Session se = HibernateUtil.getSessionFactory().openSession();
        try
        {
            se.beginTransaction();
            se.save(ter);
            se.beginTransaction().commit();
           // se.close();
        } catch (HibernateException e)
        {
            se.beginTransaction().rollback();
          //  se.close();
//            e.printStacktrace();
            System.err.println("Error al Insertar Tercero: " + e.getMessage());
            throw new Exception("Error al Insertar intente con otro numero de documento");
            //System.out.println("Error al Insertar: " + e.getMessage());
        }

    }
    
    /**
     * actualiza un tercero en la bd
     *
     * @param ter Tercero el tercero que sera actualizado en la BD
     * @throws Exception lanza una execpcion en caso de fallar al momento de actualizar
     */
    public void actualizar(Tercero ter) throws Exception
    {
       // Session se = HibernateUtil.getSessionFactory().openSession();
        try
        {
            se.beginTransaction();
            se.update(ter);
            se.beginTransaction().commit();
         //   se.close();
            System.out.println("se actualizo el registro");
        } catch (HibernateException e)
        {
            se.beginTransaction().rollback();
         //   se.close();
//            e.printStacktrace();
            System.err.println("Error al actualizar Tercero: " + e.getMessage());
            throw new Exception("Error al azctualizar "+e.getMessage());
            //System.out.println("Error al Insertar: " + e.getMessage());
        }

    }

    /**
     * obtengo todos los tercero que estan en el sistema :D
     *
     * @return List<Tercero> retorna una lista con los terceros obtenidos
     */
    public List<Tercero> getAll()
    {
     //   Session se = HibernateUtil.getSessionFactory().openSession();
        Query que = se.createQuery("from Tercero");
        return que.list();
    }
}
