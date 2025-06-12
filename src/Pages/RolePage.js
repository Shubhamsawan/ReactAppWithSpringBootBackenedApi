import React, { useEffect, useState } from "react";
import RoleForm from "../Components/RoleForm";
import RoleList from "../Components/RoleList";
import api from "../services/api";

const RolePage = () => {
  const [roles, setRoles] = useState([]);
  const [showRoleModal, setShowRoleModal] = useState(false);
  const [selectedRole, setSelectedRole] = useState(null);

  const fetchRoles = async () => {
    try {
      const res = await api.get("/roles/list_all");
      setRoles(res.data);
    } catch (err) {
      console.error("Error fetching roles:", err);
    }
  };

  useEffect(() => {
    fetchRoles();
  }, []);

  const handleDelete = async (id) => {
    try {
      await api.delete(`/roles/delete/${id}`);
      fetchRoles();
    } catch (err) {
      console.error("Error deleting role:", err);
    }
  };

  const handleAddClick = () => {
    setSelectedRole(null);
    setShowRoleModal(true);
  };

  const handleEditClick = (role) => {
    setSelectedRole(role);
    setShowRoleModal(true);
  };

  return (
    <div>
      <h2>Role Management</h2>

      <button
        onClick={handleAddClick}
        style={{ marginBottom: "10px", width: "auto" }}
      >
        ➕ Add Role
      </button>

      <RoleList
        roles={roles}
        onEditClick={handleEditClick}
        onDelete={handleDelete}
      />
      {/* </div> */}

      {showRoleModal && (
        <RoleForm
          selectedRole={selectedRole}
          fetchRoles={fetchRoles}
          clearSelection={() => setSelectedRole(null)}
          onClose={() => setShowRoleModal(false)}
        />
      )}
    </div>
  );
};

export default RolePage;
