package pe.edu.roberto.apps.orders.management.business.api.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.roberto.apps.orders.management.api.ClientesApi;
import pe.edu.roberto.apps.orders.management.model.ClienteRequest;
import pe.edu.roberto.apps.orders.management.model.ClienteResponse;

import java.util.List;

@RestController
public class ClienteResource implements ClientesApi {
    @Override
    public ResponseEntity<List<ClienteResponse>> getAllClientes(String authorization) {
        List<ClienteResponse> clientes = List.of(
                new ClienteResponse().id(1).nombres("Roberto").apellidos("Herrera"),
                new ClienteResponse().id(2).nombres("Juan").apellidos("Castro")
        );
        return ResponseEntity.ok(clientes);
    }

    @Override
    public ResponseEntity<ClienteResponse> createCliente(ClienteRequest clienteRequest) {
        return ResponseEntity.ok(new ClienteResponse());
    }

    @Override
    public ResponseEntity<Void> deleteCliente(Integer id) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ClienteResponse> getClienteById(Integer id, String authorization) {
        return ResponseEntity.ok(new ClienteResponse().id(99).nombres("Jesus").apellidos("Lopez"));
    }

    @Override
    public ResponseEntity<ClienteResponse> updateCliente(Integer id, ClienteRequest clienteRequest) {
        return ResponseEntity.ok(new ClienteResponse());
    }
}
