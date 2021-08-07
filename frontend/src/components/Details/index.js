import { useSelector, useDispatch } from 'react-redux';
import { useHistory, useParams } from 'react-router-dom';
import { StarFilled } from '@ant-design/icons';
import './index.scss';
import { currencyFormatVN } from 'utils/format';
import addToCart from 'actions/cart';
import { useEffect } from 'react';
import { selectProduct, removeSelectProduct } from 'actions/product';
import { Grid, Container } from '@material-ui/core';
function Details() {
    let history = useHistory();
    const dispatch = useDispatch();
    const { id } = useParams();
    useEffect(() => {
        if (id && id !== "") dispatch(selectProduct(id));
        return () => {
            dispatch(removeSelectProduct());
        };
    }, [id]);
    let data = useSelector(state => state.product);
    return (
        <div className="details">
            <Container fixed>
                <Grid container spacing={3}>
                    <Grid item sm={5} sx={12}>
                        <div className="details__img">
                            <img src={data.anhSP} alt="product" />
                        </div>
                    </Grid>
                    <Grid item sm={7} sx={12}>
                        <div className="details__info">
                            <h4 className="details__info-title">{data.tenSP}</h4>
                            <div className="details__info-rating">
                                <StarFilled />
                                <StarFilled />
                                <StarFilled />
                                <StarFilled />
                                <StarFilled />
                            </div>
                            <p className="details__info-des">Mô tả sản phẩm: <span>{data.moTa}</span></p>
                            <p className="details__info-price">
                                <span>{currencyFormatVN(data.gia)}</span>
                            </p>
                            <div className="details__btn">
                                <button onClick={() => history.goBack()}>Tiếp tục mua sắm</button>
                                <button className="details__btn-add" onClick={() => dispatch(addToCart(data))}>Thêm vào giỏ hàng</button>
                            </div>
                        </div>
                    </Grid>
                </Grid>
            </Container>
        </div>
    );
}
export default Details;