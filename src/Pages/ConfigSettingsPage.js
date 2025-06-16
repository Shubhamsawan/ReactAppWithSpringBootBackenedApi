import React, { useEffect, useState } from "react";
import "../CSS/ConfigSettingsPage.css";
import api from "../services/api";
import { Rnd } from "react-rnd"; // at the top of your file

const ConfigSettingsPage = () => {
  const [configs, setConfigs] = useState([]);
  const [formData, setFormData] = useState(initialFormData());
  const [showForm, setShowForm] = useState(false);

  useEffect(() => {
    fetchConfigs();
  }, []);

  const fetchConfigs = async () => {
    try {
      const res = await api.get(`/config/SearchAll`);
      setConfigs(res.data.data || []);
    } catch (err) {
      alert("Failed to fetch configs.");
    }
  };

  function initialFormData() {
    return {
      id: null,
      label: "",
      key: "",
      value: "",
      environment: "",
      configKey: "",
    };
  }

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (formData.id) {
        await api.put(`/config/update/${formData.id}`, formData);
      } else {
        await api.post(`/config/create`, formData);
      }
      fetchConfigs();
      setFormData(initialFormData());
      setShowForm(false);
    } catch (err) {
      alert("Save failed");
    }
  };

  //   const handleEdit = (cfg) => {
  //     setFormData(cfg);
  //     setShowForm(true);
  //   };

  const handleEdit = async (cfg) => {
    try {
      const res = await api.get(`/config/listById/${cfg.id}`);
      const fetchedData = res.data.data;
      setFormData({
        id: fetchedData.id,
        label: fetchedData.label || "",
        key: fetchedData.key || "",
        value: fetchedData.value || "",
        environment: fetchedData.environment || "",
        configKey: fetchedData.configKey || "",
      });
      setShowForm(true);
    } catch (err) {
      alert("Failed to fetch config details.");
    }
  };

  const handleAdd = () => {
    setFormData(initialFormData());
    setShowForm(true);
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure?")) return;
    try {
      await api.delete(`/config/deleteById/${id}`);
      fetchConfigs();
    } catch (err) {
      alert("Delete failed");
    }
  };

  return (
    // <div className="config-page">
    <div>
      {" "}
      <h2>System Configuration</h2>
      <div className="datatable-container">
        <div className="config-header">
          <h2>Configuration Settings</h2>
          <button
            className="add-btn"
            onClick={handleAdd}
            style={{ marginBottom: "10px", width: "auto" }}
          >
            + Add Config
          </button>
        </div>

        <table className="config-table">
          <thead>
            <tr>
              <th>Label</th>
              <th>Key</th>
              <th>Value</th>
              <th>Environment</th>
              <th>Created At</th>
              <th>Updated At</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {configs.map((cfg) => (
              <tr key={cfg.id}>
                <td>{cfg.label}</td>
                <td>{cfg.key}</td>
                <td>{cfg.value}</td>
                <td>{cfg.environment}</td>
                <td>{cfg.createdAt}</td>
                <td>{cfg.updatedAt}</td>
                <td>
                  <button className="edit-btn" onClick={() => handleEdit(cfg)}>
                    Edit
                  </button>
                  <button
                    className="delete-btn"
                    onClick={() => handleDelete(cfg.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        {showForm && (
          <div className="modal-overlay">
            <Rnd
              default={{
                x: 100,
                y: 100,
                width: 500,
                height: 450,
              }}
              minWidth={400}
              minHeight={300}
              bounds="window"
              className="modal-content draggable-resizable"
            >
              <h3>{formData.id ? "Edit Config" : "Add Config"}</h3>
              <form onSubmit={handleSubmit}>
                <input
                  name="label"
                  placeholder="Label"
                  value={formData.label}
                  onChange={handleChange}
                  required
                />
                <input
                  name="key"
                  placeholder="Key"
                  value={formData.key}
                  onChange={handleChange}
                  required
                />
                <input
                  name="value"
                  placeholder="Value"
                  value={formData.value}
                  onChange={handleChange}
                  required
                />
                <input
                  name="environment"
                  placeholder="Environment"
                  value={formData.environment}
                  onChange={handleChange}
                  required
                />
                <input
                  name="configKey"
                  placeholder="Config Key (URL)"
                  value={formData.configKey}
                  onChange={handleChange}
                />

                <div className="modal-actions">
                  <button type="submit" className="save-btn">
                    {formData.id ? "Update" : "Save"}
                  </button>
                  <button
                    type="button"
                    className="cancel-btn"
                    onClick={() => setShowForm(false)}
                  >
                    Cancel
                  </button>
                </div>
              </form>
            </Rnd>
          </div>
        )}
      </div>
    </div>
  );
};

export default ConfigSettingsPage;
