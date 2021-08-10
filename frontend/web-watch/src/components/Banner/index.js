import '../Banner/index.scss';
import React from 'react';
import banner from '../../assets/images/bannerlaptop.jpg';
function Banner() {
    const urlBanner = "https://cdn.tgdd.vn/2021/07/campaign/iphone-12-1200-300-1200x300.png";
    return (
        <React.Fragment>
            <div className="banner" style={{ backgroundImage: `url(${urlBanner})` }}>
            </div>

        </React.Fragment>

    );
}
export default Banner;