import React from "react";
import Sidebar from "../Components/Sidebar"; // Adjust path if needed
import "../App.css";

const Dashboard = () => {
  return (
    <div className="app-container">
      <Sidebar />
      <div className="main-content">
        <h2>Welcome to the Dashboard</h2>
        <p>Select an option from the sidebar to get started.</p>
      </div>
    </div>
  );
};

export default Dashboard;
