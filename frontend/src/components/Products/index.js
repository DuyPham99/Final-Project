import { fetchProducts } from 'actions/product';
import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import Product from '../Product/index';
import { Grid, Container } from '@material-ui/core';
import '../Products/index.scss';
function Products() {
    const data = useSelector(state => state.allProduct.products);
    console.log(data);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(fetchProducts());
    }, []);
    const [visible, setVisible] = useState(8);
    const loadMoreProducts = () => {
        setVisible(preValue => preValue + 4);
    }
    return (
        <div className="products">
            <div className="products__title">SẢN PHẨM BÁN CHẠY</div>
            <Container maxWidth="lg">
                <Grid container spacing={3}>
                    {data.slice(0, visible).map((product) =>
                        <Grid item sm={3} sx={12} key={product.idSP}>
                            <Product data={product} />
                        </Grid>
                    )}
                </Grid>
            </Container>
            <button className="products__more" onClick={loadMoreProducts} >Xem thêm</button>
        </div>
    );
}
export default Products;