package datos;


import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {

	
	public static boolean esDiaHabil(LocalDate fecha ){
		int d = fecha .getDayOfWeek().getValue();
		/* LocalDate enumera los dias de 1 a 7 en su respectiva semana. 1 es lunes y 7 es domingo. Los dias habiles son de 1 al 5*/
		return (( d >=1) &&( d <=5));
	}
	
	//hay que poner este metodo en la clase Test para que funcione
	public static void imprimirVector ( int [] v ){
		System . out .print( "{" );
		for ( int e : v ){
		System . out .print( e + "," );
		}
		System . out .println( "}" );
		}
	
	public static boolean esBisiesto(LocalDate fecha) {
		double anio = (double)fecha.getYear();
		boolean bandera= true;
		
		if(anio%4==0) {

			if((anio%100==0)&&(anio%400!=0)){
				bandera=false;
			}
			
		}else { bandera=false;}
		
		return bandera;
	}
	public static boolean esBisiesto(int anio) {
		
		boolean bandera= true;
		
		if(anio%4==0) {

			if((anio%100==0)&&(anio%400!=0)){
				bandera=false;
			}
			
		}else { bandera=false;}
		
		return bandera;
	}
	
	
	public static boolean esFechaValida(LocalDate fecha) {
		
		return esBisiesto(fecha);
	}
	
	public static String traerFechaCorta(LocalDate fecha) {
		
		
		return fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear();
	}
	
	public static String traerHoraCorta(LocalTime hora) {
		
		
		return hora.getHour()+":"+hora.getMinute();
		
	}
	
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		
		int d = fecha .getDayOfWeek().getValue();
		
		String mensaje = null;
		switch(d) {
		case 1:  mensaje="Lunes";break;
		case 2:  mensaje="Martes";break;
		case 3:  mensaje="Miercoles";break;
		case 4:  mensaje="Jueves";break;
		case 5:  mensaje="Viernes";break;
		case 6:  mensaje="Sabado";break;
		case 7:  mensaje="Domingo";break;
			
		}
		
		return mensaje;
	}
	
	
	public static String traerMesEnLetras(LocalDate fecha) {
		
		String mensaje= null;
		int m = fecha.getMonthValue();
		switch(m) {
		case 1:  mensaje="Enero";break;
		case 2:  mensaje="Febrero";break;
		case 3:  mensaje="Marzo";break;
		case 4:  mensaje="Abril";break;
		case 5:  mensaje="Mayo";break;
		case 6:  mensaje="Junio";break;
		case 7:  mensaje="Julio";break;
		case 8: mensaje="Agosto";break;
		case 9: mensaje="Septiembre";break;
		case 10:mensaje="Octubre";break;
		case 11:mensaje="Noviembre";break;
		case 12:mensaje="Diciembre";break;
			
		}	 
				
		return mensaje ;
	}
	
	public static String traerFechaLarga(LocalDate fecha) {
		
			
		return traerDiaDeLaSemana(fecha)+" "+fecha.getDayOfMonth()+" de "+traerMesEnLetras(fecha)+" del "+fecha.getYear();
	}
	
	
	public static int traerCantidadDiasDeUnMes(int anio,int mes) {
		
		int dias=0;
		
				
		switch(mes) {
		case 1:  dias=31;break;
		case 2: 
			if(esBisiesto(anio)){
				dias=29;
			}else {dias=28;
			}
			break;
		case 3:  dias=31;break;
		case 4:  dias=30;break;
		case 5:  dias=31;break;
		case 6:  dias=30;break;
		case 7:  dias=31;break;
		case 8: dias=31;break;
		case 9: dias=30;break;
		case 10:dias=31;break;
		case 11:dias=30;break;
		case 12:dias=31;break;
			
		}	 
				
		
		
		
		return dias;
	}
	
	
	public static double aproximar2Decimal(double valor) {
		
		
		double nume = Math.floor(valor); //4.0
		double nume2 = Math.round(valor*1000) - (nume *1000) ; // 4000 - 4315
	
		double nume5 =nume2/10;//31.5
		double nume6 = (nume5-Math.floor(nume5))*10;	//31.5 - 31 =0.5
		double nume7=0;
		double nume8=0;
		
		if(Math.round(nume6) >= 0.5)  {
			nume7=Math.floor(10-nume6); //resto el valor que me de a 10.
			
			nume8 = Math.round(((nume7/1000)+valor)*100.0);
		}else nume8=valor;
		
		return nume8/100;
	}
	
	
	public static boolean esNumero(char c) {
		
				
		
		return Character.isDigit(c);
	}
	
	
	public static boolean esCadenaNumeros(String cadena) {
		
		
		return cadena.matches("[+-]?\\d*(\\.\\d+)?");
	}
	
	public static boolean esCadenaLetras(String cadena) {
	    for (int i = 0; i < cadena.length(); i++) {
	        char c = cadena.charAt(i);
	        // Si no está entre a y z, ni entre A y Z, ni es un espacio
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
	            return false;
	        }
	    }
	    return true;
	}
	 
	public static boolean esPrimo(int n) {
		
		if(n==1){
			return false;
			}else if((n==2)||(n==3)||(n==5)||(n==7)){
					return true;
				}else if((n%2==0)||(n%3==0)||(n%4==0)||(n%5==0)||(n%6==0)||(n%7==0)||(n%8==0)||(n%9==0)||(n%10==0)) {return false;
				}else {return true;
				}
			}
	
	public static double convertirADouble ( int n ){
		return (( double) n);
		}
	
	public static String primeraLetraMayuscula(String cadena) {
		
		String primeraLetra = cadena.substring(0, 1);
        String restoCadena = cadena.substring(1, cadena.length());
      
        primeraLetra = primeraLetra.toUpperCase();
        cadena = primeraLetra + restoCadena;
		
		return cadena;
	}
	
	public static String cadenaMayuscula(String cadena) {
	
		return cadena.toUpperCase();
		
	}
	
}// fin clase funciones
