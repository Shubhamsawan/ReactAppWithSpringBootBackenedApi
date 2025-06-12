import React, { useEffect, useState } from "react";
import BrokerTable from "../Components/BrokerTable";
import BrokerForm from "../Components/BrokerForm";
import api from "../services/api";

const BrokerPage = () => {
  const [brokers, setBrokers] = useState([]);
  const [editingBroker, setEditingBroker] = useState(null);
  const [showForm, setShowForm] = useState(false);

  const fetchBrokers = async () => {
    const response = await api.get("/brokers/all");
    setBrokers(response.data.data);
  };

  useEffect(() => {
    fetchBrokers();
  }, []);

  const handleEdit = (broker) => {
    setEditingBroker(broker);
    setShowForm(true);
  };

  const handleFormClose = () => {
    setShowForm(false);
    setEditingBroker(null);
    fetchBrokers(); // Refresh data
  };

  return (
    <div>
      <div className="header">
        <h2>Broker Management</h2>
        <button
          onClick={() => {
            setEditingBroker(null);
            setShowForm(true);
          }}
          style={{ marginBottom: "10px", width: "auto" }}
          className="add-user-btn"
        >
          + Add Broker
        </button>
      </div>

      <BrokerTable brokers={brokers} onEdit={handleEdit} />

      {showForm && (
        <BrokerForm broker={editingBroker} onClose={handleFormClose} />
      )}
    </div>
  );
};

export default BrokerPage;
