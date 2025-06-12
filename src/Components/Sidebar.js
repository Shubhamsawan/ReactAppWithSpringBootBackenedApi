import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./Sidebar.css";

const Sidebar = () => {
  const [isOpen, setIsOpen] = useState(true);
  const navigate = useNavigate();

  const toggleSidebar = () => setIsOpen(!isOpen);

  const handleLogout = () => {
    localStorage.clear(); // or use context logout if available
    navigate("/");
  };

  return (
    <div className={`sidebar ${isOpen ? "" : "collapsed"}`}>
      {/* ✅ Logout button on top */}
      <button className="logout-btn-sidebar" onClick={handleLogout}>
        Logout
      </button>

      {/* Toggle Menu */}
      <button className="toggle-btn" onClick={toggleSidebar}>
        {isOpen ? "< Menu" : ">"}
      </button>

      {/* Navigation links */}
      {isOpen && (
        <>
          <h2>Dashboard</h2>
          <ul>
            <li>
              <Link to="/dashboard/roles">Roles</Link>
            </li>
            <li>
              <Link to="/dashboard/users">Users</Link>
            </li>
          </ul>
        </>
      )}
    </div>
  );
};

export default Sidebar;
