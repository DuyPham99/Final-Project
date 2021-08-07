import { actionTypes } from "contants/action-type";
const selectProductReducer = (state = {}, { type, payload }) => {
    switch (type) {
        case actionTypes.SELECT_PRODUCT: {
            return { ...state, ...payload };
        }
        case actionTypes.REMOVE_SELECT_PRODUCT:
            return {};
        default:
            return state;
    }
}
export default selectProductReducer;