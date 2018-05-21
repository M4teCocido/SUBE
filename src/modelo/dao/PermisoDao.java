package modelo.dao;


import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import modelo.Permiso;

public class PermisoDao {

	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();	
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos" , he);
	}
	
	public int agregarPermiso(Permiso permiso) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(permiso).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void modificarPermiso(Permiso permiso) {
		try {
			iniciaOperacion();
			session.update(permiso);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminarPermiso(Permiso permiso) {
		try {
			iniciaOperacion();
			session.delete(permiso);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Permiso traerPermiso(int idPermiso) throws HibernateException {
		Permiso permiso = null;
		try {
			iniciaOperacion();
			permiso = (Permiso) session.get(Permiso.class, idPermiso);
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return permiso;
	}
	
	public Permiso traerPermiso(String nombre) throws HibernateException {
		Permiso permiso = null;
		try {
			iniciaOperacion();
			permiso = (Permiso) session.get(Permiso.class, nombre);
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return permiso;
	}
	
	@SuppressWarnings("unchecked")
	public List<Permiso> traerPermiso() throws HibernateException {
		List<Permiso> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Permiso p order by p.idPermiso asc").list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return lista;
	}
}
