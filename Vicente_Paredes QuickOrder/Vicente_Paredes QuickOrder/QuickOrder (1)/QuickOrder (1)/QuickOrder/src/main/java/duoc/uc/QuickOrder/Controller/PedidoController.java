package duoc.uc.QuickOrder.Controller;

import duoc.uc.QuickOrder.Model.Estado;
import  duoc.uc.QuickOrder.Model.Pedido;
import  duoc.uc.QuickOrder.Service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos") // Base de datos
public class PedidoController { // Gestior De DatosContrller

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping// Buscar Datos
    public ResponseEntity<List<Pedido>> obtenerTodos() {
        return ResponseEntity.ok(pedidoService.listar());
    }

    @GetMapping("/{id}") // Buscar Por ID
    public ResponseEntity<Pedido> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPorId(id));
    }

    @PostMapping//Agregar Datos
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.crear(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
    }

    @PutMapping("/{id}")// Editar Datos
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido pedidoActualizado = pedidoService.actualizar(id, pedido);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @DeleteMapping("/{id}")// Borrar Datos Por ID
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/estado/{estado}")// Buscar Por Estado Del Pedido
    public ResponseEntity<List<Pedido>> obtenerPorEstado(@PathVariable Estado estado) {
        return ResponseEntity.ok(pedidoService.filtrarPorEstado(estado));
    }
}