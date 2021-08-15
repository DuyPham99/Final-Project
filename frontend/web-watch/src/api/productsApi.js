import axiosCLient from "./axiosClient";

const productsApi = {
    getAll: (param) => {
        const url = '/products';
        return axiosCLient.get(url, { param });
    },
    getId: (id) => {
        const url = `/products/${id}`;
        return axiosCLient.get(url);
    },
    getAllByBrand: (brand) => {
        const url = `/products/brand/${brand}`;
        return axiosCLient.get(url);
    }
}

export default productsApi;