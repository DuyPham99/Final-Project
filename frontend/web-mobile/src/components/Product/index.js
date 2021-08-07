import { StarFilled } from '@ant-design/icons';
import React from 'react';
import { Link } from 'react-router-dom';
import '../Product/index.scss';
import formatCurrency from 'utils';
function Product(props) {
    const { data } = props;
    const { idSP, anhSP, tenSP, gia, loaiSP, kieuSP } = data;
    const { tenKieu } = kieuSP;
    const { tenLoai } = loaiSP;
    return (
        <div className="product">
            <Link to={`/details/${idSP}`}><img className="product__img" src={anhSP} alt="img1"></img></Link>
            <Link to={`/details/${idSP}`}><h3 className="product__title">{tenSP} - {tenLoai} {tenKieu}</h3></Link>
            <span className="product__price">{formatCurrency(gia)} đ</span>
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
