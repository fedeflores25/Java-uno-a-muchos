package negocio;

import dao.CuotaDao;


import datos.Cuota;


public class CuotaABM {

	CuotaDao dao=new CuotaDao();

	public long agregar(Cuota cuota) {
		
		return dao.agregar(cuota);
	}
	
	//modificar
	//pagar cuotaEn cuota el atributo cancelada cambiar� a true cuando se paga la cuota. El atributo punitorios ser� calculado por un inter�s por mora en el pago de la cuota que ingresar� por par�metro, por ejempl 2% mensual.
	//En el caso de que un cliente venga a pagar una cuota se invocar� al m�todo traerCuota de CuotaABM se se �setear�n� los atributos: cancelada, fechaDePago, punitorios y por �ltimo modificarCuota de CuotaABM.

}
