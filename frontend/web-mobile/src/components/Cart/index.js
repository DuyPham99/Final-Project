import '../Cart/index.scss';
import { useSelector, useDispatch } from 'react-redux';
import { Link } from 'react-router-dom';
import { DeleteFilled } from '@ant-design/icons';
import { removeItem, increaseItem, decreaseItem } from 'actions/cart';
import formatCurrency from 'utils';
function Cart() {
    const dispatch = useDispatch();
    const cart = useSelector(state => state.cart.cartItems);
    console.log(cart);
    return (
        <div className="cart">
            {cart.length === 0 ? (<div className="cart__info">
                <div className="cart__header">Không có sản phẩm nào trong giỏ hàng</div>
                <Link to="/sanpham"> <button >Tiếp tục mua sắm</button></Link></div>) :
                (<div className="cart__center">
                    <ul className="cart__list">
                        {cart.map(item => (
                            <li className="cart__items" key={item.idSP}>
                                <div className="cart__items-img">
                                    <img src={item.anhSP} alt=""></img>
                                </div>
                                <div className="cart__items-title">{item.tenSP}</div>
                                <div className="cart__items-price">
                                    {formatCurrency(item.gia)} đ
                                </div>
                                <div className="cart__items-qt">
                                    <button className="cart__items-qt-dec" onClick={() => dispatch(decreaseItem(item))}>-</button>
                                    <span className="cart__items-qt-value">{item.soluong}</span>
                                    <button className="cart__items-qt-inc" onClick={() => dispatch(increaseItem(item))}>+</button>
                                </div>
                                <div className="cart__items-remove">
                                    <DeleteFilled onClick={() => dispatch(removeItem(item))} />
                                </div>
                            </li>

                        ))

                        }

                    </ul>
                    <div className="cart__payment">
                        <div className="cart__prices">
                            <h3 className="cart__prices-title">Thông tin đơn hàng</h3>
                            <ul className="cart__prices-items">
                                <li className="cart__prices-item">
                                    <span className="cart__prices-text">Tạm tính: </span>
                                    <span className="cart__prices-value">{formatCurrency(
                                        cart.reduce((acc, cur) =>
                                            acc + cur.gia * cur.soluong, 0
                                        )
                                    )} đ</span>
                                </li>
                                <li className="cart__prices-item">
                                    <span className="cart__prices-text">Giảm giá: </span>
                                    <span className="cart__prices-value">{formatCurrency(0)} đ</span>
                                </li>
                            </ul>
                            <div className="cart__prices-total">
                                <div className="cart__prices-des">
                                    <span className="cart__prices-text">Tổng cộng: </span>
                                    <span className="cart__prices-value ">{formatCurrency(
                                        cart.reduce((acc, cur) =>
                                            acc + cur.gia * cur.soluong, 0
                                        )
                                    )} đ</span>
                                </div>
                                <i>(Đã bao gồm VAT nếu có)</i>
                            </div>
                        </div>
                        <button type="button" className="cart__prices-process">Tiến hành đặt hàng</button>
                    </div>
                </div>)
            }
        </div>
    );
}
export default Cart;