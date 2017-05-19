public class Asistente {
	
	// Metodo principal
		public static void main(String[] args) {
			
			//Variables
			String texto="";
			boolean fin = false;
			boolean check1 = false;
			boolean check2 = false;
			boolean check3 = false;
			
			
			System.out.println("Hola, soy tu Asistente personal.");
			//Bucle que contiene todo el programa
			while(fin==false) {
				
				//Se muestra por pantalla
				System.out.println("Dime, ¿que necesitas?");
				texto = Entrada.cadena();
				String [] cadena = texto.split(" "); 
				
				for (int i=0; i<cadena.length; i++) {
					
					if (cadena[i].equals("buscar")) {
						
						String contestacion;
						
						while(check1 == false) {
											
						System.out.println("¿Desea buscar un nombre de contacto o un numero? (Escriba 'Contacto' o 'Número')");
						contestacion = Entrada.cadena();
											
							if (contestacion.equals("Contacto") || contestacion.equals("contacto")){
							
								Agenda.buscarContacto(Agenda.agendaContactos, Agenda.agendaContactoAux,Agenda.posicionList);
								check1 = true;
								
							} else if (contestacion.equals("Número") || contestacion.equals("número") || contestacion.equals("Numero") || contestacion.equals("numero")){
								
								Agenda.buscarNumero(Agenda.agendaContactos, Agenda.agendaContactoAux, Agenda.posicionList);
								check1 = true;	
								
							} else if (contestacion.equals("Borrar") || contestacion.equals("borrar")) {
								
								Agenda.agendaContactos.remove(i);
								check1 = true;
								
							} else {
								System.out.println("Lo siento, no le he entendido");
								check1 = false;
							}
										
						}
						check1 = false;
					} else if (cadena[i].equals("añadir")){
						
						Agenda.anadirContacto(Agenda.agendaContactos);
						
					} else if (cadena[i].equals("modificar")){
						 
						Agenda.modificarContacto(Agenda.agendaContactos, Agenda.agendaContactoAux, Agenda.posicionList);
						 
					} else if (cadena[i].equals("eliminar")){
							
						Agenda.eliminarContacto(Agenda.agendaContactos, Agenda.agendaContactoAux, Agenda.posicionList);
							
					} else if (cadena[i].equals("enseñar")){
						
						Agenda.mostrarLista(Agenda.agendaContactos);
						
					} else if (cadena[i].equals("llamar")){
							
						String contestacion;
						while(check2 == false) {
							System.out.println("¿Desea llamar a un contacto o un número de teléfono? (Escriba 'Contacto' o 'Número')");
							contestacion = Entrada.cadena();
							
							if (contestacion.equals("Contacto") || contestacion.equals("contacto")){
								Llamada.llamarContacto();
								check2 = true;
							} else if (contestacion.equals("Número") || contestacion.equals("número") || contestacion.equals("Numero") || contestacion.equals("numero")){
								Llamada.llamarNumero();
								check2 = true;
							} else {
								System.out.println("Lo siento, no le he entendido");
								check2 = false;
							}
						}
						check2 = false;
							
					} else if (cadena[i].equals("mostrar")){
							
						Llamada.mostrarRegistro(Llamada.registroLlamadas);
							
					} else if (cadena[i].equals("enviar")){
															
						Correo.enviarCorreo();
							
					} else if (cadena[i].equals("ver")){
						
						Correo.verCorreos(Correo.bandejaSalida);
							
					} else if (cadena[i].equals("borrar")){
							
						String contestacion;
						while (check3 == false) {
							
							System.out.println("¿Desea llamar a un contacto o un número de teléfono? (Escriba 'Contacto' o 'Número')");
							contestacion = Entrada.cadena();
									
							if (contestacion.equals("X") || contestacion.equals("X")){
								Llamada.borrarRegistro(Llamada.registroLlamadas);
								check3 = true;
							} else if (contestacion.equals("X") || contestacion.equals("X")){
								Correo.borrarBandeja(Correo.bandejaSalida);
								check3 = true;
							} else {
								System.out.println("Lo siento, no le he entendido");
								check3 = false;
							}
									
						}
						check3 = false;
					} else if (cadena[i].equals("demo")){
						
						Agenda.demo(Agenda.agendaContactos);
						
					}
				}
			}
		}
}