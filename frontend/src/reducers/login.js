import { actionTypes } from "contants/action-type"
const initialState = {};
const loginReducer = (state = initialState, { type, payload }) => {
    switch (type) {
        case actionTypes.LOGIN: {
            return {
                ...payload
            }
        }
        case actionTypes.GET_USER: {
            return {
                ...payload
            }
        }
        default:
            return state;
    }
}
export default loginReducer;