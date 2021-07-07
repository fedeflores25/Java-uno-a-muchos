package datos;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Prestamo {
private long idPrestamo;
private LocalDate fecha;
private double monto;
private double interes;
private int cantCuotas;
private Cliente cliente;
private Set<Cuota> cuotas = new HashSet<Cuota>();

public Prestamo() {}

public Prestamo(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
super();
this.fecha = fecha;
this.monto = monto;
this.interes = interes;
this.cantCuotas = cantCuotas;
this.cliente = cliente;
}
public long getIdPrestamo() {
return idPrestamo;
}
protected void setIdPrestamo(long idPrestamo) {
this.idPrestamo = idPrestamo;
}
public LocalDate getFecha() {
return fecha;
}
public void setFecha(LocalDate fecha) {
this.fecha = fecha;
}
public double getMonto() {
return monto;
}
public void setMonto(double monto) {
this.monto = monto;
}
public double getInteres() {
return interes;
}
public void setInteres(double interes) {
this.interes = interes;
}
public int getCantCuotas() {
return cantCuotas;
}
public void setCantCuotas(int cantCuotas) {
this.cantCuotas = cantCuotas;
}
public Cliente getCliente() {
return cliente;
}
public void setCliente(Cliente cliente) {
this.cliente = cliente;
}

public Set<Cuota> getCuotas() {
	return cuotas;
}
public void setCuotas(Set<Cuota> cuotas) {
	this.cuotas = cuotas;
}
public String toString() {
String prestamo = "\n$ " + monto + "\nFecha: " + Funciones.traerFechaCorta(fecha) + "\nInteres: " + interes + "\nCant.de Cuotas: " +
cantCuotas+"\n";
return prestamo;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (idPrestamo ^ (idPrestamo >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	
	return ((Prestamo)obj).getIdPrestamo() == this.getIdPrestamo();
}

public void calcularCuotas(Prestamo p) {
Set<Cuota> cuotas= new HashSet<Cuota>();
	
	LocalDate fechaVencimiento = p.getFecha().plusMonths(1);
	double saldoPendiente = p.getMonto();
	double interesCuota=0;
	double amortizacion=0;
	double cuota=0;
	double deuda=0;

	//chequeo que no sea ni sabado ni domingo.
	if(fechaVencimiento.getDayOfWeek()==DayOfWeek.SATURDAY) fechaVencimiento.plusDays(2);
	if(fechaVencimiento.getDayOfWeek()==DayOfWeek.SUNDAY) fechaVencimiento.plusDays(1);
	
	for(int i=1;i<=cantCuotas;i++) {
		
		if(i==1) {
			amortizacion=(saldoPendiente*(interes/100))/(Math.pow(1+(interes/100), p.getCantCuotas())-1);
			
		}else {
			amortizacion=(saldoPendiente*(interes/100))/(Math.pow(1+(interes/100), p.getCantCuotas()-1)-1);
			
		}
		interesCuota=saldoPendiente*(interes/100);
		cuota=amortizacion+interesCuota;
		deuda=saldoPendiente-amortizacion;		
		saldoPendiente=saldoPendiente-amortizacion;
			
		cuotas.add(new Cuota(i,fechaVencimiento,saldoPendiente,amortizacion,interesCuota,cuota,deuda,false,fechaVencimiento,0,p));
		fechaVencimiento =fechaVencimiento.plusMonths(1);
	}
	setCuotas(cuotas);
}


}//fin clase

