package datos;
import java.time.LocalDate;

public class Cuota {
private long idCuota;
private int nroCuota;
private LocalDate fechaVencimiento;
private double saldoPendiente;
private double amortizacion;
private double interesCuota;
private double cuota;
private double deuda;
private boolean cancelada;
private LocalDate fechaDePago;
private double punitorios;
private Prestamo prestamo;
//constructores
	public Cuota() {}
	public Cuota(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
			double interesCuota, double cuota, double deuda, boolean cancelada, LocalDate fechaDePago,
			double punitorios, Prestamo prestamo) {
		super();
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		this.saldoPendiente = saldoPendiente;
		this.amortizacion = amortizacion;
		this.interesCuota = interesCuota;
		this.cuota = cuota;
		this.deuda = deuda;
		this.cancelada = cancelada;
		this.fechaDePago = fechaDePago;
		this.punitorios = punitorios;
		this.prestamo = prestamo;
	}

	//getters and setters
	public long getIdCuota() {
		return idCuota;
	}

	protected void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public double getInteresCuota() {
		return interesCuota;
	}

	public void setInteresCuota(double interesCuota) {
		this.interesCuota = interesCuota;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public boolean getCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getPunitorios() {
		return punitorios;
	}

	public void setPunitorios(double punitorios) {
		this.punitorios = punitorios;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	//metodos

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nroCuota;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		return ((Cuota)obj).getNroCuota() == this.getNroCuota();
	}
	@Override
	public String toString() {
		String cadena = "\n" + "nroCuota=" + nroCuota + ", fechaVencimiento=" + fechaVencimiento
				+ ", saldoPendiente=" + Math.round(saldoPendiente) + ", amortizacion=" + Math.round(amortizacion) + ", interesCuota="
				+ Math.round(interesCuota) + ", cuota=" + Math.round(cuota) + ", deuda=" + Math.round(deuda) + ", cancelada=" + cancelada + ", fechaDePago="
				+ fechaDePago + ", punitorios=" + Math.round(punitorios) + "\n";
		
		return cadena;
	}
	
	
	

	

}
