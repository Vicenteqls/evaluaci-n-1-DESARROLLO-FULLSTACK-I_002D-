package duoc.uc.QuickOrder.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import duoc.uc.QuickOrder.Model.Estado;
import duoc.uc.QuickOrder.Model.Pedido;

@Repository
public class PedidoRepository {

    private List<Pedido> lista = new ArrayList<>();
    private Long contador = 1L;

    public List<Pedido> obtenerTodos() {
        return lista;
    }

    public Pedido guardar(Pedido p) {
        p.setId(contador++);
        lista.add(p);
        return p;
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return lista.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void eliminar(Long id) {
        lista.removeIf(p -> p.getId().equals(id));
    }

    public Pedido actualizar(Long id, Pedido datosNuevos) {
        Optional<Pedido> pedidoExistente = buscarPorId(id);
        if (pedidoExistente.isPresent()) {
            Pedido p = pedidoExistente.get();
            p.setNombreCliente(datosNuevos.getNombreCliente());
            p.setDescripcion(datosNuevos.getDescripcion());
            p.setEstado(datosNuevos.getEstado());
            p.setTipoPedido(datosNuevos.getTipoPedido());
            p.setMontoTotal(datosNuevos.getMontoTotal());
            return p;
        }
        return null;
    }

    public List<Pedido> buscarPorEstado(Estado estado) {
        return lista.stream()
                .filter(p -> p.getEstado() == estado)
                .toList(); 
    }
}
