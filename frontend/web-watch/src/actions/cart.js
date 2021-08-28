import { actionTypes } from "contants/action-type";
export const addToCart = (product) => async (dispatch, getState) => {
    const cartItems = getState().cart.cartItems.slice();
    let alreadyExists = false;
    cartItems.forEach((x) => {
        if (x.idProduct === product.idProduct) {
            alreadyExists = true;
            alert('Sản phẩm đã có trong giỏ hàng! Thêm số lượng sản phẩm vào giỏ hàng thành công!')
            x.soluong++;
        }
    });
    if (!alreadyExists) {
        alert('Thêm vào giỏ hàng thành công!');
        cartItems.push({ ...product, soluong: 1 });
    }
    dispatch({
        type: actionTypes.ADD_TO_CART,
        payload: { cartItems },
    });
    localStorage.setItem("cartItems", JSON.stringify(cartItems));

};
export default addToCart;

export const removeItem = (product) => async (dispatch, getState) => {
    const cartItems = getState().cart.cartItems.slice()
        .filter((x) => x.idProduct !== product.idProduct);
    dispatch({ type: actionTypes.REMOVE_ITEM, payload: { cartItems } });
    localStorage.setItem("cartItems", JSON.stringify(cartItems));
};
export const increaseItem = (product) => async (dispatch, getState) => {
    const cartItems = getState().cart.cartItems.slice()
        .map(item => {
            if (item.idProduct === product.idProduct) {
                item = { ...item, soluong: item.soluong + 1 }
            }
            return item;
        })
    dispatch({ type: actionTypes.INCREASE_ITEM, payload: { cartItems } });
    localStorage.setItem("cartItems", JSON.stringify(cartItems));


};
export const decreaseItem = (product) => async (dispatch, getState) => {
    const cartItems = getState().cart.cartItems.slice()
        .map(item => {
            if (item.idProduct === product.idProduct) {
                item = { ...item, soluong: item.soluong === 1 ? item.soluong = 1 : item.soluong - 1 }

            }
            return item;
        })
    dispatch({ type: actionTypes.DECREASE_ITEM, payload: { cartItems } });
    localStorage.setItem("cartItems", JSON.stringify(cartItems));

};

