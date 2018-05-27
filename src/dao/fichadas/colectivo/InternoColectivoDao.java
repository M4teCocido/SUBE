package dao.fichadas.colectivo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import modelo.fichadas.colectivo.InternoColectivo;

public class InternoColectivoDao {

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
	
	public int agregarTramo(InternoColectivo interno) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(interno).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void modificarTramo(InternoColectivo interno) {
		try {
			iniciaOperacion();
			session.update(interno);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminarTramo(InternoColectivo interno) {
		try {
			iniciaOperacion();
			session.delete(interno);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public InternoColectivo traerTramo(int idtramo) throws HibernateException {
		InternoColectivo interno = null;
		try {
			iniciaOperacion();
			interno = (InternoColectivo) session.get(InternoColectivo.class, idtramo);
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return interno;
	}
	
	@SuppressWarnings("unchecked")
	public List<InternoColectivo> traerTramos() throws HibernateException {
		List<InternoColectivo> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from InternoColectivo t order by t.idTramo asc").list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return lista;
	}
	
}
