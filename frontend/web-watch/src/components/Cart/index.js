import '../Cart/index.scss';
import { useSelector, useDispatch } from 'react-redux';
import { Link } from 'react-router-dom';
import { DeleteFilled } from '@ant-design/icons';
import { removeItem, increaseItem, decreaseItem } from 'actions/cart';
import { Grid } from '@material-ui/core';
import { currencyFormatVN } from 'utils/format';
import { Container } from '@material-ui/core';
function Cart() {
    const dispatch = useDispatch();
    const cart = useSelector(state => state.cart.cartItems);
    console.log(cart);
    return (
        <div className="cart">
            <Container fixed>
                {cart.length === 0 ? (<div className="cart__info">
                    <div className="cart__header">Không có sản phẩm nào trong giỏ hàng</div>
                    <Link to="/sanpham"> <button >Tiếp tục mua sắm</button></Link></div>) :
                    (<div className="cart__center">
                        <Grid container spacing={3}>
                            <Grid item sm={8} sx={12}>
                                <div className="cart__table">
                                    <table className="cart__table-list">
                                        <thead>
                                            <tr>
                                                <th >Hình ảnh</th>
                                                <th >Tên sản phẩm</th>
                                                <th >Giá </th>
                                                <th >Số lượng</th>
                                                <th >Thao tác</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {cart.map(item => (
                                                <tr className="cart_items">
                                                    <td ><div className="cart__items-img">
                                                        <img src={item.anhSP} alt=""></img>
                                                    </div></td>
                                                    <td><div className="cart__items-title">{item.tenSP}</div></td>
                                                    <td><div className="cart__items-price">
                                                        {currencyFormatVN(item.gia)}
                                                    </div></td>
                                                    <td > <div className="cart__items-qt">
                                                        <button className="cart__items-qt-dec" onClick={() => dispatch(decreaseItem(item))}>-</button>
                                                        <span className="cart__items-qt-value">{item.soluong}</span>
                                                        <button className="cart__items-qt-inc" onClick={() => dispatch(increaseItem(item))}>+</button>
                                                    </div></td>

                                                    <td ><div className="cart__items-remove">
                                                        <DeleteFilled onClick={() => dispatch(removeItem(item))} />
                                                    </div></td>
                                                </tr>
                                            ))
                                            }
                                        </tbody>
                                    </table>
                                </div>
                            </Grid>
                            <Grid item sm={4} sx={12}>
                                <div className="cart__payment">
                                    <div className="cart__prices">
                                        <h3 className="cart__prices-title">Thông tin đơn hàng</h3>
                                        <ul className="cart__prices-items">
                                            <li className="cart__prices-item">
                                                <span className="cart__prices-text">Tạm tính: </span>
                                                <span className="cart__prices-value">{currencyFormatVN(
                                                    cart.reduce((acc, cur) =>
                                                        acc + cur.gia * cur.soluong, 0
                                                    )
                                                )} </span>
                                            </li>
                                            <li className="cart__prices-item">
                                                <span className="cart__prices-text">Giảm giá: </span>
                                                <span className="cart__prices-value">{currencyFormatVN(0)} </span>
                                            </li>
                                        </ul>
                                        <div className="cart__prices-total">
                                            <div className="cart__prices-des">
                                                <span className="cart__prices-text">Tổng cộng: </span>
                                                <span className="cart__prices-value " style={{ color: 'red', fontSize: '18px' }}>{currencyFormatVN(
                                                    cart.reduce((acc, cur) =>
                                                        acc + cur.gia * cur.soluong, 0
                                                    )
                                                )} </span>
                                            </div>
                                            <i>(Đã bao gồm VAT nếu có)</i>
                                        </div>
                                    </div>
                                    <button type="button" className="cart__prices-process">Tiến hành đặt hàng</button>
                                </div>
                            </Grid>
                        </Grid>
                    </div>)
                }
            </Container >

        </div >
    );
}
export default Cart;