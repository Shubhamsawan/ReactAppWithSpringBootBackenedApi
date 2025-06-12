import React from "react";
import DataTable from "react-data-table-component";
import { FaEdit, FaTrash } from "react-icons/fa";

const RoleList = ({ roles, onDelete, onEditClick }) => {
  const columns = [
    {
      name: "Sr No",
      selector: (_, index) => index + 1,
      width: "80px",
    },
    {
      name: "Name",
      selector: (row) => row.name,
      sortable: true,
    },
    {
      name: "Guard Name",
      selector: (row) => row.gaurdName,
      sortable: true,
    },
    {
      name: "Actions",
      cell: (row) => (
        <div style={{ display: "flex", gap: "10px" }}>
          <button
            className="edit-btn"
            onClick={() => onEditClick(row)}
            title="Edit"
          >
            <FaEdit />
          </button>
          <button
            className="delete-btn"
            onClick={() => onDelete(row.id)}
            title="Delete"
          >
            <FaTrash />
          </button>
        </div>
      ),
      ignoreRowClick: true,
      allowOverflow: true,
      button: true,
      width: "120px",
    },
  ];

  return (
    <div className="datatable-container">
      <div className="header">
        <h2>Role List</h2>
      </div>

      <DataTable
        columns={columns}
        data={roles?.data || []}
        pagination
        responsive
        highlightOnHover
        striped
      />
    </div>
  );
};

export default RoleList;
