/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contracts;

import java.sql.SQLException;
import java.util.ArrayList;
import models.BaseEntity;

/**
 *
 * @author yuri.jwsilva
 */
public interface IRepository {
    void insert(BaseEntity entity);
    void update(BaseEntity entity);
    void remove(int id);
    BaseEntity getById(int id);
    ArrayList<Object> getAll() throws ClassNotFoundException, SQLException;
}
