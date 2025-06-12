import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LoginPage from "./Pages/LoginPage";
import RolePage from "./Pages/RolePage";
import UserPage from "./Pages/UserPage";
import DashboardHome from "./Components/Dashboard"; // this is the welcome page
import DashboardLayout from "./Components/DashboardLayout"; // NEW
import BrokerPage from "./Pages/BrokerPage";

import { AuthProvider } from "./Components/AuthContext";

function App() {
  return (
    <AuthProvider>
      <Router>
        <Routes>
          <Route path="/" element={<LoginPage />} />
          {/* Dashboard layout with nested routes */}
          <Route path="/dashboard" element={<DashboardLayout />}>
            <Route index element={<DashboardHome />} /> {/* /dashboard */}
            <Route path="roles" element={<RolePage />} />{" "}
            <Route path="users" element={<UserPage />} />{" "}
            <Route path="brokers" element={<BrokerPage />} />
          </Route>
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;
