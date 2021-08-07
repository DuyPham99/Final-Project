import productReducer from './product';
import cartReducer from './cart';
import selectProductReducer from './selectProduct';
import { combineReducers } from 'redux';
import loginReducer from './login';
const rootReducer = combineReducers({
    allProduct: productReducer,
    product: selectProductReducer,
    cart: cartReducer,
    login: loginReducer
})
export default rootReducer;