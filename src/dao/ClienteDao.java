package dao;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;



public class ClienteDao {

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

//agregar cliente
public int agregar(Cliente objeto) {
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
//actualizar cliente
public void actualizar(Cliente objeto) throws HibernateException {
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
//eliminar cliente
public void eliminar(Cliente objeto) throws HibernateException {
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


public void eliminarClientePrestamosYCuotas(Cliente objeto)throws HibernateException{
	try {
		iniciaOperacion();
		for(Prestamo p: objeto.getPrestamos()) {
				session.delete(p);
		}
		
		session.delete(objeto);
		tx.commit();
		
		
}catch(HibernateException he) {
manejaExcepcion(he);
throw he;
}finally {
	session.close();
}
}

//traer cliente por id
public Cliente traer(long idCliente) throws HibernateException {
Cliente objeto = null;
try {
iniciaOperacion();
objeto = (Cliente) session.get(Cliente.class, idCliente);
} finally {
session.close();
}
return objeto;
}
//traer cliente por dni
public Cliente traer(int dni) throws HibernateException {
Cliente objeto = null;
try {
iniciaOperacion();
objeto = (Cliente) session.createQuery("from Cliente c where c.dni="+ dni).uniqueResult();
} finally {
session.close();
}
return objeto;
}

//trae todos los clientes de la bd
@SuppressWarnings("unchecked")
public List<Cliente> traer() throws HibernateException {
List<Cliente> lista = null;
try {
iniciaOperacion();
lista = session.createQuery("from Cliente c order by c.apellido asc, c.nombre asc").list();
} finally {
session.close();
}
return lista;
}

//trae un cliente con su prestamo por id

public Cliente traerClienteYPrestamos(long idCliente) throws HibernateException {
Cliente objeto = null;
try {
iniciaOperacion();
String hql="from Cliente c where c.idCliente ="+idCliente;
objeto=(Cliente) session.createQuery(hql).uniqueResult();
Hibernate.initialize(objeto.getPrestamos());

}
finally {
session.close();
}
return objeto;
}





}