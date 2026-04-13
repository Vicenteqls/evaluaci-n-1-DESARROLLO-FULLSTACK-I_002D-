package duoc.uc.QuickOrder.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import duoc.uc.QuickOrder.Model.Estado;
import duoc.uc.QuickOrder.Model.Pedido;
import duoc.uc.QuickOrder.Repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository repo;

  
    public PedidoService(PedidoRepository repo) {
        this.repo = repo;
    }

    public List<Pedido> listar() {
        return repo.obtenerTodos();
    }

    public Pedido obtenerPorId(Long id) {
        return repo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public Pedido crear( Pedido p) {
        if (p.getNombreCliente() == null || p.getNombreCliente().isEmpty()) {
            throw new RuntimeException("Nombre obligatorio");
        }
        
        if (p.getMontoTotal() == null || p.getMontoTotal() <= 0) {
            throw new RuntimeException("Monto debe ser mayor a 0");
        }

        p.setFechaPedido(LocalDate.now());
        return repo.guardar(p);
    }

    public Pedido actualizar(Long id, Pedido nuevo) {
        Pedido existente = obtenerPorId(id);

        existente.setNombreCliente(nuevo.getNombreCliente());
        existente.setDescripcion(nuevo.getDescripcion());
        existente.setEstado(nuevo.getEstado());
        existente.setTipoPedido(nuevo.getTipoPedido());
        existente.setMontoTotal(nuevo.getMontoTotal());

        return existente;
    }
    
    public void eliminar(Long id) {
        obtenerPorId(id);
        repo.eliminar(id);
    }

    public List<Pedido> filtrarPorEstado(Estado estado) {
        return repo.obtenerTodos().stream()
                .filter(p -> p.getEstado() == estado)
                .toList();
    }
}