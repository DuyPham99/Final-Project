import axiosCLient from "./axiosClient";

const productsApi = {
    getALl: (param) => {
        const url = '/sanpham';
        return axiosCLient.get(url, { param });
    },
    getId: (id) => {
        const url = `/sanpham/${id}`;
        return axiosCLient.get(url);
    }
}

export default productsApi;