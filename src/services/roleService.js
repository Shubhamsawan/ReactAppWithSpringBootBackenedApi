import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/roles";

export const getAllRoles = () => {
  return axios.get(`${API_BASE_URL}/list_all`);
};

export const getRoleById = (id) => {
  return axios.get(`${API_BASE_URL}/${id}`);
};

export const deleteRoleById = (id) => {
  return axios.get(`${API_BASE_URL}/delete/${id}`);
};

export const addRole = (roleData) => {
  return axios.post(`${API_BASE_URL}/add`, roleData);
};

export const updateRole = (id, roleData) => {
  return axios.put(`${API_BASE_URL}/update/${id}`, roleData);
};
