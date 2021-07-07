package datos;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Cliente {
	//ATRIBUTOS
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private LocalDate fechaDeNacimiento;
	private boolean baja;
	private Set<Prestamo> prestamos = new HashSet<Prestamo>(); //¿Porque utilizamos Set y no List?

	//CONSTRUCTORES VACIO Y COMUN(sin id)
	public Cliente(){}
	public Cliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni= dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja=false;
	}

	//GETTERS Y SETTERS(protected setId)
	public long getIdCliente() {
		return idCliente;
	}
	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public boolean isBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	public String toString(){
		return (idCliente+" "+apellido+" "+nombre+" DNI: "+dni+" F.de Nacimiento:"+ Funciones.traerFechaCorta(fechaDeNacimiento)+" "+baja);
	}
	public Set<Prestamo> getPrestamos() {
		return prestamos;
	}
	
	//METODOS
	public void setPrestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCliente ^ (idCliente >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
	
		return ((Cliente)obj).getIdCliente() == this.getIdCliente();
	}
	
}//FIN CLASE

