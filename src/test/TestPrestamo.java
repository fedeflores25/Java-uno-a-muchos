package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrestamoABM prestamoABM = new PrestamoABM();
		ClienteABM clienteABM = new ClienteABM();
		//Alta ok
		//Modificar ok
		//eliminar ok
		//traer prestamo por id ok
		//traer prestamos por cliente 
		//traerPrestamosYCuotas ok
		//pagar prestamo El atributo cancelado se encontrará en true si el préstamo tiene todas sus cuotas pagas 
		
		
		//caso de uso 1*******************************
		try {
		
			println("Caso de uso 1: Crear un prestamo con sus cuotas");
			
		//prestamoABM.agregar(LocalDate.now(), 3000, 10, 3, clienteABM.traer(38526503));
		//prestamoABM.eliminar(2);
			
			Prestamo p = prestamoABM.traerPrestamoYCuotas(prestamoABM.traerPrestamo(14));
			
			println("Prestamo");
			println(p);
			println("Cuotas");
			println(p.getCuotas());
			
			println("Caso de uso correcto");
			println("");
		}catch(Exception e) {
			println("Exception: "+e.getMessage());
		}
		//caso de uso 2*******************************
				try {
				
					println("Caso de uso 2: modificar un prestamo con sus cuotas");
					
				
					
					Prestamo p = prestamoABM.traerPrestamoYCuotas(prestamoABM.traerPrestamo(17));
					
					p.setCantCuotas(4);
					p.calcularCuotas(p);
					
					//prestamoABM.modificar(p);
					//prestamoABM.eliminar(p.getIdPrestamo());
					
					println("Prestamo");
					println(prestamoABM.traerPrestamoYCuotas(prestamoABM.traerPrestamo(19)));
					println("Cuotas");
					println(prestamoABM.traerPrestamoYCuotas(prestamoABM.traerPrestamo(19)).getCuotas());
					
					println("Caso de uso correcto");
					println("");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
		
			//caso de uso 3*******************************
				try {
				
					println("Caso de uso 3: eliminar un prestamo con sus cuotas");
					
				//prestamoABM.agregar(LocalDate.now(), 3000, 10, 3, clienteABM.traer(38526503));
				//prestamoABM.eliminar(14);
					
					Prestamo p = prestamoABM.traerPrestamoYCuotas(prestamoABM.traerPrestamo(18));
					
					
					
				
					//prestamoABM.eliminar(p.getIdPrestamo());
					
					println("Prestamo");
					println(p);
					println("Cuotas");
					println(p.getCuotas());
					
					println("Caso de uso correcto");
					println("");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
			//caso de uso 4*******************************
				try {
				
					println("Caso de uso 4: traer prestamo por cliente");
					
				//prestamoABM.agregar(LocalDate.now(), 3000, 10, 3, clienteABM.traer(38526503));
				//prestamoABM.eliminar(14);
					Cliente c = clienteABM.traer(38526503);	
					List<Prestamo> p = prestamoABM.traerPrestamos(c);
				
					//prestamoABM.eliminar(p.getIdPrestamo());
					
					println("Cliente");
					println(c);
					println("Prestamos");
					println(p);
					
					println("Caso de uso correcto");
					println("");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
		
		
		
		
		
		
		
		
		
		
		
		
	}//fin main
	static void println(Object line) {
	    System.out.println(line);
	}
	
}//fin clase prestamo
