import axiosCLient from "./axiosClient";

const loginApi = {
    postLogin: (param) => {
        const url = '/login';
        return axiosCLient.post(url, param);
    },
    getUser: (tendn) => {
        const url = `/khachhang/${tendn}`;
        return axiosCLient.get(url);
    }
}
export default loginApi;