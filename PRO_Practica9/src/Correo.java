import java.util.ArrayList;

public class Correo {

	String nombre, apellido1, apellido2;

	static String date;

	String email;

	String asunto;

	String mensaje;
	
	static ArrayList<Correo> bandejaSalida = new ArrayList<Correo>();
	
	public Correo(){
		
	}
	
	public Correo(String nombre, String apellido1, String apellido2, String date, String email, String asunto, String mensaje){
		
		nombre=this.nombre;
		apellido1=this.apellido1;
		apellido2=this.apellido2;
		date=this.date;
		email=this.email;
		asunto=this.asunto;
		mensaje=this.mensaje;
		
	}

	//Este metodo envía un correo electrónico 
	public static String enviarCorreo(){
		
		String asunto;
		String mensaje;
		
		//Buscamos un contacto 
		Agenda.buscarContacto(Agenda.agendaContactos, Agenda.agendaContactoAux, Agenda.posicionList);
		//Se recorre la agenda de contactos
		for (int i = 0; i < Agenda.agendaContactos.size(); i++) {
		//Se compara y si el nombre coincide se escribe el correo electrónico a contacto comparado.
			if (Agenda.agendaContactos.get(i).nombre.equals(Agenda.agendaContactoAux.get(Agenda.posicion-1).nombre) & Agenda.agendaContactos.get(i).apellido1.equals(Agenda.agendaContactoAux.get(Agenda.posicion-1).apellido1)){
		//Destinatario comparado
				System.out.println("Destinatario: " + Agenda.nombre + Agenda.apellido1 +"(" + Agenda.email + ")");
		//Asunto
				System.out.println("Asunto");
				asunto = Entrada.cadena();
		//Mensaje
				System.out.println("Mensaje");
				mensaje = Entrada.cadena();
			
				bandejaSalida.add(new Correo(Agenda.nombre, Agenda.apellido1, Agenda.apellido2, Agenda.email, date,  asunto, mensaje));
				
			} else {
		//Si no se reconoce ninguno, será un contacot des conocido y por tanto un error.
				System.out.println("Contacto desconocido");
			}
			
			
		}
		//Confirmacion de envio
		return "Enviando correo electrónico a " + Agenda.nombre + " finalizada";
		
	}
	
	public static String verCorreos(ArrayList<Correo> bandejaSalida) {
		
		for (int i = 0; i < bandejaSalida.size(); i++) {
			
			if (bandejaSalida.size() > 0) {
				
				System.out.println("-----------------");
				System.out.println("Correo " + (i+1));
				System.out.println("Destinatario: " + bandejaSalida.get(i).nombre + " " + bandejaSalida.get(i).apellido1 + " " + bandejaSalida.get(i).apellido2 + "(" + bandejaSalida.get(i).email + ")");
				System.out.println("Asunto: " + bandejaSalida.get(i).asunto);
				System.out.println("-----------------");
				System.out.println("Mensaje: ");
				System.out.println(bandejaSalida.get(i).mensaje);
				System.out.println("-----------------");
				
			} else {

				String contestacion;
				
				System.out.println("No hay correos, labandeja de salida está vacia.");
				System.out.println("¿Desea escribir un correo nuevo?");
				contestacion = Entrada.cadena();
				
				if (contestacion.equals("Si") || contestacion.equals("Sí") || contestacion.equals("SI") || contestacion.equals("SÍ") || contestacion.equals("si") ||contestacion.equals("Sí")) {
												
					enviarCorreo();
					
				} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {
					
					System.out.println("De acuerdo.");
				}
				
			}
			
		}
		
		return "Lista de correos mostrada";		
	}
	
	public static String borrarBandeja(ArrayList<Correo> bandejaSalida) {
		
		bandejaSalida.clear();
		
		return "Borrado de bandeja de salida completado";	
	}
	
}