package serverSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

import clientSide.Tarea;

public interface TareaRemota extends Remote {
	<O> O ejecutarTarea(Tarea <O> T) throws RemoteException;
}
