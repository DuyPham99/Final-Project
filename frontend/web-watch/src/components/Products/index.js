import { fetchProducts } from 'actions/product';
import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import Product from '../Product/index';
import { Grid, Container } from '@material-ui/core';
import '../Products/index.scss';
import Carousel from 'react-elastic-carousel';
import ProductByCategory from 'components/ProductByBrand';
import { Item } from 'semantic-ui-react';
import { Row } from 'react-bootstrap';

function Products() {

    const data = useSelector(state => state.allProduct.products);

    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(fetchProducts());
    }, []);

    const [visible, setVisible] = useState(8);

    const loadMoreProducts = () => {
        setVisible(preValue => preValue + 4);
    }

    const breakPoints = [
        { width: 1, itemsToShow: 1 },
        { width: 550, itemsToShow: 2 },
        { width: 768, itemsToShow: 3 },
        { width: 1200, itemsToShow: 4 },
    ];

    return (
        <>
            <div className="products">
                <div className="products__title">SẢN PHẨM BÁN CHẠY</div>
                <Container maxWidth="lg">
                    <Grid container spacing={1} direction="row" alignItems="center" justify="center">
                        <Carousel breakPoints={breakPoints}>
                            {data.slice(0, visible).map((product) =>
                                <Grid key={product.idProduct}>
                                    <Product data={product} />
                                </Grid>
                            )}
                        </Carousel>
                    </Grid>
                </Container>
                <Container className="mt-5">
                    <ProductByCategory data={data} title="IPhone"/>
                    <ProductByCategory data={data} title="Samsung"/>
                    <ProductByCategory data={data} title="Xiaomi"/>
                </Container>
            </div>
        </>

    );
}

export default Products;