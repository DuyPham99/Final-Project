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
                            <img src="data:image/jpeg;base64,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" alt="product" />
                        </div>
                    </Grid>
                    <Grid item sm={7} sx={12}>
                        <div className="details__info">
                            <h4 className="details__info-title">IPhone 8 Plus</h4>
                            <div className="details__info-rating">
                                <StarFilled />
                                <StarFilled />
                                <StarFilled />
                                <StarFilled />
                                <StarFilled />
                            </div>
                            <p className="details__info-des">Mô tả sản phẩm: <span>Thiết kế đẹp</span></p>
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