import React, { useState, useEffect } from "react";
import "../CSS/UserForm.css";
import api from "../services/api";

const UserForm = ({ userId = null, onSuccess }) => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
    confirmPassword: "",
    roleId: 0, // initialized as number
  });

  const [roles, setRoles] = useState([]);

  useEffect(() => {
    // Fetch roles
    api.get("/roles/list_all").then((res) => {
      setRoles(res.data?.data || []);
    });

    // If editing an existing user
    if (userId) {
      api.get(`/users/listById/${userId}`).then((res) => {
        const user = res.data.data;
        setFormData({
          name: user.name,
          email: user.email,
          password: user.password,
          confirmPassword: user.confirmPassword,
          roleId: user.roleId,
        });
      });
    }
  }, [userId]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: name === "roleId" ? parseInt(value) : value, // convert roleId to number
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      console.log("Submitting form data:", formData);

      if (userId) {
        await api.put(`/users/update/${userId}`, formData); // Remove query param
      } else {
        await api.post("/users/add", formData);
      }

      alert("User saved successfully");
      onSuccess?.();
    } catch (error) {
      console.error("Error saving user", error.response?.data || error.message);
      alert(
        "Something went wrong: " +
          (error.response?.data?.message || error.message)
      );
    }
  };

  return (
    <form className="user-form" onSubmit={handleSubmit}>
      <h2 className="form-title">{userId ? "Edit User" : "Add User"}</h2>

      <div className="form-group">
        <label>Name</label>
        <input
          name="name"
          value={formData.name}
          onChange={handleChange}
          required
        />
      </div>

      <div className="form-group">
        <label>Email</label>
        <input
          name="email"
          type="email"
          value={formData.email}
          onChange={handleChange}
          required
        />
      </div>

      <div className="form-group">
        <label>Password</label>
        <input
          name="password"
          type="password"
          value={formData.password}
          onChange={handleChange}
          required
        />
      </div>

      {!userId && (
        <div className="form-group">
          <label>Confirm Password</label>
          <input
            name="confirmPassword"
            type="password"
            value={formData.confirmPassword}
            onChange={handleChange}
            required
          />
        </div>
      )}

      <div className="form-group">
        <label>Role</label>
        <select
          name="roleId"
          value={formData.roleId}
          onChange={handleChange}
          required
        >
          <option value={0}>Select Role</option>
          {roles.map((role) => (
            <option key={role.id} value={role.id}>
              {role.name}
            </option>
          ))}
        </select>
      </div>

      <button type="submit" className="submit-btn">
        {userId ? "Update User" : "Add User"}
      </button>
    </form>
  );
};

export default UserForm;
