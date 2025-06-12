import React from "react";
import "../CSS/BrokerForm.css";

const BrokerTable = ({ brokers, onEdit }) => {
  return (
    <div className="datatable-container">
      <div className="header">
        <h2>Broker Details</h2>
      </div>

      <table className="broker-table">
        <thead>
          <tr>
            <th>Action</th>
            <th>Sr. No.</th>
            <th>Name</th>
            <th>Frontend URL</th>
            <th>Backend URL</th>
            <th>Environment</th>
            <th>Support Email</th>
            <th>Support Tollfree</th>
          </tr>
        </thead>
        <tbody>
          {brokers.map((broker, index) => (
            <tr key={broker.brokerDetailId}>
              <td>
                <button
                  className="edit-btn"
                  onClick={() => onEdit(broker)}
                  title="Edit"
                >
                  ✏️
                </button>
              </td>
              <td>{index + 1}</td>
              <td>{broker.name}</td>
              <td>{broker.frontendUrl}</td>
              <td>{broker.backendUrl}</td>
              <td>{broker.environment}</td>
              <td>{broker.supportEmail}</td>
              <td>{broker.supportTollfree}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default BrokerTable;
