import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LoginPage from "./Components/LoginPage";
import RolePage from "./Pages/RolePage";
import UserPage from "./Components/UserPage";
import DashboardHome from "./Components/Dashboard"; // this is the welcome page
import DashboardLayout from "./Components/DashboardLayout"; // NEW
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
            {/* /dashboard/roles */}
            <Route path="users" element={<UserPage />} />{" "}
            {/* /dashboard/users */}
          </Route>
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;
