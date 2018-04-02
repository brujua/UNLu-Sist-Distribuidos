package serverSide;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import clientSide.Tarea;

public class ServidorDeTareas implements TareaRemota{

	public ServidorDeTareas(){
		super();
	}
	@Override
	public <O> O ejecutarTarea(Tarea<O> T) throws RemoteException {
		return T.ejecutar();
	}
	
	public static void main(String[] args) {
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		try {
			String nombre = "ejecutarTarea";
			TareaRemota serv = new ServidorDeTareas();
			TareaRemota stub = (TareaRemota) UnicastRemoteObject.exportObject(serv, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(nombre, stub);
			System.out.println("Servidor de tareas publicado(bound)");
		} catch (Exception e) {
			System.err.println("Servidor de Tareas en problemas");
			e.printStackTrace();
		}
	}

}
