import { StarFilled } from '@ant-design/icons';
import React from 'react';
import { Link } from 'react-router-dom';
import '../Product/index.scss';
import { currencyFormatVN } from 'utils/format';

function Product(props) {
    const { data } = props;
    const { idProduct, productOptions, name, brand } = data;
    return (
        <div className="product">
            <Link to={`/details/${idProduct}`}><img className="product__img" src={productOptions[0].images} alt="img1"></img></Link>
            <Link to={`/details/${idProduct}`}><h3 className="product__title">{name} - {brand.name}</h3></Link>
            <span className="product__price">{currencyFormatVN(productOptions[0].price)}</span>
            <div className="product__rating">
                <StarFilled />
                <StarFilled />
                <StarFilled />
                <StarFilled />
                <StarFilled />
            </div>
        </div>
    );

}
export default Product;
