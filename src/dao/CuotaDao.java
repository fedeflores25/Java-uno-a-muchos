package dao;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.Cuota;
import datos.Prestamo;

public class CuotaDao {

	//atributos
	private static Session session;
	private Transaction tx;

	//inicia la conexion con la bd
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	//este metodo maneja la exception, si ocurre un error durante la carga vuelve para atras a toda la carga que se hizo para no generar errores cuando se intente cargar en otro momento.
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}	
	
	
	public int agregar(Cuota objeto) {
		int id = 0;
		try {
		iniciaOperacion();
		id = Integer.parseInt(session.save(objeto).toString());
		tx.commit();
		} catch (HibernateException he) {
		manejaExcepcion(he);
		throw he;
		} finally {
		session.close();
		}
		return id;
		}
	
	
	
	
	public Cuota traer(long idCuota) throws HibernateException {
		Cuota obj = null;
		try {
		iniciaOperacion();
		String hQL = "from Cuota c inner join fetch c.prestamo c where c.idCuota=" + idCuota;
		obj = (Cuota) session.createQuery(hQL).uniqueResult();
		} finally {
		session.close();
		}
		return obj;
		}
	
	@SuppressWarnings("unchecked")
	public List<Cuota> traer(Prestamo p) throws HibernateException {
		List<Cuota> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Cuota c inner join fetch c.prestamo p where p.idPrestamo=" + p.getIdPrestamo();
			lista = session.createQuery(hQL).list();
		} finally {
			session.close();
		}
		return lista;
		}
	
	
	public void actualizar(Cuota objeto) throws HibernateException {
		try {
		iniciaOperacion();
		session.update(objeto);
		tx.commit();
		} catch (HibernateException he) {
		manejaExcepcion(he);
		throw he;
		} finally {
		session.close();
		}
		}
	
	public void eliminar(Cuota objeto) throws HibernateException {
		try {
		iniciaOperacion();
		session.delete(objeto);
		tx.commit();
		} catch (HibernateException he) {
		manejaExcepcion(he);
		throw he;
		} finally {
		session.close();
		}
		}
	
	
	
	
	
	
}//fin DAO
