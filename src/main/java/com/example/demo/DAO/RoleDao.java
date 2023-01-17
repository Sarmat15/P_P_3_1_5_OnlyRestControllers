package com.example.demo.DAO;

import com.example.demo.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleDao {
    void saveRole(Role role);

    void removeRoleById(int id);

    List<Role> getAllRole();

    Role getRoleById(int id);

    Role getRoleByRole(Role role);

    void updateRole(Role role);
}
