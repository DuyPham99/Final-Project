import axiosCLient from "./axiosClient";

const loginApi = {
    postLogin: (param) => {
        const url = '/login';
        return axiosCLient.post(url, param);
    },
    getInfo: async (payload, tendn) => {
        const url = `/khachhang/${tendn}`;
        const response = await axiosCLient.get(url, payload);
        return response;
    }
}
export default loginApi;