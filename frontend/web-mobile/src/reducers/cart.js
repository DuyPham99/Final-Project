import { actionTypes } from "contants/action-type";
const cartReducer = (state = { cartItems: JSON.parse(localStorage.getItem("cartItems") || "[]") }, { payload, type }) => {
    switch (type) {
        case actionTypes.ADD_TO_CART: {
            return { cartItems: payload.cartItems }
        }
        case actionTypes.REMOVE_ITEM: {
            return { cartItems: payload.cartItems }
        }
        case actionTypes.INCREASE_ITEM: {
            return { cartItems: payload.cartItems }
        }
        case actionTypes.DECREASE_ITEM: {
            return { cartItems: payload.cartItems }
        }
        default:
            return state;
    }
}
export default cartReducer;