package negocio;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.ClienteDao;
import datos.Cliente;
import datos.Prestamo;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao();
	
	//TRAER
	public Cliente traerId(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public List<Cliente> traer() {
		return dao.traer();
		}
	
	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
		}
	
	
	//AGREGAR
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento)throws Exception{
		if(dao.traer(dni)!=null)throw new Exception("Error: el cliente que quiere agregar ya se encuentra en la bd"+nombre+" "+dni);
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}

	
	//MODIFICAR
	public void modificar(Cliente c)throws Exception{	
		dao.actualizar(c);
	}

	
	//ELIMINAR
	public void eliminar(long idCliente)throws Exception{
		if(dao.traer(idCliente)==null)throw new Exception("Error: el cliente que se quiere eliminar no existe");
		if(dao.traerClienteYPrestamos(idCliente).getPrestamos().size()!=0)throw new Exception("ERROR: el cliente que se quiere eliminar tiene prestamos sin pagar");
		Cliente c = dao.traer(idCliente);


		dao.eliminar(c);

	}
	
	public void eliminarClienteYPrestamos(long idCliente)throws Exception{
		if(dao.traer(idCliente)==null)throw new Exception("Error: el cliente que se quiere eliminar no existe");

		Cliente c = dao.traerClienteYPrestamos(idCliente);


		dao.eliminarClientePrestamosYCuotas(c);

	
	}


	

	

	
	
	//
//	traer lista de clientes
//	traer cliente por id
//	traer cliente por dni
//	agregar
//	modificar
//	Eliminar siempre y cuando no tenga prestamos.
//  traerClienteYPrestamos
	
	
	

}//fin claseABM