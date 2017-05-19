import java.util.ArrayList;

public class Llamada {
	
	static String nombre;
	static String apellido1;
	static String apellido2;
	static String date;
	static int telefono= 0;
	
	static ArrayList<Llamada> registroLlamadas = new ArrayList<Llamada>();
	
	public Llamada() {}
	
	public Llamada(String nombre, String apellido1, String apellido2, int telefono, String date) {
		
		nombre=this.nombre;
		apellido1=this.apellido1;
		apellido2=this.apellido2;
		telefono = this.telefono;
		date=this.date;
		
	}
	//Este metodo busca un contacto para compararlo con el que se escribe
	public static String llamarContacto(){
		//Usa el metodo buscar contacto
		Agenda.buscarContacto(Agenda.agendaContactos, Agenda.agendaContactoAux, Agenda.posicionList);
		//Recorremos la agenda de contactos
		for (int i = 0; i < Agenda.agendaContactos.size(); i++) {
		//Comparamos el los nombres de la agenda con los que han coincidido con la busqueda
			if (Agenda.agendaContactos.get(i).nombre.equals(Agenda.agendaContactoAux.get(Agenda.posicion-1).nombre) & Agenda.agendaContactos.get(i).apellido1.equals(Agenda.agendaContactoAux.get(Agenda.posicion-1).apellido1)){
		//Se realiza la "llamada" y se almacena un registro de ella.	
				System.out.println("Llamando a " + Agenda.nombre + " al " + Agenda.telefono);
				registroLlamadas.add(new Llamada(nombre, apellido1,apellido2, telefono, date));
		
			} else {
				System.out.println("Contacto desconocido");
				//Aquí volvería al MAIN
			}
			
		//Devolvemos texto de finalizacion de llamada	
		}
		return "Llamada a " + Agenda.nombre + " finalizada";
	}
	
	//Este metodo es igual que el anterior pero hace una comparación (llamar contacto) con un número de telefono
	public static String llamarNumero(){
		//Busca un número para compararlo despues
		Agenda.buscarNumero(Agenda.agendaContactos, Agenda.agendaContactoAux, Agenda.posicionList);
		
		for (int i = 0; i < Agenda.agendaContactos.size(); i++) {

			if (Agenda.agendaContactos.get(i).telefono.equals(Agenda.agendaContactoAux.get(Agenda.posicion-1).telefono)){
			
				System.out.println("Llamando a " + Agenda.nombre + " al " + Agenda.telefono);
				registroLlamadas.add(new Llamada(nombre, apellido1,apellido2, telefono, date));
				
			} else {
				System.out.println("Numero desconocido");
				//Aquí volvería al MAIN
			}
			
			
		}
		return "Llamada a " + Agenda.nombre + " finalizada";
	}
	//Mostramos el registro de llamadas
	public static String mostrarRegistro(ArrayList<Llamada> registroLlamadas){
		
		//Recorremos el arrayList del registro de llamadas para mostrarlo
		for (int i = 0; i < registroLlamadas.size(); i++) {
		//Lo mostrasmos
			System.out.println("-----------------");
			System.out.println("Registro " + (i+1));
			System.out.println("Contacto: " + registroLlamadas.get(i).nombre + registroLlamadas.get(i).apellido1 + registroLlamadas.get(i).apellido2);
			System.out.println("Número de teléfono: " + registroLlamadas.get(i).telefono);
			System.out.println("Fecha de realización: " + registroLlamadas.get(i).date);
			
		}
				
		return "Fin del registro.";
		
	}
	//Con este metodo se borra el registro de llamadas
	public static String borrarRegistro(ArrayList<Llamada> registroLlamadas) {
		
		registroLlamadas.clear();
		
		return "Borrado de registro completado";	
	}
	
}