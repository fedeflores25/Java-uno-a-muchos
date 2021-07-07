package negocio;

import dao.CuotaDao;


import datos.Cuota;


public class CuotaABM {

	CuotaDao dao=new CuotaDao();

	public long agregar(Cuota cuota) {
		
		return dao.agregar(cuota);
	}
	
	//modificar
	//pagar cuotaEn cuota el atributo cancelada cambiará a true cuando se paga la cuota. El atributo punitorios será calculado por un interés por mora en el pago de la cuota que ingresará por parámetro, por ejempl 2% mensual.
	//En el caso de que un cliente venga a pagar una cuota se invocará al método traerCuota de CuotaABM se se “setearán” los atributos: cancelada, fechaDePago, punitorios y por último modificarCuota de CuotaABM.

}
