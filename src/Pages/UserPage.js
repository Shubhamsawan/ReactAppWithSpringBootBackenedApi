import React, { useState } from "react";
import UserForm from "../Components/UserForm";
import Modal from "../Components/Modal"; // ✅ Your actual modal component
import "../CSS/Modal.css"; // ✅ Just loads CSS
import UserList from "../Components/UserList";
import "../CSS/UserList.css"; // Reuse existing styles

const UserPage = () => {
  const [showForm, setShowForm] = useState(false);
  const [editUserId, setEditUserId] = useState(null);
  const [reload, setReload] = useState(false); // Trigger data reload in UserList

  const handleAddClick = () => {
    setEditUserId(null); // New user
    setShowForm(true);
  };

  const handleEdit = (userId) => {
    setEditUserId(userId);
    setShowForm(true);
  };

  const handleFormSuccess = () => {
    setShowForm(false);
    setReload((prev) => !prev); // Toggle to trigger reload in UserList
  };

  return (
    <div className="datatable-container">
      <div className="header">
        <h2>Users</h2>
        <button
          onClick={handleAddClick}
          className="add-user-btn"
          style={{ marginBottom: "10px", width: "auto" }}
        >
          + Add User
        </button>
      </div>

      {/* ✅ Modal for Add/Edit */}
      <Modal isOpen={showForm} onClose={() => setShowForm(false)}>
        <UserForm userId={editUserId} onSuccess={handleFormSuccess} />
      </Modal>

      {/* ✅ Use UserList and pass edit handler and reload trigger */}
      <UserList onEditUser={handleEdit} reload={reload} />
    </div>
  );
};

export default UserPage;
