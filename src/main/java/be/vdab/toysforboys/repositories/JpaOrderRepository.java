package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Order;
import be.vdab.toysforboys.domain.Status;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {
    private final EntityManager manager;

    public JpaOrderRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Order> findById(long id) {
        return Optional.ofNullable(manager.find(Order.class, id));
    }

    @Override
    public List<Order> findUnshipped() {
        return manager.createNamedQuery("Order.findUnshipped", Order.class)
                .setParameter("status1", Status.CANCELLED).setParameter("status2", Status.SHIPPED)
                .getResultList();
    }
}


