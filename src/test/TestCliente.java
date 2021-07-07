package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;

public class TestCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteABM = new ClienteABM();
		
	
		//	traer lista de clientes ok
		//	traer cliente por id ok
		//	traer cliente por dni ok 
		//	agregar ok
		//	modificar ok
		//	Eliminar sin prestamos ok
		// Eliminar con prestamos y que devuelva exeption.
		//  traerClienteYPrestamos
		
		
		//caso de uso 1*******************************
				try {
					clienteABM.traer(40667665);
					println("");
					println("Caso de uso 1: Agregar un cliente");
					
					//clienteABM.agregar("Flores", "Federico", 38526503,LocalDate.of(1994, 7, 27));
					
					println(clienteABM.traer(40667665));
					
					
					println("Caso de uso correcto");
					println("");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
		
		//caso de uso 2********************
				try {
					
					println("Caso de uso 2: Modificar cliente");
					
					Cliente c = clienteABM.traer(38526503);
					c.setNombre("Fede");
					
					//clienteABM.modificar(c);
					println(clienteABM.traer(38526503));
					
					
					println("Caso de uso correcto");
					println("");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
				
		//caso de uso 3**************************
				try {
					
					println("Caso de uso 3: Eliminar cliente");
				
				
					
					//clienteABM.eliminarClienteYPrestamos(7);
					println(clienteABM.traerId(7));
					
					
					println("Caso de uso correcto");
					println("");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
				
		//caso de uso 4**************************
				try {
					
					println("Caso de uso 4: Traer clientes");
					
					println(clienteABM.traer());
				
					println("Caso de uso correcto");
					println("");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
				
				
			//caso de uso 5**************************
				try {
					
					println("Caso de uso 4: Traer cliente y prestamos");
					
					Cliente c = clienteABM.traerClienteYPrestamos(7);
					println("Cliente:");
					println(c.toString());
					println("Prestamos:");
					println(c.getPrestamos());
					
					println("Caso de uso correcto");
					println("");
				}catch(Exception e) {
					println("Exception: "+e.getMessage());
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}//fin main
	static void println(Object line) {
	    System.out.println(line);
	}
	
}//fin de la clase test
