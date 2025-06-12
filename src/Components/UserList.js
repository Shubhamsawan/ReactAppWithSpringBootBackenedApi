import React, { useEffect, useState } from "react";
import DataTable from "react-data-table-component";
import api from "../services/api";
import "../CSS/UserList.css";
import { FaEdit, FaTrash } from "react-icons/fa";

const UserList = ({ onEditUser, reload }) => {
  const [users, setUsers] = useState([]);

  const fetchUsers = () => {
    api.get("/users/searchAll").then((res) => {
      setUsers(res.data.data || []);
    });
  };

  useEffect(() => {
    fetchUsers();
  }, [reload]); // refetch when reload changes

  const handleDelete = async (userId) => {
    const confirmed = window.confirm(
      "Are you sure you want to delete this user?"
    );
    if (!confirmed) return;

    try {
      await api.delete(`/users/delete/${userId}`);
      fetchUsers(); // Refresh list after deletion
    } catch (err) {
      console.error("Delete failed:", err);
      alert("Failed to delete user.");
    }
  };

  const columns = [
    {
      name: "Sr.No",
      selector: (_, index) => index + 1,
      sortable: true,
      width: "70px",
    },
    {
      name: "Action",
      cell: (row) => (
        <div className="action-buttons">
          <button className="edit-btn" onClick={() => onEditUser(row.userId)}>
            <FaEdit />
          </button>
          <button
            className="delete-btn"
            onClick={() => handleDelete(row.userId)}
          >
            <FaTrash />
          </button>
        </div>
      ),
      width: "120px",
    },
    {
      name: "Name",
      selector: (row) => row.name,
      sortable: true,
    },
    {
      name: "Email",
      selector: (row) => row.email,
      sortable: true,
    },
    {
      name: "Role",
      selector: (row) => row.roleName,
      sortable: true,
    },
    {
      name: "Authorization By User",
      selector: () => "N/A",
    },
    {
      name: "Created At",
      selector: (row) => row.createdAt?.replace("T", " ").split(".")[0] ?? "",
      sortable: true,
    },
  ];

  return (
    <div className="datatable-container">
      <DataTable
        columns={columns}
        data={users}
        pagination
        responsive
        highlightOnHover
        striped
      />
    </div>
  );
};

export default UserList;
