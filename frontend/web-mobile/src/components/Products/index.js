import { fetchProducts } from 'actions/product';
import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import Product from '../Product/index';
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
            <div className="products__title">TẤT CẢ SẢN PHẨM</div>
            <div className="products__row">
                {data.slice(0, visible).map((product) => <Product key={product.idSP} data={product} />)}
            </div>
            <button className="products__more" onClick={loadMoreProducts} >TẢI THÊM</button>
        </div>
    );
}
export default Products;