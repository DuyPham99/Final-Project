import { actionTypes } from "contants/action-type";
const initialState = {
    products: [],
};
const productReducer = (state = initialState, { type, payload }) => {
    switch (type) {
        case actionTypes.FETCH_PRODUCTS: {
            return { ...state, products: payload };
        }
        default:
            return state;
    }
}
export default productReducer;