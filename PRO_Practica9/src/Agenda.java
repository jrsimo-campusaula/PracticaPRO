import java.util.ArrayList;

public class Agenda {
	
	static String nombre = "";
	static String apellido1 = "";
	static String apellido2 = "";
	static String telefono = "";
	static String email = "";
	static String fechaNacimiento = "";
	static  int posicion;
	//Agenda general de contactos
		public static ArrayList<Agenda> agendaContactos = new ArrayList<Agenda>();
		//Agenda auxiliar de contactos
		public static ArrayList<Agenda> agendaContactoAux = new ArrayList<Agenda>();
		//ArrayList de posiciones
		public static ArrayList<Integer> posicionList = new ArrayList<Integer>();
	
	public Agenda(){
		
	}
	
	public Agenda(String nombre, String apellido1, String apellido2, String telefono, String email, String fechaNacimiento){
		
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		
	}	
	
	public static String demo(ArrayList<Agenda> agendaContactos){
	
		agendaContactos.add(new Agenda("Víctor", "Vanaclocha", "Cebrián", "987654321", "vicvace@campusaula.com", "31/01/1995"));
		agendaContactos.add(new Agenda("Javier", "ballarín", "Moral", "987123654", "jabamo@campusaula.com", "02/02/1996"));
		agendaContactos.add(new Agenda("Alex", "Suarez", "perales", "123456789", "asuape@campusaula.com", "02/07/1997"));
		
		System.out.println("¡Ejecutado!");
		
		return "Ejecutado";
	}
	
	//Este metodo Busca contactos dentro del arraylist agendaContactos y los que coinciden los mete en un arraylist de objetos auxiliar y los muestra
	public static  int buscarContacto(ArrayList<Agenda> agendaContactos, ArrayList<Agenda> agendaContactoAux, ArrayList<Integer> posicionList){
		//Limpia ArrayList cada vez que se utiliza al inicio.
		Agenda.agendaContactoAux.clear();
			
		String buscarNombre = "";
		String contestacion = "";
		int posicion = 0;
		Integer posicionAuto = 0;
		
		//Nombre que se comparará
		System.out.println("¿Que contacto necesitas? (nombre)");
		buscarNombre = Entrada.cadena();
		
		//Se recorre el ArrayList y se compara el nombre introducido con la agenda de contactos auxiliar (ArrayList agendaContactosAux)
		System.out.println("Contacto/s encontrado/s en las posición/posiciones: ");
		for (int i = 0; i < Agenda.agendaContactos.size(); i++) {
			
			if (Agenda.agendaContactos.get(i).nombre.equals(buscarNombre)) {
			
				System.out.println("Posición: " + (i+1));
				//i = posicionAuto;
				//Agenda.posicionList.add(posicionAuto);
				Agenda.agendaContactoAux.add(new Agenda(Agenda.agendaContactos.get(i).nombre, Agenda.agendaContactos.get(i).apellido1, Agenda.agendaContactos.get(i).apellido2, Agenda.agendaContactos.get(i).telefono, Agenda.agendaContactos.get(i).email, Agenda.agendaContactos.get(i).fechaNacimiento));
				
			}	
		}
		
		//Si la agenda de contactos auxiliar está vacía, le pregunta si quiere añadir nuevos contactos.
		if (Agenda.agendaContactoAux.size() == 0) {
			
			System.out.println("No he encontrado el contacto. ¿Desea introducirlo?");
			contestacion = Entrada.cadena();
			
			if (contestacion.equals("Si") || contestacion.equals("Sí") || contestacion.equals("SI") || contestacion.equals("SÍ") || contestacion.equals("si") ||contestacion.equals("Sí")) {
											
				anadirContacto(Agenda.agendaContactos);
				
			} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {
				
				System.out.println("De acuerdo.");
			}
		//Si la agenda de contactos auxiliar contiene algún objeto contacto, se recorre y se muestran los que coinciden 	
		} else if (Agenda.agendaContactoAux.size() > 0) {
			
			//Mostramos todos los contactos que coinciden
			for (int i = 0; i < Agenda.agendaContactoAux.size(); i++) {
				
				System.out.println("----------------------");
				System.out.println("Contacto " + (i+1)+ ":");
				System.out.println("Nombre: " + Agenda.agendaContactoAux.get(i).nombre);
				System.out.println("Apellidos: " + Agenda.agendaContactoAux.get(i).apellido1 + " " + Agenda.agendaContactoAux.get(i).apellido2);			
			}
			
			//Una vez mostrada la lista, la persona selecciona un número de la lista (Se le resta uno poque se visualiza desde 1 pero el array se guarda desde 0)
						
			int limite = 1;
			int contador = 0;
			
			while(limite!=contador){
				try {
					System.out.println("--------------------------------------------");
					System.out.println("Seleccione el número de la lista. (1, 2, 3...)");
					posicion = Entrada.entero();			
					
				} catch (NumberFormatException n) {
					System.out.println("No has introducido un número. Seleccione el número de la lista. (1, 2, 3...)");
					posicion = Entrada.entero();
				}
				contador++;
			}
			//Se muestra el contacto con dicha posición			
			for(int i = 0; i < Agenda.agendaContactoAux.size(); i++){
				
				System.out.println("Contacto " + posicion);
				System.out.println("Nombre: " + Agenda.agendaContactoAux.get(posicion-1).nombre);
				System.out.println("Apellidos: " + Agenda.agendaContactoAux.get(posicion-1).apellido1 + Agenda.agendaContactoAux.get(posicion-1).apellido2);
				System.out.println("Telefono: " + Agenda.agendaContactoAux.get(posicion-1).telefono);
				System.out.println("Correo electrónico: " + Agenda.agendaContactoAux.get(posicion-1).email);
				System.out.println("Fecha de nacimiento: " + Agenda.agendaContactoAux.get(posicion-1).fechaNacimiento);
				
			}

		}
		//Devuelve la posición+1 del contacto encontrado en la agenda de contactos auxiliar
		return posicion;
			
	}
		
	//Se podrá modificar un contacto que esté metido en el arraylist agenda contactos
	public static String modificarContacto(ArrayList<Agenda> agendaContactos, ArrayList<Agenda> agendaContactoAux, ArrayList<Integer> posicionList){
		//Almacenamos la contestación
		String contestacion = "";
		
		//Buscamos el contacto que queremos modificar
		Agenda.buscarContacto(Agenda.agendaContactos,Agenda.agendaContactoAux,Agenda.posicionList);
		
		//Recorremos la agenda de contactos
		for (int i = 0; i < Agenda.agendaContactos.size(); i++) {
			
			//Comparamos el contacto de la agenda de contactos auxiliar con la de la agenda de contactos real.
			if (Agenda.agendaContactos.get(i).nombre.equals(Agenda.agendaContactoAux.get(posicion-1).nombre) & Agenda.agendaContactos.get(i).apellido1.equals(Agenda.agendaContactoAux.get(posicion-1).apellido1)) {
				
				//Si coinciden la agenda de contactos con la agenda de contactos auxiliar, se modifican los datos de la agenda de contactos principal
				System.out.println("Introduzca el nuevo nombre de " + Agenda.agendaContactoAux.get(posicion-1).nombre + Agenda.agendaContactoAux.get(posicion-1).apellido1 + "" );
				Agenda.agendaContactos.get(i).nombre = Entrada.cadena();
				System.out.println("Introduzca el nuevo primer apellido");
				Agenda.agendaContactos.get(i).apellido1 = Entrada.cadena();
				System.out.println("Introduzca el nuevo segundo apellido");
				Agenda.agendaContactos.get(i).apellido2 = Entrada.cadena();
				System.out.println("Introduzca el nuevo telfono");
				Agenda.agendaContactos.get(i).nombre = Entrada.cadena();
				System.out.println("Introduzca la nueva fecha de nacimeinto (dd/mm/yyyy)");
				Agenda.agendaContactos.get(i).nombre = Entrada.cadena();
				
			//Si no se encuentra ninguna realación (Cosa que sería un error), se permite añadir un contacto si el usuario lo desea.
			} else {

				System.out.println("No lo he encontrado en la agenda de contactos... ¿Desea introducir un nuevo contacto? (Si, No)");
				contestacion = Entrada.cadena();
				
				if (contestacion.equals("Si") || contestacion.equals("Sí") || contestacion.equals("SI") || contestacion.equals("SÍ") || contestacion.equals("si") ||contestacion.equals("Sí")) {
									
					Agenda.anadirContacto(Agenda.agendaContactos);
					
				} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {

					//Aquí volvería a la clase asistente
					
				}
				
			}
				
		}
		//Se confirma la modificación
		return "Modificado el contacto " + nombre + apellido1 + apellido2;
	}
	
	//Este metodo añade un contacto en el arraylist agendaContactos en forma de objeto
	public static String anadirContacto(ArrayList<Agenda> agendaContactos){
			
			//Este metodo añadrirá contactos a un array de objetos.
			
			System.out.println("Introduzca los datos del contacto.");
			System.out.println("Nombre: ");
			nombre = Entrada.cadena();
			System.out.println("Apellido1: ");
			apellido1 = Entrada.cadena();
			System.out.println("Apellido2");
			apellido2 = Entrada.cadena();
			System.out.println("telefono");
			telefono = Entrada.cadena();
			System.out.println("email");
			email = Entrada.cadena();
			System.out.println("Fecha de nacimiento");
			fechaNacimiento = Entrada.cadena();
			
			//Se añade el objeto agenda a agendaContactos
			Agenda.agendaContactos.add(new Agenda(nombre, apellido1, apellido2, telefono, email, fechaNacimiento));
			
			System.out.println("Añadido correctamente el contacto "+ nombre + " " + apellido1 + " " + apellido2 + ".");
			
			//Se confima la inserción
			return "Añadido correctamente el contacto "+ nombre + apellido1 + apellido2 + ".";
			
		}
		
		//Este metodo elimina un objeto en la lista de agenda Contactos
	public static String eliminarContacto(ArrayList<Agenda> agendaContactos, ArrayList<Agenda> agendaContactoAux, ArrayList<Integer> posicionList){
			
			System.out.println("Busque y seleccione el contacto para eliminarlo:");
			//Se busca un contacto el buscarContacto(), 
			Agenda.buscarContacto(Agenda.agendaContactos,Agenda.agendaContactoAux,Agenda.posicionList);
			
			//Se recorre la agenda de contactos 
			for (int i = 0; i < Agenda.agendaContactos.size(); i++) {
				
				//Se compara el resultado de la busqueda con los nombres reales de la agenda de contactos
				if (Agenda.agendaContactos.get(i).nombre.equals(Agenda.agendaContactoAux.get(posicion-1).nombre) & Agenda.agendaContactos.get(i).apellido1.equals(Agenda.agendaContactoAux.get(posicion-1).apellido1));
			
				//Si coinciden se elimina dicho contacto.
				Agenda.agendaContactos.remove(i);
				
			} 
			
			return "(!)Contacto eliminado(!)";
			
		}
		
	public static  int buscarNumero(ArrayList<Agenda> agendaContactos,ArrayList<Agenda> agendaContactoAux,ArrayList<Integer> posicionList){
			//Limpia ArrayList cada vez que se utiliza al inicio.
			Agenda.agendaContactoAux.clear();
				
			String buscarTelefono = "";
			String contestacion = "";
			int posicion = 0;
			Integer posicionAuto = 0;
			
			//Nombre que se comparará
			System.out.println("¿Que número necesitas? (Número de teléfono)");
			buscarTelefono = Entrada.cadena();
			
			//Se recorre el ArrayList y se compara el nombre introducido con la agenda de contactos auxiliar (ArrayList agendaContactosAux)
			System.out.println("Contacto/s encontrado/s en las posición/posiciones: ");
			for (int i = 0; i < Agenda.agendaContactos.size(); i++) {
				
				if (Agenda.agendaContactos.get(i).telefono.equals(buscarTelefono)) {
				
					System.out.println("Posición: " + (i+1));
					i = posicionAuto;
					Agenda.posicionList.add(posicionAuto);
					Agenda.agendaContactoAux.add(new Agenda(Agenda.agendaContactos.get(i).nombre, Agenda.agendaContactos.get(i).apellido1, Agenda.agendaContactos.get(i).apellido2, Agenda.agendaContactos.get(i).telefono, Agenda.agendaContactos.get(i).email, Agenda.agendaContactos.get(i).fechaNacimiento));
					
				}	
			}
			
			//Si la agenda de contactos auxiliar está vacía, le pregunta si quiere añadir nuevos contactos.
			if (Agenda.agendaContactoAux.size() == 0) {
				
				System.out.println("No he encontrado el contacto. ¿Desea introducirlo?");
				contestacion = Entrada.cadena();
				
				if (contestacion.equals("Si") || contestacion.equals("Sí") || contestacion.equals("SI") || contestacion.equals("SÍ") || contestacion.equals("si") ||contestacion.equals("Sí")) {
												
					Agenda.anadirContacto(Agenda.agendaContactos);
					
				} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {
					
					//Aquí volvería a la clase asistente
				}
			//Si la agenda de contactos auxiliar contiene algún objeto contacto, se recorre y se muestran los que coinciden 	
			} else if (Agenda.agendaContactoAux.size() > 0) {
				
				//Mostramos todos los contactos que coinciden

				for (int i = 0; i < Agenda.agendaContactoAux.size(); i++) {
					
					System.out.println("----------------------");
					System.out.println("Contacto" + (i+1)+ ":");
					System.out.println("Nombre:" + Agenda.agendaContactoAux.get(i).nombre);
					System.out.println("Apellidos:" + Agenda.agendaContactoAux.get(i).apellido1 + Agenda.agendaContactoAux.get(i).apellido2);			
				}
				
				//Una vez mostrada la lista, la persona selecciona un númeor de la lista (Se le resta uno poque se visualiza desde 1 pero el array se guarda desde 0)
							
				int limite = 1;
				int contador = 0;
				
				while(limite!=contador){
					try {
						System.out.println("Seleccione el número de la lista. (1, 2, 3...)");
						posicion = Entrada.entero();			
						
					} catch (NumberFormatException n) {
						System.out.println("No has introducido un número. Seleccione el número de la lista. (1, 2, 3...)");
						posicion = Entrada.entero();
					}
					contador++;
				}
				
				
				//Se muestra el contacto con dicha posición
				System.out.println("Contacto " + posicion + "completo de " + Agenda.agendaContactoAux.get(posicion-1).nombre );
				System.out.println("Nombre:" + Agenda.agendaContactoAux.get(posicion-1).nombre);
				System.out.println("Apellidos:" + Agenda.agendaContactoAux.get(posicion-1).apellido1 + Agenda.agendaContactoAux.get(posicion-1).apellido2);
				System.out.println("Telefono: " + Agenda.agendaContactoAux.get(posicion-1).telefono);
				System.out.println("Correo electrónico: " + Agenda.agendaContactoAux.get(posicion-1).email);
				System.out.println("Fecha de nacimiento: " + Agenda.agendaContactoAux.get(posicion-1).fechaNacimiento);

			}
			//Devuelve la posición+1 del contacto encontrado en la agenda de contactos auxiliar
			return posicion;
		}
	
	public static String mostrarLista(ArrayList<Agenda> agendaContactos){
		
		String contestacion;
		
		//Si la agenda de contactos auxiliar está vacía, le pregunta si quiere añadir nuevos contactos.
		if (Agenda.agendaContactos.size() == 0) {
			
			System.out.println("No he encontrado ningún contacto. ¿Desea introducirlo alguno? (Sí o no)");
			contestacion = Entrada.cadena();
		
			if (contestacion.equals("Si") || contestacion.equals("Sí") || contestacion.equals("SI") || contestacion.equals("SÍ") || contestacion.equals("si") ||contestacion.equals("Sí")) {
				Agenda.anadirContacto(Agenda.agendaContactos);
			} else if (contestacion.equals("No") || contestacion.equals("NO") || contestacion.equals("no")) {
				System.out.println("De acuerdo.");
			}
			
		} else if (Agenda.agendaContactos.size() > 0) {
			//Recorremos el arrayList del agenda contactos para mostrarla
			for (int i = 0; i < Agenda.agendaContactos.size(); i++) {
				//Lo mostrasmos
					System.out.println("-----------------");
					System.out.println("Contacto " + (i+1));
					System.out.println("Nombre completo: " + Agenda.agendaContactos.get(i).nombre + " " + Agenda.agendaContactos.get(i).apellido1 + " " + Agenda.agendaContactos.get(i).apellido2);
					System.out.println("Número de teléfono: " + Agenda.agendaContactos.get(i).telefono);
					System.out.println("Fecha de Nacimiento: " + Agenda.agendaContactos.get(i).fechaNacimiento);
					
				}
			
		}
				
		return "Fin del registro.";
		
	}
}