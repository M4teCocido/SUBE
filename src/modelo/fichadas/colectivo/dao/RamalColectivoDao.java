package modelo.fichadas.colectivo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import modelo.fichadas.colectivo.RamalColectivo;

public class RamalColectivoDao {
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
	
	public int agregarRamal(RamalColectivo ramal) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(ramal).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void modificarRamal(RamalColectivo ramal) {
		try {
			iniciaOperacion();
			session.update(ramal);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminarRamal(RamalColectivo ramal) {
		try {
			iniciaOperacion();
			session.delete(ramal);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public RamalColectivo traerRamal(int idRamal) throws HibernateException {
		RamalColectivo ramal = null;
		try {
			iniciaOperacion();
			ramal = (RamalColectivo) session.get(RamalColectivo.class, idRamal);
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return ramal;
	}
	
	@SuppressWarnings("unchecked")
	public List<RamalColectivo> traerRamales() throws HibernateException {
		List<RamalColectivo> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from RamalColectivo r order by r.idRamal asc").list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return lista;
	}
}
