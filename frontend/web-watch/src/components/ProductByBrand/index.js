import { StarFilled } from '@ant-design/icons';
import addToCart from 'actions/cart';
import productsApi from 'api/productsApi';
import React, { useEffect, useState } from 'react';
import { Container, Row } from 'react-bootstrap';
import { useDispatch } from 'react-redux';
import { Link } from 'react-router-dom';
import { Button, Card, Image } from 'semantic-ui-react';
import { currencyFormatVN } from 'utils/format';
import '../ProductByBrand/index.css';

function ProductByCategory(props) {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const getProductsByBrand = async () => {
            try {
                const res = await productsApi.getAllByBrand(props.title);
                setProducts(res);
            } catch (error) {
                console.log(error);
            }
        }
        getProductsByBrand();
    }, []);

    if (products.length === 0) {
        return null;
    } else {
        return (
            <>
                <Container fluid className='row-products mb-5'>
                    <Row className='text-center pt-3'>
                        <b style={{ fontSize: '18px' }} >{props.title}</b>
                    </Row>
                    <Row className="d-flex  justify-content-center pt-1 ">
                        {products.map((product) =>
                            <Card className='size-block-product m-4' key={product.idProduct}>
                                <Image src='https://bizweb.dktcdn.net/100/112/815/products/iphone-8p-gold.jpg?v=1612254253777'
                                    wrapped ui={false}
                                />
                                <Card.Content>
                                    <Card.Header>
                                        <Link to={`/products/${product.idProduct}`} style={{ textDecoration: "none" }}><h5 className="product-link" >{product.name}</h5></Link>
                                    </Card.Header>
                                    <Card.Meta>
                                        <span className='date'></span>
                                    </Card.Meta>
                                    <Card.Description>
                                        <span className="product__price">{currencyFormatVN(product.productOptions[0].price)}</span>
                                    </Card.Description>
                                </Card.Content>
                                <Card.Content extra>
                                    <Row>
                                        <div className="product__rating d-flex justify-content-center">
                                            <StarFilled />
                                            <StarFilled />
                                            <StarFilled />
                                            <StarFilled />
                                            <StarFilled />
                                        </div>
                                        <Button color='youtube'>
                                            <Link to={`/products/${product.idProduct}`} style={{ textDecoration: "none", color : "white"}}>
                                                Mua hàng
                                            </Link>
                                        </Button>
                                    </Row>
                                </Card.Content>
                            </Card>
                        )}
                    </Row>
                    <Row >
                        <Link className="pb-2 d-flex justify-content-end" to={"/sanpham/" + props.title.toString().toLowerCase()}><p>Xem thêm</p></Link>
                    </Row>
                </Container>
            </>
        );
    }
}

export default ProductByCategory;