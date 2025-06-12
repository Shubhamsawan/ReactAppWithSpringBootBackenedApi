// src/Layouts/DashboardLayout.js
import React from "react";
import Sidebar from "../Components/Sidebar";
import { Outlet } from "react-router-dom";
import "../App.css";

const DashboardLayout = () => {
  return (
    <div className="app-container">
      <Sidebar />
      <div className="main-content">
        <Outlet /> {/* Will render nested routes here */}
      </div>
    </div>
  );
};

export default DashboardLayout;
