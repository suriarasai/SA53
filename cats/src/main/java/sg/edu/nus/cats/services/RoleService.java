package sg.edu.nus.cats.services;

import java.util.ArrayList;

import sg.edu.nus.cats.model.Role;

public interface RoleService {

	ArrayList<Role> findAllRoles();

	Role findRole(String roleId);

	Role createRole(Role role);

	Role changeRole(Role role);

	void removeRole(Role role);

	ArrayList<String> findAllRolesNames();

	ArrayList<Role> findRoleByName(String name);

}