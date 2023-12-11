package cesur.examen.domain.client;

import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Jorge Olmedo Jiménez
 * Fecha: 11/12/2023
 */

public class ClientService {

    /**
     * Return a List of Client entities that have one or more cars of the given manufacturer.
     * If a client has more than one car of the manufacturer, it only appears once in
     * the list (similar to a Set). Tip: start querying to Car entities...
     *
     * @param manufacturer
     * @return the list of clients
     */
    public static List<Client> hasManufacturer(String manufacturer){
        var out= new ArrayList<Client>(0);

        /* Implement method here */
        var hashSet = new HashSet<Client>( 0 );
        var todosClientes = new ArrayList<Client>( 0 );
        ClientDAO clientDAO = new ClientDAO();
        todosClientes = ( ArrayList<Client> ) clientDAO.getAll();

        for (Client client: todosClientes){
            for(Car car: client.getCars()){
                if(Objects.equals(car.getManufacturer(), manufacturer)){
                    hashSet.add(client);
                }
            }
        }
        out = (ArrayList<Client>) hashSet.stream().toList();


        return out;
    }
}
