// EditConfigModal.js
import React from "react";
import { Rnd } from "react-rnd";
import "../Components/EditConfigModal.css";

const EditConfigModal = ({ formData, onChange, onSubmit, onClose }) => {
  return (
    <div className="modal-overlay">
      <Rnd
        default={{
          x: 100,
          y: 100,
          width: 500,
          height: 400,
        }}
        minWidth={300}
        minHeight={300}
        bounds="window"
        className="modal-box"
      >
        <div className="modal-header">
          <h3>Edit Config</h3>
          <button onClick={onClose}>X</button>
        </div>
        <form onSubmit={onSubmit} className="modal-form">
          <input
            name="label"
            placeholder="Label"
            value={formData.label}
            onChange={onChange}
            required
          />
          <input
            name="key"
            placeholder="Key"
            value={formData.key}
            onChange={onChange}
            required
          />
          <textarea
            name="value"
            placeholder="Value"
            value={formData.value}
            onChange={onChange}
            required
          />
          <input
            name="environment"
            placeholder="Environment"
            value={formData.environment}
            onChange={onChange}
            required
          />
          <input
            name="configKey"
            placeholder="Config Key (URL)"
            value={formData.configKey}
            onChange={onChange}
          />
          <button type="submit">Update</button>
        </form>
      </Rnd>
    </div>
  );
};

export default EditConfigModal;
