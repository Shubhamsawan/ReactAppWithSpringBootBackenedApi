import React, { useState } from "react";

import {
  FaUsers,
  FaUserShield,
  FaBriefcase,
  FaChevronDown,
} from "react-icons/fa";
import { MdManageAccounts } from "react-icons/md";
import { Link } from "react-router-dom";
import "../CSS/Sidebar.css";

const Sidebar = () => {
  const [manageOpen, setManageOpen] = useState(true);
  const [userMgmtOpen, setUserMgmtOpen] = useState(true);
  const [collapsed, setCollapsed] = useState(false);
  const [configOpen, setConfigOpen] = useState(true);

  return (
    <div className={`sidebar ${collapsed ? "collapsed" : ""}`}>
      <button className="toggle-btn" onClick={() => setCollapsed(!collapsed)}>
        {collapsed ? "☰" : "✖"}
      </button>

      <ul className="menu">
        <li>
          <div
            className="menu-section"
            onClick={() => setManageOpen(!manageOpen)}
          >
            <MdManageAccounts /> {!collapsed && "Manage"}
            <FaChevronDown className={`chevron ${manageOpen ? "open" : ""}`} />
          </div>

          {manageOpen && !collapsed && (
            <ul className="submenu">
              <li>
                {/* <div className="submenu-header">Configuration</div> */}
                <div
                  className="submenu-header"
                  onClick={() => setConfigOpen(!configOpen)}
                >
                  Configuration
                  <FaChevronDown
                    className={`chevron ${configOpen ? "open" : ""}`}
                  />
                </div>
                {configOpen && (
                  <ul>
                    <li>
                      <Link to="/dashboard/brokers">
                        <FaBriefcase /> Broker Details
                      </Link>
                    </li>
                    <li>
                      <Link to="/dashboard/config">
                        <FaUsers /> System Configuration
                      </Link>
                    </li>
                  </ul>
                )}

                {/* <ul>
                  <li>
                    <Link to="/dashboard/brokers">
                      <FaBriefcase /> Broker Details
                    </Link>
                  </li>
                  <li>
                    <Link to="/dashboard/config">
                      <FaUsers /> System Configuration
                    </Link>
                  </li>
                </ul> */}
              </li>

              <li>
                <div
                  className="submenu-header"
                  onClick={() => setUserMgmtOpen(!userMgmtOpen)}
                >
                  User Management
                  <FaChevronDown
                    className={`chevron ${userMgmtOpen ? "open" : ""}`}
                  />
                </div>
                {userMgmtOpen && (
                  <ul>
                    <li>
                      <Link to="/dashboard/users">
                        <FaUsers /> Users
                      </Link>
                    </li>
                    <li>
                      <Link to="/dashboard/roles">
                        <FaUserShield /> Role
                      </Link>
                    </li>
                  </ul>
                )}
              </li>
            </ul>
          )}
        </li>
      </ul>
    </div>
  );
};

export default Sidebar;
