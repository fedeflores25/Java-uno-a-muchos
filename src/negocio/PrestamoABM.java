package negocio;
import dao.PrestamoDao;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;

public class PrestamoABM {
	
PrestamoDao dao=new PrestamoDao();

	//TRAER
	public Prestamo traerPrestamo(long idPrestamo)throws Exception{
		if(dao.traer(idPrestamo)==null)throw new Exception("Error: no existe el prestamo con el id: "+idPrestamo);
		//Implementar: si no existe el prestamo lanzar la excepción
		Prestamo p =dao.traer(idPrestamo);
		return p;
	}

	public List<Prestamo> traerPrestamos(Cliente c) throws Exception{
	if(dao.traerPrestamos(c).size()==0)throw new Exception("No hay prestamos a nombre del cliente: "+c);
	
	return dao.traerPrestamos(c);
	}
	
	public Prestamo traerPrestamoYCuotas(Prestamo p) {
		
		return dao.traerPrestamoYCuotas(p.getIdPrestamo());
		}
	
	//AGREGAR
	public int agregar(LocalDate fecha,double monto, double interes, int cantCuotas, Cliente cliente)throws Exception{
	
	Prestamo p = new Prestamo(fecha,monto,interes,cantCuotas,cliente);
	
	p.calcularCuotas(p);
	
	Set<Cuota> cuotas= p.getCuotas();
	
	
	
		
	return dao.agregar(p,cuotas);		
}

	
	//MODIFICAR
	public void modificar(Prestamo p)throws Exception{
		if(dao.traer(p.getIdPrestamo())==null)throw new Exception("Error: el prestamo que se quiere modificar no existe"+p.getIdPrestamo());	
		eliminar(p.getIdPrestamo());
		
		dao.agregar(p,p.getCuotas());
	}

	//ELIMINAR
	public void eliminar(long idPrestamo)throws Exception{
		if(dao.traer(idPrestamo)==null)throw new Exception("Error: el prestamo que se quiere eliminar no existe");

		Prestamo p = dao.traer(idPrestamo);
		dao.eliminar(p);
	}

	//PAGAR CUOTA
	public void pagarCuota(Prestamo prestamo, int nroCuota) {
		Prestamo p = dao.traerPrestamoYCuotas(prestamo.getIdPrestamo());
		
		while(p.getCuotas().iterator().hasNext()){
			
			
			if(p.getCuotas().iterator().next().getNroCuota()==nroCuota) {
				p.getCuotas().iterator().next().setCancelada(true);
			}
		}
		
		dao.actualizar(p);
	}

	//PRESTAMO PAGADO
	public boolean prestamoPagado(Prestamo prestamo) {
		Prestamo p = dao.traerPrestamoYCuotas(prestamo.getIdPrestamo());
		boolean bandera=true;
		while(p.getCuotas().iterator().hasNext()){
			
			
			if(p.getCuotas().iterator().next().getCancelada()==false) {
				bandera=false;
			}
		}
		
		return bandera;
	}

//traer prestamo por id OK
//traer prestamos por cliente OK
//Alta, Modificar y eliminar ok
//traerPrestamosYCuotas ok
//pagar prestamo El atributo cancelado se encontrará en true si el préstamo tiene todas sus cuotas pagas ok



}// fin clase