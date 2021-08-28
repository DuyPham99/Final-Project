import '../Cart/index.scss';
import { useSelector, useDispatch } from 'react-redux';
import { Link } from 'react-router-dom';
import { DeleteFilled } from '@ant-design/icons';
import { removeItem, increaseItem, decreaseItem } from 'actions/cart';
import { Grid } from '@material-ui/core';
import { currencyFormatVN } from 'utils/format';
import { Container } from '@material-ui/core';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { useState } from 'react';
import orderApi from 'api/orderApi';
function Cart() {
    const dispatch = useDispatch();
    const cart = useSelector(state => state.cart.cartItems);
    const [name, setName] = useState("");
    const [phone, setPhone] = useState("");
    const [address, setAddress] = useState("");
    const [shipping, setShipping] = useState("SHOP");
    const [payment, setPayment] = useState("BANK");
    const [description, setDescription] = useState("");
    let customer = {
        "name": "",
        "address": "",
        "phoneNumber": ""
    };

    let shippingModel = {
        "shipType": "",
        "description": ""
    };

    let listProductOption = [];

    let order = {
        "customer": customer,
        "shippingModel": shippingModel,
        "listProductOption": listProductOption,
        "payment" : {
            "type" : payment
        }
    };

    console.log(cart);

    function handleSubmit(e) {
        e.preventDefault();
        //customer 
        customer.name = name;
        customer.address = address;
        customer.phoneNumber = phone;

        //shipping
        shippingModel.shipType = shipping;
        shippingModel.description = description;

        //product order
        cart.map((x) => {
            let temp = {
                "productOption" : {
                    "idProductOption": 0
                },
                "amount": 0
            }

            temp.productOption.idProductOption = x.productOptions[0].idProductOption;
            temp.amount = x.soluong;

            listProductOption.push(temp);
        });

        console.log(order);
        orderApi.order(order).then((res) => {
            alert("Đơn hàng đã được tiếp nhận và xử lý!");
        },
        (error) => {

        })

        localStorage.clear();
    }

    function handleNameChange(e) {
        setName(e.target.value);
    }

    function handlePhoneChange(e) {
        setPhone(e.target.value);
    }

    function handleAddressChange(e) {
        setAddress(e.target.value);
    }

    function handleShippingChange(value) {
        setShipping(value);
    }

    function handlePaymentChange(value) {
        setPayment(value);
    }

    function handleDescriptionChange(e) {
        setDescription(e.target.value);
    }

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
                                                        <img src={item.productOptions[0].images} alt=""></img>
                                                    </div></td>
                                                    <td><div className="cart__items-title">{item.name}</div></td>
                                                    <td><div className="cart__items-price">
                                                        {currencyFormatVN(item.productOptions[0].price)}
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
                                                        acc + cur.productOptions[0].price * cur.soluong, 0
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
                                                        acc + cur.productOptions[0].price * cur.soluong, 0
                                                    )
                                                )} </span>
                                            </div>
                                            <i>(Đã bao gồm VAT nếu có)</i>
                                        </div>
                                    </div>
                                </div>
                            </Grid>
                        </Grid>
                    </div>)
                }
                {
                    cart.length > 0 &&
                    <Form onSubmit={(e) => handleSubmit(e)} className="mt-5">
                        <hr></hr>
                        <Row className="mb-3">
                            <Form.Group as={Col} controlId="formGridEmail">
                                <Form.Label><b>Họ tên</b></Form.Label>
                                <Form.Control type="text" value={name} onChange={handleNameChange} required />
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridPassword">
                                <Form.Label><b>Số điện thoại</b></Form.Label>
                                <Form.Control type="text" onChange={handlePhoneChange} value={phone} required />
                            </Form.Group>
                        </Row>

                        <Form.Group className="mb-3" controlId="formGridAddress1">
                            <Form.Label><b>Địa chỉ giao hàng</b></Form.Label>
                            <Form.Control type="text" onChange={handleAddressChange} value={address} required />
                        </Form.Group>
                        <Form.Group as={Row} className="mb-3">
                            <Form.Label as="legend" column sm={2}>
                                <b>Hình thức nhận hàng</b>
                            </Form.Label>
                            <Col sm={10} className="d-flex flex-row justify-content-around align-items-center" >
                                <Form.Check
                                    type="radio"
                                    label="Giữ tại của hàng"
                                    name=""
                                    id=""
                                    checked={shipping == "SHOP"}
                                    onClick={() => handleShippingChange("SHOP")}
                                />
                                <Form.Check
                                    type="radio"
                                    label="Giao tận nơi"
                                    name=""
                                    id=""
                                    checked={shipping == "SHIPPING"}
                                    onClick={() => handleShippingChange("SHIPPING")}
                                />
                            </Col>
                        </Form.Group>
                        <Form.Group as={Row} className="mb-3">
                            <Form.Label as="legend" column sm={2}>
                                <b> Hình thức thanh toán</b>
                            </Form.Label>
                            <Col sm={5} className="d-flex flex-column mt-2">
                                <Form.Check
                                    type="radio"
                                    label="Thanh toán qua thẻ ngân hàng"
                                    name=""
                                    id=""
                                    className="pb-3"
                                    checked={payment == "BANK"}
                                    onClick={() => handlePaymentChange("BANK")}
                                />
                                <Form.Check
                                    type="radio"
                                    label="Thanh toán khi nhận hàng"
                                    name=""
                                    id=""
                                    className="pb-3"
                                    checked={payment == "COD"}
                                    onClick={() => handlePaymentChange("COD")}
                                />
                                <Form.Check
                                    type="radio"
                                    label="Thanh toán qua Momo"
                                    name=""
                                    id=""
                                    checked={payment == "MOMO"}
                                    onClick={() => handlePaymentChange("MOMO")}
                                />
                            </Col>
                            <Col sm={5} className="d-flex flex-column">
                                <Form.Label as="legend" column sm={2}>
                                    <b>Chú thích</b>
                                </Form.Label>
                                <Form.Control
                                    as="textarea"
                                    style={{ height: '100px' }}
                                    value={description}
                                    onChange={handleDescriptionChange}
                                />
                            </Col>
                        </Form.Group>
                        <div class="d-flex justify-content-center">
                            <button type="submit" className="cart__prices-process text-center">Tiến hành đặt hàng</button>
                        </div>
                    </Form>
                }

            </Container >

        </div >
    );
}
export default Cart;