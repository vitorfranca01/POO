package system.contracts;

import java.sql.SQLException;
import java.util.ArrayList;
import models.BaseEntity;

/**
 *
 * @author Vitor
 */
public interface IRepository {
    void insert(BaseEntity entity);
    void update(BaseEntity entity);
    void remove(int id);
    BaseEntity getById(int id);
    ArrayList<Object> getAll() throws ClassNotFoundException, SQLException;
}