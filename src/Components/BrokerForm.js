import React, { useState, useEffect } from "react";
import api from "../services/api";
import "../CSS/BrokerForm.css"; // optional styling file

const BrokerForm = ({ broker, onClose }) => {
  const [formData, setFormData] = useState({
    name: "",
    frontendUrl: "",
    backendUrl: "",
    environment: "",
    status: "Y",
    supportEmail: "",
    supportTollfree: "",
    logo: "",
  });

  useEffect(() => {
    if (broker) {
      setFormData(broker);
    }
  }, [broker]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (broker) {
        // Update
        await api.post(`/brokers/update/${broker.brokerDetailId}`, formData);
      } else {
        // Create
        await api.post("/brokers/create", formData);
      }
      onClose();
    } catch (error) {
      console.error("Error saving broker:", error);
      alert("Error saving broker data.");
    }
  };

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <h3>{broker ? "Edit Broker" : "Add Broker"}</h3>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="name"
            placeholder="Broker Name"
            value={formData.name}
            onChange={handleChange}
            required
          />
          <input
            type="url"
            name="frontendUrl"
            placeholder="Frontend URL"
            value={formData.frontendUrl}
            onChange={handleChange}
            required
          />
          <input
            type="url"
            name="backendUrl"
            placeholder="Backend URL"
            value={formData.backendUrl}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="environment"
            placeholder="Environment (e.g., uat)"
            value={formData.environment}
            onChange={handleChange}
            required
          />
          <input
            type="email"
            name="supportEmail"
            placeholder="Support Email"
            value={formData.supportEmail}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="supportTollfree"
            placeholder="Support Tollfree"
            value={formData.supportTollfree}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="logo"
            placeholder="Logo filename (e.g., logo.png)"
            value={formData.logo}
            onChange={handleChange}
          />
          <select name="status" value={formData.status} onChange={handleChange}>
            <option value="Y">Active</option>
            <option value="N">Inactive</option>
          </select>

          <div className="modal-actions">
            <button type="submit">{broker ? "Update" : "Add"}</button>
            <button type="button" onClick={onClose} className="cancel-btn">
              Cancel
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default BrokerForm;
