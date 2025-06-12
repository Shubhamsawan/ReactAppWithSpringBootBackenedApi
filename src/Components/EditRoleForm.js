import React, { useEffect, useState } from "react";
import api from "../services/api";

const EditRoleForm = ({ roleId, onClose }) => {
  const [formData, setFormData] = useState({ name: "", gaurdName: "" });

  useEffect(() => {
    console.log(roleId);
    api
      .get(`/roles/${roleId?.id}`)
      .then((res) => setFormData(res.data.data))
      .catch((err) => console.error("Failed to fetch role:", err));
  }, [roleId]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleUpdate = () => {
    api
      .put(`/roles/update/${roleId?.id}`, formData)
      .then(() => {
        alert("Role updated successfully.");
        onClose();
      })
      .catch((err) => console.error("Failed to update role:", err));
  };

  return (
    <div className="edit-tab">
      <h4>Edit Role</h4>
      {formData.name !== "" ? (
        <>
          <input
            type="text"
            name="name"
            value={formData.name}
            placeholder="Role Name"
            onChange={handleChange}
          />
          <input
            type="text"
            name="gaurdName"
            value={formData.gaurdName}
            placeholder="Guard Name"
            onChange={handleChange}
          />
          <button onClick={handleUpdate} className="submit-btn">
            Update
          </button>
          <button onClick={onClose}>Cancel</button>
        </>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );

  //   return (
  //     <div className="edit-tab">
  //       <h4>Edit Role</h4>
  //       <input
  //         type="text"
  //         name="name"
  //         value={formData.name}
  //         placeholder="Role Name"
  //         onChange={handleChange}
  //       />
  //       <input
  //         type="text"
  //         name="gaurdName"
  //         value={formData.gaurdName}
  //         placeholder="Guard Name"
  //         onChange={handleChange}
  //       />
  //       <button onClick={handleUpdate}>Update</button>
  //       <button onClick={onClose}>Cancel</button>
  //     </div>
  //   );
};

export default EditRoleForm;
