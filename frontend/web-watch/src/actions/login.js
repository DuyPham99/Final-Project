import loginApi from "api/loginApi";
import { actionTypes } from "contants/action-type";
const login = ({ tendn, matkhau }) => async dispatch => {
    const response = await loginApi.postLogin({ tendn, matkhau });
    dispatch({
        type: actionTypes.LOGIN,
        payload: response
    });
    localStorage.setItem("token", response.accessToken);
}
export const getUser = (tendn) => async dispatch => {
    const response = await loginApi.getUser();
    dispatch({
        type: actionTypes.GET_USER,
        payload: response
    });
}
export default login;