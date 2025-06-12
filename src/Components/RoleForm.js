import React, { useState, useEffect } from "react";
import api from "../services/api";
import "../CSS/Modal.css"; // Create this for modal styles

const RoleForm = ({ selectedRole, fetchRoles, clearSelection, onClose }) => {
  const [name, setName] = useState("");
  const [guardName, setGuardName] = useState("");

  useEffect(() => {
    if (selectedRole) {
      setName(selectedRole.name);
      setGuardName(selectedRole.guardName);
    } else {
      setName("");
      setGuardName("");
    }
  }, [selectedRole]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const roleData = { name, gaurdName: guardName };

    try {
      if (selectedRole) {
        await api.put(`/roles/update/${selectedRole.id}`, roleData);
      } else {
        await api.post("/roles/add", roleData);
      }
      fetchRoles();
      onClose(); // Close modal
      clearSelection();
    } catch (err) {
      console.error("Error saving role:", err);
    }
  };

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <div style={{ display: "flex", justifyContent: "space-between" }}>
          <h3>{selectedRole ? "Edit Role" : "Add Role"}</h3>
          <button
            type="modal-close"
            onClick={onClose}
            className="modal-close"
            title="Close"
          >
            X
          </button>
        </div>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="Role Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
          <input
            type="text"
            placeholder="Guard Name"
            value={guardName}
            onChange={(e) => setGuardName(e.target.value)}
            required
          />
          <div className="modal-buttons">
            <button type="submit">{selectedRole ? "Update" : "Add"}</button>
            {/* <button type="button" onClick={onClose} className="close-btn">
              x Close
            </button> */}
          </div>
        </form>
      </div>
    </div>
  );
};

export default RoleForm;
