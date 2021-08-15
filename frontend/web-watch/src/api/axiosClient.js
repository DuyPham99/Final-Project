import axios from 'axios';
import queryString from 'query-string';

const axiosCLient = axios.create({
    baseURL: process.env.REACT_APP_API_URL,
    headers: {
        'content-type': 'application/json',
        'Access-Control-Allow-Origin' : '*',
        'Access-Control-Allow-Credentials' : 'true',
        'Access-Control-Allow-Methods'  : 'GET,HEAD,OPTIONS,POST,PUT',
        'Access-Control-Allow-Headers' : 'Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers'
    },
    //sử dụng cho phân trang hoặc filter
    paramsSerializer: params => queryString.stringify(params),
});

axiosCLient.interceptors.request.use(async (config) => {
    const accessToken = localStorage.getItem("token");
    config.headers.authorization = `Bearer ${accessToken}`;
    return config;
}, error => {
    return Promise.reject(error);
});

axiosCLient.interceptors.response.use((response) => {
    if (response && response.data) {
        return response.data;
    }
    return response;
}, (error) => {
    throw error;
});

export default axiosCLient;