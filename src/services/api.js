import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api", // your backend base URL here
});

// export const httpClient = async (a, method) => {
//   await api({
//     a,
//     method,
//   })
//     .then((res) => {
//       return res;
//     })
//     .catch((err) => {
//       console.log(err);
//     });
// };

export default api;
