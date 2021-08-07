import '../Banner/index.scss';
import React from 'react';
import banner from '../../assets/images/bannerlaptop.jpg';
function Banner() {
    return (
        <React.Fragment>
            <div className="banner" style={{ backgroundImage: `url(${banner})` }}>
            </div>

        </React.Fragment>

    );
}
export default Banner;