package clientSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TareaRemota extends Remote {
	<O> O ejecutarTarea(Tarea <O> T) throws RemoteException;
}
